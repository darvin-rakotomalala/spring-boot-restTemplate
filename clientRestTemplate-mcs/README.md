## Spring RestTemplate
Dans ce repo, nous allons avoir comment implementer Spring RestTemplate (avec Exemples CRUD).

### Qu'est-ce que Spring RestTemplate ?
---
**Spring RestTemplate** est un client REST synchrone effectuant des requêtes HTTP à l'aide d'une simple API de style modèle et est conçue pour appeler des services REST. Il utilise une bibliothèque client HTTP sous-jacente, telle que JDK  *HttpURLConnection*, *Apache HttpComponents*, etc. La classe *RestTemplate* est conçue sur les mêmes principes que les nombreuses autres classes *Template* Spring (par exemple, JdbcTemplate, JmsTemplate), offrant une approche simplifiée avec des comportements par défaut pour effectuer des tâches complexes.

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Lombok
- MapStruct
- Maven 3+

### Exemples
---
- `clientRestTemplate-mcs` un client Spring WebClient qui s'exécute sur le port 8082 et utlise les API REST de `socle-spring-data-jpa`.

### Exécuter et tester le projet
---
- Exécuter en premier `socle-spring-data-jpa` puis `clientRestTemplate-mcs` : `mvn spring-boot:run`
- Importer dans Postman la collection `clientRestTemplate.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman
  - Les descriptions OpenAPI seront disponibles au chemin `/v3/api-docs` par défaut : http://localhost:8082/v3/api-docs/ et/ou http://localhost:8082/swagger-ui/index.html