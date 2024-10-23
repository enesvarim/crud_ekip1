package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
    Price findByPrice(int price);
}
