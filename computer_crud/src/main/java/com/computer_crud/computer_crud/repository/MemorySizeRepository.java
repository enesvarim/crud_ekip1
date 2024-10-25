package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.MemorySize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemorySizeRepository extends JpaRepository<MemorySize, Long> {
    MemorySize findByMemorySize(Integer memorySize);
}
