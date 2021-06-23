==============================
== Les Batisseurs Moyen-Age ==
== Benjamin Giraud-Renard   ==
==============================

== Lancer le jeu ==

Veuillez décompresser l'archive à un endroit sans toucher aux dossiers.
Pour lancer le jeu, rendez vous dans ce dossier et lancer 

	java -jar LesBatisseurs.jar
	
Normalement vous devriez arriver sur le menu principal.


== Compiler les classes à la main ==

Rendez vous dans le dossier ws prévu à cet effet.
Compilez chacune des classes avec

	javac -d ../class $(find ../src -name "*.java")
	
== Utiliser ANT pour lancer les tests ==

Lancer la commande 
		
	ant test

pour tester chacun des programmes de test dans le package test.
