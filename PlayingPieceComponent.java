
import javax.swing.*;
import java.awt.*;

public class PlayingPieceComponent extends JComponent{

    Color color;
    String name;
    Image pieceDisplay;
    int moveCounter;
    public boolean isInCheck;

    public PlayingPieceComponent(int width, int height, Color color) {
        setPreferredSize(new Dimension(width, height));
        this.color = color;
        name = "Test";
        pieceDisplay = new ImageIcon("images/PawnBlack.png").getImage();

    }
    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard){
        return false;
    }
    public boolean inCheck(int kingCol, int kingRow, PlayingPieceComponent[][] gameboard){
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Example: Draw a simple circle as the playing piece
        g2d.setColor(color);
        g2d.fillOval(0, 0, getWidth(), getHeight());
        
        // Example: Add a border to the circle
        g2d.setColor(color);
        g2d.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }
}

