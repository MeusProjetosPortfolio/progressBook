package com.book.progress.controller;

import com.book.progress.data.dto.ProgressDto;
import com.book.progress.service.ProgressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin("*")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    // DOCUMENTAÇÃO PARA LISTAR TODOS OS PROGRESSOS
    @Operation(summary = "Retorna todos os progressos", description = "Lista todos os progressos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Progressos listados com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProgressDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @GetMapping("/all")
    public List<ProgressDto> progressDtoList() {
        return progressService.findAllProgress();
    }

    // DOCUMENTAÇÃO PARA BUSCAR PROGRESSO POR ID
    @Operation(summary = "Busca progresso por ID", description = "Busca um progresso específico pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Progresso encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProgressDto.class))),
            @ApiResponse(responseCode = "404", description = "Progresso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @GetMapping("/{id}")
    public ProgressDto findByProgressId(@PathVariable Long id) {
        return progressService.findIdProgress(id);
    }

    // DOCUMENTAÇÃO PARA CRIAR UM NOVO PROGRESSO
    @Operation(summary = "Cria um novo progresso", description = "Cria um novo progresso com as informações fornecidas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Progresso criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProgressDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PostMapping
    public ProgressDto createProgress(@RequestBody ProgressDto dtoProgress) {
        return progressService.saveProgress(dtoProgress);
    }

    // DOCUMENTAÇÃO PARA ATUALIZAR UM PROGRESSO
    @Operation(summary = "Atualiza um progresso", description = "Atualiza as informações de um progresso com o ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Progresso atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProgressDto.class))),
            @ApiResponse(responseCode = "404", description = "Progresso não encontrado"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PutMapping("/{id}")
    public ProgressDto updateProgress(@PathVariable Long id, @RequestBody ProgressDto dtoProgress) {
        return progressService.updateProgress(id,dtoProgress);
    }

    // DOCUMENTAÇÃO PARA DELETAR UM PROGRESSO
    @Operation(summary = "Deleta um progresso", description = "Deleta um progresso pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Progresso deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Progresso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @DeleteMapping("/{id}")
    public void progressDelete(@PathVariable Long id) {
        progressService.deleteProgress(id);
    }
}
