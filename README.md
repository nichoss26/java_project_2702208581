# java_project_2702208581

Projek ini adalah game RPG sederhana berbasis teks yang dibuat menggunakan Java. Pemain dapat menjelajahi map, mengumpulkan koin, melawan monster, membeli item, dan menyimpan progres permainan.

## Fitur Utama
* **Login & Register**
  Sistem autentikasi berbasis file `credentials.txt` dengan penyimpanan atribut seperti HP, uang, mana, dan damage.
* **Map & Movement**
  Map 300x300 diisi secara prosedural dengan pola-pola acak (grass, wall, dll). Karakter dapat bergerak dalam area kamera (35x15) dan berinteraksi dengan lingkungan.
* **Battle System**
  Saat masuk rumput (`v` / `V`), ada kemungkinan muncul monster dari tiga tipe (Strength, Agility, Intelligence). Sistem pertarungan berbasis giliran.
* **Shop System**
  Pemain bisa membeli berbagai item (offensive, defensive, spell) dari file `item.txt`, lalu menggunakannya dalam pertarungan.
* **Save Progress**
  Data karakter akan tersimpan otomatis saat keluar (`e`), termasuk status uang, HP, dan item yang dimiliki.

## Struktur Kode
* `Main.java` — pusat game loop, login, peta, dan logic utama.
* `character/` — berisi class monster dan pemain berdasarkan atribut kekuatan (strength, agility, intelligence).
* `models/` — menyimpan class untuk item, item reader, sistem pembelian, dan representasi karakter.

## Teknologi
* **Bahasa**: Java
* **Teknik**: Object-Oriented Programming
* **Data**: `credentials.txt`, `item.txt`, `hero.txt`

## Cara Main (Keybinds)

| Tombol    | Fungsi                   |
| --------- | ------------------------ |
| `w/a/s/d` | Gerak karakter           |
| `i`       | Lihat item yang dimiliki |
| `z`       | Buka menu shop           |
| `e`       | Simpan dan keluar        |

## Catatan 
* Map di-generate tiap kali game dimulai.
* Item memiliki jumlah penggunaan terbatas dan bisa digunakan dalam battle.
* Monster yang muncul memiliki nama acak dari `hero.txt` dan role acak.
* Game menyimpan data pemain dan item hanya secara lokal (berbasis file).
