package com.computer_crud.computer_crud.service;


import com.computer_crud.computer_crud.entity.PcName;
import com.computer_crud.computer_crud.repository.PcNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PcNameService {

    @Autowired
    private PcNameRepository repository;

    public Object getAllModels() {
        return repository.findAll();
    }

    public Object getModelById(int id) {
        return repository.findById(id);
    }

    public String addModel(PcName model) {
        repository.save(model);
        return "Model Added Successfully";
    }

    public String updateModel(PcName model) {
        repository.save(model);
        return "Model Updated Successfully";
    }

    public String deleteModel(int id) {
        repository.deleteById(id);
        return "Model Deleted Successfully";
    }




}
