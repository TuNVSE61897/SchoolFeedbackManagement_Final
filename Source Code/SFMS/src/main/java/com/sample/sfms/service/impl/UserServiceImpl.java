package com.sample.sfms.service.impl;

import com.sample.sfms.entity.Department;
import com.sample.sfms.entity.Major;
import com.sample.sfms.entity.Role;
import com.sample.sfms.entity.User;
import com.sample.sfms.model.user.SaveUserModel;
import com.sample.sfms.repository.DepartmentRepository;
import com.sample.sfms.repository.MajorRepository;
import com.sample.sfms.repository.RoleRepository;
import com.sample.sfms.repository.UserRepository;
import com.sample.sfms.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.RollbackException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }






    @Override
    public List<User> search(String q) {
        return userRepository.findByBirthContaining(q);
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private MajorRepository majorRepository;

    @Override
    public User findUserByMail(String email) {

        return userRepository.findByMail(email);
    }

    @Override
    public ResponseEntity saveUser(SaveUserModel userModel) {
        User user;
        if (userModel.getId() != 0) {
            user = userRepository.findOne(userModel.getId());
            if (user != null) {
                if (userModel.getPassword() != null && userModel.getPassword().length() > 0) {
                    String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
                    user.setPassword(encodedPassword);
                }
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } else {
            user = new User();
            String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
            user.setPassword(encodedPassword);
            user.setUsername(userModel.getUsername());
        }
        if (userModel.getRoleByRoleId() > 0) {
            Role role = roleRepository.findOne(userModel.getRoleByRoleId());
            user.setRoleByRoleId(role);
        }
        if (userModel.getDepartmentByDepartmentId() > 0) {
            Department department = departmentRepository.findOne(userModel.getDepartmentByDepartmentId());
            user.setDepartmentByDepartmentId(department);
        } else {
            user.setDepartmentByDepartmentId(null);
        }
        if (userModel.getMajorByMajorId() > 0) {
            Major major = majorRepository.findOne(userModel.getMajorByMajorId());
            user.setMajorByMajorId(major);
        } else {
            user.setMajorByMajorId(null);
        }
        user.setMail(userModel.getMail());
        user.setCode(userModel.getCode());
        user.setFullname(userModel.getFullname());
        user.setBirth(userModel.getBirth());
        user.setMale(userModel.isMale());
        user.setStatus((byte) (userModel.isStatus() ? 1 : 0));
        user.setCode(userModel.getCode());
        try {
            user = userRepository.save(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (RollbackException e) {
            logger.log(Level.FINE, e.toString());
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Role> getListRole() {

        return roleRepository.findAll();
    }














    @Override
    public User getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity checkExistedEmail(String email) {
        User user = userRepository.findByMail(email);
        if (user == null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity checkExistedCode(String code) {
        User user = userRepository.findByCode(code);
        if (user == null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity checkExistedUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

}