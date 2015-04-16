package com.justonetech.biz.utils.process.util;

import com.justonetech.core.utils.ParFileUtils;
import com.justonetech.biz.utils.process.visio.Page;
import com.justonetech.biz.utils.process.visio.Shape;
import com.justonetech.biz.utils.process.visio.VisioDocument;
import com.justonetech.biz.utils.process.visio.XMLReader;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.NodeList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

/**
 * @version 1.0
 * @author: lerry
 * @date: 2009-3-27
 */
public class VmlHtmHelper {
    private static final Log log = LogFactory.getLog(VmlHtmHelper.class);

    private static final String TOPOLOGY__XML = "topology.xml";
    private static final String VML_1_HTM = "vml_1.htm";
    private static final String VML_1_EMZ = "vml_1.emz";
    private static final String PROCESS_NAME = "Process";
    private static final String SWIMLANE_NAME = "Functional";

    public static String getSwimlaneShapesVml(File parFile) throws Exception {
        String xml = getTopologyXml(parFile);
        String htm = getVmlHtm(parFile);

        return getSwimlaneShapesVml(xml, htm);
    }

    public static String getSwimlaneShapesVml(String xml, String htm) throws Exception {
        //parse xml
        XMLReader xmlReader = new XMLReader();
        VisioDocument visioDocument = xmlReader.loadFromXml(xml);
        Page page = visioDocument.getPages().getPage().get(0);
        List<Shape> shapes = page.getShapes().getShape();

        List<Shape> processShapes = getProcesses(shapes);

        //parse htm
        Parser parser = new Parser(htm);
        parser.setEncoding("utf-8");

        TagNameFilter shapeFilter = new TagNameFilter("v:shape");
        NodeList vmlShapes = parser.extractAllNodesThatMatch(shapeFilter);
        log.debug("the vmlShapes's size is " + vmlShapes.size());

        //need 4 point info from xml file,we need find the most left and top processShape
        Shape processShape = getMostLeftTop(processShapes);

        String id = processShape.getID();
        String text = processShape.getText();
        log.debug("get sampling process id is " + id);
        log.debug("get sampling process text is " + text);
        double left = Double.parseDouble(processShape.getXForm().getPinX().replaceAll("mm", ""));
        log.debug("get sampling process left is " + left);

        double[][] xml4Points = getXml4PointsFromProcessShape(processShape);
        //注意：process的x，y是shape的中心点，但由于与path的点的对应关系是1，4点兑换，2，3点对换(因此Y的坐标计算不同与想当然)

        log.debug("points in xml:" + points2String(xml4Points));

        //get path from htm
        Tag sampleShape = getVmlShapeById(vmlShapes, id);
        String path = sampleShape.getAttribute("path");
        log.debug("path:" + path);
        if (path == null) {
            throw new RuntimeException("can't find one process to calc regression");
        }


        //get 4 point of htm
        double[][] htm4Points = path2Points(path);

        log.debug("points in htm:" + points2String(htm4Points));
        double htmLeft = htm4Points[0][0];
        log.debug("left in htm:" + htm4Points[0][0]);

        //calc regression
        SimpleRegression regressionX = new SimpleRegression();
        for (int i = 0; i < htm4Points.length; i++) {
            regressionX.addData(xml4Points[i][0], htm4Points[i][0]);
        }

        SimpleRegression regressionY = new SimpleRegression();
        for (int i = 0; i < htm4Points.length; i++) {
            regressionY.addData(xml4Points[i][1], htm4Points[i][1]);
        }

        log.debug("regressionX.getSlope()=" + regressionX.getSlope());
        log.debug("regressionX.getIntercept()=" + regressionX.getIntercept());

        log.debug("regressionY.getSlope()=" + regressionY.getSlope());
        log.debug("regressionY.getIntercept()=" + regressionY.getIntercept());

        log.debug("addjusting slope and intercept");


        //verify
//        double[][] calc4HtmPoints = new double[4][2];
//        calc4HtmPoints[0][0] = regressionX.predict(xml4Points[0][0]);
//        calc4HtmPoints[0][1] = regressionY.predict(xml4Points[0][1]);
//        calc4HtmPoints[1][0] = regressionX.predict(xml4Points[1][0]);
//        calc4HtmPoints[1][1] = regressionY.predict(xml4Points[1][1]);
//        calc4HtmPoints[2][0] = regressionX.predict(xml4Points[2][0]);
//        calc4HtmPoints[2][1] = regressionY.predict(xml4Points[2][1]);
//        calc4HtmPoints[3][0] = regressionX.predict(xml4Points[3][0]);
//        calc4HtmPoints[3][1] = regressionY.predict(xml4Points[3][1]);
//
//        log.debug("calc points in htm:" + points2String(calc4HtmPoints));
        NodeList swimlaneNodeList = new NodeList();

        List<Shape> swimlanes = getSwimlanes(shapes);
        for (int i = 0; i < swimlanes.size(); i++) {
            Shape shape = swimlanes.get(i);

            String sid = shape.getID();
            String stext = shape.getText();
            log.debug("get swimlane id is " + sid);
            log.debug("get swimlane text is " + stext);

            double sCenterX = Double.parseDouble(shape.getXForm().getPinX().replace("mm", ""));
            double sCenterY = Double.parseDouble(shape.getXForm().getPinY().replace("mm", ""));
            double sWidth = Double.parseDouble(shape.getXForm().getWidth().replace("mm", ""));
            double sHeight = Double.parseDouble(shape.getXForm().getHeight().replace("mm", ""));

            //注意：swimlane 上的x，y不是中心点,因此第一步计算出中心点
            sCenterX = sCenterX + sWidth / 2;
            sCenterY = sCenterY - sHeight / 2;
            double[][] s4Points = getXml4Points(sCenterX, sCenterY, sWidth, sHeight);
            path = points2String(s4Points);
            log.debug("swimlanepoints to convert   " + path);

            //linear transformation,注意不同回归系数
            double slope = (regressionX.getSlope() - regressionY.getSlope()) / 2;
            double intercept = (regressionX.getIntercept() - regressionY.getIntercept()) / 2;

            //调整误差
            double theda = 2.0 / 1000000.0;
            s4Points[0][0] = regressionX.predict(s4Points[0][0]);
            s4Points[0][0] = s4Points[0][0] * (1 - (s4Points[0][0] - htmLeft) * theda);
            s4Points[0][1] = regressionY.predict(s4Points[0][1]);

            s4Points[1][0] = regressionX.predict(s4Points[1][0]);
            s4Points[1][0] = s4Points[1][0] * (1 - (s4Points[1][0] - htmLeft) * theda);
            s4Points[1][1] = regressionY.predict(s4Points[1][1]);

            s4Points[2][0] = regressionX.predict(s4Points[2][0]);
            s4Points[2][0] = s4Points[2][0] * (1 - (s4Points[2][0] - htmLeft) * theda);
            s4Points[2][1] = regressionY.predict(s4Points[2][1]);

            s4Points[3][0] = regressionX.predict(s4Points[3][0]);
            s4Points[3][0] = s4Points[3][0] * (1 - (s4Points[3][0] - htmLeft) * theda);
            s4Points[3][1] = regressionY.predict(s4Points[3][1]);

            path = points2String(s4Points);
            log.debug("swimlanepoints after convert   " + path);

            //          * 4<===============3           |0
            //          * ==================           |
            //          * ========C=========           |
            //          * ==================           |
            //          * 1===============>2           |1000
            //          * 0 ------------------->1000
            long[][] vmlPoints = new long[4][2];
            vmlPoints[0][0] = Math.round(Math.ceil(s4Points[0][0]));
            vmlPoints[0][1] = Math.round(Math.floor(s4Points[0][1]));
            vmlPoints[1][0] = Math.round(Math.floor(s4Points[1][0]));
            vmlPoints[1][1] = Math.round(Math.floor(s4Points[1][1]));
            vmlPoints[2][0] = Math.round(Math.floor(s4Points[2][0]));
            vmlPoints[2][1] = Math.round(Math.ceil(s4Points[2][1]));
            vmlPoints[3][0] = Math.round(Math.ceil(s4Points[3][0]));
            vmlPoints[3][1] = Math.round(Math.ceil(s4Points[3][1]));

            path = points2Path(vmlPoints);
            log.debug("path:" + path);

            TagNode vshape = new TagNode();
            vshape.setTagName("v:shape");
            vshape.setAttribute("type", sampleShape.getAttribute("type"));
            vshape.setAttribute("swimlane", shape.getText(), '"');
            vshape.setAttribute("title", shape.getText(), '"');
            vshape.setAttribute("origTitle", shape.getText(), '"');
            vshape.setAttribute("style", sampleShape.getAttribute("style"));
            vshape.setAttribute("path", path);
            vshape.setAttribute("onmouseover", "UpdateTooltip(this," + page.getID() + "," + shape.getID() + ")");
            vshape.setAttribute("onclick", "OnSwimlineClick(" + page.getID() + "," + shape.getID() + ")");
            vshape.setEmptyXmlTag(true);
            swimlaneNodeList.add(vshape);
        }


        //输出html
        return swimlaneNodeList.toHtml();
    }

    private static double predict(double slope, double intercept, double v) {
        return v * slope + intercept;
    }

    /**
     * ==================           |10000
     * ==================           |
     * ========C=========           |
     * ==================           |
     * ==================           |
     * 0 ------------------->1000   |0
     *
     * @param processShapes
     * @return
     */
    private static Shape getMostLeftTop(List<Shape> processShapes) {
        double minLeft = Integer.MAX_VALUE;
        double maxTop = Integer.MIN_VALUE;
        Shape ret = null;
        for (int i = 0; i < processShapes.size(); i++) {
            Shape shape = processShapes.get(i);

            double left = Double.parseDouble(shape.getXForm().getPinX().replace("mm", ""));
            double top = Double.parseDouble(shape.getXForm().getPinY().replace("mm", ""));

            if (left <= minLeft && top >= maxTop) {
                minLeft = left;
                maxTop = top;
                ret = shape;
            }
        }

        return ret;
    }

    private static String points2Path(long[][] vmlPoints) {
        StringBuffer sb = new StringBuffer();
        sb.append(" m ");
        for (int i = 0; i < vmlPoints.length; i++) {
            long[] vmlPoint = vmlPoints[i];
            sb.append(vmlPoint[0]).append(",").append(vmlPoint[1]).append(" l ");
        }
        sb.append(vmlPoints[0][0]).append(",").append(vmlPoints[0][1]);

        sb.append("xe");
        return sb.toString();
    }

    private static double[][] getXml4PointsFromProcessShape(Shape processShape) {
        double centerX = Double.parseDouble(processShape.getXForm().getPinX().replace("mm", ""));
        double centerY = Double.parseDouble(processShape.getXForm().getPinY().replace("mm", ""));
        double width = Double.parseDouble(processShape.getXForm().getWidth().replace("mm", ""));
        double height = Double.parseDouble(processShape.getXForm().getHeight().replace("mm", ""));

        //make 4 point corr of xml
        return getXml4Points(centerX, centerY, width, height);
    }

    //注意：process的x，y是shape的中心点

    /**
     * 4<===============3
     * ==================
     * ========C=========
     * ==================
     * 1===============>2
     *
     * @param centerY
     * @param width
     * @param height
     * @return
     */
    private static double[][] getXml4Points(double centerX, double centerY, double width, double height) {
        double[][] xml4Points = new double[4][2];
        xml4Points[0][0] = centerX - width / 2.0;
        xml4Points[0][1] = centerY - height / 2.0;
        xml4Points[1][0] = centerX + width / 2.0;
        xml4Points[1][1] = centerY - height / 2.0;
        xml4Points[2][0] = centerX + width / 2.0;
        xml4Points[2][1] = centerY + height / 2.0;
        xml4Points[3][0] = centerX - width / 2.0;
        xml4Points[3][1] = centerY + height / 2.0;
        return xml4Points;
    }

    public static Tag getVmlShapeById(NodeList vmlShapes, String id) {
        for (int i = 0; i < vmlShapes.size(); i++) {
            Tag vmlShape = (TagNode) vmlShapes.elementAt(i);
            String onClick = vmlShape.getAttribute("onclick");
            if ((!StringUtils.isEmpty(onClick))) {
                log.debug("the onClick is " + onClick);
                //OnShapeClick(21,22) ==> 22
                String vmlShapeId = onClick.substring(onClick.indexOf(",") + 1, onClick.indexOf(")"));
                if (id.equals(vmlShapeId)) {
                    return vmlShape;
                }
            }
        }
        log.warn("the vmlShape can not find in vmlShapes id:" + id);
        return null;
    }

    public static List<Shape> getProcesses(List<Shape> shapes) {

        List<Shape> processes = new ArrayList<Shape>();
        for (Shape shape : shapes) {
            if (shape.getNameU().startsWith(PROCESS_NAME)) {
                processes.add(shape);
            }
        }
        return processes;
    }

    public static List<Shape> getSwimlanes(List<Shape> shapes) {

        List<Shape> swimlanes = new ArrayList<Shape>();
        for (Shape shape : shapes) {
            if (shape.getNameU().startsWith(SWIMLANE_NAME)) {
                swimlanes.add(shape);
            }
        }
        return swimlanes;
    }

    public static String getTopologyXml(File parFile) throws IOException {
        ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(parFile);
        for (ZipEntry zipEntry : zipEntries) {
            log.debug("zipEntry.getName() = " + zipEntry.getName());
            if (zipEntry.getName().endsWith(TOPOLOGY__XML)) {
                return ParFileUtils.getContentFromPar(parFile, zipEntry.getName(), "utf-8");
            }
        }
        return null;
    }

    public static String getVmlHtm(File parFile) throws IOException {
        ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(parFile);
        for (ZipEntry zipEntry : zipEntries) {
            log.debug("zipEntry.getName() = " + zipEntry.getName());
            if (zipEntry.getName().endsWith(VML_1_HTM)) {
                return ParFileUtils.getContentFromPar(parFile, zipEntry.getName(), "utf-8");
            }
        }
        return null;
    }

    public static String getVmlEmz(File parFile) throws IOException {
        ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(parFile);
        for (ZipEntry zipEntry : zipEntries) {
            log.debug("zipEntry.getName() = " + zipEntry.getName());
            if (zipEntry.getName().endsWith(VML_1_EMZ)) {
                return ParFileUtils.getContentFromPar(parFile, zipEntry.getName(), "utf-8");
            }
        }
        return null;
    }


    static Pattern pattern = Pattern.compile("([-]?\\d+)");

    /**
     * 4<===============3     | -10000 minum
     * ==================     |
     * ==================     |
     * ==================     |
     * 1===============>2     | 0      large
     * eg.  m -461,-238 l -179,-238 l -179,-373 l -461,-373 l -461,-238xe     *
     *
     * @param path
     * @return 4 point corr  x=[i][0] y=[i][1]
     */
    private static double[][] path2Points(String path) {
        double[][] ret = new double[4][2];
        Matcher matcher = pattern.matcher(path);
        for (int i = 0; i < 8; i++) {
            matcher.find();
            double d = Double.parseDouble(matcher.group());
            ret[i / 2][i % 2] = d;
        }
        return ret;
    }

    private static String points2String(double[][] points) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < points.length; i++) {
            double[] point = points[i];
            sb.append("p" + i + ":").append(point[0]).append(",").append(point[1]).append(" ");
        }
        return sb.toString();
    }
}
