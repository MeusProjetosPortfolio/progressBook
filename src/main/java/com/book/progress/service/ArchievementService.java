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
        archievement.setCustom(true);//LOMBOK GERA O SET SEM O "IS"

        return archivementRepository.save(archievement);
    }

    //ATUALIZAR PONTOS DE UMA CONQUISTA PERSONALIZADA
    public Optional<Archievement> updateArchievementPoints(Long id, Integer newPoints) {
        Archievement archievement = archivementRepository.findById(id).orElse(null);
        if (archievement != null && archievement.isCustom()) {
            archievement.setPoints(newPoints);
            return Optional.of(archivementRepository.save(archievement));
        }
        return Optional.empty();
    }

    //DELETAR UMA CONQUISTA PERSONALIZADA
    public boolean deleteArchievement(Long id) {
        Archievement archievement = archivementRepository.findById(id).orElse(null);
        if (archievement != null && archievement.isCustom()) {
            archivementRepository.delete(archievement);
            return true;
        }
        return false;
    }
}
