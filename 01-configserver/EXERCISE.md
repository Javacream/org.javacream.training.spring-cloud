# Übungen für Teilprojekt "configserver"

1. Erstellen Sie ein neues Maven-Modul mit Namen "my-configserver"
2. Fügen Sie die `spring-cloud-config-server` Dependency der pom.xml hinzu
3. Erstellen Sie die Applikationsklasse
4. Konfigurieren Sie mittels einer neuen `src/main/resources/application.properties` Datei
im Projekt folgende Werte:
    ````properties
   server.port: 8888
   spring.profiles.active=native
   spring.cloud.config.server.native.searchLocations=classpath:/configurations
    ````
5. Legen Sie im Projekt ein leeres Verzeichnis `src/main/resources/configurations`
6. Erstellen Sie dort Dateien folgende Dateien, jeweils mit mind. dem Property `greeting.message`:
   1. `someApp.yml`
   2. `testApp-default.yml`
   3. `testApp-testProfile.yml`
7. Erzeugen Sie im Internet ein hübsche ASCII Art Ausgabe für den Text "Config Server" und
speichern dies in einer neuen Datei `src/main/resources/banner.txt` ab.
8. Starten Sie die Anwendung
9. Rufen Sie folgende URLs auf -- was fällt Ihnen auf?
   1. http://localhost:8888/someApp/default
   1. http://localhost:8888/someApp/testProfile
   1. http://localhost:8888/someApp/xyz
   2. http://localhost:8888/testApp/default
   3. http://localhost:8888/testApp/testProfile
   3. http://localhost:8888/testApp/xyz