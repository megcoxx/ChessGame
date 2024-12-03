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
        // System.out.println("Highlighting if there is a king in check");
        // highlightKingInCheck();
    
        if (turn == 1) {
            //if it is the start of the turn
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
                    if (model.isCheckmate(Color.BLACK)) {
                        view.showInvalidMoveMessage("White wins by checkmate!");
                        endGame();
                        return;
                    }
                    turn = 2;
                } else {
                    if (model.moveNotResolveCheck) {
                        view.showInvalidMoveMessage("Move does not resolve check.");
                    } else {
                        view.showInvalidMoveMessage("Invalid Move. Try Again.");
                    }
                }
    
                selectedRow = -1;
                selectedCol = -1;
                view.clearHighlights();
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
                    if (model.isCheckmate(Color.WHITE)) {
                        view.showInvalidMoveMessage("Black wins by checkmate!");
                        endGame();
                        return;
                    }
                    turn = 1;
                } else {
                    if (model.moveNotResolveCheck) {
                        view.showInvalidMoveMessage("Move does not resolve check.");
                    } else {
                        view.showInvalidMoveMessage("Invalid Move. Try Again.");
                    }
                }
    
                selectedRow = -1;
                selectedCol = -1;
                view.clearHighlights();
            }
        }
    
        highlightKingInCheck();
    }
    
    private void endGame() {
        // Logic to end the game, e.g., disable input or close the application
        System.exit(0); // Example: End the program
    }

    private void highlightKingInCheck() {
        if (model.getPieceAt(model.whiteKingCol, model.whiteKingRow).isInCheck) {
            view.highlightCell(model.whiteKingRow, model.whiteKingCol, Color.RED);
        }

        if (model.getPieceAt(model.blackKingCol, model.blackKingRow).isInCheck) {
            view.highlightCell(model.blackKingRow, model.blackKingCol, Color.RED);
        }
    }
}