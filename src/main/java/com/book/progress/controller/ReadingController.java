package com.book.progress.controller;

import com.book.progress.data.dto.ReadingDto;
import com.book.progress.service.ReadingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/readings")
@CrossOrigin("*")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    // DOCUMENTAÇÃO PARA LISTAR TODAS AS LEITURAS
    @Operation(summary = "Retorna todas as leituras", description = "Lista todas as leituras cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Leituras listadas com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadingDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @GetMapping("/all")
    public List<ReadingDto> readingDtoList(){
        return readingService.listAllReading();
    }

    // DOCUMENTAÇÃO PARA BUSCAR LEITURA POR ID
    @Operation(summary = "Busca leitura por ID", description = "Busca uma leitura específica pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Leitura encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadingDto.class))),
            @ApiResponse(responseCode = "404", description = "Leitura não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @GetMapping("/{id}")
    public ReadingDto findByReadingId(@PathVariable Long id){

        return readingService.findIdReading(id);
    }

    // DOCUMENTAÇÃO PARA CRIAR UMA NOVA LEITURA
    @Operation(summary = "Cria uma nova leitura", description = "Cria uma nova leitura com as informações fornecidas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Leitura criada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadingDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PostMapping
    public ReadingDto createReading(@RequestBody ReadingDto dtoReading){
       return readingService.saveReading(dtoReading);
    }

    // DOCUMENTAÇÃO PARA ATUALIZAR UMA LEITURA
    @Operation(summary = "Atualiza uma leitura", description = "Atualiza as informações de uma leitura com o ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Leitura atualizada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadingDto.class))),
            @ApiResponse(responseCode = "404", description = "Leitura não encontrada"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PutMapping("/{id}")
    public ReadingDto updateReading(@PathVariable Long id, @RequestBody ReadingDto dtoReading) {
        return readingService.updateReading(id,dtoReading);
    }

    // DOCUMENTAÇÃO PARA DELETAR UMA LEITURA
    @Operation(summary = "Deleta uma leitura", description = "Deleta uma leitura pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Leitura deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Leitura não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @DeleteMapping("/{id}")
    public void  readingDelete(@PathVariable Long id) {
        readingService.deleteReading(id);
    }
}
