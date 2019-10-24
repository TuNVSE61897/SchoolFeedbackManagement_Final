package com.sample.sfms.controller;

import com.sample.sfms.entity.User;
import com.sample.sfms.service.interf.DepartmentService;
import com.sample.sfms.service.interf.MajorService;
import com.sample.sfms.service.interf.RoleService;
import com.sample.sfms.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private MajorService majorService;

    @GetMapping
    private ModelAndView listUser() {
        ModelAndView mav = new ModelAndView("view-list-users");
        mav.addObject("roleList", roleService.getListRole());
        mav.addObject("departmentList", departmentService.getAllDepartment());
        mav.addObject("majorList", majorService.getAllMajor());
        return mav;
    }

    @GetMapping("/edit/{id}")
    private ModelAndView editUser(@PathVariable("id") int id) {
        User user = userService.findOne(id);
        ModelAndView mav = new ModelAndView("user-detail");
        mav.addObject("userDetail", user);
        mav.addObject("roleList", roleService.getListRole());
        mav.addObject("departmentList", departmentService.getAllDepartment());
        mav.addObject("majorList", majorService.getAllMajor());
        return mav;
    }

    @GetMapping("/add")
    private ModelAndView addUser() {
        ModelAndView mav = new ModelAndView("user-detail");
        mav.addObject("userDetail", new User());
        mav.addObject("roleList", roleService.getListRole());
        mav.addObject("departmentList", departmentService.getAllDepartment());
        mav.addObject("majorList", majorService.getAllMajor());
        return mav;
    }
}

