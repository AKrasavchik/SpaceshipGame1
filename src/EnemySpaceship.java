import javax.swing.*;
import java.awt.*;

public class EnemySpaceship {
    private ImageIcon enemySpaceship;
    int x;
    int y;
    private boolean appears;

    public EnemySpaceship(int x, int y,ImageIcon enemySpaceship){
        this.enemySpaceship=enemySpaceship;
        this.x = x;
        this.y = y;
        this.appears = true;
    }

    public void moveLeft(Graphics graphics, GameScene gameScene){
        this.enemySpaceship.paintIcon(gameScene,graphics,this.x=x-2,this.y);
    }

    public void paint (Graphics graphics, GameScene gameScene){
            this.enemySpaceship.paintIcon(gameScene, graphics, this.x, this.y);

    }

    public boolean isAppears() {
        return appears;
    }

    public void setAppears(boolean appears) {
        this.appears = appears;
    }

    public ImageIcon getEnemySpaceship() {
        return enemySpaceship;
    }

    public void setEnemySpaceship(ImageIcon enemySpaceship) {
        this.enemySpaceship = enemySpaceship;
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
