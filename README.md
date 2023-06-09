## projet Tamagoshi

### Jouer
```
git clone https://github.com/YvanDesPatates/tamagoshis-revisite.git
cd tamagoshis-revisite
./gradlew run
```

### Besoins de doc ?
```
./gradlew javadoc
x-www-browser build/docs/javadoc/index.html
```

### Règles
Choisir un nombre de Tamagoshis, les garder en vie le plus longtemps possible

Attention, en plus des GrosMangeur et des GrosJoueurs, certains sont des Parieurs et ont 15% de chances de mourrir quand vous jouer avec !

Vous ne saurez qu'as la fin le type de chaque tamagoshi

### Principes vus en cours et implémentés
- Tracage du jeu en console grâce aux Loggers
- Utilisation des lambdas en particulier pour les évènements graphiques et les foreach
- Utilisation des Collections en particulier List et Map pour faciliter l'écriture et la lecture du code
- Écriture de la JavaDoc et ajout des package-info.java pour une doc sans manquements
- JavaFx : utilisation des méthodes vues dans le TD plus utilisation des gridPane et approfondissement des Stage pour le multifenetrage
- Integration d'une license publique avec les fonctionnalitées de l'IDE
- Utilisation du Modèle-Vue-Controller renommé respectivement tamagoshi-graphics-jeu
- Persistance du choix du nombre de Tamagoshis de la dernière partie grâce à la classe Propoerties (voire FileStore.java)
- Internationalisation de l'interface avec le ResourceBundle et des fichiers properties (français par défaut et anglais possible)
