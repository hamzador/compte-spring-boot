package com.dr.compteservice.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Compte.class)
public interface CompteProjection {
    Long getCode() ;
    double getSolde();
}
