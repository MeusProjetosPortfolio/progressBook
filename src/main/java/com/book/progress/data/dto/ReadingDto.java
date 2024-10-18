package com.book.progress.data.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class ReadingDto {

    private Long id;
    private Integer currentPage;
    private Date startDate;
    private Date endDate;
    private Integer rating;

    private UserDto user;
    private BookDto book;
    private ProgressDto progressDto;
}
