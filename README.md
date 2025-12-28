# Expense Tracker API

API sederhana yang dibangun dengan Spring Boot untuk melacak pengeluaran pribadi.

## Fitur
- **Manajemen Pengeluaran**: Membuat, membaca, memperbarui, dan menghapus (CRUD) data pengeluaran.
- **Statistik**: Melihat total jumlah pengeluaran.
- **Dokumentasi API**: Antarmuka Swagger UI yang interaktif untuk eksplorasi API.

## Teknologi
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- SpringDoc OpenAPI (Swagger UI)

## Endpoint API

| Metode | Endpoint | Deskripsi |
|---|---|---|
| `POST` | `/expenses` | Menambahkan pengeluaran baru |
| `GET` | `/expenses` | Mengambil semua daftar pengeluaran |
| `GET` | `/expenses/{id}` | Mengambil detail pengeluaran berdasarkan ID |
| `PUT` | `/expenses/{id}` | Memperbarui data pengeluaran |
| `DELETE` | `/expenses/{id}` | Menghapus pengeluaran |
| `GET` | `/expenses/stats/total` | Mendapatkan total nominal pengeluaran |

## Highlight Teknis

Beberapa pendekatan teknis dan *best practice* yang diterapkan dalam proyek ini:

- **3-Tier Architecture**: Implementasi yang bersih dengan pemisahan antara `Controller` (HTTP interface), `Service` (Business logic), dan `Repository` (Data access).
- **DTO Pattern**: Penggunaan Data Transfer Objects untuk memisahkan kontrak API dari entitas database, menjaga keamanan dan fleksibilitas skema.
- **Global Exception Handling**: Penanganan error terpusat menggunakan `@ControllerAdvice` yang memberikan respons error JSON yang konsisten dan informatif, termasuk detail validasi field.
- **Input Validation**: Penerapan validasi data yang kuat menggunakan anotasi `@Valid` untuk mencegah input *bad* data, dengan pesan error yang spesifik.
- **Optimisasi JPA & SQL**: Penggunaan `@Query` kustom di repository untuk operasi agregasi (seperti penjumlahan total) yang efisien dan mencegah kebocoran memori.
- **Standar RESTful**: Kepatuhan terhadap prinsip REST dengan penggunaan metode HTTP yang tepat (`GET`, `POST`, `PUT`, `DELETE`) dan kode status yang sesuai.

## Cara Memulai

1. **Prasyarat**: Pastikan Java (JDK 17 atau lebih baru) dan PostgreSQL sudah terinstal.
2. **Konfigurasi Database**:
   - Buat database di PostgreSQL dengan nama `expense_tracker`.
   - Cek `src/main/resources/application.properties` dan sesuaikan username/password jika perlu:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/expense_tracker
     spring.datasource.username=admin
     spring.datasource.password=password
     ```
3. **Menjalankan Aplikasi**:
   Jalankan perintah berikut di terminal:
   ```bash
   ./mvnw spring-boot:run
   ```
4. **Akses API**:
   - API berjalan di `http://localhost:8080`.
   - Dokumentasi Swagger UI dapat diakses di `http://localhost:8080/swagger-ui.html`.
