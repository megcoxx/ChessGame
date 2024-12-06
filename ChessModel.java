import java.awt.Color;

public class ChessModel {
    PlayingPieceComponent[][] board;
    PiecesTaken whitePlayer, blackPlayer;
    int whiteKingCol, blackKingCol, whiteKingRow, blackKingRow;

    public ChessModel() {
        board = new PlayingPieceComponent[8][8];
        whitePlayer = new PiecesTaken(Color.WHITE);
        blackPlayer = new PiecesTaken(Color.BLACK);
        gameStartBoard();
    }

    public void gameStartBoard() {
        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn(Color.BLACK);
            board[i][6] = new Pawn(Color.WHITE);
        }
        board[0][0] = new Rook(Color.BLACK);
        board[7][0] = new Rook(Color.BLACK);
        board[1][0] = new Knight(Color.BLACK);
        board[6][0] = new Knight(Color.BLACK);
        board[2][0] = new Bishop(Color.BLACK);
        board[5][0] = new Bishop(Color.BLACK);
        board[3][0] = new King(Color.BLACK);
        board[4][0] = new Queen(Color.BLACK);

        board[0][7] = new Rook(Color.WHITE);
        board[7][7] = new Rook(Color.WHITE);
        board[1][7] = new Knight(Color.WHITE);
        board[6][7] = new Knight(Color.WHITE);
        board[2][7] = new Bishop(Color.WHITE);
        board[5][7] = new Bishop(Color.WHITE);
        board[4][7] = new King(Color.WHITE);
        board[3][7] = new Queen(Color.WHITE);

    }

    public boolean movePiece(int colC, int rowC, int colN, int rowN) {
        PlayingPieceComponent pieceMoving = getPieceAt(colC, rowC);

        if (pieceMoving.canMoveTo(colC, rowC, colN, rowN, board)) {
            if (getKing(pieceMoving.color).isInCheck) {
                if (!(willGetOutOfCheck(getKing(pieceMoving.color), colC, rowC, colN, rowN))) {
                    return false;
                } else {
                    getKing(pieceMoving.color).isInCheck = false;
                }
            }
            if (board[colN][rowN] != null) {
                if (pieceMoving.color == Color.WHITE) {
                    whitePlayer.addPiece(board[colN][rowN]);
                } else {
                    blackPlayer.addPiece(board[colN][rowN]);
                }
            }
            board[colN][rowN] = pieceMoving;
            board[colC][rowC] = null;
            if (pieceMoving.name == "King") {
                pieceMoving.column = colN;
                pieceMoving.row = rowN;
                pieceMoving.moveCounter++;
            }

            if(pieceMoving.name == "Pawn"){
                pieceMoving.moveCounter++;
            }

            if(pieceMoving.name == "Rook"){
                pieceMoving.moveCounter++;
            }
            return true;
        } else {
            return false;
        }
    }

    public PlayingPieceComponent getPieceAt(int col, int row) {
        return board[col][row];
    }

    public PlayingPieceComponent getKing(Color color) {
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (board[col][row] != null) {
                    if (color == Color.WHITE) {
                        if (board[col][row].name == "King" && board[col][row].color == Color.WHITE) {
                            return board[col][row];
                        }
                    } else {
                        if (board[col][row].name == "King" && board[col][row].color == Color.BLACK) {
                            return board[col][row];
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean isInCheckMate(PlayingPieceComponent king) {
        if (!(king.isInCheck)) {
            return false;
        }

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                // Check if the piece is the current player's and not null
                if (board[col][row] != null && board[col][row].color == king.color) {
                    for (int colToMove = 0; colToMove < 8; colToMove++) {
                        for (int rowToMove = 0; rowToMove < 8; rowToMove++) {
                            // Check if the target square is valid and the piece can move there
                            if (board[col][row] != null
                                    && board[col][row].canMoveTo(col, row, colToMove, rowToMove, board)) {
                                if (willGetOutOfCheck(king, col, row, colToMove, rowToMove)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean willGetOutOfCheck(PlayingPieceComponent king, int colC, int rowC, int colN, int rowN) {
        PlayingPieceComponent[][] fakeBoard = new PlayingPieceComponent[8][8];

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (board[col][row] != null) {
                    fakeBoard[col][row] = board[col][row].clone();
                } else {
                    fakeBoard[col][row] = null;
                }
            }
        }

        if (getPieceAt(colC, rowC).name == "King") {
            fakeBoard[colN][rowN] = board[colC][rowC];
            fakeBoard[colC][rowC] = null;
            King fakeKing = new King(king.color);
            fakeKing.column = colN;
            fakeKing.row = rowN;

            if (!(fakeKing.inCheck(fakeBoard))) {
                return false;
            } else {
                return true;
            }
        } else {
            fakeBoard[colN][rowN] = board[colC][rowC];
            fakeBoard[colC][rowC] = null;
            if (!(king.inCheck(fakeBoard))) {
                return false;
            } else {
                return true;
            }
        }
    }
}
