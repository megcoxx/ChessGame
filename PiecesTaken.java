import java.awt.Color;
import java.util.ArrayList;

public class PiecesTaken {
    ArrayList<PlayingPieceComponent> piecesTaken;
    Color playerColor;
    int count;

    PiecesTaken(Color color){
        playerColor = color;
        piecesTaken = new ArrayList<PlayingPieceComponent>();
        count = 0;
    }

    public void addPiece(PlayingPieceComponent piece){
        piecesTaken.add(piece);
        count++;
    }
}
