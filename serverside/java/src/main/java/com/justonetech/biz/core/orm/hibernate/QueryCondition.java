package com.justonetech.biz.core.orm.hibernate;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-3-22
 * Time: 上午9:39
 * To change this template use File | Settings | File Templates.
 */
public class QueryCondition {

    private Group group;

    private String orderColumn;

    private String orderType;

    public QueryCondition() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
