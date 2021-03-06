# ProjetJ2E
Répertoire du projet de J2E

## Installation

L'application nécessite pour fonctionner
- Un JDK de version 13 (azul...)
- D'avoir installer maven (version 3.8.4) sur son ordinateur

**Sous Linux** : 

Pré-requis: Avoir installé un JDK (1.7 et plus)
```
sudo apt-get install maven
```

**Sous Windows** :

Prérequis : Avoir téléchargé un JDK (1.7 et plus) et l'avoir ajouté en temps que variable d'environnement (voir [ici](https://maven.apache.org/install.html) pour plus de détails).

Téléchargez le zip du package [maven](https://maven.apache.org/download.cgi).

Déziper le fichier.

Ajoutez le fichier bin en tant que variable d'environnement.
- Un IDE (IntelliJ, VSC...)
- Avoir installer PostgreSQL (version 14.1)

## Organisation du code

Le code est organisé en deux grandes parties:
- La partie main, contenant le code principal de l'application ;
- La partie test, contenant les tests unitaires et d'intégration continue.

## Quelques lignes de commande utiles
#### Commande globale
```
mvn clean package jacoco:report
```
#### Compile le projet
```
mvn package
```
#### Effectuer les tests
```
mvn test
```
#### Mettre à jour la couverture de test
```
mvn jacoco:report
```
#### Démarrer l'application
```
mvn spring-boot:run
```


## Utilisation
Pour utiliser l'application, il faut la démarrer:
#### Démarrer l'application
```
mvn spring-boot:run
```

#### Ouvrir l'application dans un navigateur
```
localhost:8080/home.html
```
Une fois l'application démarrée, seul les administrateurs pouvant s'authentifier peuvent accéder au site :
```
Username : admin
Password : password
```
L'administrateur peut créer un évènement ou un participant, le supprimer ou encore le modifier.
Il peut également ajouter des participants à un évènement.
Lorsqu'il veut sortir de l'application, il peut se déconnecté.
