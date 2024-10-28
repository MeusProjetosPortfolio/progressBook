package com.book.progress.controller;

import com.book.progress.data.dto.UserDto;
import com.book.progress.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    //DOCUMENTAÇÃO LISTAR TODOS OS USUÁRIOS
    @Operation(summary = "Retorna todos os usuários", description = "Lista todos os usuários cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @GetMapping("/all")
    public List<UserDto> userDtoList() {
        return userService.listAllUser();
    }

    //DOCUMENTAÇÃO LISTAR POR ID OS USUÁRIOS
    @Operation(summary = "Busca usuário por ID", description = "Busca um usuário específico pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })

    @GetMapping("/{id}")
    public UserDto findByUserId(@PathVariable Long id) {
        return userService.findIdUser(id);
    }

    //DOCUMENTAÇÃO CRIAR USUÁRIO
    @Operation(summary = "Cria um novo usuário", description = "Cria um novo usuário com as informações fornecidas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PostMapping
    public UserDto createUser(@RequestBody UserDto dtoUser) {
        return userService.saveUser(dtoUser);
    }

    //DOCUMENTAÇÃO PARA A ATUALIZAÇÃO DE USUÁRIO
    @Operation(summary = "Atualiza um usuário", description = "Atualiza um usuário existente com o ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto dtoUser) {
        return userService.updateUser(id,dtoUser);
    }

    //DOCUMENTAÇÃO PARA DELETAR USUÁRIO
    @Operation(summary = "Deleta um usuário", description = "Deleta um usuário pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @DeleteMapping("/{id}")
    public void userDelete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
