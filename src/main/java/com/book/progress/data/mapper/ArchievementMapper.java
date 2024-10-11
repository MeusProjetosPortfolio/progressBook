package com.book.progress.data.mapper;


import com.book.progress.data.dto.ArchivementDto;
import com.book.progress.model.Archievement;

import java.util.List;
import java.util.stream.Collectors;

public class ArchievementMapper {

    public static ArchivementDto toDto(Archievement archievement){
        ArchivementDto dto = new ArchivementDto();
        dto.setId(archievement.getId());
        dto.setName(archievement.getName());
        dto.setDescription(archievement.getDescription());
        dto.setPoints(archievement.getPoints());
        dto.setCustom(archievement.isCustom());

        if (archievement.getUser() != null) {
            dto.setUserDto(UserMapper.toDto(archievement.getUser()));
        }

        return dto;
    }

    public static Archievement toEntity(ArchivementDto dto) {
        Archievement archievement = new Archievement();
        archievement.setId(dto.getId());
        archievement.setName(dto.getName());
        archievement.setDescription(dto.getDescription());
        archievement.setPoints(dto.getPoints());
        archievement.setCustom(dto.isCustom());

        if (dto.getUserDto() != null) {
            archievement.setUser(UserMapper.toEntity(dto.getUserDto()));
        }

        return archievement;
    }

    // Métodos para converter listas de Archievement para ArchivementDto e vice-versa
    public static List<ArchivementDto> toDto(List<Archievement> archievements) {
        return archievements.stream()
                .map(ArchievementMapper::toDto)
                .collect(Collectors.toList());
    }

    public static List<Archievement> toEntity(List<ArchivementDto> archivementDtos) {
        return archivementDtos.stream()
                .map(ArchievementMapper::toEntity)
                .collect(Collectors.toList());
    }

}
