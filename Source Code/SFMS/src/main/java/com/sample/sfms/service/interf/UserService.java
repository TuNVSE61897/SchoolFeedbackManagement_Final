package com.sample.sfms.service.interf;

import com.sample.sfms.entity.Role;
import com.sample.sfms.entity.User;
import com.sample.sfms.model.user.SaveUserModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface UserService {
    User findUserByMail(String email);

    ResponseEntity saveUser(SaveUserModel user);

    List<Role> getListRole();

    List<User> findAll();

    List<User> search(String q);

    User findOne(int id);

    void save(User user);

    void delete(int id);

    User getCurrentAuthenticatedUser();

    ResponseEntity checkExistedEmail(String email);

    ResponseEntity checkExistedCode(String code);

    ResponseEntity checkExistedUsername(String username);

}
