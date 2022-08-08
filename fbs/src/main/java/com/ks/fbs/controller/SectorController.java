package com.ks.fbs.controller;

import com.ks.fbs.exception.ResourceNotFoundException;
import com.ks.fbs.model.Sector;
import com.ks.fbs.service.SectorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SectorController {


    private final SectorService sectorService;

    @Value("${msg.title}")
    private String title;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/sector")
    public String sectorPage(Model model){
        Sector sector =new Sector();
        model.addAttribute("sector",sector);
        model.addAttribute("title", title);
        return "/pages/sector";
    }
    @GetMapping(value = "/sectors")
    public List<Sector> getSectors(){
        return sectorService.getAllSectors();
    }

    @GetMapping(value = "/sector/{sectorName}")
    public List<Sector> getSectorByName(Model model, @PathVariable String sectorName) {
        return sectorService.getSectorByName(sectorName);
    }

    @PostMapping("/sector")
    public String addSector(@Valid Sector sector, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/pages/sector";
        }
        sectorService.createSector(sector);
        return "/pages/sector";
    }
    @PutMapping("/sector")
    public String editSector(@Valid Sector sector, BindingResult result, Model model) throws ResourceNotFoundException {
        if (result.hasErrors()) {
            return "/pages/sector";
        }
        sectorService.updateSector(sector);
        return "/pages/sector";
    }

    @DeleteMapping("/sector")
    public String deleteSector( @PathVariable Long id) throws ResourceNotFoundException {
        sectorService.deleteSectorById(id);
        return "/pages/sector";
    }
}
