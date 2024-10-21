package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.PcName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcNameRepository extends JpaRepository<PcName, Integer> {


}
