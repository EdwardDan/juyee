package com.justonetech.biz.utils.jbpm.db;

public class NodeEnterActionData {
    private String[] userIds;
    private NodeTask[] nodeTasks;

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    public NodeTask[] getNodeTasks() {
        return nodeTasks;
    }

    public void setNodeTasks(NodeTask[] nodeTasks) {
        this.nodeTasks = nodeTasks;
    }

    public String getTaskTypeByName(String name){
        for(NodeTask nodeTask:nodeTasks){
            if(name.equals(nodeTask.getTaskName())){
                return nodeTask.getTaskType();
            }
        }
        return null;
    }
}
