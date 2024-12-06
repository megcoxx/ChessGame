import java.awt.Color;

import javax.swing.ImageIcon;

public class Knight extends PlayingPieceComponent {
    public Knight(Color color) {
        super(color);
        name = "Knight";
        if (color == Color.BLACK) {
            pieceDisplay = new ImageIcon("images/KnightBlack.png").getImage();
        }
        if (color == Color.WHITE) {
            pieceDisplay = new ImageIcon("images/KnightWhite.png").getImage();
        }
    }

    @Override
    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
        if ((Math.abs(colN - colC) == 2 && Math.abs(rowN - rowC) == 1) ||
                (Math.abs(colN - colC) == 1 && Math.abs(rowN - rowC) == 2)) {
            if (gameboard[colN][rowN] == null || gameboard[colN][rowN].color != this.color) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Knight clone() {
        return new Knight(this.color);
    }
}