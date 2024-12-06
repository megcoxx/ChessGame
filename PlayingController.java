import java.awt.Color;

public class PlayingController {
    ChessModel model;
    GameboardPanel view;
    int selectedCol, selectedRow;
    int turn;

    PlayingController(ChessModel model, GameboardPanel view) {
        this.model = model;
        this.view = view;
        selectedCol = -1;
        selectedRow = -1;
        turn = 1;
    }

    // if turn = 1, white; turn = 2, black
    public void handleCellClick(int clickedCol, int clickedRow) {
        if (turn == 1) {
            // if it is the start of the turn
            if (selectedRow == -1 && selectedCol == -1) {
                if (model.getPieceAt(clickedCol, clickedRow) != null
                        && model.getPieceAt(clickedCol, clickedRow).color == Color.WHITE) {
                    selectedRow = clickedRow;
                    selectedCol = clickedCol;
                    view.highlightCell(clickedRow, clickedCol, Color.YELLOW);
                }
            } else {
                if (model.movePiece(selectedCol, selectedRow, clickedCol, clickedRow)) {
                    view.refreshPieces();
                    turn = 2;
                } else {
                    view.showInvalidMoveMessage("Invalid Move. Try Again.");
                }
                selectedRow = -1;
                selectedCol = -1;
                view.clearHighlights();
                view.showInvalidMoveMessage("Black Piece's Turn");
                if (model.getKing(Color.BLACK).inCheck(model.board)) {
                    System.out.println("Black is in check");
                    view.highlightCell(model.getKing(Color.BLACK).row, model.getKing(Color.BLACK).column, Color.red);
                }
            }
        } else if (turn == 2) {
            if (selectedRow == -1 && selectedCol == -1) {
                if (model.getPieceAt(clickedCol, clickedRow) != null
                        && model.getPieceAt(clickedCol, clickedRow).color == Color.BLACK) {
                    selectedRow = clickedRow;
                    selectedCol = clickedCol;
                    view.highlightCell(clickedRow, clickedCol, Color.YELLOW);
                }
            } else {
                if (model.movePiece(selectedCol, selectedRow, clickedCol, clickedRow)) {
                    view.refreshPieces();
                    turn = 1;
                } else {
                    view.showInvalidMoveMessage("Invalid Move. Try Again.");
                }
                selectedRow = -1;
                selectedCol = -1;
                view.clearHighlights();
                view.showInvalidMoveMessage("White Piece's Turn");
                if (model.getKing(Color.WHITE).inCheck(model.board)) {
                    System.out.println("White is in check");
                    view.highlightCell(model.getKing(Color.WHITE).row, model.getKing(Color.WHITE).column, Color.red);
                }
            }
        }
        if (model.getKing(Color.BLACK) == null) {
            System.out.println("White wins!");
            view.showInvalidMoveMessage("White wins!");
            endGame();
        }
        if (model.getKing(Color.WHITE) == null) {
            System.out.println("Black wins!");
            view.showInvalidMoveMessage("Black wins!");
            endGame();
        }
    }

    private void endGame() {
        System.exit(0);
    }
}