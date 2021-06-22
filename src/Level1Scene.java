import javax.swing.*;
import java.awt.*;

public class Level1Scene extends DefaultScene {

    private PlayerSpaceship playerSpaceship;
    private EnemySpaceship enemySpaceship;


    public Level1Scene(GameScene gameScene, PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship1,
                       EnemyFire enemyFire, Explosion explosion, PlayerFire playerFire, ImageIcon background){
        super(gameScene,playerSpaceship,enemySpaceship1,
                enemyFire,explosion,playerFire,background);
        super.setSceneId(Definitions.LEVEL_1_SCENE);


    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        Graphics2D createGraphics = (Graphics2D) graphics;
        createGraphics.setFont( new Font("Ariel", Font.BOLD, 50));
        createGraphics.setPaint( Color.WHITE );
        createGraphics.drawString("level 1 ",400,100);
        super.getEnemySpaceship().paint(graphics, super.getGameScene());
        if(this.getEnemyFire().isAppears()) {
            this.getEnemyFire().paint(graphics, super.getGameScene());
        }

    }

    public boolean collision (PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship, EnemyFire enemyFire){
        Rectangle playerRectangleWithEnemy = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),90,90);
        Rectangle playerRectangleWithFire = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),75,75);
        Rectangle enemyRectangle = new Rectangle(enemySpaceship.getX(),
                enemySpaceship.getY(),100,100);
        Rectangle enemyFireRectangle = new Rectangle(enemyFire.getX(),
                enemyFire.getY(),45,45);
        boolean collision1 = playerRectangleWithEnemy.intersects(enemyRectangle);
        boolean collision2 = playerRectangleWithFire.intersects(enemyFireRectangle);
        return collision1 || collision2;
    }

    public boolean enemyMeetBullet(EnemySpaceship enemySpaceship,PlayerFire playerFire) {
        Rectangle playerRectangle = new Rectangle(enemySpaceship.getX(), enemySpaceship.getY());
        Rectangle playerFireRectangle = new Rectangle(playerFire.getX(),playerFire.getY());
        boolean meeting = playerRectangle.intersects(playerFireRectangle);
        return meeting;

    }




}
