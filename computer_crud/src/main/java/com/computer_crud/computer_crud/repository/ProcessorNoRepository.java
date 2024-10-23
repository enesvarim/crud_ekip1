package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.ProcessorNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessorNoRepository extends JpaRepository<ProcessorNo, String> {
    ProcessorNo findByProcessorNoName(String processorNoName);
}
