package com.book.progress.repository;

import com.book.progress.model.Archivement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivementRepository extends JpaRepository<Archivement, Long> {
}
