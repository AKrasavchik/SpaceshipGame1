import javax.swing.*;
import java.awt.*;

public class EnemyFire {
    private ImageIcon enemyFire;
    private int x;
    private int y;
    private boolean appears;

    public EnemyFire(int x, int y, ImageIcon enemyFire){
        this.enemyFire =enemyFire;
        this.x = x;
        this.y = y;
        this.appears = true;
    }
    public void moveLeft(Graphics graphics, GameScene gameScene){
        this.enemyFire.paintIcon(gameScene,graphics,this.x=x-4,this.y);
    }

    public void paint (Graphics graphics, GameScene gameScene){
        this.enemyFire.paintIcon(gameScene,graphics,this.x,this.y);
    }

    public boolean isAppears() {
        return appears;
    }

    public void setAppears(boolean appears) {
        this.appears = appears;
    }

    public ImageIcon getEnemyFire() {
        return enemyFire;
    }

    public void setEnemyFire(ImageIcon enemyFire) {
        this.enemyFire = enemyFire;
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
