package com.computer_crud.computer_crud.service;


import com.computer_crud.computer_crud.DTO.PcNameDTO;
import com.computer_crud.computer_crud.entity.*;
import com.computer_crud.computer_crud.repository.*;
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

    @Autowired
    private RamRepository ramRepository;

    @Autowired
    private ProcessorNoRepository processorNoRepository;

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private MemorySizeRepository memorySizeRepository;

    @Autowired
    private MemoryTypeRepository memoryTypeRepository;

    @Autowired
    private PriceRepository priceRepository;



    public String addModel(PcNameDTO pcNameDTO) {
        Processor processor = processorRepository.findByProcessorName(pcNameDTO.getProcessorName());
        GraphicsCard graphicsCard = graphicsCardRepository.findByGraphicscardName(pcNameDTO.getGraphicscardName());
        Ram ram = ramRepository.findByRamSize(pcNameDTO.getRamSize());
        Brands brands = brandsRepository.findByBrandsName(pcNameDTO.getBrandsName());
        ProcessorNo processorNo = processorNoRepository.findByProcessorNoName(pcNameDTO.getProcessorNoName());
        MemorySize memorySize = memorySizeRepository.findByMemorySize(pcNameDTO.getMemorySize());
        MemoryType memoryType = memoryTypeRepository.findByMemoryType(pcNameDTO.getMemoryType());
        Price price = priceRepository.findByPrice(pcNameDTO.getPrice());


        PcName pcName = new PcName();
        pcName.setPcName(pcNameDTO.getPcName());

        pcName.setProcessor(processor);
        pcName.getProcessor().setProcessorNo(processorNo);
        pcName.setGraphicsCard(graphicsCard);
        pcName.setRam(ram);
        pcName.setBrands(brands);
        pcName.setMemoryType(memoryType);
        pcName.getMemoryType().setMemorySize(memorySize);
        pcName.setPrice(price);

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
