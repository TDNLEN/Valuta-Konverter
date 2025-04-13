# 💱 Rendszerterv – Valuta Konverter

## 1. A rendszer célja

Az alkalmazás célja, hogy a felhasználó egyszerűen, gyorsan és megbízható módon átválthassa a magyar forint (HUF) összegét más, gyakran használt valutákra, mint például az euró (EUR), az amerikai dollár (USD) és az angol font (GBP).  
A rendszer lehetőséget biztosít arra, hogy a felhasználó valós idejű árfolyamadatok alapján kapjon pontos átváltási eredményeket, növelve ezzel a konverzió pontosságát és hasznosságát.

A projekt elsődleges célja egy letisztult, intuitív és felhasználóbarát felületet nyújtó alkalmazás fejlesztése.

---

## 2. Projektterv

### 2.1 Projektszerepkörök, felelősségek

**Üzleti szereplő:**

- Megrendelő: Herbák Marcell

### 2.2 Projektmunkások és felelősségek

**Frontend és backend:**

- Nagy Péter  
- Török Kristóf

**Tesztelés:**

- Nagy Péter  
- Török Kristóf

### 2.3 Ütemterv

| Funkció               | Feladat                        | Prioritás | Becslés (nap) |
|-----------------------|-------------------------------|-----------|---------------|
| Rendszerterv          | Dokumentáció összeállítása    | 1         | 1             |
| Alkalmazás prototípus | Alap GUI és konverziók        | 2         | 2             |
| GUI formázás          | Szebb felület, elrendezés     | 3         | 1             |
| Tesztelés             | Hibák keresése, javítása      | 4         | 1             |

### 2.4 Mérföldkövek

- 📅 **05.10.** Projekt elkezdése  
- 📅 **05.11.** Alap prototípus elkészítése  
- 📅 **05.12.** Végleges prototípus elkészítése  
- 📅 **05.12.** Tesztelés  
- 📅 **05.13.** Bemutatás és átadás

---

## 3. Üzleti folyamatok modellje

### 3.1 Üzleti szereplők

- Felhasználó: aki HUF összeget ad meg, és más valutára konvertál.

### 3.2 Üzleti folyamat

1. Felhasználó elindítja az alkalmazást  
2. Beír egy összeget HUF-ban  
3. Kiválasztja a kívánt célvalutát (EUR, USD, GBP)  
4. Megkapja az átváltott összeget

---

## 4. Követelmények

### Funkcionális követelmények

| ID  | Megnevezés             | Leírás                                           |
|-----|------------------------|--------------------------------------------------|
| F1  | Összeg beírása         | A felhasználó beírhat egy tetszőleges HUF összeget |
| F2  | Célvaluta kiválasztása | A felhasználó kiválasztja, hogy melyik valutára vált |
| F3  | Átváltás indítása      | Egy gombnyomásra megtörténik az átváltás        |
| F4  | Eredmény kijelzése     | Az átváltott érték szövegesen megjelenik        |

### Nemfunkcionális követelmények

| ID  | Megnevezés               | Leírás                                                       |
|-----|--------------------------|---------------------------------------------------------------|
| N1  | Felhasználóbarát GUI     | Átlátható, könnyen használható, nem zsúfolt felület          |
| N2  | SOLID elvek alkalmazása  | A kód az ISP és LSP elveket alkalmazza a mi esetünkben       |

---

## 5. Funkcionális terv

### 5.1 Rendszerszereplők

- **Felhasználó:** adatbevitel, konvertálás  
- **Konverter objektumok:** számításokat végeznek

### 5.2 Menüpontok, komponensek

- Input mező (összeg)  
- Dropdown menü (valuta választás)  
- Convert gomb  
- Eredmény kijelzése

---

## 6. Fizikai környezet

- Bármilyen Java alkalmazás futtatására alkalmas eszköz  
- Olyan eszköz, amely Windows 10/11 operációs rendszerrel rendelkezik

---

## 7. Architekturális terv

- Ablakos **Swing** alkalmazás  
- Interfész alapján működő logikai osztályok (euró, font, dollár)  
- GUI különválasztva a konverziós logikától

---

## 8. Tesztterv

| Teszteset            | Elvárt eredmény                                  |
|----------------------|---------------------------------------------------|
| Üres vagy hibás input | Hibaüzenet jelenik meg                           |
| HUF → EUR konverzió   | Az elvárt euró érték jelenik meg                 |
| HUF → USD konverzió   | Helyes dollárérték megfelelő mértékegységgel     |
| HUF → GBP konverzió   | Az angol font érték helyesen jelenik meg         |

---

## 9. Telepítési terv

- Futtatható `.java` forráskódként vagy `.jar` fájlban  
- A futtatáshoz **Java Runtime környezet (JRE)** szükséges

---

## 10. Karbantartási terv

- Árfolyamok kézi vagy későbbi online frissítése  
- Hibák javítása felhasználói visszajelzések alapján  
- Új valuták egyszerűen hozzáadhatók új osztályként (LSP szerint)

---

👨‍💻 *Fejlesztők: Nagy Péter & Török Kristóf*  
📄 *Dokumentáció: Herbák Marcell*
