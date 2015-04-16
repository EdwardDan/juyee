package com.justonetech.biz.core.orm.hibernate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-2-27
 * Time: 下午2:11
 * To change this template use File | Settings | File Templates.
 */
public class Group {

    private String groupOp;

    private List<Rule> rules;

    private List<Group> groups;

    public Group() {
    }

    public Group(String groupOp, List<Rule> rules, List<Group> groups) {
        this.groupOp = groupOp;
        this.rules = rules;
        this.groups = groups;
    }

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}

