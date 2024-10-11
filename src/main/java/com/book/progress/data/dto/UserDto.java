package com.book.progress.data.dto;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String readerLevel;

    private List<ReadingDto> readingDtos;
    private List<ArchivementDto>archivementDtos;
}
