package com.justonetech.biz.utils.jbpm.db;

public class TimerCreateActionData {
    private String dueDate;
    private String repeat;

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }
}
