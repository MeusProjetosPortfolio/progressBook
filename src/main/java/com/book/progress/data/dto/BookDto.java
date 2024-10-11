package com.book.progress.data.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private Integer totalPages;
    private List<ReadingDto> readingDtoList;
}
