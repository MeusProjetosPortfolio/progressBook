package com.book.progress.data.mapper;

import com.book.progress.data.dto.UserDto;
import com.book.progress.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setReaderLevel(user.getReaderLevel());

        if (user.getReadingList()!= null){
            dto.setReadingDtos(ReadingMapper.toDto(user.getReadingList()));
        }

        if (user.getArchievementList()!=null){
            dto.setArchivementDtos(ArchievementMapper.toDto(user.getArchievementList()));
        }
        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setReaderLevel(dto.getReaderLevel());

        if (dto.getArchivementDtos()!=null) {
            user.setArchievementList(ArchievementMapper.toEntity(dto.getArchivementDtos()));
        }
        return user;
    }

    // Métodos para converter listas de User para UserDto e vice-versa
    public static List<UserDto> toDto(List<User> users) {
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    public static List<User> toEntity(List<UserDto> userDtos) {
        return userDtos.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
    }
}
