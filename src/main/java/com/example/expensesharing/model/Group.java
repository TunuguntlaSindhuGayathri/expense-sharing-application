package com.example.expensesharing.model;

import java.util.List;

public class Group {

    private String groupId;
    private String name;
    private List<User> members;

    public Group() {}

    public Group(String groupId, String name, List<User> members) {
        this.groupId = groupId;
        this.name = name;
        this.members = members;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
