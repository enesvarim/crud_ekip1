package com.computer_crud.computer_crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphicsCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GraphicsCardId;

    private String graphicscardName;
}

