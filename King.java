import java.awt.Color;

import javax.swing.ImageIcon;

public class King extends PlayingPieceComponent {
    boolean isInCheck;

    public King(Color color) {
        super(color);
        name = "King";
        if (color == Color.BLACK) {
            pieceDisplay = new ImageIcon("images/KingBlack.png").getImage();
            column = 3;
            row = 0;
        }
        if (color == Color.WHITE) {
            pieceDisplay = new ImageIcon("images/KingWhite.png").getImage();
            column = 4;
            row = 7;
        }
        this.color = color;
        this.moveCounter = 0;
        this.isInCheck = false;
    }

    @Override
    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
        if (Math.abs(colC - colN) > 1 || Math.abs(rowC - rowN) > 1) {
            return false;
        }

        if (gameboard[colN][rowN] != null && gameboard[colN][rowN].color == this.color) {
            return false;
        }
        return true;
    }

    public void setColRow(int col, int row) {
        column = col;
        this.row = row;
    }

    public boolean inCheck(PlayingPieceComponent[][] gameboard) {
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (gameboard[col][row] != null) {
                    if (gameboard[col][row].canMoveTo(col, row, column, this.row, gameboard)) {
                        this.isInCheck = true;
                        return true;
                    }
                }
            }
        }
        isInCheck = false;
        return false;
    }

    @Override
    public King clone() {
        return new King(this.color);
    }
}
