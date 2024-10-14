package com.book.progress.service;

import com.book.progress.model.Archievement;
import com.book.progress.repository.ArchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchievementService {

    @Autowired
    private ArchievementRepository archivementRepository;

    //LISTAR TODAS AS CONQUISTAS
    public List<Archievement> findAllArchivement() {
        return archivementRepository.findAll();
    }

    //BUSCAR A CONQUISTA POR ID
    public Optional<Archievement> findIdArchivement(Long id) {
        return archivementRepository.findById(id);
    }

    //SALVAR UMA NOVA CONQUISTA
    public Archievement saveArquievement(Archievement archievement) {
        return archivementRepository.save(archievement);
    }

    //ATUALIZAR PONTOS DE UMA CONQUISTA PERSONALIZADA
    public Optional<Archievement> updateArchievement(Long id, Archievement newArchievementData) {
        return archivementRepository.findById(id).map(existingArchievement ->{
            existingArchievement.setName(newArchievementData.getName());
            existingArchievement.setDescription(newArchievementData.getDescription());
            existingArchievement.setPoints(newArchievementData.getPoints());

            return archivementRepository.save(existingArchievement);
        });
    }

    //DELETAR UMA CONQUISTA PERSONALIZADA
    public boolean deleteArchievement(Long id) {
        Optional<Archievement> archievement = archivementRepository.findById(id);
        if (archievement.isPresent()) {
            archivementRepository.delete(archievement.get());
            return true;
        }
        return false;
    }
}
