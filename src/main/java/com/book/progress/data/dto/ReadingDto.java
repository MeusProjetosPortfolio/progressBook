package com.book.progress.data.dto;
import lombok.Data;

@Data
public class ReadingDto {

    private Long id;
    private Integer rating;
    private Integer currentPage;

    private UserDto user;
    private BookDto book;
    private ProgressDto progress;
}
