package com.sample.sfms.service.impl;

import com.sample.sfms.entity.Privilege;
import com.sample.sfms.entity.PrivilegeRole;
import com.sample.sfms.entity.Role;
import com.sample.sfms.repository.PrivilegeRepository;
import com.sample.sfms.repository.PrivilegeRoleRepository;
import com.sample.sfms.repository.RoleRepository;
import com.sample.sfms.service.interf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    static Logger logger = Logger.getLogger(RoleServiceImpl.class.getName());
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PrivilegeRoleRepository privilegeRoleRepository;

    @Override
    public List<Role> getListRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByRoleId(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public ResponseEntity<Role> saveRole(int id, String roleName, String[] privilegeNames) {
        Role role = roleRepository.findById(id);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        role.setRoleName(roleName);
        ResponseEntity<Role> response;
        try {
            List<Privilege> privileges = findPrivilegesByName(privilegeNames);
            List<PrivilegeRole> privilegeRoles = new ArrayList<>();
            List<Integer> listPrivilegeIds = new ArrayList<>();
            for (Privilege p : privileges) {
                PrivilegeRole pr = new PrivilegeRole();
                pr.setRole(role);
                pr.setPrivilege(p);
                privilegeRoles.add(pr);
                listPrivilegeIds.add(p.getId());
            }
            privilegeRoleRepository.clearAllByRoleId(role.getId()); //TODO tìm cách khác tốt hơn :(
            privilegeRoleRepository.save(privilegeRoles);
            role.setPrivilegeRolesById(privilegeRoles);
            roleRepository.save(role);
            response = new ResponseEntity<>(HttpStatus.OK);
            return response;
        } catch (UnexpectedRollbackException e){
            logger.log(Level.FINE, e.toString());
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    @Override
    public ResponseEntity<Role> saveRole(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        try {
            roleRepository.save(role);
            return new ResponseEntity<>(role, HttpStatus.CREATED);
        } catch (UnexpectedRollbackException e){
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Role> saveRole(String roleName, String[] privilegeNames) {
        Role role = new Role();
        role.setRoleName(roleName);
        try {
            role = roleRepository.save(role);
            List<Privilege> privileges = findPrivilegesByName(privilegeNames);
            PrivilegeRole pr;
            List<PrivilegeRole> privilegeRoles = new ArrayList<>();
            for (Privilege p : privileges) {
                pr = new PrivilegeRole();
                pr.setPrivilege(p);
                pr.setRole(role);
                privilegeRoles.add(pr);
            }
            privilegeRoleRepository.save(privilegeRoles);
            role.setPrivilegeRolesById(privilegeRoles);
            return new ResponseEntity<>(role, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<Role>(role, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Role> removeRole(int id) {
        Role role = roleRepository.findById(id);
        if(null == role){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try{
            privilegeRoleRepository.clearAllByRoleId(role.getId());
            roleRepository.delete(role.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnexpectedRollbackException e){
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private List<Privilege> findPrivilegesByName(String[] privilegeNames) {
        List<Privilege> listPrivilege = new ArrayList<>();
        if (null != privilegeNames) {
            if (privilegeNames.length > 0) {
                for (int i = 0; i < privilegeNames.length; i++) {
                    Privilege privilege = privilegeRepository.findByName(privilegeNames[i]);
                    if (privilege != null) {
                        listPrivilege.add(privilege);
                    }
                }
            }
        }
        return listPrivilege;
    }
}
