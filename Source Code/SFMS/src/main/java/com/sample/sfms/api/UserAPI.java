package com.sample.sfms.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.entity.User;
import com.sample.sfms.model.user.SaveUserModel;
import com.sample.sfms.service.interf.UserService;
import com.sample.sfms.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAPI {

    @Autowired
    private UserService userService;

    @JsonView(UserView.listUserView.class)
    @GetMapping
    private Iterable<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    private User getUser(@PathVariable("id") int id){
        return userService.findOne(id);
    }

    @PostMapping
    private ResponseEntity saveUser(@RequestBody SaveUserModel userModel) {
        return userService.saveUser(userModel);
    }

    @PutMapping
    private ResponseEntity updateUser(@RequestBody SaveUserModel userModel) {
        return userService.saveUser(userModel);
    }

    @DeleteMapping
    private void deleteUser(@RequestParam("id") int id){
        userService.delete(id);
    }
<<<<<<< Updated upstream
=======

    @GetMapping("/email")
    private ResponseEntity checkExistedEmail(@RequestParam("email") String email) {
        return userService.checkExistedEmail(email);
    }

    @GetMapping("/code")
    private ResponseEntity checkExistedCode(@RequestParam("code") String code) {
        return userService.checkExistedCode(code);
    }

    @GetMapping("/username")
    private ResponseEntity checkExistedUsername(@RequestParam("username") String username) {
        return userService.checkExistedUsername(username);
    }

>>>>>>> Stashed changes
}
