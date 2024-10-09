package com.book.progress.repository;

import com.book.progress.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading,Long> {
}
