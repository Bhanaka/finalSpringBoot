package com.wings.inventory.Controller;

import com.wings.inventory.Dto.UserDTO;
import com.wings.inventory.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {
    @Autowired
    private  UserService userService ;
    @GetMapping("/getusers")
    public List<UserDTO> getAllUser(){
       List<UserDTO> users =userService.getAllUser() ;
       return  users ;
    }
}
