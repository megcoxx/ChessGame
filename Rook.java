import java.awt.Color;

import javax.swing.ImageIcon;

public class Rook extends PlayingPieceComponent {
    public Rook(Color color) {
        super(color);
        name = "Rook";
        if (color == Color.BLACK) {
            pieceDisplay = new ImageIcon("images/RookBlack.png").getImage();
        }
        if (color == Color.WHITE) {
            pieceDisplay = new ImageIcon("images/RookWhite.png").getImage();
        }
        this.color = color;
        this.moveCounter = 0;
    }

    @Override
    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
        if (color == Color.WHITE) {
            if (gameboard[colN][rowN] == null) {
                if (colC == colN) {
                    if (rowC > rowN) {
                        for (int i = rowC - 1; i >= rowN; i--) {
                            if (gameboard[colN][i] != null) {
                                return false;
                            }
                        }
                        moveCounter++;
                        return true;
                    } else {
                        for (int i = rowC + 1; i <= rowN; i++) {
                            if (gameboard[colN][i] != null) {
                                return false;
                            }
                        }
                        moveCounter++;
                        return true;
                    }
                } else if (rowC == rowN) {
                    if (colC > colN) {
                        for (int i = colC - 1; i >= colN; i--) {
                            if (gameboard[i][rowN] != null) {
                                return false;
                            }
                        }
                        moveCounter++;
                        return true;
                    } else {
                        for (int i = colC + 1; i <= colN; i++) {
                            if (gameboard[i][rowN] != null) {
                                return false;
                            }
                        }
                        moveCounter++;
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                if (gameboard[colN][rowN].color == Color.WHITE) {
                    return false;
                } else {
                    if (colC == colN) {
                        if (rowC > rowN) {
                            for (int i = rowC - 1; i > rowN; i--) {
                                if (gameboard[colN][i] != null) {
                                    return false;
                                }
                            }
                            moveCounter++;
                            return true;
                        } else {
                            for (int i = rowC + 1; i < rowN; i++) {
                                if (gameboard[colN][i] != null) {
                                    return false;
                                }
                            }
                            moveCounter++;
                            return true;
                        }
                    } else if (rowC == rowN) {
                        if (colC > colN) {
                            for (int i = colC - 1; i > colN; i--) {
                                if (gameboard[i][rowN] != null) {
                                    return false;
                                }
                            }
                            moveCounter++;
                            return true;
                        } else {
                            for (int i = colC + 1; i < colN; i++) {
                                if (gameboard[i][rowN] != null) {
                                    return false;
                                }
                            }
                            moveCounter++;
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
            }
        } else {
            if (gameboard[colN][rowN] == null) {
                if (colC == colN) {
                    if (rowC > rowN) {
                        for (int i = rowC - 1; i >= rowN; i--) {
                            if (gameboard[colN][i] != null) {
                                return false;
                            }
                        }
                        moveCounter++;
                        return true;
                    } else {
                        for (int i = rowC + 1; i <= rowN; i++) {
                            if (gameboard[colN][i] != null) {
                                return false;
                            }
                        }
                        moveCounter++;
                        return true;
                    }
                } else if (rowC == rowN) {
                    if (colC > colN) {
                        for (int i = colC - 1; i >= colN; i--) {
                            if (gameboard[i][rowN] != null) {
                                return false;
                            }
                        }
                        moveCounter++;
                        return true;
                    } else {
                        for (int i = colC + 1; i <= colN; i++) {
                            if (gameboard[i][rowN] != null) {
                                return false;
                            }
                        }
                        moveCounter++;
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                if (gameboard[colN][rowN].color == Color.BLACK) {
                    return false;
                } else {
                    if (colC == colN) {
                        if (rowC > rowN) {
                            for (int i = rowC - 1; i > rowN; i--) {
                                if (gameboard[colN][i] != null) {
                                    return false;
                                }
                            }
                            moveCounter++;
                            return true;
                        } else {
                            for (int i = rowC + 1; i < rowN; i++) {
                                if (gameboard[colN][i] != null) {
                                    return false;
                                }
                            }
                            moveCounter++;
                            return true;
                        }
                    } else if (rowC == rowN) {
                        if (colC > colN) {
                            for (int i = colC - 1; i > colN; i--) {
                                if (gameboard[i][rowN] != null) {
                                    return false;
                                }
                            }
                            moveCounter++;
                            return true;
                        } else {
                            for (int i = colC + 1; i < colN; i++) {
                                if (gameboard[i][rowN] != null) {
                                    return false;
                                }
                            }
                            moveCounter++;
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    @Override
    public Rook clone() {
        return new Rook(this.color);
    }
}
