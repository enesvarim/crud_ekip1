package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.MemorySize;
import com.computer_crud.computer_crud.entity.MemoryType;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoryTypeRepository extends JpaRepository<MemoryType, Long> {
    MemoryType findByMemoryType(String memoryType);
    List<MemoryType> findByMemoryTypeList(String memoryType);
}
