package com.dr.compteservice.service;

public interface CompteService {

    void virement(Long codeSource, Long codeDestination, double montant);

}
