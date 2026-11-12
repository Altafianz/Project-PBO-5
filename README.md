# Project-PBO-kel-5

# Project PBO Kelompok 5 — Coffee Shop

## Deskripsi

**Coffee Shop** merupakan project berbasis Java yang dikembangkan untuk memenuhi tugas mata kuliah Pemrograman Berorientasi Objek (PBO). Project ini mensimulasikan pengelolaan menu makanan, minuman, dan pesanan pada sebuah kedai kopi dengan menerapkan konsep dasar Object-Oriented Programming (OOP).

## Fitur dan Konsep PBO

- **Class dan Object:** Membuat objek untuk merepresentasikan menu makanan, minuman, dan pesanan.
- **Encapsulation:** Menggunakan atribut `private` serta method getter dan setter untuk mengakses dan mengelola data.
- **Inheritance:** Menerapkan pewarisan antarclass, seperti `Makanan` dan `Minuman` yang mewarisi class `Menu`, serta `MinumanCoffee` dan `MinumanNonCoffee` yang mewarisi class `Minuman`.
- **Constructor Overloading:** Menyediakan beberapa constructor pada class `Pesanan` untuk menangani pesanan makanan dan minuman dengan kombinasi yang berbeda.
- **Validasi Data:** Memvalidasi harga menu agar tidak bernilai negatif serta jumlah pesanan agar lebih dari nol.
- **Static dan Final:** Menggunakan variabel `static` untuk menghitung jumlah pesanan yang dibuat dan konstanta `final` untuk menetapkan tarif pajak.
- **Relasi HAS-A:** Class `Pesanan` memiliki referensi ke objek `Makanan` dan `Minuman` untuk merepresentasikan item dalam pesanan.

## Teknologi

- Java
- IntelliJ IDEA (pengembangan project)

## Cara Menjalankan

1. Clone repository ini ke komputer lokal.
2. Buka project menggunakan IDE yang mendukung Java.
3. Jalankan file `Main.java` yang berada di package `CoffeShopMenu`.
4. Amati hasil simulasi data menu, validasi, informasi pesanan, perhitungan pajak, dan jumlah pesanan melalui console.

## Tujuan Project

Project ini bertujuan untuk memahami dan menerapkan konsep dasar Pemrograman Berorientasi Objek menggunakan Java melalui studi kasus sederhana pada sistem pemesanan di kedai kopi.
