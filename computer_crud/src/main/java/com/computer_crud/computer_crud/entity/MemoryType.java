package com.computer_crud.computer_crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoryType {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int memoryTypeId;

    private String memoryType;

    @ManyToOne
    @JoinColumn(name = "Memory_size")
    private MemorySize memorySize;
}
