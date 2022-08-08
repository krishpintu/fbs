package com.ks.fbs.service;

import com.ks.fbs.exception.ResourceNotFoundException;
import com.ks.fbs.model.Sector;
import com.ks.fbs.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    private boolean existsById(Long id) {
        return sectorRepository.existsById(id);
    }

    public List<Sector> getAllSectors(){
        return sectorRepository.findAll().stream().toList();
    }

    public  List<Sector> getSectorByName(String sectorName){
        return Collections.singletonList(sectorRepository.findBySectorName(sectorName).get());
    }
    public Sector createSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    public Sector updateSector( Sector request) throws ResourceNotFoundException {
        Sector sector =new Sector();
        if (!existsById(request.getId())) {
            throw new ResourceNotFoundException("Cannot find Sector with id: " + request.getId().toString());
        }

        sector.setId(request.getId());
        sector.setSectorName(request.getSectorName());
        sector.setStatus(request.getStatus());
        sector.setUpdateBy(request.getUpdateBy());
        sector.setUpdatedAt(LocalDateTime.now());

        return sectorRepository.save(sector);
    }

    public void deleteSectorById(Long id) throws ResourceNotFoundException {
        if (!existsById(id)) {
            throw new ResourceNotFoundException("Cannot find Sector with id: " + id);
        }
        else {
            sectorRepository.deleteById(id);
        }
    }

}
