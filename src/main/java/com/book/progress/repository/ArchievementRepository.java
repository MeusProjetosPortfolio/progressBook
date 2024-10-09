package com.book.progress.repository;

import com.book.progress.model.Archievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchievementRepository extends JpaRepository<Archievement, Long> {
}
