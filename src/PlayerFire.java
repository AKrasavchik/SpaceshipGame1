import javax.swing.*;
import java.awt.*;

public class PlayerFire {

    private ImageIcon playerFire;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean appears;

    public PlayerFire(int x,int y){
        this.playerFire = new ImageIcon("images/playerFire.png");
        this.x =x;
        this.y = y;
        this.appears = false;
        getImageDimensions();
    }
    protected void getImageDimensions() {

        this.width = this.playerFire.getIconWidth();
        this.height = this.playerFire.getIconHeight();
    }

    public void move(Graphics graphics,GameScene gameScene) {
        if (this.x > 0 && this.x < Definitions.WINDOW_WIDTH) {
            this.playerFire.paintIcon(gameScene, graphics, this.x = x + 3, this.y);
        }
    }

    public void paint(Graphics graphics,GameScene gameScene) {}

    public ImageIcon getPlayerFire() {
        return playerFire;
    }

    public void setPlayerFire(ImageIcon playerFire) {
        this.playerFire = playerFire;
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

    public boolean isAppears() {
        return appears;
    }

    public void setAppears(boolean appears) {
        this.appears = appears;
    }
}
