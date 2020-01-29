package com.oklimenko.sampleapp.repository;

import com.oklimenko.sampleapp.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Provides default implementations for find, save, delete database operations.
 * For Test entity.
 *
 * @author oklimenko@gmail.com
 */
@Repository
public interface TestRepository extends JpaRepository<Test, UUID> {
}
