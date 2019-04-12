# Testausdokumentti

## Tehdyt testit
### Yksikkötestit
![testikattavuus raportti](https://github.com/Radiant92/tiraLab-Luolasto/blob/master/dokumentaatio/kuvat/cave-coverage1.png)

#### Ui
ei testausta, tämä luokka saattaa saada testejä mutta pääosin vain käskee muita luokkia

#### Draw
samoin kuin Ui tämäkin saattaa saada testejä kun se on valmis.

### domain
#### Sleeve
Muutama testi riittää tämän luokan testaukseen eli: hihojen koordinaatit suhteessa niiden numeroon on oikein ja huone on hihan sisällä.
#### Room
Huoneitakin testasin ihan vain muutamalla testistillä jotka tarkistivat, että huone palauttaa tietonsa oikein
#### CaveMapper
Tässä suoritin testejä, jotka luovat useita luolia tarkistaen että hihoja luodaan tarpeeksi ja, ettei huoneita luoda päällekkäin sivuhuoneiden kanssa. 

### util
#### MyList
MyLististä testasin sen metodien lisäksi sitä, että poisto siirtää oikealla tavalla taulukon elementtejä.
Testauksessa on viellä muutama puute joita paikkaan sittenkun polkujen toteutus on tehty ja olen tyytyväinen listojen toteutukseen.
![testikattavuus MyList](https://github.com/Radiant92/tiraLab-Luolasto/blob/master/dokumentaatio/kuvat/MyListCoverage1.png)

## Testauksen syötteet

## Miten testit voidaan toistaa

## Tulokset graafisessa muodossa
