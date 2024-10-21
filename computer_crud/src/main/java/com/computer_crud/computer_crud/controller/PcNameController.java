package com.computer_crud.computer_crud.controller;


import com.computer_crud.computer_crud.DTO.PcNameDTO;
import com.computer_crud.computer_crud.entity.PcName;
import com.computer_crud.computer_crud.service.PcNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("main"))
public class PcNameController {

    @Autowired
    private PcNameService service;

    @GetMapping("/models")
    public Object getAllModels() {
        return service.getAllModels();
    }

    @PostMapping("/model")
    public String addModel(@RequestBody PcNameDTO pcNameDTO) {
        return service.addModel(pcNameDTO);
    }

    @GetMapping("/model/{id}")
    public Object getModelById(@PathVariable("id") int id) {
        return service.getModelById(id);
    }

    @PutMapping("/model/{id}")
    public String updateModel(@PathVariable("id") Integer id,@RequestBody PcNameDTO pcNameDTO) {
        return service.updateModel(id,pcNameDTO);
    }

    @DeleteMapping("/model/{id}")
    public String deleteModel(@PathVariable("id") int id) {
        return service.deleteModel(id);
    }
}


