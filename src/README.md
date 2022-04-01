"Hotel Cuzco" est un hôtel charmant de la ville de Cusco city au Pérou.

Il a rencontré beaucoup de succès ces dernières années.

L'administration a décidé de mettre en place un système de réservation simple pour remplacer leur vieux fichier excel.


Premièrement, le staff de l'hotel doit être en mesure d'initialiser l'hotel :
1. Ajouter une chambre 
   1. Chaque chambre doit avoir un numéro d'étage positif 
   2. Un numéro en guise d'identifiant, ce dernier doit respecter le pattern suivant : numéro d'étage + 0 + nombre unique sur l'étage 
   3. Une description : maximum 255 caractères, si aucune description n'est donnée alors une description par défaut est fourni : "très belle chambre"
   4. Une capacité : le nombre de personnes que la chambre peut accueillir
   
2. Lister les chambres
   1. Toutes les chambres et leurs infos sont retournées à l'utilisateur

Une fois l'hotel initialisé, l'application doit fournir deux autres fonctionnalités essentielles et complémentaires :
3. Passer une réservation
   1. L'utilisateur doit saisir les dates de début et fin de réservation, le nombre de voyageurs et la numéro de la chambre
   2. Si la chambre est disponible alors cette dernière est considérée comme réservée et n'est plus disponible à la réservation
4. Trouver une chambre disponible
   1. L'utilisateur peut saisir les dates de début et de fin de réservation ainsi que le nombre de voyageurs
   2. Le nombre minimal de nuit est de 1
   3. L'application retourne alors les chambres libres selon les critères renseignés