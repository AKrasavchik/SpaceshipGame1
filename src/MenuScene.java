import javax.swing.*;
import java.awt.*;

public class MenuScene extends JPanel {

    private int sceneId;

    public MenuScene(){
        this.sceneId = Definitions.MENU_SCENE;
    }

    public void paint(Graphics graphics){
        Graphics2D createGraphics = (Graphics2D) graphics;
        createGraphics.setFont( new Font("Ariel", Font.BOLD, Definitions.FONT_SIZE));
        createGraphics.setPaint( Color.WHITE );
        createGraphics.drawString("To start game, press enter",Definitions.DRAW_STRING_MENU_X,Definitions.DRAW_STRING_MENU_Y);
        createGraphics.dispose();
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}
