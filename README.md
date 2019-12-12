[![Build Status](https://travis-ci.com/gfresnais/POO_TP_DM_SpringBoot.svg?token=5K17HmxMpZcxFUnn27Gu&branch=master)](https://travis-ci.com/gfresnais/POO_TP_DM_SpringBoot) [![Maintainability](https://api.codeclimate.com/v1/badges/a8e53cb3dee738ce134f/maintainability)](https://codeclimate.com/github/gfresnais/POO_TP_DM_SpringBoot/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/a8e53cb3dee738ce134f/test_coverage)](https://codeclimate.com/github/gfresnais/POO_TP_DM_SpringBoot/test_coverage) [![Documentation Status](https://readthedocs.org/projects/poo-tp-dm-springboot/badge/?version=latest)](https://poo-tp-dm-springboot.readthedocs.io/en/latest/?badge=latest)

https://github.com/gfresnais/POO_TP_DM_SpringBoot

Première partie du DM
=====================

<h2>DEPENDENCIES</h2> 
'''
* [Spring Boot](https://spring.io/projects/spring-boot)
    Creates a stand-alone application based on the Spring API

* Spring Boot Devtools
    An additional set of tools to enhance the development of Spring Boot applications

* Spring Web
    An API to build web-based applications, includes the RESTful API
    
* [H2 database](http://www.h2database.com/html/main.html)
    A very fast and open source Java SQL database based on the JDBC API
    
* [Thymeleaf](https://www.thymeleaf.org/)
    A server-side Java template engine
'''

<h2>ÉTAPE 13</h2>
'''
* L'url d'appel /greeting a été configuré grâce au @GetMapping("/greeting")

* Le fichier HTML à afficher a été choisi grâce au return "greeting"

* On envoie le nom à qui on dit bonjour grâce au paramètre @RequestParam(name='name')
    Petite erreur dans le sujet, name est configuré pour récupérer nameGET et non pas name
'''

<h2>ÉTAPE 17</h2>
'''
La redéfinition de la JDBC URL a changé la valeur par défaut du champ JDBC URL de la console H2
'''

<h2>ÉTAPE 18</h2>
'''
Hibernate gère la persistance des objets en base de données relationelle
La table Article a été créé grâce à la classe Article présente dans le package model
La classe Article respecte les conventions Java Beans avec des getter et setter pour chaque attribut 
les tags appropriés pour que Spring l'intègre automatiquement et une clé primaire (son Id)
'''

<h2>ÉTAPE 20</h2>
'''
En ajoutant la config suivante :
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
cela permet à Spring Hibernate d'accéder au lancement de l'application à ma base de données H2 créée en mémoire
La présence d'un fichier data.sql permet de lancer des requêtes SQL au démarrage de l'application
J'ai donc bien ma table Article qui est renseignée avec 2 enregistrements
'''

<h2>ÉTAPE 23</h2>
'''
Le tag Autowired sur une propriété, dans notre cas l'attribut "addressRepository" permet à Spring d'assigner
automatiquement une valeur à cette propriété. Cela remplace le setter
'''

<h2>ÉTAPE 30</h2>
'''
Pour ajouter Bootstrap, j'ai ajouté la dépendance Maven du site webjars.org dans mon pom.xml
Maven va donc chercher un .jar contenant Bootstrap
'''

Seconde partie du DM
====================

<h2>ÉTAPE 2</h2>
'''
PostMapping : permet de récupérer des informations via une requête POST
Ici je récupère la valeur que j'ai entré dans le champ "address" grâce à @RequestParam
'''

<h2>ÉTAPE 3</h2>
'''
J'ai dû créer 4 classes afin de parser le JSON de la GeoAPI : 
- GeoRequest : L'objet de base renvoyé par la requête
- Feature : Contient les informations de l'adresse ainsi que ses coordonnées
- Geometry : les coordonnées géographiques de l'adresse
- Properties : les informations de l'adresse comme la rue, le département etc.
'''

<h2>ÉTAPE 5</h2>
'''
J'ai dû créer 7 classes afin de parser le JSON de la DarkSkyAPI :
- Weather : L'objet de base renvoyé par la requête
- Currently : La météo actuelle
- Hourly : La météo par heure
- Datum : Les informations de la météo par heure
- Daily : La météo par jour
- DatumDay : Les informations de la météo par jour
- Alert : Les informations d'alertes sur une région géographique
- Flags : Les différentes informations liées à l'utilisation de l'API comme les unités utilisées
'''

<h2>ÉTAPE 6</h2>
'''
Q1 - Oui il faut une clé API pour utiliser DarkSky, la formule de base est limité à 1000 appels par jour
Q2 - L'URL est la suivante https://api.darksky.net/forecast/CLE_API_DU_COMPTE/COORDS_LON,COORDS_LAT
Q3 - On utilise la méthode HTTP GET pour utiliser l'API
Q4 - On passe les paramètres d'appel avec un ?NOM_PARAM=VALEUR et on les concatène avec &
Q5 - Les informations suivantes se situent dans :
    - Température : Dans la section currently et l'attribut temperature
    - Prévision :  Dans la section currently et l'attribut summary
'''