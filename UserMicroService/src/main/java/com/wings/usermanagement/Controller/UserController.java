package com.wings.usermanagement.Controller;

import com.wings.usermanagement.Dto.UserDTO;
import com.wings.usermanagement.Model.TbUserLevel;
import com.wings.usermanagement.Service.JWTService;
import com.wings.usermanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {
    @Autowired
    private  UserService userService ;

    private  final JWTService jwtService ;

    public UserController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/getusers")
    public List<UserDTO> getAllUser(){
       List<UserDTO> users =userService.getAllUser() ;
       return  users ;
    }

    @GetMapping("/getuserlevel")
    public List<TbUserLevel> getAllUserLevels(){
        return userService.getAllUserLevels();
    }
    @GetMapping("/login")
    public String login(){
        return jwtService.getJWTToken();
    }
    @PostMapping("/loginrequest")
    public  String loginReq(){
        return "login request";
    }
    @GetMapping("/username")
    public String getUserName(@RequestParam String token){
        return jwtService.getUserName(token);
    }
}
