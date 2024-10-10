package com.book.progress.data.dto;

import com.book.progress.model.Book;

public class BookMapper {

    public static BookDto toDto(Book book){
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        dto.setPublicationYear(book.getPublicationYear());

        return dto;
    }

    public static Book toEntity(BookDto dto){
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setPublicationYear(dto.getPublicationYear());

        return book;
    }
}
