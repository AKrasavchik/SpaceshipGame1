import javax.swing.*;
import java.awt.*;

public class MenuScene extends JPanel {

    private int sceneId;

    public MenuScene(){
        this.sceneId = Definitions.MENU_SCENE;
    }

    public void paint(Graphics graphics){
        Graphics2D createGraphics = (Graphics2D) graphics;
        createGraphics.setFont( new Font("Ariel", Font.BOLD, 50));
        createGraphics.setPaint( Color.WHITE );
        createGraphics.drawString("To start game, press enter",200,600);
        createGraphics.dispose();
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}
