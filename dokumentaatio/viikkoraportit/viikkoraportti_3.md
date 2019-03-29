### Mitä olen tehnyt tällä viikolla?
Loin luokan luolastojen luomiselle CaveMapper.
Tälle luokalle annetaan parametriksi luolaston syvyys "deep" jonka jälkeen UI kutsuu siltä listan pääluolia "mainCaves()" 
ja sitten sivuluolia "subCaves()"

mainCaves() on melko suoraviivainen ja varmistaa vain, että jokaisella syvyys asteella on ainakin yksi pääluola.

subCaves() sen sijaan valitsee umpimähkään kaikkien luolien listasta luolan ja tarkistaa onko sillä tilaa naapurille, 
jos on niin tähän tulee uusi sivuluola joka itsekkin nyt kuuluu luolien listaan jotka voivat saada naapurin.

Ohjelman piirtoon lisäsin selvyyttä erottamalla huoneita enemmän toisistaan ja uudet sivuhuoneet näkyvät keltaisina ja päähuoneet punaisina.
piirtoaika on suht nopea, mutta riittävän hidas että näkee miten luolasto muodostuu.

Tämän lisäksi tein testit luokalle.

### Miten ohjelma on edistynyt?
Ohjelman palat on polkujen luomista ja piirtämistä vaille valmiita. Suunnitteluun meni tällä kertaa hieman kauemmin kun piti sumplia mikä olisi
järkevin keino mahduttaa kaikki luolastoon ilman että rakenne näyttäisi liian luonnottomalta tai hajanaiselta.

### Mitä opin tällä viikolla / tänään?
Opin suunnittelun arvon, että hyvin suunniteltu on parempi kuin kumitus ja korjaus. Jätin myös monta kohtaa sellaisiksi ettei ne riippuisi
liikaa toisista osista jotta niitä on helppo vaihtaa ja muokata jos huomaankin, että vaikka polkujen piirtäminen tähän rakenteeseen ei onnistukkaan.

### Mikä jäi epäselväksi tai tuottanut vaikeuksia?
JFrameen meni taas hermo ja siihen pitää yksi viikko nyt sitten varmaan uhrata.

### Mitä teen seuraavaksi?
Päätin että oleellisinta nyt olisi aloittaa noi arrayListien muuttamiset ja sitten viilata käyttöliittymästä käytettävä.

**tunnit: 7h**
