package com.wings.inventory.Service;

import com.wings.inventory.Dto.UserDTO;
import com.wings.inventory.Model.UserEntity;
import com.wings.inventory.Repository.UserRepository;
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
    private ModelMapper modelMapper ;

    public List<UserDTO>getAllUser(){
        List<UserEntity>userList = userRepository.findAll();
        return  modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

}
