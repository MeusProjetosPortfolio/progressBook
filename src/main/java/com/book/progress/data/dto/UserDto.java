package com.book.progress.data.dto;
import java.util.List;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String readerLevel;

    private List<ReadingDto> readingDtos;
    private ProgressDto progressDto;
    private List<ArchivementDto>archivementDtos;
}
