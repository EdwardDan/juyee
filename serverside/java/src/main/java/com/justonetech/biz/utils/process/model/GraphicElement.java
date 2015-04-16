package com.justonetech.biz.utils.process.model;


import com.justonetech.biz.utils.process.visio.Shape;
import org.dom4j.Element;

public abstract class GraphicElement {
    private Long id;

    private String text;

    private double x;

    private double y;

    private double width;

    private double height;

    private double angle;

    private String nameU;

    private String name;

    private String uniqueID;

    private String from;

    private String to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    protected void setNormalAttribute(GraphicElement element, Shape shape) {
        element.setId(Long.valueOf(shape.getID()));
        element.setUniqueID(shape.getUniqueID());
        element.setX(string2Double(shape.getXForm().getPinX()));
        element.setY(string2Double(shape.getXForm().getPinY()));
        element.setAngle(string2Double(shape.getXForm().getAngle()));
        element.setHeight(string2Double(shape.getXForm().getHeight()));
        element.setWidth(string2Double(shape.getXForm().getWidth()));
        element.setName(shape.getName());
        element.setNameU(shape.getNameU());
        element.setText(shape.getText());
    }

    private Double string2Double(String stringNum) {
        Double result = 0.0;
        stringNum = stringNum.substring(0, stringNum.indexOf(" "));
        result = Double.valueOf(stringNum);
        return result;
    }

    public abstract Element toXml();
}