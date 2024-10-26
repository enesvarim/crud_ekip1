package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.MemorySize;
import com.computer_crud.computer_crud.entity.MemoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoryTypeRepository extends JpaRepository<MemoryType, Long> {
    MemoryType findByMemoryType(String memoryType);
    MemoryType findByMemorySize(MemorySize memorySize);
}
