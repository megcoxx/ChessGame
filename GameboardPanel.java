
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class GameboardPanel extends JPanel {
    JPanel[][] cells;
    ChessModel model;
    PlayingController controller;
    JPanel blackPiecesTaken, whitePiecesTaken;

    public GameboardPanel(ChessModel model) {
        this.model = model;
        this.controller = new PlayingController(model, this);
        cells = new JPanel[8][8];

        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(8, 8));
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel panel = new JPanel();

                if ((row + col) % 2 == 0) {
                    panel.setBackground(Color.WHITE);
                } else {
                    panel.setBackground(Color.DARK_GRAY);
                }

                boardPanel.add(panel);
                cells[row][col] = panel;
            }
        }

        whitePiecesTaken = new JPanel();
        whitePiecesTaken.setLayout(new FlowLayout());
        whitePiecesTaken.setBorder((BorderFactory.createTitledBorder("White Pieces Taken:")));
        blackPiecesTaken = new JPanel();
        blackPiecesTaken.setLayout(new FlowLayout());
        blackPiecesTaken.setBorder((BorderFactory.createTitledBorder("Black Pieces Taken:")));

        add(whitePiecesTaken, BorderLayout.NORTH);
        add(createRowLabels(), BorderLayout.WEST);
        add(boardPanel, BorderLayout.CENTER);
        add(createRowLabels(), BorderLayout.EAST);
        add(blackPiecesTaken, BorderLayout.SOUTH);

        refreshPieces();
        boardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickedRow = e.getY() / (boardPanel.getHeight() / 8);
                int clickedCol = e.getX() / (boardPanel.getWidth() / 8);

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
        updatePiecesCaptured();
        revalidate();
        repaint();
    }

    private void updatePiecesCaptured() {
        whitePiecesTaken.removeAll();
        blackPiecesTaken.removeAll();

        ArrayList<PlayingPieceComponent> whiteCaptured = model.whitePlayer.piecesTaken;
        ArrayList<PlayingPieceComponent> blackCaptured = model.blackPlayer.piecesTaken;

        for (PlayingPieceComponent piece : blackCaptured) {
            JLabel pieceLabel = new JLabel(new ImageIcon(piece.pieceDisplay));
            whitePiecesTaken.add(pieceLabel);
        }

        for (PlayingPieceComponent piece : whiteCaptured) {
            JLabel pieceLabel = new JLabel(new ImageIcon(piece.pieceDisplay));
            blackPiecesTaken.add(pieceLabel);
        }

        whitePiecesTaken.revalidate();
        whitePiecesTaken.repaint();
        blackPiecesTaken.revalidate();
        blackPiecesTaken.repaint();
    }

    private JPanel createRowLabels() {
        JPanel rowPanel = new JPanel(new GridLayout(8, 1));
        rowPanel.setPreferredSize(new Dimension(20, 400));
        for (int i = 8; i >= 1; i--) {
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            rowPanel.add(label);
        }
        return rowPanel;
    }

    public void highlightCell(int col, int row, Color color) {
        cells[col][row].setBackground(color);
    }

    public void showInvalidMoveMessage(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Message",
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
