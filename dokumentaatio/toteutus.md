# Toteutusdokumentaatio

### Ohjelman yleisrakenne
Käyttöliittymä kutsuu CaveMapper luokkaa luomaan käyttäjän syöttämän syvyyden mukaan luolaston, joka koostuu hihaluokista (Sleeve) joiden sisälle sijoitetaan vaihtelevan kokoinen huone (Room) ja joiden välillä kulkee huoneita yhdistävät polut.

Huoneita tehdään kaksi listaa: päähuoneet ja sivuhuoneet, jotka generoidaan siten että kullakin syvyysasteella on vähintään yksi päähuone ja sivuhuoneita siten, että ne voivat esiintyä minkätahansa pää tai olemassa olevan sivuhuoneen naapurina.

Nämä UI, Room ja CaveMapper luokkien käyttämät listat muodostetaan MyList luokan dynaamisen listarakenteen avulla.

Lopulta Draw luokka piirtää luolaston sellaisella nopeudella, että siitä näkyy miten luolasto on rakentunut ja näyttää ajan jossa luolasto on generoitu.

### Aika- ja tilavaativuudet
Sovelluksen toiminnaltaan hitain metodi on CaveMapper luokan mainCaves(): O(3n).
Toisaalta pisin aika menee CaveMapperin metodiin subCaves: O(n), koska tämä joutuu luomaan huoneita (luolan syvyys/4) verran, joista useita läpikäymään useamman kerran (Tilanteet joissa hihalla ei ole enää vapaita naapureita).

#### Muita huomattavia aikavaativuuksia
Kaikki muut metodit ovat O(1) tai eivät ole osana suoritusta kuten luokat Draw tai Ui.

Paitsi CaveMapperin metodit mainCaves ja subCaves tai luokan MyList metodit:
##### MyList
- add- Room, Integer ja Sleeve metodit kaikki ovat O(1), ellei listan tila ole loppunut jolloin ne kutsuvat metodia 
doubleSize- Room, Integer tai sleeve ajassa O(n).

- doubleSize metodit: O(n)

- remove metodit (kutsuvat metodia moveLeft): O(n)

- moveLeft metodit: O(n)

- contains metodi: O(n)

##### Room
- add appendage, joka lisää listaan huoneen toimii O(1) ajassa eikä O(n) koska sen listalle annettu 10 elementin tila 
  riittää kaikille huoneen mahdollisille poluille.

### Suorituskyky

### puutteet ja parannusehdotukset

### Lähteet

https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
