package com.example.expensesharing.service;

import com.example.expensesharing.model.Group;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GroupService {

    private final Map<String, Group> groups = new HashMap<>();

    public Group createGroup(Group group) {
        groups.put(group.getGroupId(), group);
        return group;
    }

    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }

    public Collection<Group> getAllGroups() {
        return groups.values();
    }
}
