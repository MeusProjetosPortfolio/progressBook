package com.book.progress.controller;

import com.book.progress.data.dto.ProgressDto;
import com.book.progress.data.mapper.ProgressMapper;
import com.book.progress.model.Progress;
import com.book.progress.service.ProgressService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin("*")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping
    public List<ProgressDto> progressDtoList() {
        List<Progress> progresses = progressService.findAllProgress();

        return progresses.stream()
                .map(ProgressMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProgressDto findByProgressId(@PathVariable Long id) {

        return progressService.findIdProgress(id)
                .map(ProgressMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Não encontrado o progresso com o id " + id));
    }

    @PostMapping
    public ProgressDto createProgress(@RequestBody ProgressDto dtoProgress) {
        Progress progress = ProgressMapper.toEntity(dtoProgress);
        Progress progressSave = progressService.saveProgress(progress);
        return ProgressMapper.toDto(progressSave);
    }

    @PutMapping("/{id}")

    public ResponseEntity<ProgressDto> updateProgress(@PathVariable Long id, @RequestBody ProgressDto dtoProgress) {

        if (!progressService.findIdProgress(id).isPresent()) {
            throw new EntityNotFoundException("Progresso não encontrado com o id " + id);
        }

        Progress progressUpdate = progressService.updateProgressStatus(id, dtoProgress);

        return ResponseEntity.ok(ProgressMapper.toDto(progressUpdate));
    }

    @DeleteMapping("/{id}")
    public void progressDelete(@PathVariable Long id) {
        progressService.deleteProgress(id);
    }
}
