package com.book.progress.data.mapper;

import com.book.progress.data.dto.UserDto;
import com.book.progress.model.User;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setReaderLevel(user.getReaderLevel());

        if (user.getReadingList()!= null){
            dto.setReadingDtos(user.getReadingList().stream()
                    .map());
        }

        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setReaderLevel(dto.getReaderLevel());

        return user;
    }
}
