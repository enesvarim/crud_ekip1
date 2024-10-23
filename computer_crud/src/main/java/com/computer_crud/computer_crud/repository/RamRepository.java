package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RamRepository extends JpaRepository<Ram, Integer> {
    Ram findByRamSize(int ramSize);
}
