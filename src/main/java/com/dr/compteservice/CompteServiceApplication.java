package com.dr.compteservice;

import com.dr.compteservice.entity.Compte;
import com.dr.compteservice.enums.TypeCompte;
import com.dr.compteservice.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            // pour exporter le id car par défaut n'est pas listé
            repositoryRestConfiguration.exposeIdsFor(Compte.class);
            compteRepository.save(new Compte(null, 98000, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 1000, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 2108, new Date(), TypeCompte.COURANT));

            compteRepository.findAll().forEach(cp -> {
                System.out.print(cp.getType());
                System.out.println(" --> " + cp.getSolde());
                System.out.println(" ------------- ");
                    }
            );
        };
    }
}
