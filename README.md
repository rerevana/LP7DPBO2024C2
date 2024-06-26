## LP7DPBO2024C2

#### Saya Revana Faliha Salma NIM 2202869 mengerjakan Soal Latihan Praktikum 7 dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

Disini saya melanjutkan program game yaitu Flappy Bird dengan menambahkan beberapa fitur, diantaranya:
1. Saya menambahkan kelas baru yaitu FlappyBirdStart.java yang bertanggung jawab untuk menampilkan layar awal permainan sebelum permainan dimulai. Kelas FlappyBirdStart memiliki tiga atribut: panel, label, dan frame. panel digunakan untuk menampung komponen-komponen GUI, label digunakan untuk menampilkan gambar start, dan frame adalah frame utama untuk tampilan awal permainan. Dalam konstruktor FlappyBirdStart, sebuah JFrame dengan judul "Mulai Flappy Bird" dibuat. Kemudian sebuah JPanel disusun dengan layout BoxLayout yang diatur agar komponen-komponen ditata secara vertikal. Pada JPanel tersebut, sebuah JLabel dibuat untuk menampilkan gambar start. Gambar tersebut diatur sebagai ikon untuk label menggunakan ImageIcon. Fungsi mouse listener ditambahkan ke label sehingga saat gambar start diklik, frame akan ditutup dan permainan Flappy Bird akan dimulai dengan memanggil metode startGame(). Metode startGame() membuat JFrame baru dengan judul "Flappy Bird". Pada JFrame tersebut, objek dari kelas FlappyBird ditambahkan sebagai komponen utama.
2. Saya menambahkan metode collision(Player a, Pipe b) bertanggung jawab untuk mendeteksi tabrakan antara pemain (burung) dan pipa. Metode ini menggunakan metode bounding box untuk memeriksa apakah dua objek saling bersentuhan. Ini dilakukan dengan membandingkan posisi dan ukuran pemain serta pipa. Jika pemain bersentuhan dengan pipa, metode ini akan mengembalikan nilai true, menandakan terjadinya tabrakan.
4. Saya menambahkan penampilan skor yang diperbarui melalui JLabel scoreLabel. Pada setiap pembaruan skor, teks pada JLabel diperbarui dengan nilai skor terbaru, yang dibulatkan terlebih dahulu menggunakan metode Math.round().
5. Saya menambahkan metode updateScoreLabel() yang bertugas memperbarui JLabel yang menampilkan skor pemain. Skor dihitung berdasarkan jumlah pipa yang berhasil dilewati oleh pemain. Setiap kali pemain melewati pipa, skor akan bertambah 0.5 poin (karena ada dua pipa untuk setiap pasangannya).
6. Saya menambahkan beberapa kondisi dalam metode move() yaitu elama iterasi, dilakukan pengecekan apakah pemain telah melewati setiap pipa. Jika pemain melewati pipa, skor ditambah 0.5 karena adanya dua pipa setiap kali, kemudian skor diperbarui pada label skor. Selain itu, ada kondisi untuk mengakhiri permainan jika pemain menyentuh pipa atau jatuh di luar layar. Jika salah satu dari kondisi ini terpenuhi, permainan dihentikan dengan menghentikan timer untuk penempatan pipa dan loop game. Ini menyebabkan permainan berakhir dan skor akhir pemain ditampilkan.
8. Saya menambahkan kondisi if (e.getKeyCode() == KeyEvent.VK_R) yang bertujuan untuk menangani jika tombol 'R' ditekan saat permainan berakhir (ditandai dengan variabel gameOver yang bernilai true) akan me-restart permainan. Jika kondisi tersebut terpenuhi, maka permainan akan diatur ulang dengan mengembalikan pemain ke posisi awal, membersihkan ArrayList pipa, mengatur skor kembali ke 0, dan menghidupkan kembali loop game serta timer penempatan pipa.

# Dokumentasi
-> Penampilan awal permainan sebelum dimulai
![Screenshot (1073)](https://github.com/rerevana/LP7DPBO2024C2/assets/113984261/d7a7c4b4-75c6-4ec3-886c-6f3cefe2733f)

-> Pada saat game over (menyentuh pipa)
![Screenshot (1074)](https://github.com/rerevana/LP7DPBO2024C2/assets/113984261/5b046bab-dab7-48fc-8129-0e1e7281fa5f)

-> Pada saat game over (jatuh ke bawah/ke luar layar)
![Screenshot (1075)](https://github.com/rerevana/LP7DPBO2024C2/assets/113984261/62e73d19-f45a-4e4e-9981-bd41253d9929)

# Video Dokumentasi
https://github.com/rerevana/LP7DPBO2024C2/assets/113984261/3a10d968-b5c1-4ffe-bea0-c8895be956c7

