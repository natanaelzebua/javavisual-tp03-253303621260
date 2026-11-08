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