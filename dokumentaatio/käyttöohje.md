# Käyttöohje

### Tiedoston suorittaminen
Sovelluksen voi käynnistää lataamalla [jar tiedoston](https://github.com/Radiant92/tiraLab-Luolasto/releases/tag/v1.0) haluamaansa kansioon ja menemällä terminaalissa ladatun tiedoston sijaintiin ja kirjoittaa **java -jar tiralabra-cave.jar**

Tai lataamalla koko projekti zip pakettina ja purkaa sieltä jar tiedosto.

### Toiminnot
Ohjelman käynnistyessä ruudulle ilmestyy graafinen käyttöliittymä

![napit](https://github.com/Radiant92/tiraLab-Luolasto/blob/master/dokumentaatio/kuvat/napit.png)

Käyttäjälle annetaan 8 nappia joilla käyttäjä voi vaikuttaa syvyyteen eli lukemaan joka näkyy kentässä -100 ja +100 napin välissä.

- Lukemaa ei voi laskea alle 100
- Käyttäjä ei voi kirjoittaa mihinkään tekstikenttään eli ainoa tapa antaa syötettä on napeilla.

Kaksi viimeistä nappia "activate" ja "dont draw" käynnistävät luolaston generoinnin

#### Activate

Painamalla "activate" sovellus luo luolaston jonka jälkeen uusi ruutu avautuu, jossa näytetään visuaalisesti ja hitaasti luolaston rakentuminen. (suosittelen vain pieniä luolastokokoja)

![luolasto](https://github.com/Radiant92/tiraLab-Luolasto/blob/master/dokumentaatio/kuvat/luolasto100.png)

**Punaiset huoneet = Päähuoneet**

**Vihreät huoneet = Sivuhuoneet**

**Siniset viivat = Päähuoneista lähtevät polut**

**Pinkit viivat = Sivuhuoneista lähtevät polut**

#### Dont draw

Painamalla "dont draw" sovellus ohittaa piirtämis vaiheen ja vain luo luolaston

Lopulta molemmat napit johtavat siihen, että nappien alapuolella oleviin tulos kenttiin ilmestyy luolaston luomiseen mennyt aika sekä sivu ja pää huoneiden määrät.

![tulosruutu](https://github.com/Radiant92/tiraLab-Luolasto/blob/master/dokumentaatio/kuvat/tulos1mil.png)

Sulkemalla kumpi tahansa ikkuna sovellus sulkeutuu.
