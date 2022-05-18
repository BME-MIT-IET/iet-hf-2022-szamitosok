# Swing UI tesztek megtervezése

Automata GUI tesztek készítésével az a célunk, hogy funkcionálisan teszteljük a játékot és ellenőrizzük, hogy a grafikus felület megfelelően jeleníti meg az adatokat az üzleti logika változása után. Ennek megfelelően egy egyszerű, egy közepesen bonyolult és egy komplex teszt terve készült el.

## Teszt előkészítés:

Az alábbi lépések minden teszt előtt az alábbi sorrendben le kell fussanak:

- ablak létrehozása a fő panelből
- ablak láthatóvá tétele
- ablak láthatóságának ellenőrzése
- játék indítása 3 játékossal
- játékosok nevének megadása

## Test1 - Játékosok ellenőrzése

A teszt célja ellenőrizni, hogy annyi játékos szerepel a játékban, amennyit az előkészítésben létrehoztunk és a jétékosok nevei megegyeznek a megadott nevekkel.

lépések:

- ComboBox elemszámának ellenőrzése
- első játékos kiválasztása
- első játékos nevének ellenőrzése a ComboBox elemen

- második játékos kiválasztása
- második játékos nevének ellenőrzése a ComboBox elemen

- harmadik játékos kiválasztása
- harmadik játékos nevének ellenőrzése a ComboBox elemen

## Test2 - Fúrás ellenőrzése

A teszt célja ellenőrizni, hogy a létrehozott játékosok tudnak-e fúrni.

lépések:

- első játékos kiválasztása
- első játékos nevének ellenőrzése a tulajdonságok panelen
- aszteroidakéreg vastagságnak ellenőrzése a tulajdonságok panelen (>=1)
- fúrás gomb megnyomása

- második játékos kiválasztása
- második játékos nevének ellenőrzése a tulajdonságok panelen
- aszteroidakéreg vastagságnak ellenőrzése a tulajdonságok panelen (>=1)
- fúrás gomb megnyomása

- harmadik játékos kiválasztása
- harmadik játékos nevének ellenőrzése a tulajdonságok panelen
- aszteroidakéreg vastagságnak ellenőrzése a tulajdonságok panelen (>=1)
- fúrás gomb megnyomása

- első játékos kiválasztása
- aszteroidakéreg vastagságnak ellenőrzése a tulajdonságok panelen (csökkent-e)

- második játékos kiválasztása
- aszteroidakéreg vastagságnak ellenőrzése a tulajdonságok panelen (csökkent-e)

- harmadik játékos kiválasztása
- aszteroidakéreg vastagságnak ellenőrzése a tulajdonságok panelen (csökkent-e)

## Test3 - Mozgás ellenőrzése

A teszt célja ellenőrizni, hogy a létrehozott játékosok tudnak-e fúrni.

lépések:

- első játékos kiválasztása
- első játékos nevének ellenőrzése a tulajdonságok panelen
- place ComboBox lenyitása
- ComboBox elemszámának ellenőrzése (>=1)
- szomszédos aszteroida ComboBox elem választása
- kiválasztott elem ellenőrzése
- mozogj gomb megnyomása

- második játékos kiválasztása
- második játékos nevének ellenőrzése a tulajdonságok panelen
- place ComboBox lenyitása
- ComboBox elemszámának ellenőrzése (>=1)
- szomszédos aszteroida ComboBox elem választása
- kiválasztott elem ellenőrzése
- mozogj gomb megnyomása

- harmadik játékos kiválasztása
- harmadik játékos nevének ellenőrzése a tulajdonságok panelen
- place ComboBox lenyitása
- ComboBox elemszámának ellenőrzése (>=1)
- szomszédos aszteroida ComboBox elem választása
- kiválasztott elem ellenőrzése
- mozogj gomb megnyomása

- első játékos kiválasztása
- első játékos pozíciójának ellenőrzése

- második játékos kiválasztása
- második játékos pozíciójának ellenőrzése

- harmadik játékos kiválasztása
- harmadik játékos pozíciójának ellenőrzése


## Teszt lezárás:

Az alábbi lépések minden teszt után az alábbi sorrendben le kell fussanak:

- ablak bezárása
