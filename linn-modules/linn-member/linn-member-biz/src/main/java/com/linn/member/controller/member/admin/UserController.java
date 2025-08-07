package com.linn.member.controller.member.admin;

import com.linn.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("adminUserController")
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;


    
}
