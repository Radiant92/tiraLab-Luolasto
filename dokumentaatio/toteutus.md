# Toteutusdokumentaatio

### Ohjelman yleisrakenne
Käyttöliittymä kutsuu CaveMapper luokkaa luomaan käyttäjän syöttämän syvyyden mukaan luolaston, joka koostuu hihaluokista (Sleeve) joiden sisälle sijoitetaan vaihtelevan kokoinen huone (Room) ja joiden välillä kulkee huoneita yhdistävät polut.

Huoneita tehdään kaksi listaa: päähuoneet ja sivuhuoneet, jotka generoidaan siten että kullakin syvyysasteella on vähintään yksi päähuone ja sivuhuoneet siten, että ne voivat esiintyä minkätahansa pää tai olemassa olevan sivuhuoneen naapurina.

Nämä UI:n käyttämät listat ja muut CaveMapperin käyttämät listat muodostetaan MyList dynaamisen listarakenteen avulla.

Lopulta Draw luokka piirtää luolaston sellaisella nopeudella, että siitä näkyy miten luolasto on rakentunut ja näyttää ajan jossa luolasto on generoitu ajoin: päähuoneet, sivuhuoneet, polut.

### aika- ja tilavaativuudet

### Suorituskyky

### puutteet ja parannusehdotukset

### Lähteet

https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
