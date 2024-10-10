package com.book.progress.service;

import com.book.progress.model.Progress;
import com.book.progress.repository.ProgressRepository;
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
    public Progress updateProgressStatus(Long id, String novoStatus) {
       Progress progress = progressRepository.findById(id).orElse(null);

        if (progress != null) {
            progress.setStatus(novoStatus);
            return progressRepository.save(progress);
        }

        return null;
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
