# EXSTREAM_BATCH
C’est un programme batch qui permet de packager un projet EXSTREAM depuis Eclipse c'est-à-dire qu'il permet de crée le fichier de package d'un projet EXSTREAM

Etapes:

(Facultatif)
1- Crée une classe MyFilterClass qui permet de détecter les documents type ".XML"   

2- Dans la classe Main TEST ; crée une méthode qui permet de vérifier si un chemin spécifique est un répertoire et si le répertoire contient des document ".xml"  (Facultatif)

(Obligatoire)

3- Crée un dossier vide "TEMP" sur votre ordinateur; il est utilisé pour le stockage temporaire du fichier "temp.opt"  "File.createTempFile"

4- Avec "PrintWriter" écrire les informations nécessaires incluse dans temp.opt temporaire et qui permet de déclencher le package (Obligatoire)
À savoir :

  - chemin du fichier PACKAGEFILE
  
  - chemin du fichier MSGRESOURCE
  
  - chemin du fichier FILEMAP=FILEINPUT
  
  - chemin du fichier FILEMAP
  
  - chemin du répertoire OUTPUTDIRECTORY
  
  - chemin du fichier MESSAGEFILE
  
  Lancer le job, Exstream doit rester ouvert sur votre machine 
