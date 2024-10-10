package com.book.progress.data.dto;

import lombok.Data;

@Data
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private Integer publicationYear;
    private Integer totalPages;
}
