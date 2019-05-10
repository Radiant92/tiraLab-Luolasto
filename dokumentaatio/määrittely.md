## Määrittelydokumentti

### Käytetyt algoritmit ja tietorakenteet
ArrayListin kaltainen "MyList" rakenne, joka luo listan annetusta objectista (Integer, Room tai Sleeve).
Tällä lista rakenteella pystyin kasaamaan huoneet, hihat, listan hiha numeroista ja luomaan polut eli antaa huoneille listan huoneista joihin huoneella on polku.

Muuten pärjäsin perus taulukoilla, kuten jo käytettyjen hihojen merkitsemiseen.

### Miksi nämä algoritmit
Haluan että luomani luolasto on monipuolinen mutta silti noudattaa suht selvää päästä päähän (tai useampaan selvään päähän kuten haarukkamalli) rakennetta.
Esimerkiksi luolasto jossa on 100 erikokoista huonetta on jokainen kytkettynä toisiinsa siten että kustakin huoneestä voi mahdollisesti mennä neljään eri käytävään (suuntaan), joista kukin johtaa johonkin eri huoneeseen.
Käytävät jotka poikkeavat pää polusta eivät lopulta johda muutamaa huonetta pidemmälle.

### Haasteet
Haasteina tulee olemaan muunmuassa: luolaston rakenne eli pääpolkujen selvyys siten, ettei luolasto kuitenkaan ole ennalta arvattava, muttei kuitenkaan sekasotkuinen rihmasto lyhyitä käytäviä jokaiseen suuntaan.
Huoneiden eri kokoisuuskin vaikuttaa siihen pystyykö pääpolku jatkamaan rakentumaansa suuntaan.

### Mitä syötteitä ohjelma saa
Syötteenä ohjelma saa syvyyden jonka käyttäjä syöttää alussa. Tämä vaikuttaa suoraan luolaston kokoon muttei siihen miten luolasto rakentuu.

### Analyysi
tulen analysoimaan aikaa joka ohjelmalla kestää huoneiden järjestämiseen ja luolaston rakentamiseen.
