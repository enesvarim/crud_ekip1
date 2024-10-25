package com.computer_crud.computer_crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessorNo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int processorNoId;

    private String processorNoName;

}
