# Issue-3-manuális-tesztek-megtervezése

## 1. teszt: Fúrás és bányászás tesztelése

* 1. lépés: Program elinditása, 1 játékos beírása, Indítás gomb megnyomása
* 2. lépés: Játékos nevének megadása (jatekos), Ok gomb megnyomása
* 3. lépés: Astronaut gomb megnyomása, jatekos kiválasztása
* 4. lépés: Fúrj gomb megnyomása (amíg a réteg nem 0)
* 5. lépés: Astronaut gomb megnyomása, jatekos kiválasztása 
* 6. lépés: Ha a réteg nem 0, akkor vissza a 3. lépéshez. Ha 0 akkor bányászás gomb megnyomása.

Lépések utáni elvárások:

* 1. lépés után: Új ablak feljön ahova a jatekos nevét tudjuk beírni
* 2. lépés után: A játék elindul, új ablak jön létre ahol látunk sokféle adatot. Az Astronaut gombra kattintva látjuk az elnevezett játékost.
* 3. lépés után: A jatekos Rulajdonságok fülénél látnunk kell, hogy melyik aszteroidán van, annak mekkora  rétege, és mi van benne.
* 4. lépés után: Kör vége, már nem vagyunk a játékosban.
* 5. lépés után:  A jatekos Rulajdonságok fülénél látnunk kell, hogy melyik aszteroidán van, annak mekkora  rétege, és mi van benne, ilyenkor a réteg eggyel kisebb lesz.
* 6. lépés után: Ha a réteg 0 volt, akkor ha ujbol kiválasztjuk a jatekost, az inventory-jában megjelenik a nyersanyag.

## 2. teszt: Mozgás tesztelése, több játékos tesztelése

* 1. lépés: Program elinditása, 2 játékos beírása, Indítás gomb megnyomása
* 2. lépés: Játékosok neveinek megadása (jatekos1,jatekos2), Ok gomb megnyomása
* 3. lépés: Astronaut gomb megnyomása, jatekos1 kiválasztása
* 4. lépés: Tulajdonságoknál a Hely megtekintése, az adott számú aszteroidára rákattintunk bal oldalt.
* 5. lépés: Place gomb megnyomása, egy tetszőleges hely kiválasztása, majd mozogj gomb megnyomása
* 6. lépés: Astronaut gomb megnyomása, jatekos2 kiválasztása
* 7. lépés: Tulajdonságoknál a Hely megtekintése, az adott számú aszteroidára rákattintunk bal oldalt.
* 8. lépés: Place gomb megnyomása, egy tetszőleges hely kiválasztása, majd mozogj gomb megnyomása
* 9. lépés: Astronaut gomb megnyomása, jatekos1 kiválasztása
* 10. lépés: Tulajdonságoknál a Hely megtekintése, az adott számú aszteroidára rákattintunk bal oldalt.
* 11. lépés: Astronaut gomb megnyomása, jatekos2 kiválasztása
* 12. lépés: Tulajdonságoknál a Hely megtekintése, az adott számú aszteroidára rákattintunk bal oldalt.

Lépések utáni elvárások:

* 1. lépés után: Új ablak feljön ahova a jatekosok neveitt tudjuk beírni
* 2. lépés után: A játék elindul, új ablak jön létre ahol látunk sokféle adatot. Az Astronaut gombra kattintva látjuk az elnevezett játékost.
* 3. lépés után: A jatekos1 tulajdonságok fülénél látnunk kell, hogy melyik aszteroidán van, annak mekkora  rétege, és mi van benne.
* 4. lépés után: jatekos1 megjelenik az adott számú aszteroidán.
* 5. lépés után: Kör vége, már nem vagyunk a jatekos1-ben, nem látjuk már jatekos1-et mert már lépett.
* 6. lépés után: A jatekos2 tulajdonságok fülénél látnunk kell, hogy melyik aszteroidán van, annak mekkora rétege, és mi van benne.
* 7. lépés után: jatekos2 megjelenik az adott számú aszteroidán.
* 8. lépés után: Kör vége, már nem vagyunk a jatekos2-ben, ilyenkor már mindenki lépett, megint látjuk jatekos1-et és jatekos2-t is.
* 9. lépés után: A jatekos1 tulajdonságok fülénél látnunk kell, hogy melyik aszteroidán van, ez az a számú aszteroida amit kiválasztottunk az előző lépésénél.
* 10. lépés után: jatekos1 megjelenik az adott számú aszteroidán. Tehát működik a mozgás.
* 11. lépés után: A jatekos2 tulajdonságok fülénél látnunk kell, hogy melyik aszteroidán van, ez az a számú aszteroida amit kiválasztottunk az előző lépésénél.
* 12. lépés után: jatekos2 megjelenik az adott számú aszteroidán. Tehát működik a mozgás, és kettő játékos vezérlése is.

## 3. teszt: Gate craft-olása

* 1. lépés: Program elinditása, 1 játékos beírása, Indítás gomb megnyomása
* 2. lépés: Játékos nevének megadása (jatekos), Ok gomb megnyomása
* 3. lépés: Astronaut gomb megnyomása, jatekos kiválasztása
* 4. lépés: Ha a tulajdonságoknál egy nem új színű aszteroidát találunk elmozgunk egy új aszteroidára.
* 5. lépés: Ha nem új színű aszteroidára érkeztünk, akkor vissza a 4. lépéshez, egyébként: Fúrj gomb megnyomása (amíg a réteg nem 0)
* 6. lépés: Astronaut gomb megnyomása, jatekos kiválasztása 
* 7. lépés: Ha a réteg nem 0, akkor vissza a 5. lépéshez. Ha 0 akkor bányászás gomb megnyomása.
* 8. lépés: Ha van 3 különböző színű alapanyagunk mit épits gomb megnyomása, robot kivalasztasa, craft gomb megnyomása. Ha nincs akkor vissza a 4. lépéshez.
* 9. lépés: Astronaut gomb megnyomása, jatekos kiválasztása, a tulajdonságoknál azon a számú aszteroidára kattintás ahol jatekos helye van.



* 1. lépés után: Új ablak feljön ahova a jatekos nevét tudjuk beírni
* 2. lépés után: A játék elindul, új ablak jön létre ahol látunk sokféle adatot. Az Astronaut gombra kattintva látjuk az elnevezett játékost.
* 3. lépés után: A jatekos Rulajdonságok fülénél látnunk kell, hogy melyik aszteroidán van, annak mekkora  rétege, és mi van benne.
* 4. lépés után: Az új aszteroidának más adatai vannak.
* 5. lépés után: Kör vége, már nem vagyunk a játékosban.
* 6. lépés után:  A jatekos Rulajdonságok fülénél látnunk kell, hogy melyik aszteroidán van, annak mekkora  rétege, és mi van benne, ilyenkor a réteg eggyel kisebb lesz.
* 7. lépés után: Ha a réteg 0 volt, akkor ha ujbol kiválasztjuk a jatekost, az inventory-jában megjelenik a nyersanyag.
* 8. lépés után: Ha megvolt a 3 különböző színű aszteroida, craft gomb megnyomásánál kör vége.
* 9. lépés után: Az aszteroidán egy robot található, tehát sikeres a teszt.



