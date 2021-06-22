import javax.swing.*;
import java.awt.*;

public class LosingScene extends JPanel {
    private int sceneId;

    public LosingScene(){
        this.sceneId = Definitions.LOSING_SCENE;
    }

    public void paint(Graphics graphics){
        Graphics2D createGraphics1 = (Graphics2D) graphics;
        createGraphics1.setFont( new Font("Ariel", Font.BOLD, 50));
        createGraphics1.setPaint( Color.WHITE );
        createGraphics1.drawString("YOU LOST",350,350);
        createGraphics1.dispose();
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}
