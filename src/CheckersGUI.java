import javax.swing.*;
import java.awt.*;

public class CheckersGUI extends JFrame {
    private static final int BOARD_SIZE = 8;
    private static final int WINDOW_SIZE = 800;
    private JPanel boardPanel;
    private JLabel[][] cells;

    public CheckersGUI() {
        setTitle("Checkers");
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        cells = new JLabel[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();

        add(boardPanel, BorderLayout.CENTER);

        setFocusable(true);
    }

    private void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                cells[row][col] = new JLabel();
                cells[row][col].setOpaque(true);
                cells[row][col].setHorizontalAlignment(SwingConstants.CENTER);
                cells[row][col].setVerticalAlignment(SwingConstants.CENTER);
                cells[row][col].setPreferredSize(new Dimension(80, 80));
                cells[row][col].setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.BLACK);

                boardPanel.add(cells[row][col]);
            }
        }
        setLocationRelativeTo(null);
    }

}
