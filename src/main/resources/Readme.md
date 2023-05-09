#News-Service
Schreiben Sie eine Applikation, die interessierten Leser Push-Nachrichten für bestimmte Kategorien zukommen lassen kann.


## Requirements
Die Menüführung soll selbständig erarbeitet werden!

Es gibt ein fixes Set an Nachrichten (Top Stories, Sport, Politik, Boulevard), für die sich zuvor registrierte Leser:innen anmelden um mit News versorgen werden zu können.
Registrierte Nutzer:innen müssen ausgegeben werden können.
(Hint. String stellt the Methode "repeat" zur Verfügung, zB "xyz".repeat(3))

---------------------------------------------
Registered users:
Barbara
Max
---------------------------------------------

### Dateiformat
Die Nachrichten werden als Datei angeliefert. Diese können per Befehl auf der Konsole mehrfach neu geladen werden.
Am Anfang der Applikation werden diese ebenfalls geladen.
Die Datei hat eine Header-Zeile und liefert pro Zeile/Block eine Kategorie, eine Nachricht und ein Datum mit Uhrzeit an.
Wenn diese Datei eine unbekannte Kategorie enthält oder nicht genug Parameter hat, soll die Zeile übersprungen werden.

    category,text,time
    SPORT,Lewis Hamilton won the last Silverstone race,10.05.2021 09:15

Es kann davon ausgegangen werden, dass keine Nachricht doppelt in der Datei vorkommt!

### Kategorien
Eine:r Leser:in kann sich für Kategorie(n) anmelden. Es soll möglich sein, mehrere Kategorien auf einmal einzugeben
oder auch per erneutem Menübefehl additiv hinzuzufügen.
Auch Leser:innen ohne Kategorien sind möglich.

Beispiel:

    Please enter the username for the desired action
    Barbara
    (output available categories)
    Please enter the categories separated with a comma: 
    Sport
    (...call menu again...)
    Please enter the categories separated with a comma: 
    Politik,Top Stories

Dies ergibt 3 Kategorien für die Nutzerin.


### News Ausgabe
Nach Befehl "Send News" werden alle interessierten Leserin:innen mit den gewünschten Nachrichten beliefert.
Mittels separatem Menübefehl können alle empfangenen Nachrichten für alle Nutzer:innen ausgegeben werden.
Es darf keine Nachricht doppelt vorkommen! (Dh. selbst wenn "Send News" öfter aufgerufen wird, darf keine Nachricht doppelt vorkommen!)

Wenn für eine:n Benutzer:in keine Nachrichten verfügbar sind, wird dies ebenfalls ausgegeben.

News for Barbara
  No news at the moment.

Die Ausgabe soll wie folgt aussehen (Beispiel für eine Nachricht). Achten Sie genau (!) auf das Format:

News for Barbara
  News: SPORT
    Lewis Hamilton won the last Silverstone race News from 10.05.2021 09:15
  News: POLITIK
    ....
News for Max
...

Per Befehl können die Nachrichten aus der Datei nachgeladen werden.

### Testing

Programming hints:
Sie müssen in Ihren Tests das Format der Ausgabe sicherstellen.

    private final ByteArrayOutputStream bo = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(bo, true));
    }
    @Test
    public void cortrectOutput() {
        // call method that creates output
        String allWrittenLines = bo.toString();
        String[] split = allWrittenLines.split(System.lineSeparator());
        assertEquals(split[4], "Barbara");
        assertEquals(split[5], "   Politik");
    }

### Mandatory.
* Unit Tests
* Design Pattern Subject/Observer
* Logging
* Clean Code Rules
* Javadoc



### Optional (Plus Punkte, max aber 100 Punkte auf die Hausübung)
* Die News für den:die User:in sollen nur nachgeladen werden, wenn zwischen letztem Update und aktuellen Update 10 
  Sekunden vergangen sind.
  Ein entsprechender Hinweis soll ausgegeben werden. - 7 Punkte
* Der Befehl "List Users" gibt die registrierten Nutzer mit den abonnierten Kategorien zusätzlich aus. - 5 Punkte
* Die Leser:innen und ihre Kategorien können für einen nächsten Programmablauf gespeichert und wieder geladen werden.
  5 Punkte
 ---------------------------------------------
Registered users:
Barbara
   Sport
Max
---------------------------------------------


