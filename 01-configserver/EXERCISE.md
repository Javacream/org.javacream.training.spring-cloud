# Übungen für Teilprojekt "configserver"

1. Erstellen Sie ein neues Maven-Modul mit Namen "my-configserver"
2. Fügen Sie die `spring-cloud-config-server` Dependency der pom.xml hinzu
3. Erstellen Sie die Applikationsklasse
4. Legen Sie im Projekt ein leeres Git-Repository an und initialisieren Sie dieses (`git init .`)
5. Erstellen Sie dort eine Datei `application.yml` mit ein paar Beispiel-Properties, die mit "some.test." beginnen
6. Konfigurieren Sie (neue `src/main/resources/application.properties` anlegen) im Projekt selbst folgende Werte:
    ````properties
    server.port: 8888
    spring.cloud.config.server.git.uri: file:./01-configserver/src/main/git
    ````
7. Erzeugen Sie im Internet ein hübsche ASCII Art Ausgabe für den Text "Config Server" und
speichern dies in einer neuen Datei `src/main/resources/banner.txt` ab.
8. Starten Sie die Anwendung
9. Rufen Sie folgende URL auf http://localhost:8888/some/test