# Shop

## Végpontok

### Felhasználók

| Végpont | Metódus | Azonostás | Leírás |
|-|-|-|-|
| registry | POST   | igen | read   |
| users    | GET    | igen | read   |
| users    | POST   | igen | create |
| users    | PUT    | igen | update |
| users    | DELETE | igen | delete |

### Rendelések

| Végpont | Metódus | Azonostás | Leírás |
|-|-|-|-|
| orders | GET    | igen | read   |
| orders | POST   | igen | create |
| orders | PUT    | igen | update |
| orders | DELETE | igen | delete |

### Rendelés

Először szükség van egy rendelés azonosítóra: add order
Az első rendelésnél fel kell venni.

Utána jöhetnek a rendelések: add orderitem

A rendelés véglegeítése az active mező beállításával történik.

#### A rendelés rendezése

Ha rendelés rendezve lett, a sorted mező beállításával jelezzük.
