import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    private ImageIcon background;
    protected int sceneId;
    private PlayerSpaceship playerSpaceship;
    private EnemySpaceship enemySpaceship1,enemySpaceship2,enemySpaceship3;
    private EnemyFire enemyFire1,enemyFire2,enemyFire3;
    private Explosion explosion;
    private PlayerFire playerFire;
    private Level1Scene level1Scene;
    private Level2Scene level2Scene;
    private MenuScene menuScene;
    private LosingScene losingScene;
    private PlayerFire[] playerFires;
    private WinningScene winningScene;



    public GameScene() {
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.background = new ImageIcon("images/space.png");
        this.playerSpaceship = new PlayerSpaceship(Definitions.SPACESHIP_STARTING_POSITION,getHeight());
        this.enemySpaceship1 = new EnemySpaceship(Definitions.WINDOW_WIDTH,Definitions.SPACESHIP_STARTING_POSITION,
                new ImageIcon("images/enemySpaceship.png"));
        this.enemySpaceship2 = new EnemySpaceship(Definitions.WINDOW_WIDTH,Definitions.ENEMY_SPACESHIP_2_STARTING_POSITION,
                new ImageIcon("images/enemySpaceship2.png"));
        this.enemySpaceship3 = new EnemySpaceship(Definitions.WINDOW_WIDTH,Definitions.ENEMY_SPACESHIP_3_STARTING_POSITION,
                new ImageIcon("images/enemySpaceship3.png"));
        this.enemyFire1 = new EnemyFire(Definitions.WINDOW_WIDTH,Definitions.SPACESHIP_STARTING_POSITION,
                new ImageIcon("images/enemyFire.png"));
        this.enemyFire2 = new EnemyFire(this.enemySpaceship2.getX(),Definitions.ENEMY_SPACESHIP_2_STARTING_POSITION+15,
                new ImageIcon("images/enemyFire2.png"));
        this.enemyFire3 = new EnemyFire(this.enemySpaceship3.getX(),Definitions.ENEMY_SPACESHIP_3_STARTING_POSITION+3,
                new ImageIcon("images/enemyFire3.png"));
        this.explosion = new Explosion(playerSpaceship.getX(),playerSpaceship.getY());
        this.playerFire = new PlayerFire(this.playerSpaceship.getX()+Definitions.INCREASE_X,this.playerSpaceship.getY()+Definitions.INCREASE_Y);
        this.menuScene = new MenuScene();
        this.losingScene = new LosingScene();
        this.winningScene = new WinningScene();
        this.level1Scene= new Level1Scene(this,this.playerSpaceship,this.enemySpaceship1,this.enemyFire1,
                this.explosion,this.playerFire,this.background);
        this.level2Scene = new Level2Scene(this,this.playerSpaceship,this.enemySpaceship1,
                this.enemySpaceship2,this.enemySpaceship3, this.enemyFire1,
                this.enemyFire2,this.enemyFire3,this.explosion,this.playerFire,this.background);
        this.playerFires = new PlayerFire[Definitions.MAX_PLAYER_FIRE_SHOOT];
        for (int i = 0; i < this.playerFires.length; i++) {
            this.playerFires[i] = new PlayerFire(this.playerSpaceship.getX()+Definitions.INCREASE_X,this.playerSpaceship.getY()+Definitions.INCREASE_Y);
        }
        this.add(level1Scene);
        this.add(level2Scene);
        this.mainGameLoop();


    }

    public void addPlayerFire(){
        for (int i = 0; i < this.playerFires.length; i++) {
            PlayerFire playerFire = this.playerFires[i];
            if (!playerFire.isAppears()) {
                playerFire.setY(this.playerSpaceship.getY());
                playerFire.setAppears(true);
                break;
            }
        }
    }



    public int startGame(){
        this.sceneId = Definitions.LEVEL_1_SCENE;
        return sceneId;
    }

    public void paint (Graphics graphics) {
        super.paint(graphics);
        this.background.paintIcon(this,graphics,Definitions.STARTING_X,Definitions.STARTING_Y);
        switch (this.sceneId){
            case Definitions.MENU_SCENE:
                this.menuScene.paint(graphics);
               break;
            case Definitions.LEVEL_1_SCENE:
                this.level1Scene.paint(graphics);
                break;
            case Definitions.LEVEL_2_SCENE:
                this.level2Scene.paint(graphics);
                break;
            case Definitions.LOSING_SCENE:
               this.losingScene.paint(graphics);
                break;
            case Definitions.WINNING_SCENE:
                this.winningScene.paint(graphics);
                break;
        }

    }


 public void collisionWithPlayerFire () {
     for (PlayerFire fire : playerFires) {
         Rectangle fireRectangle = new Rectangle(fire.getX(), fire.getY(), Definitions.PLAYER_FIRE_WIDTH, Definitions.PLAYER_FIRE_HEIGHT);
         if (this.sceneId == Definitions.LEVEL_1_SCENE) {
             Rectangle enemyRectangle = new Rectangle(this.enemySpaceship1.getX(),
                     this.enemySpaceship1.getY(), Definitions.ENEMY_SPACESHIP_WIDTH, Definitions.ENEMY_SPACESHIP_HEIGHT);
             if (fireRectangle.intersects(enemyRectangle)) {
                 this.enemySpaceship1.setAppears(false);
                 this.sceneId = Definitions.LEVEL_2_SCENE;
             }
         }
         else if(this.sceneId == Definitions.LEVEL_2_SCENE) {
             Rectangle enemyRectangle2 = new Rectangle(this.enemySpaceship2.getX(),
                     this.enemySpaceship2.getY(), Definitions.ENEMY_SPACESHIP_WIDTH, Definitions.ENEMY_SPACESHIP_HEIGHT);
             Rectangle enemyRectangle3 = new Rectangle(this.enemySpaceship3.getX(),
                     this.enemySpaceship3.getY(), Definitions.ENEMY_SPACESHIP_WIDTH, Definitions.ENEMY_SPACESHIP_HEIGHT);
             if (fireRectangle.intersects(enemyRectangle2)) {
                 this.enemySpaceship2.setAppears(false);
             }
             if (fireRectangle.intersects(enemyRectangle3)) {
                 this.enemySpaceship3.setAppears(false);
             }
         }
     }
 }



    private void mainGameLoop() {
        new Thread(() -> {
            while (true) {
                switch (this.sceneId) {
                    case Definitions.LEVEL_1_SCENE:
                        enemySpaceship1.moveLeft(this.getGraphics(), this);
                        enemyFire1.moveLeft(this.getGraphics(), this);
                        for (PlayerFire fire : this.playerFires) {
                            if (fire.isAppears()) {
                                fire.move(this.getGraphics(),this);
                            }
                        }
                        collisionWithPlayerFire();
                        if (this.level1Scene.collision(playerSpaceship, this.level1Scene.getEnemySpaceship(), this.level1Scene.getEnemyFire())) {
                            this.playerSpaceship.setAlive(false);
                            this.enemyFire1.setAppears(false);
                            this.explosion.paint(this.getGraphics(),this);
                            this.sceneId = Definitions.LOSING_SCENE;
                        }
                       if (this.level1Scene.getEnemySpaceship().getX() == Definitions.STARTING_X) {
                           this.sceneId = Definitions.LEVEL_2_SCENE;
                       }
                        break;
                    case Definitions.LEVEL_2_SCENE:
                        enemySpaceship2.moveLeft(this.getGraphics(),this);
                        enemySpaceship3.moveLeft(this.getGraphics(),this);
                        enemyFire2.moveLeft(this.getGraphics(), this);
                        enemyFire3.moveLeft(this.getGraphics(), this);
                        for (PlayerFire fire : this.playerFires) {
                            if (fire.isAppears()) {
                                fire.move(this.getGraphics(), this);
                            }
                        }
                        collisionWithPlayerFire();
                        if(this.level2Scene.collision(playerSpaceship,this.enemySpaceship2,this.enemySpaceship3,
                                this.enemyFire2,this.enemyFire3)){
                            this.playerSpaceship.setAlive(false);
                            this.enemyFire2.setAppears(false);
                            this.enemyFire3.setAppears(false);
                            this.explosion.paint(this.getGraphics(),this);
                            this.sceneId = Definitions.LOSING_SCENE;
                        }
                        if (this.level2Scene.getEnemySpaceship2().getX() == Definitions.STARTING_X ||
                                this.level2Scene.getEnemySpaceship3().getX() == Definitions.STARTING_X) {
                            this.sceneId = Definitions.WINNING_SCENE;
                        }
                        if(!this.enemySpaceship2.isAppears()&& !this.enemySpaceship3.isAppears()){
                            this.sceneId = Definitions.WINNING_SCENE;
                        }
                        break;
                }
                repaint();
                try {
                    Thread.sleep(18);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public PlayerSpaceship getPlayerSpaceship() {
        return playerSpaceship;
    }

    public void setPlayerSpaceship(PlayerSpaceship playerSpaceship) {
        this.playerSpaceship = playerSpaceship;
    }

    public void setBackground(ImageIcon background) {
        this.background = background;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public EnemySpaceship getEnemySpaceship1() {
        return enemySpaceship1;
    }

    public void setEnemySpaceship1(EnemySpaceship enemySpaceship1) {
        this.enemySpaceship1 = enemySpaceship1;
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


    public Explosion getExplosion() {
        return explosion;
    }

    public void setExplosion(Explosion explosion) {
        this.explosion = explosion;
    }

    public Level1Scene getLevel1Scene() {
        return level1Scene;
    }

    public void setLevel1Scene(Level1Scene level1Scene) {
        this.level1Scene = level1Scene;
    }

    public Level2Scene getLevel2Scene() {
        return level2Scene;
    }

    public void setLevel2Scene(Level2Scene level2Scene) {
        this.level2Scene = level2Scene;
    }

    public PlayerFire getPlayerFire() {
        return playerFire;
    }

    public void setPlayerFire(PlayerFire playerFire) {
        this.playerFire = playerFire;
    }
}
