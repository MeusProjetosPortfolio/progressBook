package com.book.progress.data.dto;

import com.book.progress.model.User;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setReaderLevel(user.getReaderLevel());

        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setReaderLevel(dto.getReaderLevel());

        return user;
    }
}
