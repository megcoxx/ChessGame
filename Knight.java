import java.awt.Color;

import javax.swing.ImageIcon;

public class Knight extends PlayingPieceComponent {
    public Knight(Color color) {
        super(50, 50, color);
        name = "Knight";
        if (color == Color.BLACK) {
            pieceDisplay = new ImageIcon("images/KnightBlack.png").getImage();
        }
        if (color == Color.WHITE) {
            pieceDisplay = new ImageIcon("images/KnightWhite.png").getImage();
        }
    }

    @Override
    public boolean canMoveTo(int colC, int rowC, int colN, int rowN, PlayingPieceComponent[][] gameboard) {
        if (color == Color.WHITE) {
            if (gameboard[colN][rowN] == null) {
                if ((rowN - 1 == rowC) || (rowN + 1 == rowC)) {
                    if ((colN + 2 == colC) || (colN - 2 == colC)) {
                        if (colC < colN) {
                            if (gameboard[colC + 1][rowC] != null) {
                                return false;
                            }
                            if (gameboard[colC + 2][rowC] != null) {
                                return false;
                            }
                        }
                        if (colC > colN) {
                            if (gameboard[colC - 1][rowC] != null) {
                                return false;
                            }
                            if (gameboard[colC - 2][rowC] != null) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if ((rowN - 2 == rowC) || (rowN + 2 == rowC)) {
                    if ((colN + 1 == colC) || (colN - 1 == colC)) {
                        if (rowC < rowN) {
                            if (gameboard[colC][rowC + 1] != null) {
                                return false;
                            }
                            if (gameboard[colC][rowC + 2] != null) {
                                return false;
                            }
                        }
                        if (rowC > rowN) {
                            if (gameboard[colC][rowC - 1] != null) {
                                return false;
                            }
                            if (gameboard[colC][rowC - 2] != null) {
                                return false;
                            }
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                if (gameboard[colN][rowN].color != Color.BLACK) {
                    return false;
                } else {
                    if ((rowN - 1 == rowC) || (rowN + 1 == rowC)) {
                        if ((colN + 2 == colC) || (colN - 2 == colC)) {
                            if (colC < colN) {
                                if (gameboard[colC + 1][rowC] != null) {
                                    return false;
                                }
                                if (gameboard[colC + 2][rowC] != null) {
                                    return false;
                                }
                            }
                            if (colC > colN) {
                                if (gameboard[colC - 1][rowC] != null) {
                                    return false;
                                }
                                if (gameboard[colC - 2][rowC] != null) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    } else if ((rowN - 2 == rowC) || (rowN + 2 == rowC)) {
                        if ((colN + 1 == colC) || (colN - 1 == colC)) {
                            if (rowC < rowN) {
                                if (gameboard[colC][rowC + 1] != null) {
                                    return false;
                                }
                                if (gameboard[colC][rowC + 2] != null) {
                                    return false;
                                }
                            }
                            if (rowC > rowN) {
                                if (gameboard[colC][rowC - 1] != null) {
                                    return false;
                                }
                                if (gameboard[colC][rowC - 2] != null) {
                                    return false;
                                }
                            }
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            if (gameboard[colN][rowN] == null) {
                if ((rowN - 1 == rowC) || (rowN + 1 == rowC)) {
                    if ((colN + 2 == colC) || (colN - 2 == colC)) {
                        if (colC < colN) {
                            if (gameboard[colC + 1][rowC] != null) {
                                return false;
                            }
                            if (gameboard[colC + 2][rowC] != null) {
                                return false;
                            }
                        }
                        if (colC > colN) {
                            if (gameboard[colC - 1][rowC] != null) {
                                return false;
                            }
                            if (gameboard[colC - 2][rowC] != null) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if ((rowN - 2 == rowC) || (rowN + 2 == rowC)) {
                    if ((colN + 1 == colC) || (colN - 1 == colC)) {
                        if (rowC < rowN) {
                            if (gameboard[colC][rowC + 1] != null) {
                                return false;
                            }
                            if (gameboard[colC][rowC + 2] != null) {
                                return false;
                            }
                        }
                        if (rowC > rowN) {
                            if (gameboard[colC][rowC - 1] != null) {
                                return false;
                            }
                            if (gameboard[colC][rowC - 2] != null) {
                                return false;
                            }
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                if (gameboard[colN][rowN].color != Color.WHITE) {
                    return false;
                } else {
                    if ((rowN - 1 == rowC) || (rowN + 1 == rowC)) {
                        if ((colN + 2 == colC) || (colN - 2 == colC)) {
                            if (colC < colN) {
                                if (gameboard[colC + 1][rowC] != null) {
                                    return false;
                                }
                                if (gameboard[colC + 2][rowC] != null) {
                                    return false;
                                }
                            }
                            if (colC > colN) {
                                if (gameboard[colC - 1][rowC] != null) {
                                    return false;
                                }
                                if (gameboard[colC - 2][rowC] != null) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    } else if ((rowN - 2 == rowC) || (rowN + 2 == rowC)) {
                        if ((colN + 1 == colC) || (colN - 1 == colC)) {
                            if (rowC < rowN) {
                                if (gameboard[colC][rowC + 1] != null) {
                                    return false;
                                }
                                if (gameboard[colC][rowC + 2] != null) {
                                    return false;
                                }
                            }
                            if (rowC > rowN) {
                                if (gameboard[colC][rowC - 1] != null) {
                                    return false;
                                }
                                if (gameboard[colC][rowC - 2] != null) {
                                    return false;
                                }
                            }
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}