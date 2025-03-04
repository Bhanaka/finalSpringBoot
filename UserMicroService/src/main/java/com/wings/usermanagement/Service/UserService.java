package com.wings.usermanagement.Service;

import com.wings.usermanagement.Dto.UserDTO;
import com.wings.usermanagement.Model.TbUser;
import com.wings.usermanagement.Model.TbUserLevel;
import com.wings.usermanagement.Model.UserEntity;
import com.wings.usermanagement.Repository.UserDetailsRepository;
import com.wings.usermanagement.Repository.UserLevelRepository;
import com.wings.usermanagement.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService{
    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private UserLevelRepository userLevelRepository ;
    @Autowired
    UserDetailsRepository userDetailsRepository ;

    @Autowired
    private ModelMapper modelMapper ;

    public List<UserDTO>getAllUser(){
        List<UserEntity>userList = userRepository.findAll();
        return  modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public List<TbUserLevel> getAllUserLevels(){
        return  userLevelRepository.findAll() ;
    }

    public List<TbUser> getAllAuthUser(){
        return userDetailsRepository.findAll();
    }

}
