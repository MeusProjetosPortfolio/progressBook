package com.book.progress.controller;

import com.book.progress.data.dto.ArchievementDto;
import com.book.progress.service.ArchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/archievements")
@CrossOrigin("*")
public class ArchievementController {

    @Autowired
    private ArchievementService archievementService;

    @GetMapping("/all")
    public List<ArchievementDto> archivementDtoList() {
        return archievementService.findAllArchivement();
    }

    @GetMapping("/{id}")
    public ArchievementDto findArchievementById(@PathVariable Long id) {
        return archievementService.findIdArchivement(id);
    }

    @PostMapping
    public ArchievementDto createArchievement(@RequestBody ArchievementDto dtoArchievement){
        return archievementService.saveArquievement(dtoArchievement);
    }

    @PutMapping("/{id}")
    public ArchievementDto updateArchievement(@RequestBody ArchievementDto dtoArchievement){
        return archievementService.saveArquievement(dtoArchievement);
    }

    @DeleteMapping("/{id}")
    public void deleteArchievement(@PathVariable Long id){
        archievementService.deleteArchievement(id);
    }
}
