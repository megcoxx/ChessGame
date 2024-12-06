
import javax.swing.*;
import java.awt.*;

public class PlayingPieceComponent extends JComponent {

    Color color;
    String name;
    Image pieceDisplay;
    int moveCounter;
    public boolean isInCheck;
    int column, row;

    public PlayingPieceComponent(Color color) {
        this.color = color;
        name = "Test";
        pieceDisplay = new ImageIcon("images/PawnBlack.png").getImage();
    }

    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
        return false;
    }

    public PlayingPieceComponent clone() {
        return new PlayingPieceComponent(this.color);
    }

    public boolean inCheck(PlayingPieceComponent[][] gameboard) {
        return false;
    }
}
