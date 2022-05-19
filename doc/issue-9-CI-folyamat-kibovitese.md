# CI folyamat kibovitese

Az első issue-ban az alap CI-t beüzemeltük, majd leteszteltük. Ezt követően kiegészítettük a gyakorlaton opcionálisnak számító két lépéssel:
* ```--no-transfer-progress``` mvn kapcsoló a fordítási lépésnek: ezzel tesszük átláthatóbbá a maven fordítás log-ját
* ```cache: maven``` paraméter a jdk beállítás lépésnél: ennek hatására a különböző projekt függőségek gyorsítótárazva lesznek, ezzel gyorsítva a lefutó workflow-k sebességét

A következő bővítés a SonarCloud integrációját segíti. Az összekapcsoláshoz hozzáadtunk egy sonar lépést futtató paramétert a maven parancshoz, valamint felvettünk egy új lépést, ami pedig a SonarCloud csomagjait cache-eli, szintén a gyorsaság növelése érdekében. Az elkészítés módja a gyakorlathoz hasonló volt, a helyes működéshez még fel kellet vennünk egy secret-et a repo-ba.

A harmadik bővítés a fordítás során létrejövő fájlok megőrzését és későbbi felhasználását teszi lehetővé. Ehhez az *upload-artifact* nevű action-t használtuk, a következő paraméterekkel:

* ```name:``` esetünkben __Built jar__
* ```path:``` az elkészült jar fájl elérési útja
* ```if-no-files-found:``` átállítottuk *error*-ra, mert ha nincs az előző úton fájl, akkor hibát dob, így észleljük és ki tudjuk az utat javítani
* ```retention-days:``` a lehető legkisebb értékre, 1 napra állítottuk

A működő jar file létrehozásához szükség volt még a pom.xml kiegészítésére, itt egy új plugin-t kellett felvenni, ahol megadtuk az alkalmazás belépési pontját.


