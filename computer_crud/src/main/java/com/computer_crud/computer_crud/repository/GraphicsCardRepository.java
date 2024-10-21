package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.GraphicsCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphicsCardRepository extends JpaRepository<GraphicsCard, Long> {
    GraphicsCard findByGraphicscardName(String graphicscardName);
}
