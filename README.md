#  Microservice Bancaire - Spring Data REST

##  Description
Microservice de gestion de comptes bancaires développé avec **Spring Boot 3.2.0** et **Spring Data REST**. L'API REST est générée automatiquement à partir des repositories JPA, offrant un CRUD complet sans développement manuel.


##  Technologies Utilisées

- **Java 17** & **Spring Boot 3.2.0**
- **Spring Data REST** (génération automatique des APIs)
- **Spring Data JPA** & **H2 Database** (base mémoire)
- **Lombok** & **Maven**

##  Architecture du Projet

```
ms-banque/
├── src/
│   └── main/
│       ├── java/ma/rest/spring/
│       │   ├── entities/ (Client, Compte, TypeCompte, Projections)
│       │   └── repositories/ (ClientRepository, CompteRepository)
│       └── resources/application.properties
└── pom.xml
```

### ARCHITECTURE DU MICROSERVICE BANCAIRE - SPRING DATA REST
<img width="3204" height="1656" alt="DIAGRAMME ms-banque" src="https://github.com/user-attachments/assets/06967788-72b9-424b-966d-21ef7e47715a" />

##  Modèle de Données

### 🔹 Client
```java
@Entity
public class Client {
    private Long id;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "client")
    private List<Compte> comptes;
}
```

### 🔹 Compte
```java
@Entity
public class Compte {
    private Long id;
    private double solde;
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type; // COURANT ou EPARGNE
    @ManyToOne
    private Client client;
}
```
# Accès immédiat aux URLs principales :
  http://localhost:8082/api/comptes - Liste des comptes
  <br>
  http://localhost:8082/api/clients - Liste des clients  
  <br>
  http://localhost:8082/api/comptes/search/byType?t=EPARGNE - Comptes 
  <br>
  http://localhost:8082/h2-console - Base de données (JDBC: jdbc:h2:mem:banque, User: sa)

## Démonstration
# Liste des comptes 
<img width="1443" height="960" alt="liste compte1" src="https://github.com/user-attachments/assets/662d5453-756f-4d8c-9328-9e44a8bbc0ba" />
<img width="1443" height="960" alt="liste compte1" src="https://github.com/user-attachments/assets/764fca4f-8de1-4bc0-8ca9-1ee06608a7bd" />
<img width="1443" height="927" alt="liste compte2" src="https://github.com/user-attachments/assets/40ee2fdc-e538-4a84-9c8c-e0cb083195d7" />

# Liste des clients
<img width="1443" height="957" alt="liste client1" src="https://github.com/user-attachments/assets/7ab77263-7de6-47e3-9f87-7f447afeb995" />
<img width="1452" height="962" alt="liste client2" src="https://github.com/user-attachments/assets/12bccef9-7b4a-41f6-9a07-12266c90d5e7" />

# RECHERCHE DE COMPTES PAR TYPE
<img width="1445" height="955" alt="EPARGANE1" src="https://github.com/user-attachments/assets/0529e75c-6998-4ec6-bde5-cf5b699cf691" />
<img width="1445" height="963" alt="EPARGANE2" src="https://github.com/user-attachments/assets/b542d135-9008-4c67-a1c1-d4acaf553dbb" />
<img width="1442" height="956" alt="EPARGANE3" src="https://github.com/user-attachments/assets/5891d763-fc20-423c-93ab-85749949ad0b" />

# h2-console
<img width="1918" height="680" alt="CONSOLE" src="https://github.com/user-attachments/assets/4b11c099-8550-416f-a657-27b96862bb3f" />

<img width="1918" height="971" alt="H2 consol" src="https://github.com/user-attachments/assets/b027a6aa-6174-4ed7-a144-2e01f1cc62f0" />
<br><br>

## Video de la console intelij java





https://github.com/user-attachments/assets/51588c51-2a22-4bba-acf1-8c68526f526c



```
```

##  Configuration Essentielle

```properties
# application.properties
server.port=8082
spring.datasource.url=jdbc:h2:mem:banque
spring.h2.console.enabled=true
spring.data.rest.base-path=/api
spring.jpa.hibernate.ddl-auto=create-drop
```

##  Fonctionnalités Clés

-  **CRUD Automatique** via Spring Data REST
-  **Recherches Personnalisées** (par type de compte)
-  **Relations Automatiques** entre entités
-  **Projections** pour vues personnalisées
-  **Pagination & Tri** 
-  **Interface H2** pour gestion base de données


##  Auteur & Encadrant

-  **Realisée par** : BENZIAT hana
-  **Encadre par** : Mr.LACHGRE mohammed
-  **Etablissement**: Ecole Normale Superieur Marrakech
-  **gmail** :h.benziat1318@uca.ac.ma
---

