package com.wings.usermanagement.Controller;

import com.wings.usermanagement.Model.TbUser;
import com.wings.usermanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService ;

    @GetMapping("/getallusers")
    public List<TbUser> getAllUsers(){
        List<TbUser> users = userService.getAllAuthUser();
        return users;
    }
}
