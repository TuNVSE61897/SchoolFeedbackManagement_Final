package com.sample.sfms.repository;

import com.sample.sfms.entity.PrivilegeRole;
import com.sample.sfms.entity.PrivilegeRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by MyPC on 19/02/2018.
 */
@Repository
public interface PrivilegeRoleRepository extends JpaRepository<PrivilegeRole, PrivilegeRolePK> {
    @Transactional
    @Modifying
    @Query("DELETE FROM PrivilegeRole where privilegeRolePK.role.id=:roleId")
    int clearAllByRoleId(@Param("roleId") int roleId);
}
