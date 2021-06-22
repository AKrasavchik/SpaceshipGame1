import javax.swing.*;
import java.awt.*;

public class Explosion {
    private ImageIcon explosion;
    int x;
    int y;

    public Explosion(int x, int y){
        this.explosion = new ImageIcon("images/explosion.png");
        this.x = x;
        this.y = y;
    }

    public void paint (Graphics graphics, GameScene gameScene){
        this.explosion.paintIcon(gameScene,graphics,this.x,this.y);
    }

    public ImageIcon getExplosion() {
        return explosion;
    }

    public void setExplosion(ImageIcon explosion) {
        this.explosion = explosion;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
