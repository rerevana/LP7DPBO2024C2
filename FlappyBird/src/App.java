// Saya Revana Faliha Salma NIM 2202869 mengerjakan Soal Latihan Praktikum 7 dalam mata kuliah DPBO 
//untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

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
