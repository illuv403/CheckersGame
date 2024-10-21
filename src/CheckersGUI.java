import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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

                if (row < 3 && (row + col) % 2 == 1) {
                    cells[row][col].setIcon(createFigure(Color.BLACK, false));
                } else if (row > 4 && (row + col) % 2 == 1) {
                    cells[row][col].setIcon(createFigure(Color.WHITE, true));
                } else {
                    cells[row][col].setIcon(null);
                }

                boardPanel.add(cells[row][col]);
            }
        }
        setLocationRelativeTo(null);
    }


    private Icon createFigure(Color color, boolean withOutline) {
        BufferedImage figure = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = figure.createGraphics();
        if (withOutline) {
            g.setColor(Color.BLACK);
            g.fillOval(5, 5, 70, 70);
        } else {
            g.setColor(Color.WHITE);
            g.fillOval(5, 5, 70, 70);
        }
        g.setColor(color);
        g.fillOval(10, 10, 60, 60);
        g.dispose();
        return new ImageIcon(figure);
    }

}
