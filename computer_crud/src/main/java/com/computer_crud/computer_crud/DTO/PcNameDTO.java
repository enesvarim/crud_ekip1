package com.computer_crud.computer_crud.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcNameDTO {


    private String pcName;
    private String processorName;
    private String graphicscardName;
    private String brandsName;
    private int ramSize;
    private String processorNoName;
    private int memorySize;
    private String memoryType;
    private int price;



}
