# ProjetJ2E
Répertoire du projet de J2E

## Installation

L'application nécessite pour fonctionner
- Un JDK de version 13 (azul...)
- D'avoir installer maven (version 3.8.4) sur son ordinateur
- Un IDE (IntelliJ, VSC...)

## Organisation du code 
## Utilisation
### En lignes de commande
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
