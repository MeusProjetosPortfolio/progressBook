package com.book.progress.controller;

import com.book.progress.data.dto.BookDto;
import com.book.progress.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<BookDto> bookDtoList(){
        return bookService.listAllBook();
    }

    @GetMapping("/{id}")
    public BookDto findByBookId(@PathVariable Long id) {
        return bookService.findIdBook(id);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto dtoBook){
        return bookService.saveBook(dtoBook);
    }

    @PutMapping("/{id}")
    public  BookDto updateBook(@PathVariable Long id, @RequestBody BookDto dtoBook) {
        //return bookService.saveBook(dtoBook);
        return bookService.updateBook(id,dtoBook);
    }

    @DeleteMapping("/{id}")
    public void bookDelete(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
