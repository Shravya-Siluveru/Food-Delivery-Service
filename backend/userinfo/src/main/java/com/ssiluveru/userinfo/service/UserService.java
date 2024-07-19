package com.ssiluveru.userinfo.service;

import com.ssiluveru.userinfo.dto.UserDTO;
import com.ssiluveru.userinfo.entity.User;
import com.ssiluveru.userinfo.mapper.UserMapper;
import com.ssiluveru.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> fetchUsers() {
        List<User> all = userRepository.findAll();
        return all.stream().map(UserMapper.INSTANCE::mapUserToUserDTO).collect(Collectors.toList());
    }

    public UserDTO addNewUser(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.INSTANCE.mapUserDTOtoUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(user);
    }

    public UserDTO getUserByID(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserMapper.INSTANCE::mapUserToUserDTO).orElse(null);
    }

}
