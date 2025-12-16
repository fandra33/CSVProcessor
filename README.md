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

IMPORTANT: aplicația ta, conform implementării actuale, folosește `FileReader`/fisier direct pentru a deschide CSV-ul (nu `getResourceAsStream`). Asta înseamnă că:
- Dacă rulați din JAR: fișierul CSV trebuie să existe pe sistemul de fișiere (de exemplu, în același director din care rulați JAR-ul) — nu poate fi citit din interiorul JAR-ului printr-o cale simplă de fișier.
- Dacă rulați în modul dezvoltare (IDE sau `mvn javafx:run`) puteți folosi calea relativă la directorul de lucru (de obicei rădăcina proiectului) sau o cale absolută.

Recomandări practice:
- Pentru testare rapidă, folosiți calea relativă către fișierul din resurse: `src/main/resources/data3col.csv` (de exemplu). Aceasta funcționează când rulați din IDE sau din directorul proiectului.
- Pentru rularea JAR-ului distribuit: copiați `test_data.csv` în același director cu JAR-ul și rulați `java -jar csvReaderProcesor-1.0-SNAPSHOT.jar test_data.csv`.

## Ce argument trebuie să dai aplicației

Aplicația așteaptă ca primul argument (`args[0]`) să fie calea către fișierul CSV. Poți da:

- O cale relativă la directorul curent, de exemplu:
  - `src/main/resources/data3col.csv` (dacă rulezi din rădăcina proiectului)
  - `data3col.csv` (dacă ai copiat fișierul în directorul curent)
- O cale absolută, de exemplu `/home/andre/Downloads/test_data.csv`

Exemple:

Rulare din terminal după `mvn package` (dacă JAR-ul tău poate rula singur):

```bash
mvn clean package
java --enable-native-access=javafx.graphics -jar target/csvReaderProcesor-1.0-SNAPSHOT.jar src/main/resources/data3col.csv
```

Dacă preferi să rulezi din IDE (IntelliJ):
- Deschide Run Configuration pentru `MainApp`.
- La `Program arguments` pune `src/main/resources/data3col.csv` sau calea dorită.
- Asigură-te că `Working directory` este setat la rădăcina proiectului (implicit ar trebui să fie).

Notă: nu folosi numele de fișier fără cale decât dacă fișierul este în directorul din care rulezi comanda (working directory).

## Mesaje WARN și cum scapi de ele

La rularea JavaFX pe anumite JDK/OpenJFX apar mesaje de genul:

```
WARNING: A restricted method in java.lang.System has been called
WARNING: Use --enable-native-access=javafx.graphics to avoid a warning for callers in this module
```

Puteți suprima avertismentul (și evita blocarea în viitor) adăugând flag-ul JVM:

```bash
--enable-native-access=javafx.graphics
```

Exemplu complet cu flag și argument CSV:

```bash
java --enable-native-access=javafx.graphics -jar target/csvReaderProcesor-1.0-SNAPSHOT.jar /cale/catre/test_data.csv
```

Notă: unele alte warnings (de exemplu în legătură cu `sun.misc.Unsafe`) pot rămâne și sunt emise de biblioteci native; ele nu opresc aplicația, dar pot fi raportate upstream către proiectele respective.

## Rulare cu `mvn javafx:run`

Plugin-ul `javafx-maven-plugin` este configurat în `pom.xml` și vă permite să rulați aplicația cu:

```bash
mvn clean javafx:run
```

Pentru a transmite argumente prin plugin, cel mai robust e să le specificați în configurarea plugin-ului din `pom.xml` (secțiunea `<configuration><arguments>`). Alternativ, rulați din IDE cu argumentele setate în configurația de run.

## Sugestii practice / sfaturi pentru dezvoltare

- Dacă doriți ca aplicația să poată citi CSV-urile ambalate în JAR (în `src/main/resources`), e nevoie să modificați citirea CSV din `FileReader(new File(path))` la citirea de pe classpath cu `getResourceAsStream` și să adaptați logica (de ex. folosiți un `Reader` construit pe baza `InputStreamReader`).
- Daca preferi să păstrezi citirea prin fișier, folosește o comandă/argument care trece o cale pe FS (ex: `src/main/resources/data3col.csv` în timpul dezvoltării sau `./test_data.csv` în producție).
- Pentru a evita probleme legate de versiunea JDK, sincronizați `maven-compiler-plugin` cu versiunea JDK instalată sau instalați JDK-ul cerut (vezi comentariul din `pom.xml`).

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

Sau, pentru dezvoltare rapidă în IDE, setează argumentul `src/main/resources/data3col.csv` și pornește `MainApp`.

## Probleme frecvente și remedieri

- FileNotFoundException pentru `test_data.csv` — asigură-te că calea transmisă ca argument este corectă și că fișierul există în acea locație. Exemplu de cale care funcționează în mod frecvent în dev: `src/main/resources/data3col.csv`.
- Avertismente JavaFX native access — adaugă `--enable-native-access=javafx.graphics` la comanda `java`.
- Erori de modul/reflection (ex: `module does not export ...`) — asigură-te că `module-info.java` conține `opens` pentru pachetele FXML/GUI (în proiectul curent este deja prezent `opens org.example.csvreaderprocesor.gui to javafx.graphics;`).

---

Dacă vrei, pot:
- Adăuga în `pom.xml` o opțiune implicită pentru a transmite argumentul CSV către `javafx-maven-plugin` (dacă dorești rularea `mvn javafx:run` cu argument implicit),
- Sau modifica codul ca să încarce fișiere CSV din resurse (folosind `getResourceAsStream`) astfel încât să poți folosi fișiere ambalate în JAR.

Spune-mi ce preferi și îl adaptez pentru tine.
