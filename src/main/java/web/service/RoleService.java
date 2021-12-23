package web.service;

import web.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);

    List<Role> allRoles();

    void createRole(Role role);

    HashSet<Role> getSetOfRoles(String[] roleNames);
}
