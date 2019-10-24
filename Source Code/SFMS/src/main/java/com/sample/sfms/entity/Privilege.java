package com.sample.sfms.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
public class Privilege {
    private int id;
    private String name;
    private Collection<PrivilegeRole> privilegeRolesById;

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
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;

        if (id != privilege.id) return false;
        if (name != null ? !name.equals(privilege.name) : privilege.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "privilegeRolePK.privilege")
    public Collection<PrivilegeRole> getPrivilegeRolesById() {
        return privilegeRolesById;
    }

    public void setPrivilegeRolesById(Collection<PrivilegeRole> privilegeRolesById) {
        this.privilegeRolesById = privilegeRolesById;
    }
}
