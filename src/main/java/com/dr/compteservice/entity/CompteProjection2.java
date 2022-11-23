package com.dr.compteservice.entity;

import com.dr.compteservice.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p2", types = Compte.class)
public interface CompteProjection2 {
    double getSolde();
    TypeCompte getType();
}
