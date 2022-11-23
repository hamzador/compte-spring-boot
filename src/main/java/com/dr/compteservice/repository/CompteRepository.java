package com.dr.compteservice.repository;

import com.dr.compteservice.entity.Compte;
import com.dr.compteservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

    @RestResource(path = "/byType")
    List<Compte> findByType(@Param(value = "type") TypeCompte typeCompte);
    //http://localhost:8081/comptes/search/byType?type=COURANT

}
