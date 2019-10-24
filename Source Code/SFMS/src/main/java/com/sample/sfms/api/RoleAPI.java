package com.sample.sfms.api;

import com.sample.sfms.entity.Role;
import com.sample.sfms.service.interf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleAPI {

    @Autowired
    private RoleService roleService;

    @GetMapping
    private List<Role> getListRole(){
        return roleService.getListRole();
    }

    @GetMapping("/{id}")
    private Role getRole(@PathVariable("id") int id){
        return roleService.getRoleByRoleId(id);
    }

    @PostMapping
    private ResponseEntity<Role> postRole(@RequestParam("roleName") String roleName, @RequestParam(value = "privilegeNames", required = false) String[] privilegeNames) {
        return roleService.saveRole(roleName, privilegeNames);
    }

    @PutMapping
    private ResponseEntity<Role> putRole(@RequestParam("id") int id, @RequestParam("roleName") String roleName, @RequestParam(value = "privilegeNames", required = false) String[] privilegeNames) {
        return roleService.saveRole(id, roleName, privilegeNames);
    }

    @DeleteMapping
    private ResponseEntity<Role> deleteRole(@RequestParam("id") int id){
        return roleService.removeRole(id);
    }
}
