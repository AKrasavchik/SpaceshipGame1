import javax.swing.*;
import java.awt.*;


public class DefaultScene extends JPanel  {
    private int sceneId;
    private GameScene gameScene;
    private PlayerSpaceship playerSpaceship;
    private EnemySpaceship enemySpaceship;
    private EnemyFire enemyFire;
    private Explosion explosion;
    private PlayerFire playerFire;
    private ImageIcon background;

    public DefaultScene(){}

    public DefaultScene(GameScene gameScene, PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship,
                       EnemyFire enemyFire, Explosion explosion,PlayerFire playerFire, ImageIcon background){
        this.gameScene=gameScene;
        this.playerSpaceship=playerSpaceship;
        this.explosion=explosion;
        this.enemyFire=enemyFire;
        this.enemySpaceship=enemySpaceship;
        this.playerFire = playerFire;
        this.background=background;

    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        this.background.paintIcon(this,graphics,0,0);
        if(this.playerSpaceship.isAlive()) {
            this.playerSpaceship.paint(graphics, this.gameScene);
        }
        if(this.playerFire.isAppears()){
            this.playerFire.paint(graphics,this.gameScene);
        }
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public PlayerSpaceship getPlayerSpaceship() {
        return playerSpaceship;
    }

    public void setPlayerSpaceship(PlayerSpaceship playerSpaceship) {
        this.playerSpaceship = playerSpaceship;
    }

    public EnemySpaceship getEnemySpaceship() {
        return enemySpaceship;
    }

    public void setEnemySpaceship(EnemySpaceship enemySpaceship) {
        this.enemySpaceship = enemySpaceship;
    }

    public EnemyFire getEnemyFire() {
        return enemyFire;
    }

    public void setEnemyFire(EnemyFire enemyFire) {
        this.enemyFire = enemyFire;
    }

    public Explosion getExplosion() {
        return explosion;
    }

    public void setExplosion(Explosion explosion) {
        this.explosion = explosion;
    }

    public void setBackground(ImageIcon background) {
        this.background = background;
    }

}
