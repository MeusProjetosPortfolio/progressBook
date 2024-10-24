package com.book.progress.service;

import com.book.progress.data.dto.ArchievementDto;
import com.book.progress.dozer.DozerConverter;
import com.book.progress.exception.CommonsException;
import com.book.progress.model.Archievement;
import com.book.progress.repository.ArchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArchievementService {

    @Autowired
    private ArchievementRepository archievementRepository;

    //LISTAR TODAS AS CONQUISTAS
    public List<ArchievementDto> findAllArchivement() {
        return DozerConverter.parseListObjects(archievementRepository.findAll(),ArchievementDto.class);
    }

    //BUSCAR A CONQUISTA POR ID
    public ArchievementDto findIdArchivement(Long id) {
        var archievementEntity = archievementRepository.findById(id);
        if (archievementEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,"archievement.service.notfound","não foi encontrado");
        }
        return DozerConverter.parseObject(archievementEntity.get(),ArchievementDto.class);
    }

    //ATUALIZAR A CONQUISTA
    public ArchievementDto updateArchievement(Long id, ArchievementDto archievementDto){
        var existingArchievement = archievementRepository.findById(id);
        if (existingArchievement.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,  "archievement.service.notfound", "Conquista não encontrada");
        }

        Archievement archievementToUpdate = DozerConverter.parseObject(archievementDto,Archievement.class);
        archievementToUpdate.setId(id);

        return DozerConverter.parseObject(archievementRepository.save(archievementToUpdate), ArchievementDto.class);
    }

    //SALVAR UMA NOVA CONQUISTA
    public ArchievementDto saveArquievement(ArchievementDto archievementDto ) {
        return DozerConverter.parseObject(archievementRepository.save(DozerConverter.parseObject(archievementDto,Archievement.class)),ArchievementDto.class);
    }

    //DELETAR UMA CONQUISTA PERSONALIZADA
    public void deleteArchievement(Long id) {
        archievementRepository.deleteById(id);
    }
}
