package com.book.progress.service;

import com.book.progress.data.dto.ProgressDto;
import com.book.progress.data.dto.ReadingDto;
import com.book.progress.dozer.DozerConverter;
import com.book.progress.exception.CommonsException;
import com.book.progress.model.Progress;
import com.book.progress.model.Reading;
import com.book.progress.repository.ProgressRepository;
import com.book.progress.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private ReadingRepository readingRepository;

    //LISTAR TODOS OS PROGRESSOS
    public List<ProgressDto> findAllProgress() {
        List<Progress> progressList = progressRepository.findAll();
        List<ProgressDto> progressDtoList = DozerConverter.parseListObjects(progressList, ProgressDto.class);

        // Cálculo de duração e porcentagem em todos os progressos
        progressDtoList.forEach(progressDto -> {
                    calculateDuration(progressDto); // Calcula a duração

            // Tenta buscar o Reading associado para calcular a porcentagem
            if (progressDto.getId() != null) {
                readingRepository.findById(progressDto.getId()).ifPresent(reading -> {
                    ReadingDto readingDto = DozerConverter.parseObject(reading, ReadingDto.class);
                    calculatePercentage(progressDto, readingDto); // Calcula a porcentagem
                });
            }
        });

        return progressDtoList;
    }

    //BUSCAR O PROGRESSO POR ID
    public ProgressDto findIdProgress(Long id) {
        var progressEntity = progressRepository.findById(id);
        if (progressEntity.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND, "progress.service.notfound", "não foi encontrado");
        }

        ProgressDto progressDto = DozerConverter.parseObject(progressEntity.get(), ProgressDto.class);
        calculateDuration(progressDto);  // Calcula a duração antes de retornar
        return progressDto;
    }

    //ATUALIZAR O PROGRESSO
    public ProgressDto updateProgress(Long id, ProgressDto progressDto) {
        var existingProgress = progressRepository.findById(id);
        if (existingProgress.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND, "progress.service.notfound", "Usuário não encontrado");
        }

        Progress progressToUpdate = DozerConverter.parseObject(progressDto, Progress.class);
        progressToUpdate.setId(id);
        Progress savedProgress = progressRepository.save(progressToUpdate);

        ProgressDto updatedProgressDto = DozerConverter.parseObject(savedProgress, ProgressDto.class);
        calculateDuration(updatedProgressDto);  // Calcula a duração antes de retornar

        return updatedProgressDto;
    }

    //ATUALIZAÇÃO
    public ProgressDto updateCurrentPage(Long progressId, Long readingId, Integer currentPage) {
        var progressEntity = progressRepository.findById(progressId)
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND, "progress.service.notfound", "Progress não encontrado"));

        var readingEntity = readingRepository.findById(readingId)
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND, "reading.service.notfound", "Reading não encontrado"));

        // Atualiza a página atual e recalcula a porcentagem de progresso
        readingEntity.setCurrentPage(currentPage);
        readingRepository.save(readingEntity);

        ProgressDto progressDto = DozerConverter.parseObject(progressEntity, ProgressDto.class);
        calculatePercentage(progressDto, DozerConverter.parseObject(readingEntity, ReadingDto.class));

        // Atualiza o progresso no banco de dados após calcular a porcentagem
        Progress progressToUpdate = DozerConverter.parseObject(progressDto,Progress.class);
        progressRepository.save(progressToUpdate);

        return progressDto;
    }


    //SALVAR O STATUS
    public ProgressDto saveProgress(ProgressDto progressDto) {
        Progress progress = DozerConverter.parseObject(progressDto, Progress.class);
        Progress savedProgress = progressRepository.save(progress);

        ProgressDto savedProgressDto = DozerConverter.parseObject(savedProgress, ProgressDto.class);
        calculateDuration(savedProgressDto);  // Calcula a duração antes de retornar

        return savedProgressDto;
    }

    //DELETAR O PROGRESSO
    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }

    // DURAÇÃO DE DIAS
    public ProgressDto calculateReadingDuration(Long id) {
        var progressEntity = progressRepository.findById(id);

        if (progressEntity.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND, "progress.service.notfound", "Progress não encontrado");
        }

        ProgressDto progressDto = DozerConverter.parseObject(progressEntity.get(), ProgressDto.class);
        calculateDuration(progressDto);  // Calcula a duração antes de retornar

        return progressDto;
    }

    // Duração
    public void calculateDuration(ProgressDto progressDto) {
        if (progressDto.getStartDate() == null) {
            throw new CommonsException(HttpStatus.BAD_REQUEST, "progress.service.invaliddate", "Data de início não pode ser nula");
        }

        if (progressDto.getEndDate() != null) {
            Long durationInDays = ChronoUnit.DAYS.between(progressDto.getStartDate().toInstant(), progressDto.getEndDate().toInstant());
            progressDto.setDurationInDays(durationInDays);
        } else {
            progressDto.setDurationInDays(null);
        }
    }

    //PORCENTAGEM
    public void calculatePercentage(ProgressDto progressDto, ReadingDto readingDto){
        if (readingDto.getCurrentPage() != null
            && readingDto.getBook() != null
            && readingDto.getBook().getTotalPages() != null
            && readingDto.getBook().getTotalPages()>0) {

            double percentage = (double) readingDto.getCurrentPage() / readingDto.getBook().getTotalPages() * 100;
            progressDto.setPercentage(percentage);
        } else {
            progressDto.setPercentage(0.0);
        }
    }
}
