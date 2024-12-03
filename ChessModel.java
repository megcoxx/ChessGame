import java.awt.Color;

public class ChessModel {
    PlayingPieceComponent[][] board;
    PiecesTaken whitePlayer, blackPlayer;
    int whiteKingCol, blackKingCol, whiteKingRow, blackKingRow;
    boolean moveNotResolveCheck = false;

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
        blackKingCol = 3;
        blackKingRow = 0;
        board[4][0] = new Queen(Color.BLACK);

        board[0][7] = new Rook(Color.WHITE);
        board[7][7] = new Rook(Color.WHITE);
        board[1][7] = new Knight(Color.WHITE);
        board[6][7] = new Knight(Color.WHITE);
        board[2][7] = new Bishop(Color.WHITE);
        board[5][7] = new Bishop(Color.WHITE);
        board[4][7] = new King(Color.WHITE);
        whiteKingCol = 4;
        whiteKingRow = 7;
        board[3][7] = new Queen(Color.WHITE);

    }

    public boolean movePiece(int colC, int rowC, int colN, int rowN) {
        moveNotResolveCheck = false;
        PlayingPieceComponent pieceMoving = getPieceAt(colC, rowC);

        if (isKingInCheck(pieceMoving.color) && !doesMoveResolveCheck(colC, rowC, colN, rowN, pieceMoving.color)) {
            moveNotResolveCheck = true;
            return false;
        }

        if (pieceMoving.canMoveTo(colC, rowC, colN, rowN, board)) {
            if (board[colN][rowN] != null) {
                if (pieceMoving.color == Color.WHITE) {
                    whitePlayer.addPiece(board[colN][rowN]);
                } else {
                    blackPlayer.addPiece(board[colN][rowN]);
                }
            }
            board[colN][rowN] = pieceMoving;
            board[colC][rowC] = null;

            if (pieceMoving.name.equals("King")) {
                if (pieceMoving.color == Color.WHITE) {
                    whiteKingCol = colN;
                    whiteKingRow = rowN;
                } else {
                    blackKingCol = colN;
                    blackKingRow = rowN;
                }
            }

            board[whiteKingCol][whiteKingRow].isInCheck = board[whiteKingCol][whiteKingRow].inCheck(whiteKingCol,
                    whiteKingRow, board);
            board[blackKingCol][blackKingRow].isInCheck = board[blackKingCol][blackKingRow].inCheck(blackKingCol,
                    blackKingRow, board);

            return true;
        } else {
            return false;
        }
    }

    private boolean doesMoveResolveCheck(int colC, int rowC, int colN, int rowN, Color kingColor) {
        PlayingPieceComponent movingPiece = board[colC][rowC];
        PlayingPieceComponent capturedPiece = board[colN][rowN];
    
        // Simulate the move
        board[colN][rowN] = movingPiece;
        board[colC][rowC] = null;
    
        int originalKingCol = -1;
        int originalKingRow = -1;
        if (movingPiece.name.equals("King")) {
            if (kingColor == Color.WHITE) {
                originalKingCol = whiteKingCol;
                originalKingRow = whiteKingRow;
                whiteKingCol = colN;
                whiteKingRow = rowN;
            } else {
                originalKingCol = blackKingCol;
                originalKingRow = blackKingRow;
                blackKingCol = colN;
                blackKingRow = rowN;
            }
        }
    
        boolean kingStillInCheck = isKingInCheck(kingColor);
    
        // Undo the simulated move
        board[colC][rowC] = movingPiece;
        board[colN][rowN] = capturedPiece;
    
        if (movingPiece.name.equals("King")) {
            if (kingColor == Color.WHITE) {
                whiteKingCol = originalKingCol;
                whiteKingRow = originalKingRow;
            } else {
                blackKingCol = originalKingCol;
                blackKingRow = originalKingRow;
            }
        }
    
        return !kingStillInCheck;
    }

    public boolean isKingInCheck(Color kingColor) {
        int kingCol = (kingColor == Color.WHITE) ? whiteKingCol : blackKingCol;
        int kingRow = (kingColor == Color.WHITE) ? whiteKingRow : blackKingRow;

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                PlayingPieceComponent piece = board[col][row];
                if (piece != null && piece.color != kingColor) {
                    if (piece.canMoveTo(col, row, kingCol, kingRow, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCheckmate(Color kingColor) {
        if (!isKingInCheck(kingColor)) {
            return false; // The king is not in check, so no checkmate
        }
    
        // Iterate through all pieces of the current player
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                PlayingPieceComponent piece = board[col][row];
                if (piece != null && piece.color == kingColor) {
                    // Try all possible moves for this piece
                    for (int colN = 0; colN < 8; colN++) {
                        for (int rowN = 0; rowN < 8; rowN++) {
                            if (piece.canMoveTo(col, row, colN, rowN, board)) {
                                if (doesMoveResolveCheck(col, row, colN, rowN, kingColor)) {
                                    return false; // Found a valid move that resolves check
                                }
                            }
                        }
                    }
                }
            }
        }
    
        return true; // No valid moves found; the king is in checkmate
    }

    public PlayingPieceComponent getPieceAt(int col, int row) {
        return board[col][row];
    }
}
