package com.computer_crud.computer_crud.repository;

import com.computer_crud.computer_crud.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<Brands, Long> {
    Brands findByBrandsName(String brandsName);

}
