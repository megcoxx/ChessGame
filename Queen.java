import java.awt.Color;

import javax.swing.ImageIcon;

public class Queen extends PlayingPieceComponent {
    public Queen(Color color) {
        super(color);
        name = "Queen";
        if (color == Color.BLACK) {
            pieceDisplay = new ImageIcon("images/QueenBlack.png").getImage();
        }
        if (color == Color.WHITE) {
            pieceDisplay = new ImageIcon("images/QueenWhite.png").getImage();
        }
    }

    @Override
    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
        if (colC == colN && rowC == rowN) {
            return false;
        }

        if (gameboard[colN][rowN] != null && gameboard[colN][rowN].color == this.color) {
            return false;
        }

        if (colC == colN || rowC == rowN) {
            int colStep = Integer.signum(colN - colC);
            int rowStep = Integer.signum(rowN - rowC);

            int currentCol = colC + colStep;
            int currentRow = rowC + rowStep;

            while (currentCol != colN || currentRow != rowN) {
                if (gameboard[currentCol][currentRow] != null) {
                    return false;
                }
                currentCol += colStep;
                currentRow += rowStep;
            }
            return true;
        }

        if (Math.abs(colN - colC) == Math.abs(rowN - rowC)) {
            int colStep = Integer.signum(colN - colC);
            int rowStep = Integer.signum(rowN - rowC);

            int currentCol = colC + colStep;
            int currentRow = rowC + rowStep;

            while (currentCol != colN || currentRow != rowN) {
                if (gameboard[currentCol][currentRow] != null) {
                    return false;
                }
                currentCol += colStep;
                currentRow += rowStep;
            }
            return true;
        }

        return false;
    }

    @Override
    public Queen clone() {
        return new Queen(this.color);
    }
}