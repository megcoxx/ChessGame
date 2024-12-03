import java.awt.Color;

import javax.swing.ImageIcon;

public class King extends PlayingPieceComponent {
    boolean isInCheck;
    public King(Color color) {
        super(50, 50, color);
        name = "King";
        if (color == Color.BLACK) {
            pieceDisplay = new ImageIcon("images/KingBlack.png").getImage();
        }
        if (color == Color.WHITE) {
            pieceDisplay = new ImageIcon("images/KingWhite.png").getImage();
        }
        this.color = color;
        this.moveCounter = 0;
        this.isInCheck = false;
    }

    @Override
public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
    // Ensure the king moves only one square in any direction
    if (Math.abs(colC - colN) > 1 || Math.abs(rowC - rowN) > 1) {
        return false;
    }

    // Prevent moving onto a friendly piece
    if (gameboard[colN][rowN] != null && gameboard[colN][rowN].color == this.color) {
        return false;
    }

    // Simulate the move to check if the king will remain in check
    PlayingPieceComponent originalPiece = gameboard[colN][rowN];
    gameboard[colN][rowN] = this;
    gameboard[colC][rowC] = null;

    boolean stillInCheck = inCheck(colN, rowN, gameboard);

    // Undo the simulated move
    gameboard[colC][rowC] = this;
    gameboard[colN][rowN] = originalPiece;

    return !stillInCheck; // Only allow the move if it resolves check
}

    @Override
    public boolean inCheck(int kingCol, int kingRow, PlayingPieceComponent[][] gameboard) {
        System.out.println("Hitting Check");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                PlayingPieceComponent piece = gameboard[x][y];

                if (piece != null && piece.color != this.color) {
                    if (piece.canMoveTo(x, y, kingCol, kingRow, gameboard)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
