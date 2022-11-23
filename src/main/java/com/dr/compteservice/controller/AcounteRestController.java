package com.dr.compteservice.controller;

import com.dr.compteservice.dtos.VirementRequestDTO;
import com.dr.compteservice.service.CompteService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcounteRestController {

   private CompteService compteService;

    public AcounteRestController(CompteService compteService) {
        this.compteService = compteService;
    }

    @PutMapping(path = "comptes/virement")
    public void virement(@RequestBody VirementRequestDTO requestDTO){
        compteService.virement(
                requestDTO.getCodeSource(),
                requestDTO.getCodeDestination(),
                requestDTO.getMontant());

    }

}
