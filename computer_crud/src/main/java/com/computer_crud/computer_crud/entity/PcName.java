package com.computer_crud.computer_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pcName;

    @ManyToOne
    @JoinColumn(name = "processor_id", referencedColumnName = "processorId")
    private Processor processor;

    @ManyToOne
    @JoinColumn(name = "graphics_card_id")
    private GraphicsCard graphicsCard;

    @ManyToOne
    @JoinColumn(name = "brands_id")
    private Brands brands;

    @ManyToOne
    @JoinColumn(name = "ram_id")
    private Ram ram;

    @ManyToOne
    @JoinColumn(name = "memory_type_id")
    private MemoryType memoryType;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;

}