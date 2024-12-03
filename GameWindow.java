import javax.swing.JFrame;

public class GameWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorry!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1080);

        ChessModel model = new ChessModel();
        GameboardPanel gameboardPanel = new GameboardPanel(model);

        frame.add(gameboardPanel);

        frame.setVisible(true);
    }
}
