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
        createGraphics.setFont( new Font("Ariel", Font.BOLD, Definitions.FONT_SIZE));
        createGraphics.setPaint( Color.WHITE );
        createGraphics.drawString("level 1 ",Definitions.DRAW_STRING_LEVEL_NUMBER_X,Definitions.DRAW_STRING_LEVEL_NUMBER_Y);
        super.getEnemySpaceship().paint(graphics, super.getGameScene());
        if(this.getEnemyFire().isAppears()) {
            this.getEnemyFire().paint(graphics, super.getGameScene());
        }

    }

    public boolean collision (PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship, EnemyFire enemyFire){
        Rectangle playerRectangleWithEnemy = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),Definitions.PLAYER_RECTANGLE_WITH_ENEMY_WIDTH,Definitions.PLAYER_RECTANGLE_WITH_ENEMY_HEIGHT);
        Rectangle playerRectangleWithFire = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),Definitions.PLAYER_RECTANGLE_WITH_FIRE_WIDTH,Definitions.PLAYER_RECTANGLE_WITH_FIRE_HEIGHT);
        Rectangle enemyRectangle = new Rectangle(enemySpaceship.getX(),
                enemySpaceship.getY(),Definitions.ENEMY_SPACESHIP_WIDTH,Definitions.ENEMY_SPACESHIP_HEIGHT);
        Rectangle enemyFireRectangle = new Rectangle(enemyFire.getX(),
                enemyFire.getY(),Definitions.ENEMY_FIRE_WIDTH,Definitions.ENEMY_FIRE_HEIGHT);
        boolean collision1 = playerRectangleWithEnemy.intersects(enemyRectangle);
        boolean collision2 = playerRectangleWithFire.intersects(enemyFireRectangle);
        return collision1 || collision2;
    }






}
