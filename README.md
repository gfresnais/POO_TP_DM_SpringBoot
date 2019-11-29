====================
    DEPENDENCIES 
====================
- Spring Boot
    Creates a stand-alone application based on the Spring API
    https://spring.io/projects/spring-boot

- Spring Boot Devtools
    An additional set of tools to enhance the development of Spring Boot applications

- Spring Web
    An API to build web-based applications, includes the RESTful API
    
- H2 database
    A very fast and open source Java SQL database based on the JDBC API
    http://www.h2database.com/html/main.html
    
- Thymeleaf
    A server-side Java template engine
    https://www.thymeleaf.org/
 

=================
    ÉTAPE 13
================= 
- L'url d'appel /greeting a été configuré grâce au @GetMapping("/greeting")

- Le fichier HTML à afficher a été choisi grâce au return "greeting"

- On envoie le nom à qui on dit bonjour grâce au paramètre @RequestParam(name='name')
    Petite erreur dans le sujet, name est configuré pour récupérer nameGET et non pas name

=================
    ÉTAPE 17
================= 
- La redéfinition de la JDBC URL a changé la valeur par défaut du champ JDBC URL de la console H2

=================
    ÉTAPE 18
================= 
Hibernate gère la persistance des objets en base de données relationelle
La table Article a été créé grâce à la classe Article présente dans le package model
La classe Article respecte les conventions Java Beans avec des getter et setter pour chaque attribut 
les tags appropriés pour que Spring l'intègre automatiquement et une clé primaire (son Id)

=================
    ÉTAPE 20
================= 
En ajoutant la config suivante :
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
cela permet à Spring Hibernate d'accéder au lancement de l'application à ma base de données H2 créée en mémoire
La présence d'un fichier data.sql permet de lancer des requêtes SQL au démarrage de l'application
J'ai donc bien ma table Article qui est renseignée avec 2 enregistrements

=================
    ÉTAPE 23
================= 
Le tag Autowired sur une propriété, dans notre cas l'attribut "addressRepository" permet à Spring d'assigner
automatiquement une valeur à cette propriété. Cela remplace le setter

=================
    ÉTAPE 30
================= 
Pour ajouter Bootstrap, j'ai ajouté la dépendance Maven du site webjars.org dans mon pom.xml
Maven va donc chercher un .jar contenant Bootstrap