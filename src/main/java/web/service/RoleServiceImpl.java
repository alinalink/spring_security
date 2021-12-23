package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDAO;
import web.model.Role;

import java.util.HashSet;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    public List<Role> allRoles() {
        return roleDAO.allRoles();
    }

    @Override
    public void createRole(Role role) {
        roleDAO.createRole(role);
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        return roleDAO.getSetOfRoles(roleNames);
    }

}
