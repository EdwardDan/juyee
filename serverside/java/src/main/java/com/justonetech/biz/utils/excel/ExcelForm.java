package com.justonetech.biz.utils.excel;

import com.justonetech.core.utils.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.tags.HeadTag;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.HtmlPage;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ExcelForm extends HtmlPage {
    //@currentTable:excel中当前被遍历的table的序列号
    private int currentTable;
    private int currentTr;
    private int currentTd;
    private int endCol;

    //@markMap:标记单元格是否被占据；
    private Map<String, Boolean> markMap = new HashMap<String, Boolean>();

    private String bodyTagHtml;

    //@htmlTagHtml:excel起始标签
    private String htmlTagHtml;
    private String headHtml;

    //@document:xml解析器
    private Document document;
    //@parser:html解析器,可以通过该编辑器来设置编码解析格式(parser.setEncoding("gb2312"))
    private Parser parser;

    private static final Log log = LogFactory.getLog(ExcelForm.class);

    /**
     * @param htmlString 待解析的html代码，默认编码格式为gb2312
     * @param xmlString  待解析的xml代码
     * @throws org.htmlparser.util.ParserException
     *                                  .
     * @throws java.io.IOException      .
     * @throws org.xml.sax.SAXException .
     * @throws javax.xml.parsers.ParserConfigurationException
     *                                  .
     */
    public ExcelForm(String htmlString, String xmlString) throws ParserException, IOException, SAXException, ParserConfigurationException {
        this(getParser(htmlString), ExcelFormUtils.getDocument(xmlString));
    }

    /**
     * @param parser   html代码解析器
     * @param document xml代码解析器
     */
    public ExcelForm(Parser parser, Document document) {
        super(parser);
        this.parser = parser;
        this.document = document;
    }

    /**
     * 把列数转化成excel的表示方式
     * 如:5转化为E，27转化为AA
     * 目前根据excel2003仅支持到256
     *
     * @param number 列编号
     * @return 列编码(A, B...)
     */
    public String number2Alphabet(int number) {
        String alphabet = "";

        //excel2003的最大列数为256
        if (number < 1 || number > 256) {
            throw new RuntimeException("number overflow for alphabet!");
        }
        final int charCount = 26;
        int firstChar = number / charCount;
        int secondChar = number % charCount;
        if (firstChar > 0) {
            alphabet += (char) (firstChar + 65 - 1);
        }
        alphabet += (char) (secondChar + 65 - 1);

        return alphabet;
    }

    /**
     * A => 1, AA=>27
     *
     * @param alphabet .
     * @return .
     */
    public int alphabet2Number(String alphabet) {
        int number = 0;
        if (alphabet.length() > 2)
            throw new RuntimeException("alphabet length overflow!");

        char[] chars = alphabet.toUpperCase().toCharArray();
        for (char aChar : chars) {
            if (aChar < 'A' && aChar > 'Z') {
                throw new RuntimeException("alphabet is illegal:" + aChar);
            }
            int offset = aChar - 'A' + 1;
            number = number * 26 + offset;
        }

        return number;
    }

    /**
     * @return 返回合并xml和htm而生成的新htm代码
     * @throws org.htmlparser.util.ParserException
     *          .
     */
    public String getHTMLContent() throws ParserException {
        this.parser.visitAllNodesWith(this);
        return getHtmlTagHtml() + "\n" + getHeadHtml() + "\n" + getBodyTagHtml() + "\n" + this.getBody().toHtml() + "\n</body>\n</html>";
    }

    /**
     * 遍历excel的每一个节点(Table,Tr,Td...)，修改和调整各节点属性
     *
     * @param tag 节点
     */
    public void visitTag(Tag tag) {
        super.visitTag(tag);
        if (tag.getTagName().equalsIgnoreCase("HTML")) {
            setHtmlTagHtml(tag.toTagHtml());
        } else if (tag instanceof HeadTag) {
            setHeadHtml(tag.toHtml());
        } else if (tag.getTagName().equalsIgnoreCase("BODY")) {
            bodyTagHtml = tag.toTagHtml();
        } else if (tag.getTagName().equalsIgnoreCase("TABLE")) {
            visitTableTag();
        } else if (tag.getTagName().equalsIgnoreCase("/TABLE")) {
            visitEndTableTag();
        } else if (tag.getTagName().equalsIgnoreCase("TR")) {
            visitTRTag(tag);
        } else if (tag.getTagName().equalsIgnoreCase("/TR")) {
            visitEndTRTag(tag);
        } else if (tag.getTagName().equalsIgnoreCase("TD")) {
            visitTDTag(tag);
        }
    }

    private void visitEndTableTag() {
        currentTable--;
    }

    private void visitTRTag(Tag tag) {
        //取采用样式合并rows的mso-xlrowspan值
        String style = tag.getAttribute("style");
        if (!StringHelper.isEmpty(style)) {
            String[] styleAttrs = style.split(";");
            for (String styleAttr : styleAttrs) {
                if (styleAttr.contains("mso-xlrowspan")) {
                    currentTr += Integer.valueOf(styleAttr.substring(styleAttr.indexOf(":") + 1, styleAttr.length()).trim()) - 1;
                }
            }
        }
        currentTr++;
        currentTd = 0;
        endCol = 0;
    }

    private void visitEndTRTag(Tag tag) {
        currentTr--;
    }

    private void visitTableTag() {
        currentTable++;
        //因为currentTr++
        currentTr = -1;
        if (currentTable > 1) {
            log.warn("列表中table 数量大于1");
        }
    }

    private void visitTDTag(Tag tag) {
        //得到当前单元格是多少行多少列
        Integer colspan = Integer.valueOf(tag.getAttribute("colspan") == null ? "1" : tag.getAttribute("colspan"));
        Integer rowspan = Integer.valueOf(tag.getAttribute("rowspan") == null ? "1" : tag.getAttribute("rowspan"));

        //找到未被占据的单元格,只查找当前行,
        int unSetCol = endCol;
        for (; ; unSetCol++) {
            Boolean hasSet = getMarkMap().get("$" + number2Alphabet(unSetCol + 1) + "$" + (currentTr + 1));
            if (hasSet == null) {
                break;
            }
        }
        //给map设定标识
        for (int row = 1; row <= rowspan; row++) {
            for (int col = 1; col <= colspan; col++) {
                Boolean hasSetCell = getMarkMap().get("$" + number2Alphabet(unSetCol + col) + "$" + (currentTr + row));
                if (hasSetCell != null) {
                    log.warn("key:" + "$" + number2Alphabet(unSetCol + col) + "$" + (currentTr + row) + " has in markmap!!");
                }
                getMarkMap().put("$" + number2Alphabet(unSetCol + col) + "$" + (currentTr + row), true);
            }
        }
        //根据行和列的序列生成定位单元格的address
        String address = "";
        if (colspan < 1 || rowspan < 1) {
            log.warn("colspan's value or rowspan's value smaller than 1.i,j:" + currentTr + "," + currentTd);
        } else if (colspan == 1 && rowspan == 1) {
            address = "$" + number2Alphabet(unSetCol + 1) + "$" + (currentTr + 1);
            tag.setAttribute("address", "$" + number2Alphabet(unSetCol + 1) + "$" + (currentTr + 1));
        } else {
            address = "$" + number2Alphabet(unSetCol + 1) + "$" + (currentTr + 1) + ":$" + number2Alphabet(unSetCol + colspan) + "$" + (currentTr + rowspan);
            tag.setAttribute("address", address);
        }
        //添加单元格的属性
        addAttributeToTdTag(tag, address);

        endCol += colspan;
    }

    /**
     * 如果td的address等于xml中Item属性Address的值
     * 或者address在Address的范围之中（如：address=$A$3,address="$A$3:$H$5"） ,给Td注入属性
     *
     * @param tag     .
     * @param address .
     */
    private void addAttributeToTdTag(Tag tag, String address) {
        NodeList itemNodeList = document.getElementsByTagName("Item");
        if (null != itemNodeList)
            for (int i = 0; i < itemNodeList.getLength(); i++) {
                String range = itemNodeList.item(i).getAttributes().getNamedItem("Address").getNodeValue();
//                if (address.equals(range) || addressInRange(address, range)) {  //modify by chenjp at 20140618
                if (address.equals(range)) {
                    NodeList childNodeList = itemNodeList.item(i).getChildNodes();
                    for (int j = 0; j < childNodeList.getLength(); j++) {
                        //当节点名称为Property时，取其属性和文本
                        if (childNodeList.item(j).getNodeName().equals("Property")) {
                            String attributeName = childNodeList.item(j).getAttributes().getNamedItem("Name").getNodeValue();
                            String attributeValue = childNodeList.item(j).getTextContent();
                            //排出空白节点
                            if (!attributeValue.trim().equals("")) {
                                tag.setAttribute(attributeName, attributeValue);
                            }
                        }
                    }
                }

            }
    }

    /**
     * 判断编号是否在添加属性范围之列
     *
     * @param address .
     * @param range   .
     * @return .
     */
    private boolean addressInRange(String address, String range) {
        //range:$D$3:$J$3
        //range:$D$3

        //address:$L$3:$M$3
        //address:$L$3

        int rangeCol0, rangeRow0, rangeCol1, rangeRow1;
        int addressCol0, addressRow0, addressCol1, addressRow1;


        String rangeFromCell, rangeToCell;
        rangeFromCell = range;
        rangeToCell = rangeFromCell;
        if (range.contains(":")) {
            String[] cells = range.split(":");
            rangeFromCell = cells[0];
            rangeToCell = cells[1];
        }

        rangeCol0 = cell2ColRow(rangeFromCell)[0];
        rangeRow0 = cell2ColRow(rangeFromCell)[1];

        rangeCol1 = cell2ColRow(rangeToCell)[0];
        rangeRow1 = cell2ColRow(rangeToCell)[1];

        String addressFromCell, addressToCell;
        addressFromCell = address;
        addressToCell = addressFromCell;
        if (address.contains(":")) {
            String[] cells = address.split(":");
            addressFromCell = cells[0];
            addressToCell = cells[1];
        }

        addressCol0 = cell2ColRow(addressFromCell)[0];
        addressRow0 = cell2ColRow(addressFromCell)[1];

        addressCol1 = cell2ColRow(addressToCell)[0];
        addressRow1 = cell2ColRow(addressToCell)[1];


        return (addressCol0 >= rangeCol0 && addressRow0 >= rangeRow0 && addressCol1 <= rangeCol1 && addressRow1 <= rangeRow1);

    }

    /**
     * $A$3  => new int[]{1,3};  todo alphabet2Number存在问题
     *
     * @param cell .
     * @return .
     */
    private int[] cell2ColRow(String cell) {
        int[] ret = new int[2];
        String addressCol = cell.substring(1, cell.lastIndexOf("$"));
        String addressRow = cell.substring(cell.lastIndexOf("$") + 1, cell.length());
        ret[0] = alphabet2Number(addressCol);
        ret[1] = Integer.parseInt(addressRow);

        return ret;
    }


    /**
     * @param htmlString .
     * @return .
     * @throws org.htmlparser.util.ParserException
     *          .
     */
    private static Parser getParser(String htmlString) throws ParserException {

        //1.replace comment in one line which make the parse work abnormally
        htmlString = htmlString.replaceAll("<!--[^>\\n\\r]*-->", "");
        return new Parser(htmlString);

//        Lexer mLexer = new Lexer(new Page(htmlString));
//        return new Parser(mLexer,
//                new DefaultParserFeedback(DefaultParserFeedback.QUIET));
    }

    public String getBodyTagHtml() {
        return bodyTagHtml;
    }

    public void setBodyTagHtml(String bodyTagHtml) {
        this.bodyTagHtml = bodyTagHtml;
    }

    private String getHtmlTagHtml() {
        return htmlTagHtml;
    }

    private void setHtmlTagHtml(String htmlTagHtml) {
        this.htmlTagHtml = htmlTagHtml;
    }

    private String getHeadHtml() {
        return headHtml;
    }

    private void setHeadHtml(String headHtml) {
        this.headHtml = headHtml;
    }

    private Map<String, Boolean> getMarkMap() {
        return markMap;
    }

}