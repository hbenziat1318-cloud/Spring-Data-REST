package ma.rest.spring;

import ma.rest.spring.entities.Client;
import ma.rest.spring.entities.Compte;
import ma.rest.spring.entities.TypeCompte;
import ma.rest.spring.repositories.ClientRepository;
import ma.rest.spring.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CompteRepository compteRepository,
                           ClientRepository clientRepository,
                           RepositoryRestConfiguration restConfiguration) {
        return args -> {
            // Exposer les IDs dans les réponses JSON
            restConfiguration.exposeIdsFor(Compte.class);

            // Création des clients
            Client client1 = clientRepository.save(new Client(null, "Amal", "amal@email.com", null));
            Client client2 = clientRepository.save(new Client(null, "Ali", "ali@email.com", null));

            // Création des comptes
            compteRepository.save(new Compte(null, 367.31, new Date(), TypeCompte.EPARGNE, client1));
            compteRepository.save(new Compte(null, 1500.87, new Date(), TypeCompte.COURANT, client1));
            compteRepository.save(new Compte(null, 2500.50, new Date(), TypeCompte.EPARGNE, client2));

            // Affichage dans la console
            System.out.println("=== COMPTES CRÉÉS ===");
            compteRepository.findAll().forEach(compte -> {
                System.out.println("Compte ID: " + compte.getId() +
                        ", Solde: " + compte.getSolde() +
                        ", Type: " + compte.getType() +
                        ", Client: " + compte.getClient().getNom());
            });
        };
    }
}