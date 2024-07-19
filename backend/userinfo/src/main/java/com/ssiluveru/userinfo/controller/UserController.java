package com.ssiluveru.userinfo.controller;

import com.ssiluveru.userinfo.dto.UserDTO;
import com.ssiluveru.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getUsersList() {
        List<UserDTO> userDTOS = userService.fetchUsers();
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.addNewUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserByID(id);
        if(userDTO == null)  return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
