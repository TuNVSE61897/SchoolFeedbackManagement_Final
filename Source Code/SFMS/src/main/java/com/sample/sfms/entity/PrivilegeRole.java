package com.sample.sfms.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
@Table(name = "privilege_role", schema = "capstone", catalog = "")
//@IdClass(PrivilegeRolePK.class)
public class PrivilegeRole {
    private PrivilegeRolePK privilegeRolePK;

    public PrivilegeRole() {
        privilegeRolePK = new PrivilegeRolePK();
    }

    @EmbeddedId
    public PrivilegeRolePK getPrivilegeRolePK() {
        return privilegeRolePK;
    }

    public void setPrivilegeRolePK(PrivilegeRolePK privilegeRolePK) {
        this.privilegeRolePK = privilegeRolePK;
    }

    @Transient
    public Privilege getPrivilege() {
        return getPrivilegeRolePK().getPrivilege();
    }

    public void setPrivilege(Privilege privilege) {
        getPrivilegeRolePK().setPrivilege(privilege);
    }

    @Transient
    public Role getRole() {
        return getPrivilegeRolePK().getRole();
    }

    public void setRole(Role role) {
        getPrivilegeRolePK().setRole(role);
    }

//    private int roleId;
//    private int privilegeId;
//    private Role roleByRoleId;
//    private Privilege privilegeByPrivilegeId;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_id", nullable = false)
//    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
//
//    @Id
//    @Column(name = "privilege_id", nullable = false)
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
//        PrivilegeRole that = (PrivilegeRole) o;
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
//
//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
//    public Role getRoleByRoleId() {
//        return roleByRoleId;
//    }
//
//    public void setRoleByRoleId(Role roleByRoleId) {
//        this.roleByRoleId = roleByRoleId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "privilege_id", referencedColumnName = "id", nullable = false)
//    public Privilege getPrivilegeByPrivilegeId() {
//        return privilegeByPrivilegeId;
//    }
//
//    public void setPrivilegeByPrivilegeId(Privilege privilegeByPrivilegeId) {
//        this.privilegeByPrivilegeId = privilegeByPrivilegeId;
//    }
}
