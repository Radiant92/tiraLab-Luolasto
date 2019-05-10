# Toteutusdokumentaatio

### Ohjelman yleisrakenne
Käyttöliittymä kutsuu CaveMapper luokkaa luomaan käyttäjän syöttämän syvyyden mukaan luolaston, joka koostuu hihaluokista (Sleeve) joiden sisälle sijoitetaan vaihtelevan kokoinen huone (Room) ja joiden välillä kulkee huoneita yhdistävät polut.

Huoneita tehdään kaksi listaa: päähuoneet ja sivuhuoneet, jotka generoidaan siten että kullakin syvyysasteella on vähintään yksi päähuone ja sivuhuoneita siten, että ne voivat esiintyä minkätahansa pää tai olemassa olevan sivuhuoneen naapurina.

Nämä UI, Room ja CaveMapper luokkien käyttämät listat muodostetaan MyList luokan dynaamisen listarakenteen avulla.

Lopulta Draw luokka piirtää luolaston sellaisella nopeudella, että siitä näkyy miten luolasto on rakentunut ja näyttää ajan jossa luolasto on generoitu.

### Aika- ja tilavaativuudet
Sovelluksen toiminnaltaan hitain metodi on CaveMapper luokan mainCaves(): O(3n).
Toisaalta pisin aika menee CaveMapperin metodiin subCaves: O(n), koska tämä joutuu luomaan huoneita (luolan syvyys/4) verran, joista useita läpikäymään useamman kerran (Tilanteet joissa hihalla ei ole enää vapaita naapureita).
Tämä nopeus ero tulee ilmi vasta noin 100k syvyysluokasta eteenpäin (josta lisää alempana).

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
Kaikki ajat laskettu millisekunteina.
Vertaan tässä kahta tapaa generoida subCavern() lista.

Ensimmäisessä käytän MyList luokan remove() metodia joka poistaa taulukosta elementin ja siirtää sitten koko taulukkoa vasemmalle.
Toisessa korvaan remove() metodin taulukolla johon merkataan jos hihalla ei ole enää vapaita naapureita.

#### Aika remove() metodilla O(n)
|mainCaves listan generointi| subCaves listan generointi | kokonaisaika | päähuoneiden määrä | sivuhuoneiden määrä | syvyys |
|:---:|:---:|:---:|:---:|:---:|:---:|
| 0 | 1 | 1 | 15 | 25 | 100 |
| 1 | 1 | 2 | 154 | 250  | 1k |
| 12 | 15 | 27 | 1600 | 2500 | 10k |
| 35 | 68 | 103 | 16 025 | 25 000 | 100k |
| 59 | 1312 | 1371 | 80 020 | 125 000 | 500k |
| 85 | 4139 | 4224 | 160 254 | 250 000 | 1mil |
| 471 | 102 535 | 103 006 | 800 673 | 1 250 000 | 5mil |
| 579 | 414 031 | 414 610 | 1 598 878 | 2 500 000 | 10mil |

![removella](dokumentaatio/kuvat/)

#### Aika ilman remove() metodia (tilalla taulukko)
|mainCaves listan generointi| subCaves listan generointi | kokonaisaika | päähuoneiden määrä | sivuhuoneiden määrä | syvyys |
|:---:|:---:|:---:|:---:|:---:|:---:|
| 0 | 1 | 1 | 18 | 25 | 100 |
| 5 | 5 | 10 | 155 | 250  | 1k |
| 17 | 8 | 25 | 1584 | 2500 | 10k |
| 30 | 25 | 55 | 16 022 | 25 000 | 100k |
| 50 | 67 | 117 | 80 056 | 125 000 | 500k |
| 71 | 182 | 253 | 160 095 | 250 000 | 1mil |
| 394 | 1092 | 1486 | 800 469 | 1 250 000 | 5mil |
| 668 | 3594 | 4262 | 1 599 148 | 2 500 000 | 10mil |

### Suoritusaika

UI kutsuu kahta CaveMapper luokan metodia mainCaves() ja subCaves()

mainCaves(): O(n) * O(3) + O(1) = O(3n)

subCaves(): O(n) + O(1) = O(n)

**yhteensä = O(3n) + O(n)**

### puutteet ja parannusehdotukset
Contains ja Remove metodit ovat hitaita O(n) ja jouduin sovellusta nopeuttaakseni sivuttamaan molempien käytön (eli listan läpikäynnin) sijaan käyttämään yksinkertaisia taulukoita CaveMapper luokan subCaves() metodissa, jonne merkataan ja josta tarkistetaan onko hihalla vapaita naapureita.

Tämän seurauksena metodi sivuhuoneiden luontiin hidastuu huomattavasti koska looppi törmää usein jo läpikäytyyn hihaan.
Vertailu kuitenkin osoitti, että taulukointi on huomattavasti nopeampaa kuin vain Remove() metodin käyttö.

Contains() metodi toisaalta oli täysin turha.
Toinen nopeutus oli ennakoida paljonko tilaa kukin lista tarvitsi ja syöttää tämä tieto taulukon luonnissa jolloin vältti hitaan taulukon koon suurennuksen. 

Ideaali tilanteessa tosin tähänkin olisi voinut löytää jonkun elegantimman ratkaisun.

### Lähteet

https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
