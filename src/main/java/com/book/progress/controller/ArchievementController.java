package com.book.progress.controller;

import com.book.progress.data.dto.ArchivementDto;
import com.book.progress.data.mapper.ArchievementMapper;
import com.book.progress.model.Archievement;
import com.book.progress.service.ArchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/archievements")
@CrossOrigin("*")
public class ArchievementController {

    @Autowired
    private ArchievementService archievementService;

    @GetMapping
    public List<ArchivementDto> archivementDtoList() {
        List<Archievement> archievements = archievementService.findAllArchivement();

        return archievements.stream()
                .map(ArchievementMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArchivementDto> findArchievementById(@PathVariable Long id) {
        Optional<Archievement> archievement = archievementService.findIdArchivement(id);
        return archievement.map(value -> ResponseEntity.ok(ArchievementMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ArchivementDto createArchievement(@RequestBody ArchivementDto dtoArchievement){
        Archievement archievement = ArchievementMapper.toEntity(dtoArchievement);
        Archievement archievementSave = archievementService.saveArquievement(archievement);
        return ArchievementMapper.toDto(archievementSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArchivementDto> updateArchievement(@PathVariable Long id, @RequestBody ArchivementDto dtoArchievement){
        Archievement newArchievementData = ArchievementMapper.toEntity(dtoArchievement);
        Optional<Archievement> archievementUpdate = archievementService.updateArchievement(id,newArchievementData);

        return archievementUpdate
                .map(value -> ResponseEntity.ok(ArchievementMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArchievement(@PathVariable Long id){
        boolean deleted = archievementService.deleteArchievement(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
