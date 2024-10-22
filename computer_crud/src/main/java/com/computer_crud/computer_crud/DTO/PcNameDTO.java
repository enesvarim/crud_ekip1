package com.computer_crud.computer_crud.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcNameDTO {

    @JsonIgnore
    private int id;

    private String pcName;
    private String processorName;
    private String graphicscardName;



}
