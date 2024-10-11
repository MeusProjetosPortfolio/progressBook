package com.book.progress.controller;

import com.book.progress.data.dto.UserDto;
import com.book.progress.data.mapper.UserMapper;
import com.book.progress.model.User;
import com.book.progress.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> userDtoList() {
        List<User> users = userService.listAllUser();

        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto findByUserId(@PathVariable Long id) {

        return userService.findIdUser(id)
                .map(UserMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o id: " + id));
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto dtoUser) {
        User user = UserMapper.toEntity(dtoUser);
        User userSave = userService.saveUser(user);
        return UserMapper.toDto(userSave);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto dtoUser) {

        if (!userService.findIdUser(id).isPresent()) {
            throw new EntityNotFoundException("Pessoa não encontrada com o id " + id);
        }

        User user = UserMapper.toEntity(dtoUser);
        user.setId(id);
        User userUpdated = userService.updateUser(user);
        return UserMapper.toDto(userUpdated);
    }


    @DeleteMapping("/{id}")
    public void userDelete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
