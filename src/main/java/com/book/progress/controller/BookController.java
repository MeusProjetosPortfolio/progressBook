package com.book.progress.controller;

import com.book.progress.data.dto.BookDto;
import com.book.progress.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;

    // DOCUMENTAÇÃO PARA LISTAR TODOS OS LIVROS
    @Operation(summary = "Retorna todos os livros", description = "Lista todos os livros cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livros listados com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @GetMapping("/all")
    public List<BookDto> bookDtoList(){
        return bookService.listAllBook();
    }

    // DOCUMENTAÇÃO PARA BUSCAR LIVRO POR ID
    @Operation(summary = "Busca livro por ID", description = "Busca um livro específico pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @GetMapping("/{id}")
    public BookDto findByBookId(@PathVariable Long id) {
        return bookService.findIdBook(id);
    }

    // DOCUMENTAÇÃO PARA CRIAR UM NOVO LIVRO
    @Operation(summary = "Cria um novo livro", description = "Cria um novo livro com as informações fornecidas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Livro criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PostMapping
    public BookDto createBook(@RequestBody BookDto dtoBook){
        return bookService.saveBook(dtoBook);
    }

    // DOCUMENTAÇÃO PARA ATUALIZAR UM LIVRO
    @Operation(summary = "Atualiza um livro", description = "Atualiza as informações de um livro com o ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PutMapping("/{id}")
    public  BookDto updateBook(@PathVariable Long id, @RequestBody BookDto dtoBook) {
        //return bookService.saveBook(dtoBook);
        return bookService.updateBook(id,dtoBook);
    }

    // DOCUMENTAÇÃO PARA DELETAR UM LIVRO
    @Operation(summary = "Deleta um livro", description = "Deleta um livro pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Livro deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @DeleteMapping("/{id}")
    public void bookDelete(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
