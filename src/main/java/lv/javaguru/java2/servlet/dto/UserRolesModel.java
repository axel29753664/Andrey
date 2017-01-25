package lv.javaguru.java2.servlet.dto;

import lv.javaguru.java2.domain.Role;
import lv.javaguru.java2.domain.RolesSet;

import java.util.HashSet;
import java.util.Set;

public class UserRolesModel {
    private boolean admin;
    private boolean user;

    public UserRolesModel() {
    }

    public UserRolesModel(Set<Role> roleSet) {
        for (Role role : roleSet) {
            if (role.getName().equals(RolesSet.ADMIN.getName())) {
                admin = true;
            }
            if (role.getName().equals(RolesSet.USER.getName())) {
                user = true;
            }
        }
    }

    public Set<Role> getUserRoles() {
        Set<Role> roleSet = new HashSet<>();
        if (admin) {
            roleSet.add(RolesSet.ADMIN);
        }
        if (user) {
            roleSet.add(RolesSet.USER);
        }
        return roleSet;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRolesModel{" +
                "admin=" + admin +
                ", user=" + user +
                '}';
    }
}
