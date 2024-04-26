import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int frameWidth = 360; // Lebar frame game
    int frameHeight = 640; // Tinggi frame game

    // Atribut gambar
    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    // Player
    int playerPosX = frameWidth / 8;
    int playerPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;
    Player player;

    // Atribut pipa
    int pipeStartPosX = frameWidth;
    int pipeStartPosY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;
    ArrayList<Pipe> pipes;

    Timer gameLoop; // Timer untuk mengatur loop game
    Timer pipesCooldown; // Timer untuk mengatur penempatan pipa
    int gravity = 1; // Gravitasi yang memengaruhi pergerakan pemain
    boolean gameOver = false; // Menandakan apakah game berakhir
    double score = 0; // Skor pemain

    // JLabel untuk menampilkan skor
    JLabel scoreLabel;

    // Konstruktor
    public FlappyBird() {
        setPreferredSize(new Dimension(frameWidth, frameHeight)); // Mengatur dimensi panel
        setFocusable(true); // Mengatur panel untuk dapat fokus
        addKeyListener(this); // Menambahkan KeyListener ke panel

        // load image
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        player = new Player(playerPosX, playerPosY, playerWidth, playerHeight, birdImage); // Membuat objek pemain
        pipes = new ArrayList<>(); // Inisialisasi ArrayList untuk pipa

        // Mengatur timer untuk penempatan pipa
        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pipa");
                placePipes(); // Memasang pipa secara berkala
            }
        });
        pipesCooldown.start(); // Memulai timer penempatan pipa

        gameLoop = new Timer(1000 / 60, this); // Membuat timer untuk loop game
        gameLoop.start(); // Memulai loop game

        // Menginisialisasi dan menambahkan JLabel untuk skor
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Clarendon Blk BT", Font.PLAIN, 30));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(10, 10, 100, 30);
        add(scoreLabel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Memanggil paintComponent dari kelas induk
        draw(g); // Memanggil metode draw
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null); // Menggambar latar belakang

        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null); // Menggambar pemain

        // Menggambar pipa
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }

        // Jika game berakhir, gambar layar game over
        if (gameOver) {
            ImageIcon gameOverImageIcon = new ImageIcon(getClass().getResource("assets/gameOver.png"));
            Image gameOverImage = gameOverImageIcon.getImage();
            int gameOverY = frameHeight / 2 - gameOverImageIcon.getIconHeight() / 2 - 35;
            g.drawImage(gameOverImage, frameWidth / 2 - gameOverImageIcon.getIconWidth() / 2, gameOverY, null);

            // Menambahkan tulisan "Press R to restart the game" beserta bayangannya
            g.setColor(Color.WHITE);
            g.setFont(new Font("Clarendon Blk BT", Font.BOLD, 20));
            String restartText = "Press R to restart the game";
            int restartTextWidth = g.getFontMetrics().stringWidth(restartText);
            int restartTextY = gameOverY + gameOverImageIcon.getIconHeight() + 25;
            g.drawString(restartText, frameWidth / 2 - restartTextWidth / 2 + 2, restartTextY + 2);

            g.setColor(Color.BLACK);
            g.drawString(restartText, frameWidth / 2 - restartTextWidth / 2, restartTextY);

        }
    }

    public void placePipes() {
        int randomPosY = (int) (pipeStartPosY - pipeHeight / 4 - Math.random() * (pipeHeight / 2)); // Posisi Y acak untuk pipa
        int openingSpace = frameHeight / 4; // Ruang pembukaan antara pipa atas dan bawah

        Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidth, pipeHeight, upperPipeImage); // Membuat pipa atas
        pipes.add(upperPipe);

        Pipe lowerPipe = new Pipe(pipeStartPosX, (randomPosY + openingSpace + pipeHeight), pipeWidth, pipeHeight, lowerPipeImage); // Membuat pipa bawah
        pipes.add(lowerPipe);
    }

    public void move() {
        player.setVelocityY(player.getVelocityY() + gravity); // Menerapkan gravitasi pada pemain
        player.setPosY(player.getPosY() + player.getVelocityY()); // Menggerakkan pemain

        // Menggerakkan pipa dan menghitung skor
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipe.getVelocityY());

            if (!pipe.passed && player.getPosX() > pipe.getPosX() + pipe.getWidth()) {
                pipe.passed = true;
                score += 0.5; // Karena ada 2 pipa, setiap pipa yang dilewati memberikan 0.5 poin
                updateScoreLabel();
            }

            if (collision(player, pipe)) {
                gameOver = true; // Jika terjadi tabrakan antara pemain dan pipa, game berakhir
            }
        }

        // Jika pemain jatuh ke luar layar, game berakhir
        if (player.getPosY() > frameHeight) {
            gameOver = true;
        }
    }

    // Metode untuk mendeteksi tabrakan antara pemain dan pipa
    public boolean collision(Player a, Pipe b) {
        return a.getPosX() < b.getPosX() + b.getWidth()
                && a.getPosX() + a.getWidth() > b.getPosX()
                && a.getPosY() < b.getPosY() + b.getHeight()
                && a.getPosY() + a.getHeight() > b.getPosY();
    }

    // Metode untuk memperbarui JLabel skor
    public void updateScoreLabel() {
        int roundedScore = (int) Math.round(score); // Bulatkan nilai skor
        scoreLabel.setText("Score: " + roundedScore); // Update teks skor
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        move(); // Pemanggilan metode move
        repaint(); // Menggambar ulang panel
        if (gameOver) {
            pipesCooldown.stop(); // Menghentikan timer penempatan pipa
            gameLoop.stop(); // Menghentikan loop game
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Metode yang dipanggil ketika tombol ditekan
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setVelocityY(-10); // Pemain melompat saat tombol spasi ditekan
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {
            if (gameOver) {
                // Mengatur ulang game jika tombol R ditekan setelah game berakhir
                player.setPosY(playerPosY);
                player.setVelocityY(0);
                pipes.clear();
                score = 0;
                gameOver = false;
                updateScoreLabel();
                gameLoop.start(); // Mulai kembali loop game
                pipesCooldown.start(); // Mulai kembali timer penempatan pipa
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}