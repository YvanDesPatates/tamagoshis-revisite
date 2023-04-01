## projet Tamagoshi

### Jouer
```
git clone https://gitlabinfo.iutmontp.univ-montp2.fr/rouxy/tamagoshis.git
cd tamagoshis
./gradlew run
```

### Règles
Choisir un nombre de Tamagoshis, les garder en vie le plus longtemps possible

### Principes vus en cours et implémentés
- Tracage du jeu en console grâce aux Loggers
- Utilisation des lambdas en particulier pour les évènements graphiques et les foreach
- Utilisation des Collections en particulier List et Map pour faciliter l'écriture et la lecture du code
- Écriture de la JavaDoc et ajout des package-info.java pour une doc sans manquements
- JavaFx : utilisation des méthodes vues dans le TD plus utilisation des gridPane et approfondissement des Stage pour le multifenetrage
- Integration d'une license publique avec les fonctionnalitées de l'IDE
- Utilisation du Modèle-Vue-Controller renommé respectivement tamagoshi-graphics-jeu
- Persistance du choix du nombre de Tamagoshis de la dernière partie grâce à la classe Propoerties (voire FileStore.java)