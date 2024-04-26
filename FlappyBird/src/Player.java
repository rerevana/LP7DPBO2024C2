import java.awt.*;

public class Player {
    private int posX; // Variabel untuk posisi X pemain/objek
    private int posY; // Variabel untuk posisi Y pemain/objek
    private int width; // Variabel untuk lebar pemain/objek
    private int height; // Variabel untuk tinggi pemain/objek
    private Image image; // Variabel untuk gambar pemain/objek
    private int velocityY; // Variabel untuk kecepatan vertikal pemain/objek

    public Player(int posX, int posY, int width, int height, Image image){
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;

        this.velocityY = -0;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setImage(Image image) {this.image = image;}

    public void setVelocityY(int velocityY) {this.velocityY = velocityY;}

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Image getImage() {return image;}

    public int getVelocityY() {return velocityY;}
}
