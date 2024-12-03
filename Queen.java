import java.awt.Color;

import javax.swing.ImageIcon;

public class Queen extends PlayingPieceComponent {
    public Queen(Color color) {
        super(50, 50, color);
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
        if (color == Color.WHITE) {
            if (gameboard[colN][rowN] != null) {
                if (gameboard[colN][rowN].color == Color.WHITE) {
                    return false;
                }
            }
            if (colC == colN) {
                if (rowC > rowN) {
                    for (int i = rowC - 1; i >= rowN; i--) {
                        if (gameboard[colN][i] != null) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    for (int i = rowC + 1; i <= rowN; i++) {
                        if (gameboard[colN][i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            } else if (rowC == rowN) {
                if (colC > colN) {
                    for (int i = colC - 1; i >= colN; i--) {
                        if (gameboard[i][rowN] != null) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    for (int i = colC + 1; i <= colN; i++) {
                        if (gameboard[i][rowN] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            } else if (Math.abs(colN - colC) == Math.abs(rowN - rowC)) {
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
            if (colC == colN) {
                if (rowC > rowN) {
                    for (int i = rowC - 1; i >= rowN; i--) {
                        if (gameboard[colN][i] != null) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    for (int i = rowC + 1; i <= rowN; i++) {
                        if (gameboard[colN][i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            } else if (rowC == rowN) {
                if (colC > colN) {
                    for (int i = colC - 1; i >= colN; i--) {
                        if (gameboard[i][rowN] != null) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    for (int i = colC + 1; i <= colN; i++) {
                        if (gameboard[i][rowN] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            } else if (Math.abs(colN - colC) == Math.abs(rowN - rowC)) {
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