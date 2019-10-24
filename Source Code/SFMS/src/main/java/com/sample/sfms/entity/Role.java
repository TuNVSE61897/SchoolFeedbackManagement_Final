package com.sample.sfms.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
public class Role {
    private int id;
<<<<<<< Updated upstream
=======
    @JsonView({UserView.authenticatedUser.class, UserView.listUserView.class})
>>>>>>> Stashed changes
    private String roleName;
    private Collection<PrivilegeRole> privilegeRolesById;
    private Collection<User> usersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name", nullable = true, length = 255)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        if (roleName != null ? !roleName.equals(role.roleName) : role.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "privilegeRolePK.role")
    public Collection<PrivilegeRole> getPrivilegeRolesById() {
        return privilegeRolesById;
    }

    public void setPrivilegeRolesById(Collection<PrivilegeRole> privilegeRolesById) {
        this.privilegeRolesById = privilegeRolesById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
