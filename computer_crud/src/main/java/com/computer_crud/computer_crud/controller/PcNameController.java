package com.computer_crud.computer_crud.controller;


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
    public String addModel(@RequestBody PcName model) {
        return service.addModel(model);
    }

    @GetMapping("/model/{id}")
    public Object getModelById(@PathVariable("id") int id) {
        return service.getModelById(id);
    }

    @PutMapping("/model")
    public String updateModel(@RequestBody PcName model) {
        return service.updateModel(model);
    }

    @DeleteMapping("/model/{id}")
    public String deleteModel(@PathVariable("id") int id) {
        return service.deleteModel(id);
    }
}


