# csvReaderProcesor

Acest proiect este o aplicație Java care citește fișiere CSV și afișează grafice cu JavaFX.

Scopul acestui README este să permită oricui clonează proiectul să îl compileze și să îl ruleze local.

## Ce trebuie instalat

- JDK (Java Development Kit) 17+ recomandat; proiectul folosește Java modulară și JavaFX. Observație: în `pom.xml` momentan `maven-compiler-plugin` are `source`/`target` setate la `25` — dacă tu sau alții nu aveți JDK 25 instalați, schimbați acele valori la versiunea JDK-ului vostru (de exemplu `21`) înainte de build.
- Maven (3.x)
- Un IDE Java modern (opțional): IntelliJ IDEA recomandat pentru dezvoltare JavaFX.

## Dependențe folosite

- JavaFX (org.openjfx javafx-controls, javafx-fxml) — gestionate prin Maven
- OpenCSV (com.opencsv)

## Structura resurse CSV

Există exemple de CSV în `src/main/resources/`:
- `data2col.csv`
- `data3col.csv`
- `data4col.csv`

## Rulare cu `mvn javafx:run`

Plugin-ul `javafx-maven-plugin` este configurat în `pom.xml` și vă permite să rulați aplicația cu:

```bash
mvn clean javafx:run
```

## Exemplu de flux de lucru minimal (dev)

1. Clonează repo

```bash
git clone <repository-url>
cd csvReaderProcesor
```

2. Rulează din IDE sau din terminal (exemplu terminal):

```bash
# build
mvn clean package
# rulează cu fișier de test din resurse
java --enable-native-access=javafx.graphics -jar target/csvReaderProcesor-1.0-SNAPSHOT.jar src/main/resources/data3col.csv
```
