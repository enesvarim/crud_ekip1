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

        PcName pcName = new PcName();


        if (processorRepository.findByProcessorName(pcNameDTO.getProcessorName()) != null) {
            Processor processor = processorRepository.findByProcessorName(pcNameDTO.getProcessorName());
            processor.setProcessorName(pcNameDTO.getProcessorName());
            if (processorNoRepository.findByProcessorNoName(pcNameDTO.getProcessorNoName()) != null) {
                ProcessorNo processorNo = processorNoRepository.findByProcessorNoName(pcNameDTO.getProcessorNoName());
                processor.setProcessorNo(processorNo);
                processorRepository.save(processor);
                pcName.setProcessor(processor);
            }
            else {
                processor.getProcessorNo().setProcessorNoId(0);
                processorRepository.save(processor);
                pcName.setProcessor(processor);
            }
        }
        else {
            pcName.getProcessor().setProcessorId(0L);
            pcName.getProcessor().getProcessorNo().setProcessorNoId(0);
        }

        //yukardaki yapının benzeri bunada uygulanacak
        MemoryType memoryType = memoryTypeRepository.findByMemoryType(pcNameDTO.getMemoryType());
        memoryType.setMemoryType(pcNameDTO.getMemoryType());
        MemorySize memorySize = memorySizeRepository.findByMemorySize(pcNameDTO.getMemorySize());
        memoryType.setMemorySize(memorySize);
        memoryTypeRepository.save(memoryType);
        pcName.setMemoryType(memoryType);


        if (graphicsCardRepository.findByGraphicscardName(pcNameDTO.getGraphicscardName()) == null) {
            pcName.getGraphicsCard().setGraphicsCardId(0L);
        }
        else {
            GraphicsCard graphicsCard = graphicsCardRepository.findByGraphicscardName(pcNameDTO.getGraphicscardName());
            pcName.setGraphicsCard(graphicsCard);
        }
         if (ramRepository.findByRamSize(pcNameDTO.getRamSize()) == null) {
            pcName.getRam().setRamSize(0);}
        else {
            Ram ram = ramRepository.findByRamSize(pcNameDTO.getRamSize());
            pcName.setRam(ram);
         }

        Brands brands = brandsRepository.findByBrandsName(pcNameDTO.getBrandsName());
        if (priceRepository.findByPrice(pcNameDTO.getPrice()) == null) {
            Price price = new Price();
            price.setPrice(pcNameDTO.getPrice());
            priceRepository.save(price);
            pcName.setPrice(price);
        }
        else {
            Price price = priceRepository.findByPrice(pcNameDTO.getPrice());
            pcName.setPrice(price);
        }

        pcName.setPcName(pcNameDTO.getPcName());
        pcName.setBrands(brands);

        repository.save(pcName);
        return "Model Added Successfully";
    }


    public List<PcNameDTO> getAllModels() {
        List<PcNameDTO> pcNameDTOList = new ArrayList<>();
        for (PcName pcName : repository.findAll()) {
            PcNameDTO pcNameDTO = new PcNameDTO();
            pcNameDTO.setGraphicscardName(pcName.getGraphicsCard().getGraphicscardName());
            pcNameDTO.setProcessorName(pcName.getProcessor().getProcessorName());
            pcNameDTO.setBrandsName(pcName.getBrands().getBrandsName());
            pcNameDTO.setRamSize(pcName.getRam().getRamSize());
            pcNameDTO.setProcessorNoName(pcName.getProcessor().getProcessorNo().getProcessorNoName());
            pcNameDTO.setMemorySize(pcName.getMemoryType().getMemorySize().getMemorySize());
            pcNameDTO.setMemoryType(pcName.getMemoryType().getMemoryType());
            pcNameDTO.setPrice(pcName.getPrice().getPrice());
            pcNameDTO.setPcName(pcName.getPcName());
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
