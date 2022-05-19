# Issue-6-manuális-tesztek-vegrehajtasa

## 1. teszt: Fúrás és bányászás tesztelése

* 1. lépés: A program sikeresen elindult, játékosok számát be lehet írni, gomb működik. **Nincs probléma**.
* 2. lépés: Ablakváltás működik, játékosok neveit be lehet írni. **Nincs probléma**.
* 3. lépés: A jatekos a 7-es aszteroidán van, rétege 1. **Nincs probléma**.
* 4. lépés: Fúrás után, a réteg eggyel csökkent, tehát **Nincs probléma**.
* 5. lépés: Kör vége sikeresen látszódott. **Nincs probléma**.
* 6. lépés: Amikor nulla volt a réteg a bányássz gomb működött, következő körre a játékos inventoryjába került a nyersanyag. **Nincs probléma**.

**Az 1. teszt lefutása a tervek, és elvárások szerint megfelelt az előre leírtaknak.**

## 2. teszt: Mozgás tesztelése, több játékos tesztelése

* 1. lépés: A program sikeresen elindult, játékosok számát be lehet írni, gomb működik.**Nincs probléma**
* 2. lépés: Ablakváltás működik, játékosok neveit be lehet írni. **Nincs probléma**.
* 3. lépés:  A jatekos1 a 4-es aszteroidán van. **Nincs probléma**.
* 4. lépés: Az adott számú aszteroidán megtalálható egy asztronauta.**Nincs probléma**.
* 5. lépés: Place gomb működik, vannak szomszédok, a 6-osra mozgunk. **Nincs probléma**.
* 6. lépés: Csak jatekos2 elérhető, a 6-os aszteroidán található, tehát **Nincs probléma**.
* 7. lépés: 2 darab asztonauta van a 6-os aszteroidán, ami megfelelő működés. **Nincs probléma**.
* 8. lépés: Gombok működnek, 4-es aszteroidára mozgunk. **Nincs probléma**.
* 9-10. lépés: Jatekos1 azon az aszteroidan van ahova mozogtunk. **Nincs probléma**.
* 11-12. lépés: Jatekos2 azon az aszteroidan van ahova mozogtunk. **Nincs probléma**.

**Az 2. teszt lefutása a tervek, és elvárások szerint megfelelt az előre leírtaknak.**

## 3. teszt: Gate craft-olása

* 1. lépés: A program sikeresen elindult, játékosok számát be lehet írni, gomb működik. **Nincs probléma**.
* 2. lépés: Ablakváltás működik, játékosok neveit be lehet írni. **Nincs probléma**.
* 3. lépés: Jatekos az 1-es aszteroidán van vilagosszurke aszteroidén 1 a réteg. **Nincs probléma**
* 4. lépés: Itt maradunk, új színű aszteroidán vagyunk.**Nincs probléma**
* 5. lépés: Fúrás sikeres, de a nyersanyag eltűnt 0 vastagság után, nem bírunk bányászni. **Probléma, előre nem leírt viselkedés.**. Vissza a 4. lépéshez.
* 4.2 lépés: Elmozdulunk a 12-es aszteroidára. Új szinű aszteroidára érkeztünk (zöld) réteg 4. **Nincs probléma**.
* 5.2 lépés: Fúrás sikeres, addig fúrok amíg a réteg nem 0. **Nincs probléma**a.
* 6-7.2 lépés: Bányászás sikeres. **Nincs probléma**.
* 4.3 lépés: Elmozdulunk a 2-es aszteroidára. Új szinű aszteroidára érkeztünk (szürke) réteg 2. **Nincs probléma**.
* 5.3 lépés: Fúrás sikeres, addig fúrok amíg a réteg nem 0. **Nincs probléma**.
* 6-7.3 lépés: Bányászás sikeres. **Nincs probléma**.
* 4.4 lépés: Elmozdulunk a 8-es aszteroidára. Nem új szinű aszteroidára érkeztünk (szürke) réteg 3. **Nincs probléma**.
* 4.5 lépés: Elmozdulunk a 15-es aszteroidára. Nem új szinű aszteroidára érkeztünk (szürke) réteg 1. **Nincs probléma**.
* 4.6 lépés: Elmozdulunk a 11-es aszteroidára. Nem új szinű aszteroidára érkeztünk (sötétszürke) réteg 3. **Nincs probléma**.
* 5.6 lépés: Fúrás sikeres, addig fúrok amíg a réteg nem 0. **Nincs probléma**.
* 6-7.3 lépés: Bányászás sikeres. **Nincs probléma**.
* 8. lépés: Robot építése sikeres. **Nincs probléma**.
* 9. lépés: A 11-es aszteroidán egy robot és egy asztronauta képét láthatjuk. **Nincs probléma**.

**Az 3. teszt lefutása nagyrészben tervek, és elvárások szerint megfelelt az előre leírtaknak, de egy előre nem leírt viselkedést tapasztaltam az 5.lépésnél, eltűnt a nyersanyag a rétegek lefúrásakor. (Erre a jelenségre a magyarázat, valőszínűleg játék szerint működött, napközelben volt az aszteroida, elolvadt a jég, mivel a program nem szállt el.)**


