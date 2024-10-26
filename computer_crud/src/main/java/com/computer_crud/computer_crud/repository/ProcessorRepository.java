package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.Processor;
import com.computer_crud.computer_crud.entity.ProcessorNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessorRepository extends JpaRepository<Processor, Long> {
    Processor findByProcessorName(String processorName);
    Processor findByProcessorNo(ProcessorNo processorNo);
}
