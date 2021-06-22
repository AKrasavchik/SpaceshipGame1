import javax.swing.*;
import java.awt.*;

public class LosingScene extends JPanel {
    private int sceneId;

    public LosingScene(){
        this.sceneId = Definitions.LOSING_SCENE;
    }

    public void paint(Graphics graphics){
        Graphics2D createGraphics1 = (Graphics2D) graphics;
        createGraphics1.setFont( new Font("Ariel", Font.BOLD, Definitions.FONT_SIZE));
        createGraphics1.setPaint( Color.WHITE );
        createGraphics1.drawString("YOU LOST",Definitions.DRAW_STRING_LOSING_X,Definitions.DRAW_STRING_LOSING_Y);
        createGraphics1.dispose();
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}
