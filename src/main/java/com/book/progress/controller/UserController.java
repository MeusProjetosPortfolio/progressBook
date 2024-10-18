package com.book.progress.controller;

import com.book.progress.data.dto.UserDto;
import com.book.progress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDto> userDtoList() {
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public UserDto findByUserId(@PathVariable Long id) {
        return userService.findIdUser(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto dtoUser) {
        return userService.saveUser(dtoUser);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto dtoUser) {
        return userService.saveUser(dtoUser);
    }

    @DeleteMapping("/{id}")
    public void userDelete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
