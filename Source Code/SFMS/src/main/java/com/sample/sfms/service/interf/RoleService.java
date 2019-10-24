package com.sample.sfms.service.interf;

import com.sample.sfms.entity.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {

    List<Role> getListRole();

    Role getRoleByRoleId(int id);

    ResponseEntity<Role> saveRole(int id, String roleName, String[] privilegeNames);

    ResponseEntity<Role> saveRole(String roleName);

    ResponseEntity<Role> saveRole(String roleName, String[] privilegeNames);

    ResponseEntity<Role> removeRole(int id);

}

