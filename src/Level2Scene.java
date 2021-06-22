import javax.swing.*;
import java.awt.*;

public class Level2Scene extends DefaultScene {
    private EnemySpaceship enemySpaceship2;
    private EnemySpaceship enemySpaceship3;
    private EnemyFire enemyFire2;
    private EnemyFire enemyFire3;


    public Level2Scene(GameScene gameScene, PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship1,
                       EnemySpaceship enemySpaceship2, EnemySpaceship enemySpaceship3
                       ,EnemyFire enemyFire1, EnemyFire enemyFire2,EnemyFire enemyFire3, Explosion explosion,
                       PlayerFire playerFire, ImageIcon background) {
        super(gameScene, playerSpaceship, enemySpaceship1,
                enemyFire1, explosion,playerFire, background);
        this.enemySpaceship2=enemySpaceship2;
        this.enemySpaceship3=enemySpaceship3;
        this.enemyFire2=enemyFire2;
        this.enemyFire3=enemyFire3;
        super.setSceneId(Definitions.LEVEL_2_SCENE);

    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D createGraphics = (Graphics2D) graphics;
        createGraphics.setFont(new Font("Ariel", Font.BOLD, Definitions.FONT_SIZE));
        createGraphics.setPaint(Color.WHITE);
        createGraphics.drawString("level 2 ", Definitions.DRAW_STRING_LEVEL_NUMBER_X, Definitions.DRAW_STRING_LEVEL_NUMBER_Y);
        this.enemySpaceship2.paint(graphics,super.getGameScene());
        this.enemySpaceship3.paint(graphics,super.getGameScene());
        this.enemyFire2.paint(graphics,super.getGameScene());
        this.enemyFire3.paint(graphics,super.getGameScene());
    }

    public boolean collision (PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship2,EnemySpaceship enemySpaceship3,
                               EnemyFire enemyFire2, EnemyFire enemyFire3){
        Rectangle playerRectangleWithEnemy = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),Definitions.PLAYER_RECTANGLE_WITH_ENEMY_WIDTH,Definitions.PLAYER_RECTANGLE_WITH_FIRE_HEIGHT);
        Rectangle playerRectangleWithFire = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),Definitions.PLAYER_RECTANGLE_WITH_FIRE_WIDTH,Definitions.PLAYER_RECTANGLE_WITH_FIRE_HEIGHT);
        Rectangle enemy2Rectangle = new Rectangle(enemySpaceship2.getX(),
                enemySpaceship2.getY(),Definitions.ENEMY_SPACESHIP_WIDTH,Definitions.ENEMY_SPACESHIP_HEIGHT);
        Rectangle enemy3Rectangle = new Rectangle(enemySpaceship3.getX(),
                enemySpaceship3.getY(),Definitions.ENEMY_SPACESHIP_WIDTH,Definitions.ENEMY_SPACESHIP_HEIGHT);
        Rectangle enemyFire2Rectangle = new Rectangle(enemyFire2.getX(),
                enemyFire2.getY(),Definitions.ENEMY_FIRE_WIDTH,Definitions.ENEMY_FIRE_HEIGHT);
        Rectangle enemyFire3Rectangle = new Rectangle(enemyFire3.getX(),
                enemyFire3.getY(),Definitions.ENEMY_FIRE_WIDTH,Definitions.ENEMY_FIRE_HEIGHT);
        boolean collision1 = playerRectangleWithEnemy.intersects(enemy2Rectangle);
        boolean collision2 = playerRectangleWithEnemy.intersects(enemy3Rectangle);
        boolean collision3 = playerRectangleWithFire.intersects(enemyFire2Rectangle);
        boolean collision4 = playerRectangleWithFire.intersects(enemyFire3Rectangle);
        if (collision1) return collision1;
        if (collision2) return collision2;
        if (collision3) return collision3;
        if (collision4) return collision4;
        return false;

    }

    public EnemySpaceship getEnemySpaceship2() {
        return enemySpaceship2;
    }

    public void setEnemySpaceship2(EnemySpaceship enemySpaceship2) {
        this.enemySpaceship2 = enemySpaceship2;
    }

    public EnemySpaceship getEnemySpaceship3() {
        return enemySpaceship3;
    }

    public void setEnemySpaceship3(EnemySpaceship enemySpaceship3) {
        this.enemySpaceship3 = enemySpaceship3;
    }

}
