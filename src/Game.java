import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public static void main(String[] args) {
        new Game();
        userManual();
    }


    private static void userManual() {
        JFrame startButton = new JFrame();
        JFrame instruction = new JFrame();
        startButton.setLocationRelativeTo(null);
        instruction.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(startButton, "Welcome to Space Wars");
        JOptionPane.showMessageDialog(instruction, "#Game purpose:" +
                "\nTo win this game you need to kill all the enemies or avoid them and their rockets \n#" +
                "Rules: \n" +
                "1.Use arrow keyboard(Upwards & Downwards Arrows)\n2.Use space bar to shoot the enemies" +
                "\n3.You have only one life.Once you win or lose you have to restart the game!" +
                "\n4.You have only 25 shots so use wisely");

    }

    public Game (){
        this.setVisible(true);
        this.setSize(Definitions.WINDOW_WIDTH,Definitions.WINDOW_HEIGHT);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Space Wars");
        GameScene gameScene = new GameScene();
        gameScene.setBounds(Definitions.STARTING_X,Definitions.STARTING_Y,Definitions.WINDOW_WIDTH,Definitions.WINDOW_HEIGHT);
        this.add(gameScene);
        PlayerMovement playerMovement = new PlayerMovement(gameScene.getLevel1Scene().getPlayerSpaceship(),
                gameScene,
                gameScene.getGraphics(),
                gameScene.getSceneId());
        this.addKeyListener(playerMovement);

    }
}
