import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {

    private PlayerSpaceship playerSpaceship;
    private GameScene gameScene;
    private Graphics graphics;
    private  int sceneId;


    public PlayerMovement(PlayerSpaceship playerSpaceship, GameScene gameScene, Graphics graphics, int sceneId){
        this.playerSpaceship = playerSpaceship;
        this.gameScene = gameScene;
        this.graphics = graphics;
        this.sceneId=sceneId;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (this.playerSpaceship.getY() - Definitions.PLAYER_HEIGHT + 40 >= Definitions.END_FRAME) {
                    this.playerSpaceship.move(Definitions.MOVE_UP);
                }
                break;

            case KeyEvent.VK_DOWN:
                if (this.playerSpaceship.getY() - Definitions.PLAYER_HEIGHT - 510 <= Definitions.END_FRAME) {
                    this.playerSpaceship.move(Definitions.MOVE_DOWN);
                }
                break;
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            this.gameScene.addPlayerFire();
            System.out.println("Space!!");
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            if (this.gameScene.sceneId == Definitions.MENU_SCENE) {
                gameScene.startGame();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
