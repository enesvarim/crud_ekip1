package com.computer_crud.computer_crud.service;


import com.computer_crud.computer_crud.DTO.PcNameDTO;
import com.computer_crud.computer_crud.entity.GraphicsCard;
import com.computer_crud.computer_crud.entity.PcName;
import com.computer_crud.computer_crud.entity.Processor;
import com.computer_crud.computer_crud.repository.GraphicsCardRepository;
import com.computer_crud.computer_crud.repository.PcNameRepository;
import com.computer_crud.computer_crud.repository.ProcessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PcNameService {

    @Autowired
    private PcNameRepository repository;

    @Autowired
    private ProcessorRepository processorRepository;

    @Autowired
    private GraphicsCardRepository graphicsCardRepository;

    public String addModel(PcNameDTO pcNameDTO) {
        PcName pcName = new PcName();
        BeanUtils.copyProperties(pcNameDTO, pcName);

        Processor processor = processorRepository.findByProcessorName(pcNameDTO.getProcessorName());
        GraphicsCard graphicsCard = graphicsCardRepository.findByGraphicscardName(pcNameDTO.getGraphicscardName());

        pcName.setProcessor(processor);
        pcName.setGraphicsCard(graphicsCard);

        repository.save(pcName);
        return "Model Added Successfully";
    }


    public List<PcNameDTO> getAllModels() {
        List<PcNameDTO> pcNameDTOList = new ArrayList<>();
        for (PcName pcName : repository.findAll()) {
            PcNameDTO pcNameDTO = new PcNameDTO();
            pcNameDTO.setGraphicscardName(pcName.getGraphicsCard().getGraphicscardName());
            pcNameDTO.setProcessorName(pcName.getProcessor().getProcessorName());
            BeanUtils.copyProperties(pcName, pcNameDTO);
            pcNameDTOList.add(pcNameDTO);
        }
        return pcNameDTOList;
    }


    public PcNameDTO getModelById(int id) {
        PcNameDTO pcNameDTO = new PcNameDTO();
        PcName pcName = repository.findById(id).get();
        BeanUtils.copyProperties(pcName, pcNameDTO);
        return pcNameDTO;
    }


    public String updateModel(Integer id,PcNameDTO pcNameDTO) {
        PcName pcName = repository.findById(id).get();
        BeanUtils.copyProperties(pcNameDTO, pcName);

        Processor processor = processorRepository.findByProcessorName(pcNameDTO.getProcessorName());
        GraphicsCard graphicsCard = graphicsCardRepository.findByGraphicscardName(pcNameDTO.getGraphicscardName());

        pcName.setProcessor(processor);
        pcName.setGraphicsCard(graphicsCard);
        repository.save(pcName);
        return "Model Updated Successfully";
    }




    public String deleteModel(int id) {
        repository.deleteById(id);
        return "Model Deleted Successfully";
    }




}
