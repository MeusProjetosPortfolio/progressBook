package com.book.progress.service;

import com.book.progress.data.dto.ProgressDto;
import com.book.progress.model.Progress;
import com.book.progress.repository.ProgressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    //LISTAR TODOS OS PROGRESSOS
    public List<Progress> findAllProgress() {
        return progressRepository.findAll();
    }

    //BUSCAR O PROGRESSO POR ID
    public Optional<Progress> findIdProgress(Long id) {
        return progressRepository.findById(id);
    }

    //SALVAR O STATUS
    public Progress saveProgress(Progress progress) {

        if (progress.getStatus() == null || progress.getStatus().isEmpty()) {
            progress.setStatus("Em progresso");
        }
        return progressRepository.save(progress);
    }

    //ATUALIZAR O STATUS
    public Progress updateProgressStatus(Long id, ProgressDto dtoProgress) {
       Progress progressExisting = progressRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Progresso não encontrado com o id " + id));

        progressExisting.setStatus(dtoProgress.getStatus());
        progressExisting.setAverageReadingProgress(dtoProgress.getAverageReadingProgress());
        progressExisting.setReadingDurationInDays(dtoProgress.getReadingDurationInDays());

        return progressRepository.save(progressExisting);
    }

    public boolean deleteProgress(Long id){
        Optional<Progress> progressOptional = progressRepository.findById(id);
        if (progressOptional.isPresent()) {
            progressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
