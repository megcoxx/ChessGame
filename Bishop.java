import java.awt.Color;

import javax.swing.ImageIcon;

public class Bishop extends PlayingPieceComponent {
    public Bishop(Color color) {
        super(50, 50, color);
        name = "Bishop";
        if (color == Color.BLACK) {
            pieceDisplay = new ImageIcon("images/BishopBlack.png").getImage();
        }
        if (color == Color.WHITE) {
            pieceDisplay = new ImageIcon("images/BishopWhite.png").getImage();
        }
    }

    @Override
    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
        if (color == Color.WHITE) {
            if (gameboard[colN][rowN] != null) {
                if (gameboard[colN][rowN].color == Color.WHITE) {
                    return false;
                }
            }
            if (Math.abs(colN - colC) == Math.abs(rowN - rowC)) {
                if (colN - colC > 0 && rowN - rowC > 0) {
                    // both positive
                    // going right up
                    int tempCol = colC + 1;
                    int tempRow = rowC + 1;
                    while (tempCol != colN) {
                        if (gameboard[tempCol][tempRow] != null) {
                            return false;
                        }
                        tempCol++;
                        tempRow++;
                    }
                } else if (colN - colC > 0 && rowN - rowC < 0) {
                    // positive and negative
                    // going right down
                    int tempCol = colC + 1;
                    int tempRow = rowC - 1;
                    while (tempCol != colN) {
                        if (gameboard[tempCol][tempRow] != null) {
                            return false;
                        }
                        tempCol++;
                        tempRow--;
                    }
                } else if (colN - colC < 0 && rowN - rowC > 0) {
                    // positive and negative
                    // going left up
                    int tempCol = colC - 1;
                    int tempRow = rowC + 1;
                    while (tempCol != colN) {
                        if (gameboard[tempCol][tempRow] != null) {
                            return false;
                        }
                        tempCol--;
                        tempRow++;
                    }
                } else if (colN - colC < 0 && rowN - rowC < 0) {
                    // both negative
                    // going left down
                    int tempCol = colC - 1;
                    int tempRow = rowC - 1;
                    while (tempCol != colN) {
                        if (gameboard[tempCol][tempRow] != null) {
                            return false;
                        }
                        tempCol--;
                        tempRow--;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            if (gameboard[colN][rowN] != null) {
                if (gameboard[colN][rowN].color == Color.BLACK) {
                    return false;
                }
            }
            if (Math.abs(colN - colC) == Math.abs(rowN - rowC)) {
                if (colN - colC > 0 && rowN - rowC > 0) {
                    // both positive
                    // going right up
                    int tempCol = colC + 1;
                    int tempRow = rowC + 1;
                    while (tempCol != colN) {
                        if (gameboard[tempCol][tempRow] != null) {
                            return false;
                        }
                        tempCol++;
                        tempRow++;
                    }
                } else if (colN - colC > 0 && rowN - rowC < 0) {
                    // positive and negative
                    // going right down
                    int tempCol = colC + 1;
                    int tempRow = rowC - 1;
                    while (tempCol != colN) {
                        if (gameboard[tempCol][tempRow] != null) {
                            return false;
                        }
                        tempCol++;
                        tempRow--;
                    }
                } else if (colN - colC < 0 && rowN - rowC > 0) {
                    // positive and negative
                    // going left up
                    int tempCol = colC - 1;
                    int tempRow = rowC + 1;
                    while (tempCol != colN) {
                        if (gameboard[tempCol][tempRow] != null) {
                            return false;
                        }
                        tempCol--;
                        tempRow++;
                    }
                } else if (colN - colC < 0 && rowN - rowC < 0) {
                    // both negative
                    // going left down
                    int tempCol = colC - 1;
                    int tempRow = rowC - 1;
                    while (tempCol != colN) {
                        if (gameboard[tempCol][tempRow] != null) {
                            return false;
                        }
                        tempCol--;
                        tempRow--;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }
}