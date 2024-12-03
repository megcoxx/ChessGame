
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GameboardPanel extends JPanel {
    PlayingPieceComponent player1, player2;
    JPanel[][] cells;
    ChessModel model;
    PlayingController controller;


    public GameboardPanel(ChessModel model) {
        this.model = model;
        this.controller = new PlayingController(model, this);
        player1 = new PlayingPieceComponent(50, 50, Color.RED);
        player2 = new PlayingPieceComponent(50, 50, Color.BLUE);
        cells = new JPanel[8][8];

        setLayout((LayoutManager) new GridLayout(8, 8));
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel panel = new JPanel();

                if ((row + col) % 2 == 0) {
                    panel.setBackground(Color.WHITE);
                } else {
                    panel.setBackground(Color.DARK_GRAY);
                }

                add(panel);
                cells[row][col] = panel;
            }
        }
        refreshPieces();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Calculate which cell was clicked based on mouse coordinates
                int clickedRow = e.getY() / (getHeight() / 8);
                int clickedCol = e.getX() / (getWidth() / 8);

                // Send the click event to the controller for handling
                controller.handleCellClick(clickedCol, clickedRow);
            }
        });
    }

    public void refreshPieces() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                cells[row][col].removeAll();
                PlayingPieceComponent piece = model.board[col][row];
                if (piece != null) {
                    JLabel pieceLabel = new JLabel(new ImageIcon(piece.pieceDisplay));
                    pieceLabel.setForeground(piece.color);
                    cells[row][col].add(pieceLabel);
                }
            }
        }
        revalidate();
        repaint();
    }

    public void highlightCell(int col, int row, Color color) {
        cells[col][row].setBackground(color);
    }

    public void showInvalidMoveMessage(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void clearHighlights() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    cells[row][col].setBackground(Color.WHITE);
                } else {
                    cells[row][col].setBackground(Color.DARK_GRAY);
                }
            }
        }
        repaint();
    }
}
