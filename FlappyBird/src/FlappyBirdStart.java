import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class FlappyBirdStart {
    private JPanel panel; // Panel untuk tampilan awal permainan
    private JLabel label; // Label untuk menampilkan gambar start
    private JFrame frame; // Frame untuk tampilan awal permainan

    public FlappyBirdStart() {
        frame = new JFrame("Mulai Flappy Bird"); // Membuat objek frame dengan judul "Mulai Flappy Bird"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mengatur operasi penutupan frame
        frame.setSize(360, 640); // Mengatur ukuran frame
        frame.setLocationRelativeTo(null); // Mengatur posisi frame ke tengah layar

        panel = new JPanel() { // Membuat objek panel
            @Override
            protected void paintComponent(Graphics g) { // Mengganti metode paintComponent untuk menggambar latar belakang
                super.paintComponent(g);
                URL imageURL = getClass().getResource("/assets/background-day.png"); // Mendapatkan URL gambar latar belakang
                if (imageURL != null) { // Jika URL gambar tidak kosong
                    try {
                        Image backgroundImage = ImageIO.read(imageURL); // Membaca gambar dari URL
                        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); // Menggambar gambar latar belakang
                    } catch (IOException e) { // Tangkap kesalahan IO
                        e.printStackTrace(); // Cetak jejak kesalahan
                    }
                } else {
                    System.err.println("Gambar tidak ditemukan!"); // Cetak pesan kesalahan jika URL gambar tidak ditemukan
                }

            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Mengatur layout panel menjadi BoxLayout dengan sumbu Y
        frame.add(panel); // Menambahkan panel ke frame

        label = new JLabel(); // Membuat objek label
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Mengatur posisi label ke tengah

        // Mengatur gambar sebagai ikon label
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/start.png"));
        label.setIcon(imageIcon);

        // Menambahkan fungsi untuk memulai permainan saat gambar diklik
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Menutup frame saat gambar diklik
                startGame(); // Memulai permainan
            }
        });
        panel.add(Box.createVerticalGlue()); // Mengisi ruang kosong di atas label
        panel.add(label); // Menambahkan label ke panel
        panel.add(Box.createVerticalGlue()); // Mengisi ruang kosong di atas label

        frame.setVisible(true); // Menampilkan frame
    }

    private void startGame() { // Metode untuk memulai permainan
        JFrame gameFrame = new JFrame("Flappy Bird"); // Membuat objek frame permainan dengan judul "Flappy Bird"
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mengatur operasi penutupan frame
        gameFrame.setSize(360, 640); // Mengatur ukuran frame
        gameFrame.setLocationRelativeTo(null); // Mengatur posisi frame ke tengah layar
        gameFrame.setResizable(false); // Mengatur agar ukuran frame tidak dapat diubah

        FlappyBird flappyBird = new FlappyBird(); // Membuat objek FlappyBird
        gameFrame.add(flappyBird); // Menambahkan objek FlappyBird ke frame
        gameFrame.pack(); // Mengatur ukuran frame sesuai dengan konten
        gameFrame.setVisible(true); // Menampilkan frame permainan
    }
}