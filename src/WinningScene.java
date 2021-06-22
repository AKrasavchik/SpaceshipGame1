import javax.swing.*;
import java.awt.*;

public class WinningScene extends JPanel {
    private int sceneId;
    private ImageIcon winning;

    public WinningScene(){
        this.sceneId = Definitions.WINNING_SCENE;
        this.winning = new ImageIcon("images/winning.png");
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        this.winning.paintIcon(this,graphics,Definitions.STARTING_X,Definitions.STARTING_Y);
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}
