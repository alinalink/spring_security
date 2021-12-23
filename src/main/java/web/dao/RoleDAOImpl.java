package web.dao;

import org.springframework.stereotype.Component;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("select role from Role role where role.role=:name", Role.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Role> allRoles() {
        return entityManager.createQuery("select role from Role role", Role.class).getResultList();
    }

    @Override
    public void createRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(getRoleByName(role));
        }
        return (HashSet) roleSet;
    }

}
