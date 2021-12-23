package web.dao;

import web.model.Role;

import java.util.HashSet;
import java.util.List;


public interface RoleDAO {
    Role getRoleByName(String name);

    List<Role> allRoles();

    void createRole(Role role);

    HashSet<Role> getSetOfRoles(String[] roleNames);

}
