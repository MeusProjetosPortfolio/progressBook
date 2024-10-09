package com.book.progress.data.dto;

import java.util.Date;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String readerLevel;

    private List<ReadingDTO> readings;
    private ProgressDTO progress;
    private List<ArchivementDTO> archivements;
}
