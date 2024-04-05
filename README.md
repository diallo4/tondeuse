# TONDEUSE

Enoncé du l'exercice : [Lien vers l'énoncé](input/Tondeuse.pdf)

# Usage du projet

Il est possible de lancer le projet directement avec le fichier testfile.txt qui correspond au cas décrit dans l'énoncé avec la commande maven

```
$ mvn compile exec:java
```

Il est egalement possible de choisir le fichier souhaite en l'ajoutant au répertoire input et en lançant la commande suivante

```
$ mvn compile exec:java -Dexec.args="input/testfile.txt"
```
Si on utilise un IDE tel que intelliJ il est possible de le lenace via intelliJ en passant par le menu Run : Run > Edit Configuration
Ensuite on selectionne Application et on met le chemin du package de la classe qui contient le Main : 

```
$ com.mowitnow.demo.MowerInstructionFileLauncher
```
Et dans le champ Program arguments on met le chemin vers le fichier que l'on veut utiliser 

Les résultats sont visibles dans la console ou le terminal de lancement de la commande


# Tester le projet

Le projet est couvert par des tests unitaires (JUnit). j'ai fait le choix de mettre des tests unitaire uniquement sur les 
fonctionnalités et pas sur les getters et setters, ainsi que le Equals et Hashcode. 

Il reste possible de rajouter des scénarios de tests BDD avec les frameworks adaptés.

Il est possible d'executer les tests avec la commande suivante

```
$ mvn surefire:test
```