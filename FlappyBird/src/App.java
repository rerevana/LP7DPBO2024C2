import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // Memulai eksekusi GUI di thread terpisah
            @Override
            public void run() {
                FlappyBirdStart flappyBirdStart = new FlappyBirdStart();
            }
        });
    }
}
