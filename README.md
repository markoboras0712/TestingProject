#ZADATAK – TESTIRATI MIKRONIS WEB STRANICU

Svrha ovog projekta je izrada projekta za kolegij Metode i tehnike testiranja programske podrške.  Webstranica koja se testira je službena stranica Mikronis tvrtke, a link je https://www.mikronis.hr/.
Popis alata potrebnih za pokretanje projekta.
1.	Google Chrome 
2.	IntelliJ IDEA  https://www.jetbrains.com/idea/download/
3.	ChromeDriver 88.0.4324.96 https://chromedriver.chromium.org/downloads
Unutar ovog repozitorija se nalazi 5 testnih slučajeva. Testovi su napisani u Kotlin programskom jeziku koristeći IntelliJ IDEA.
Testni slučaji su : 
1.	Otvaranje web stranice putem drivera i provjeravanje je li header prikazan. Ukoliko se testni slučaj ne izvrši pravilno, u konzoli se dobije odgovarajuća poruka.
2.	Pretraživanje Acer proizvoda koristeći search box. Pretraživač je jedan od najkorisnijih alata koje web stranica može imati. Test funkcionira tako što se input pošalje u search box i pritisne se search button. Ukoliko sljedeća stranica u URL-u završava sa onime što smo poslali, test je pravilno izvršen i prikazani su Acer proizvodi. Ukoliko ne , pojavi se odgovarajuća poruka. 
3.	Promjenjivanje kategorija proizvoda koristeći navigaciju. U ovom testu se prelazi između kategorije „Gaming i zabava“ i „Mobitela“.  Na taj način se korisnik može lakše naći ono što želi tako što bira po kategorijama.
4.	Prijava na newsletter kako bi se tjedno dobijale obavijesti o najnovijim akcijama i pogodnostima. Na ovaj način korisnik može pratiti tjedne akcije.
5.	Logiranje korisnika u sustav. Unutar testa se nalaze podaci već registriranog korisnika kako bi se mogao izvršiti test. 


Upotreba : 
1.	Klonirati repozitorij na svoje računalo 
2.	Otvoriti projekt u IntelliJ IDEA
3.	Build project
4.	Desni klik na MyFirstTest.kt -> Run'MyFirstTest'
5.	Rezultati testova se nalaze na dnu
