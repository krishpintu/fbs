package com.ks.fbs.service;

import com.ks.fbs.model.Sector;
import com.ks.fbs.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    public List<Sector> getAllSectors(){
        return sectorRepository.findAll().stream().toList();
    }

    public  List<Sector> getSectorByName(String sectorname){
        return Collections.singletonList(sectorRepository.findBySectorName(sectorname).get());
    }
}
