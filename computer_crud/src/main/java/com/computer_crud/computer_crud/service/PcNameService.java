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
        pcName.setPcName(pcNameDTO.getPcName());


        if (processorRepository.findByProcessorName(pcNameDTO.getProcessorName()) != null) {
            if (processorNoRepository.findByProcessorNoName(pcNameDTO.getProcessorNoName()) == null) {
                Processor processor = new Processor();
                processor.setProcessorName(pcNameDTO.getProcessorNoName());
                processorRepository.save(processor);
                if (processorNoRepository.findByProcessorNoName(pcNameDTO.getProcessorNoName()) == null) {
                    return "Processor No is not found";
                }
                else {
                    ProcessorNo processorNo = processorNoRepository.findByProcessorNoName(pcNameDTO.getProcessorNoName());
                    processor.setProcessorNo(processorNo);
                    processorRepository.save(processor);
                    pcName.setProcessor(processor);
                }
            }
            else {
                ProcessorNo processorNo = processorNoRepository.findByProcessorNoName(pcNameDTO.getProcessorNoName());
                Processor processor = processorRepository.findByProcessorName(pcNameDTO.getProcessorName());
                processor.setProcessorNo(processorNo);
                processorRepository.save(processor);
                pcName.setProcessor(processor);
            }
        }
        else {
            return"Processor Name is not found";
        }



        if (memoryTypeRepository.findByMemoryType(pcNameDTO.getMemoryType()) != null) {
            if (memorySizeRepository.findByMemorySize(pcNameDTO.getMemorySize()) == null) {
                MemoryType memoryType = new MemoryType();
                memoryType.setMemoryType(pcNameDTO.getMemoryType());
                memoryTypeRepository.save(memoryType);
                if (memorySizeRepository.findByMemorySize(pcNameDTO.getMemorySize()) == null) {
                    return "Memory Size is not found";
                }
                else {
                    MemorySize memorySize = memorySizeRepository.findByMemorySize(pcNameDTO.getMemorySize());
                    memoryType.setMemorySize(memorySize);
                    memoryTypeRepository.save(memoryType);
                    pcName.setMemoryType(memoryType);
                }

            }
            else {
                MemorySize memorySize = memorySizeRepository.findByMemorySize(pcNameDTO.getMemorySize());
                MemoryType memoryType = memoryTypeRepository.findByMemoryType(pcNameDTO.getMemoryType());
                memoryType.setMemorySize(memorySize);
                memoryTypeRepository.save(memoryType);
                pcName.setMemoryType(memoryType);
            }

        }
        else {
            return "Memory Type is not found";
        }


        GraphicsCard graphicsCard = graphicsCardRepository.findByGraphicscardName(pcNameDTO.getGraphicscardName());
        pcName.setGraphicsCard(graphicsCard);


        Ram ram = ramRepository.findByRamSize(pcNameDTO.getRamSize());
        pcName.setRam(ram);

        Brands brands = brandsRepository.findByBrandsName(pcNameDTO.getBrandsName());
        brands.setBrandsName(pcNameDTO.getBrandsName());
        pcName.setBrands(brands);

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


        repository.save(pcName);
        return "Model Added Successfully";
    }


    public List<PcNameDTO> getAllModels() {
        List<PcNameDTO> pcNameDTOList = new ArrayList<>();
        for (PcName pcName : repository.findAll()) {
            PcNameDTO pcNameDTO = new PcNameDTO();

            if (pcName.getGraphicsCard() == null) {
                pcNameDTO.setGraphicscardName("Bilgi Yok");
            }
            else {
                pcNameDTO.setGraphicscardName(pcName.getGraphicsCard().getGraphicscardName());
            }

            if (pcName.getProcessor() == null) {
                pcNameDTO.setProcessorName("Bilgi Yok");
            }
            else {
                pcNameDTO.setProcessorName(pcName.getProcessor().getProcessorName());
            }
            if (pcName.getBrands() == null) {
                pcNameDTO.setBrandsName("Bilgi Yok");
            }
            else {
                pcNameDTO.setBrandsName(pcName.getBrands().getBrandsName());
            }
            if (pcName.getRam() == null) {
                pcNameDTO.setRamSize(0);
            }
            else {
                pcNameDTO.setRamSize(pcName.getRam().getRamSize());
            }
            if (pcName.getProcessor() == null) {
                pcNameDTO.setProcessorNoName("Bilgi Yok");
            }
            else {
                pcNameDTO.setProcessorNoName(pcName.getProcessor().getProcessorNo().getProcessorNoName());
            }
            if (pcName.getMemoryType() == null) {
                pcNameDTO.setMemoryType("Bilgi Yok");
            }
            else {
                pcNameDTO.setMemoryType(pcName.getMemoryType().getMemoryType());
            }
            if (pcName.getMemoryType().getMemorySize() == null) {
                pcNameDTO.setMemorySize(0);
            }
            else {
                pcNameDTO.setMemorySize(pcName.getMemoryType().getMemorySize().getMemorySize());
            }
            if (pcName.getPrice() == null) {
                pcNameDTO.setPrice(0);
            }
            else {
                pcNameDTO.setPrice(pcName.getPrice().getPrice());
            }


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
