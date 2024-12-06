import java.awt.Color;

import javax.swing.ImageIcon;

public class Pawn extends PlayingPieceComponent {
    public Pawn(Color color) {
        super(color);
        name = "Pawn";
        if (color == Color.BLACK) {
            pieceDisplay = new ImageIcon("images/PawnBlack.png").getImage();
        }
        if (color == Color.WHITE) {
            pieceDisplay = new ImageIcon("images/PawnWhite.png").getImage();
        }
        this.color = color;
        this.moveCounter = 0;
    }

    @Override
    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
        if (color == Color.WHITE) {
            if (gameboard[colN][rowN] == null) {
                if ((rowC - 2 == rowN) && (colC == colN)) {
                    if (this.moveCounter == 0 && gameboard[colC][rowC - 1] == null && gameboard[colN][rowN] == null) {
                        return true;
                    } else {
                        return false;
                    }
                } else if ((rowC - 1 == rowN) && (colC == colN)) {
                    return true;
                } else {
                    return false;
                }
            } else if (gameboard[colN][rowN].color != Color.WHITE) {
                if ((rowC - 1 == rowN) && ((colC - 1 == colN) || (colC + 1 == colN))) {
                    return true;
                } else {
                    return false;
                }
            }
        } else if (this.color == Color.BLACK) {
            if (gameboard[colN][rowN] == null) {
                if ((rowC + 2 == rowN) && (colC == colN)) {
                    if (this.moveCounter == 0 && gameboard[colC][rowC + 1] == null && gameboard[colN][rowN] == null) {
                        return true;
                    } else {
                        return false;
                    }
                } else if ((rowC + 1 == rowN) && (colC == colN)) {
                    return true;
                } else {
                    return false;
                }
            } else if (gameboard[colN][rowN].color != Color.BLACK) {
                if ((rowC + 1 == rowN) && ((colC - 1 == colN) || (colC + 1 == colN))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public Pawn clone() {
        return new Pawn(this.color);
    }
}
