package com.book.progress.controller;

import com.book.progress.data.dto.BookDto;
import com.book.progress.data.mapper.BookMapper;
import com.book.progress.model.Book;
import com.book.progress.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> bookDtoList(){
        List<Book> books = bookService.listAllBook();

        return books.stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDto findByBookId(@PathVariable Long id) {

        return bookService.findIdBook(id)
                .map(BookMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("Pessoa não encontrada com o id: " + id));
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto dtoBook){
        Book book = BookMapper.toEntity(dtoBook);
        Book bookSave = bookService.saveBook(book);
        return BookMapper.toDto(bookSave);
    }

    @PutMapping("/{id}")
    public  BookDto updateBook(@PathVariable Long id, @RequestBody BookDto dtoBook) {

        if (!bookService.findIdBook(id).isPresent()) {
            throw new EntityNotFoundException("Pessoa não encontrada com o id: " + id);
        }

        Book book = BookMapper.toEntity(dtoBook);
        book.setId(id);
        Book bookUpdate = bookService.updateBook(book);
        return BookMapper.toDto(bookUpdate);
    }

    public void bookDelete(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
