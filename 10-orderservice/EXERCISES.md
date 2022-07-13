# Übungen für Teilprojekt "orderservice"

## setup

1. Erstellen Sie ein neues Maven-Modul mit Namen "my-orderservice"
2. Erstellen Sie die Applikationsklasse
3. Definieren Sie den Applikationsnamen und die Quelle der zu importierenden Properties fest (`application.properties`):
    ````properties
    spring.application.name: someApp
    spring.config.import=configserver:http://localhost:8888
    ````

## erster test der konfiguration

1. Erstellen Sie einen REST Controller, der das Property `greeting.message` mittels `@Value` injiziert
bekommt und mittels GET auf `/greeting` ausgibt
5. Starten Sie die Anwendung und rufen Sie http://localhost:8080/greeting auf
6. Ändern Sie den Anwendungsnamen auf "testApp"
7. Starten Sie die Anwendung und rufen Sie http://localhost:8080/greeting auf
8. Starten Sie die Anwendung mit dem aktiven Profil "testProfile" und rufen Sie http://localhost:8080/greeting auf

## spezifische konfiguration 
1. Ändern Sie den Anwendungsnamen auf "orderservice"
10. Legen Sie eine neue `orderservice-default.yml` Datei im "configserver" Projekt an und starten Sie diesen neu
11. Starten Sie die Anwendung und rufen Sie http://localhost:8080/greeting auf
