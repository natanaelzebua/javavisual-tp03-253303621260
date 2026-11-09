# Character Manager — TP3 (Java Visual SIH-6406)

Proyek ini adalah implementasi sistem manajemen karakter menggunakan prinsip Object-Oriented Programming (OOP) di Java. Proyek ini memuat pemodelan class `Character` lengkap dengan enkapsulasi (getter, setter ber-validasi) dan penggunaan `Enum` untuk menjaga keamanan tipe data.

## Hasil Output Terminal

![alt text](image.png)

## Struktur Folder Project
```text
javavisual-tp03-253303621260/
├── src/
│   ├── Main.java
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               └── model/
│                   ├── Character.java
│                   └── CharacterType.java
└── README.md
```

##  Identitas

Nama : Natanael Lata Saro Agassi Zebua  
NIM : 253303621260

Analisis Bagian D (Google Docs) : https://docs.google.com/document/d/1SNxDcftUvaI1R1VRfGxcKZ1W032N9d-9/edit?usp=drive_link&ouid=114985403171917953493&rtpof=true&sd=true

# TP5 — Character Manager Sprint #2
Pada sprint ini ditambahkan class CharacterManager yang mengelola koleksi Character memakai ArrayList, dengan penolakan nama duplikat lewat equals(), getAllCharacters() yang mengembalikan salinan (defensive copy), serta counter static untuk jumlah objek yang dibuat.

## Fitur baru
equals() pada Character membandingkan nama, sehingga nama duplikat ditolak
totalCharacterCreated (static) menghitung jumlah objek Character yang dibuat
CharacterManager: addCharacter(), findByName(), removeCharacter(), getTotalCharacters(), getAllCharacters()
Mini-Challenge: getAverageLevel() (mengembalikan 0 jika list kosong) dan findByType()
Fitur mandiri: getTypeSummary()

## Screenshot output (CRUD dan eksperimen reference)
![alt text](image-1.png)
Screenshot memperlihatkan nama duplikat ditolak, getAverageLevel() pada list kosong menghasilkan 0.0 tanpa error, serta eksperimen reference: asli == duplikatReferensi bernilai true, sedangkan menambah karakter ke salinan list tidak mengubah total di manager (manager tetap 2, salinan menjadi 3).

## Fitur mandiri (Bagian C): getTypeSummary()
getTypeSummary() merangkum jumlah karakter untuk setiap tipe (WARRIOR, MAGE, ARCHER, HEALER) dalam satu String, misalnya untuk ditampilkan di GUI pada sprint berikutnya. Method ini mengembalikan String, bukan characterList atau salinannya, karena String tidak dapat diubah dari luar. Pemanggil hanya menerima hasil hitungan dan tidak pernah memegang reference ke list internal, sehingga Encapsulation terjaga dan perubahan data hanya bisa lewat addCharacter() dan removeCharacter(). Method memakai CharacterType.values(), sehingga jika kelak ditambah tipe baru seperti NECROMANCER, method ini otomatis ikut menghitungnya tanpa perlu diubah.

## Struktur folder
```text
javavisual-tp03/
├── README.md
├── screenshots/
│   ├── (image.png)
│   └── (image-1.png)
└── CharacterManager/
    └── src/
        ├── Main.java
        └── com/unpri/charactermanager/model/
            ├── CharacterType.java
            ├── Character.java
            └── CharacterManager.java
```

## Analisis Bagian D TP5 (Google Docs)
https://docs.google.com/document/d/1WvyJLbKh31XICXCgzROtQKsQAZ6VGwOY/edit?usp=drive_link&ouid=114985403171917953493&rtpof=true&sd=true


# TP8 — Character Manager Sprint #3
Pada sprint ini aplikasi berpindah dari console ke GUI. Ditambahkan class MainWindow (package view, extends JFrame) yang menampilkan daftar karakter secara dinamis lewat loop, ditambah statistik "Rata-rata Level" di bawah daftar. Main.java menjalankan jendela lewat SwingUtilities.invokeLater().

## Screenshot MainWindow
Sebelum data diubah (Morgana level 20, rata-rata level 13,00):
![alt text](<Screenshot 2026-11-09 125623.png>)

Sesudah data diubah (Morgana level 25, rata-rata level 14.00):

![alt text](<Screenshot 2026-11-09 132316.png>)

Kedua screenshot memuat 5 karakter dan membuktikan bahwa statistik ikut berubah saat data diubah.

## Aliran data: Main → CharacterManager → MainWindow
Main.java membuat CharacterManager dan mengisinya dengan lima karakter (Model). Data diambil lewat manager.getAllCharacters(), yang mengembalikan salinan list, lalu diteruskan ke constructor MainWindow. MainWindow (View) hanya menerima list itu, membuat satu JLabel untuk setiap karakter lewat loop, dan menampilkan rata-rata level, tanpa mengetahui cara data disimpan. Dalam MVC, Main untuk sementara berperan sebagai penghubung (pengganti Controller yang dibangun pada pertemuan berikutnya): Model tidak mengenal View, dan View tidak mengubah data Model.

## Karakter baru
| Karakter | Tipe | Level | Alasan pemilihan |
| :--- | :--- | :--- | :--- |
| Galahad | WARRIOR | 12 | Melengkapi empat tipe karakter (sebelumnya belum ada HEALER) dan level rendah agar datanya bervariasi |
| Morgana | MAGE | 20, lalu diubah menjadi 25 | Level tinggi sehingga pengaruhnya pada rata-rata level terlihat jelas saat data diubah |

## Struktur folder
```text
javavisual-tp03/
├── README.md
├── .gitignore
├── screenshots/
│   ├── output.png
│   ├── output-tp5.png
│   ├── Screenshot 2026-11-09 125623.png
│   └── Screenshot 2026-11-09 132316.png
└── CharacterManager/
    └── src/
        ├── Main.java
        └── com/unpri/charactermanager/
            ├── model/
            │   ├── CharacterType.java
            │   ├── Character.java
            │   └── CharacterManager.java
            └── view/
                └── MainWindow.java
```
## Analisis Bagian D TP8 (Google Docs)
https://docs.google.com/document/d/1P2E1Vt90Tm4gVKWp6zVS8HTPDeWaj57T_hBUxTMtxhY/edit?usp=drive_link