package com.book.progress.controller;

import com.book.progress.data.dto.ArchievementDto;
import com.book.progress.service.ArchievementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/archievements")
@CrossOrigin("*")
public class ArchievementController {

    @Autowired
    private ArchievementService archievementService;

    //DOCUMENTAÇÃO PARA LISTAR TODAS AS CONQUISTAS
    @Operation(summary = "Retorna todas as conquistas", description = "Lista todas as conquistas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conquistas listadas com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArchievementDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @GetMapping("/all")
    public List<ArchievementDto> archivementDtoList() {
        return archievementService.findAllArchivement();
    }

    //DOCUMENTAÇÃO PARA BUSCAR POR ID A CONQUISTA
    @Operation(summary = "Busca conquista por ID", description = "Busca uma conquista específica pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conquista encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArchievementDto.class))),
            @ApiResponse(responseCode = "404", description = "Conquista não encontrada")
    })

    @GetMapping("/{id}")
    public ArchievementDto findArchievementById(@PathVariable Long id) {
        return archievementService.findIdArchivement(id);
    }

    //DOCUMENTAÇÃO PARA CRIAR CONQUISTAS
    @Operation(summary = "Cria uma nova conquista", description = "Cria uma nova conquista com as informações fornecidas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Conquista criada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArchievementDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PostMapping
    public ArchievementDto createArchievement(@RequestBody ArchievementDto dtoArchievement){
        return archievementService.saveArquievement(dtoArchievement);
    }

    //DOCUMENTAÇÃO PARA ATUALIZAR CONQUISTA
    @Operation(summary = "Atualiza uma conquista", description = "Atualiza uma conquista existente com o ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conquista atualizada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArchievementDto.class))),
            @ApiResponse(responseCode = "404", description = "Conquista não encontrada"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @PutMapping("/{id}")
    public ArchievementDto updateArchievement(@PathVariable Long id, @RequestBody ArchievementDto dtoArchievement){
        return archievementService.updateArchievement(id,dtoArchievement);
    }

    //DOCUMENTAÇÃO PARA DELETAR CONQUISTA
    @Operation(summary = "Deleta uma conquista", description = "Deleta uma conquista pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Conquista deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Conquista não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })

    @DeleteMapping("/{id}")
    public void deleteArchievement(@PathVariable Long id){
        archievementService.deleteArchievement(id);
    }
}
