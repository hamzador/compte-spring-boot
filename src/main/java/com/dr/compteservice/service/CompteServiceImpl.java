package com.dr.compteservice.service;

import com.dr.compteservice.entity.Compte;
import com.dr.compteservice.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

    private CompteRepository compteRepository;

    public CompteServiceImpl(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public void virement(Long codeSource, Long codeDestination, double montant) {
        Compte compteSource = compteRepository.getReferenceById(codeSource);
        Compte compteDestination = compteRepository.getReferenceById(codeDestination);
        compteSource.setSolde(compteSource.getSolde() - montant);
        compteDestination.setSolde(compteDestination.getSolde() + montant);
        // @Transactional avec cette annotation dés qu'on termine il fait save automatiquement
        // ces deux lignes pour s'assuré l'eregistrement
        compteRepository.save(compteSource);
        compteRepository.save(compteDestination);
    }
}
