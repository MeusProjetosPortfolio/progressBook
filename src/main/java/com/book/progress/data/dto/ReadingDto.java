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

    @JsonProperty("user")
    private UserDto userDto;
    @JsonProperty("book")
    private BookDto bookDto;

    private ProgressDto progressDto;
}
