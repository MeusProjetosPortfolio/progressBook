package com.book.progress.data.dto;

import lombok.Data;

@Data
public class ArchivementDto {

    private Long id;
    private String name;
    private String description;
    private Integer points;

    private UserDto userDto;
}
