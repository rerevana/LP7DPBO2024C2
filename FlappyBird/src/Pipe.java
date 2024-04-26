import java.awt.*;

public class Pipe {
    private int posX; // Variabel untuk posisi X pipa
    private int posY; // Variabel untuk posisi Y pipa
    private int width; // Variabel untuk lebar pipa
    private int height; // Variabel untuk tinggi pipa
    private Image image; // Variabel untuk gambar pipa
    private int velocityY; // Variabel untuk kecepatan vertikal pipa
    boolean passed = false; // Variabel boolean untuk menandai apakah pemain telah melewati pipa

    public Pipe(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;

        this.velocityY = -3;
        this.passed = false;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
