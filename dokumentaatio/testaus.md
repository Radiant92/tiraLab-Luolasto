# Testausdokumentti

### Yksikkötestit
![testikattavuus raportti](https://github.com/Radiant92/tiraLab-Luolasto/blob/master/dokumentaatio/kuvat/cave-coverage1.png)

### Luokat ilman testausta Paketissa ui
Tässä paketissa on luokat Draw ja Ui joilla ei ole sovelluslogiikan kanssa muuta tekemistä kuin, että ui kutsuu CaveMapper
luokkaa toteuttamaan luolastojen rakennuksen.
Näille luokille en nähnyt tarvetta suorittaa testejä.

### domain
#### Sleeve
Muutama testi riittää tämän luokan testaukseen eli: hihojen koordinaatit suhteessa niiden numeroon on oikein ja huone on hihan sisällä.
#### Room
Huoneitakin testasin ihan vain muutamalla testistillä jotka tarkistivat, että huone palauttaa tietonsa oikein ja kykenee
lisäämään itselleen listan muita huoneita polkujen piirtämistä varten.

#### CaveMapper
Tässä suoritin testejä, jotka luovat useita luolia tarkistaen että hihoja luodaan tarpeeksi ja, ettei huoneita luoda päällekkäin sivuhuoneiden kanssa. 

### util
#### MyList
MyLististä testasin sen metodien lisäksi sitä, että poisto siirtää oikealla tavalla taulukon elementtejä.
Testauksessa näkyy puutteita kohdissa jotka eivät koskaan tapahdu.
![testikattavuus MyList](https://github.com/Radiant92/tiraLab-Luolasto/blob/master/dokumentaatio/kuvat/MyListCoverage1.png)

## Miten testit voidaan toistaa
Kaikki testit ovat Junit yksikkötestejä ja ne voi suorittaa ilman mitään erityistä dataa.
