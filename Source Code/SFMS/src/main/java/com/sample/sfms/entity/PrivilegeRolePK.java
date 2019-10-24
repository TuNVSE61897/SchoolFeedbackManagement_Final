package com.sample.sfms.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by MyPC on 22/02/2018.
 */
@Embeddable
public class PrivilegeRolePK implements Serializable {

    private Privilege privilege;
    private Role role;

    @ManyToOne
    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    @ManyToOne
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    private int roleId;
//    private int privilegeId;
//
//    @Column(name = "role_id", nullable = false, insertable = false, updatable = false)
//    @Id
//    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
//
//    @Column(name = "privilege_id", nullable = false, insertable = false, updatable = false)
//    @Id
//    public int getPrivilegeId() {
//        return privilegeId;
//    }
//
//    public void setPrivilegeId(int privilegeId) {
//        this.privilegeId = privilegeId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PrivilegeRolePK that = (PrivilegeRolePK) o;
//
//        if (roleId != that.roleId) return false;
//        if (privilegeId != that.privilegeId) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = roleId;
//        result = 31 * result + privilegeId;
//        return result;
//    }
}
