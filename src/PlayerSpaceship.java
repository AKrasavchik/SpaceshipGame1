import javax.swing.*;
import java.awt.*;

public class PlayerSpaceship {
    private ImageIcon playerSpaceship;
    private int x;
    private int y;
    private boolean alive;
    private int height;
    private int width;
    private final int speed;


    public PlayerSpaceship(int y,int height){
        this.playerSpaceship = new ImageIcon("images/spaceship.png");
        this.alive=true;
        this.height = height;
        this.y = Definitions.SPACESHIP_STARTING_POSITION;
        this.speed=Definitions.SPACESHIP_SPEED;
        getImageDimensions();

    }

    protected void getImageDimensions() {

        this.width = this.playerSpaceship.getIconWidth();
        this.height = this.playerSpaceship.getIconHeight();
    }

  public void paint (Graphics graphics, GameScene gameScene){
      this.playerSpaceship.paintIcon(gameScene,graphics,this.x,this.y);
  }


    public void move(int direction) {
        switch (direction) {
            case Definitions.MOVE_UP:
                this.y-=this.speed;
                break;
            case Definitions.MOVE_DOWN:
                this.y+=this.speed;

                break;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public ImageIcon getPlayerSpaceship() {
        return playerSpaceship;
    }

    public void setPlayerSpaceship(ImageIcon playerSpaceship) {
        this.playerSpaceship = playerSpaceship;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
