# Code refactorálás SonarCloud code smellek segítségével 

A #2-es issue-ban beüzemelt SonarCloud által észlelt code smellek:

![alt text](https://i.imgur.com/aPI9e7w.png)

Ezek alapján refactoráltuk a kód egy részét:
- Model-View struktúra szerint struktúráltuk az osztályokat
- Kikkommentezett kódblokkok eltávolítása
- Importok optimalizálása / Unusued importok törlése
- Fölösleges nestelt if-ek kijavítása
- == operátor helyett .equals() használata
- néhány egyéb kisebb módosítás