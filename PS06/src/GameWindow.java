import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameWindow extends JFrame {

    private GameLogic logic = new GameLogic();

    private ArrayList<ArrayList<GameSpace>> buttons;

    private JPanel panel;

    public GameWindow() {
        setTitle("Tic Tac Toe");

        setSize(900, 900);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(3, 3));

        makeButtons();

        add(panel);

        setVisible(true);
    }

    private void makeButtons () {
        buttons = new ArrayList<ArrayList<GameSpace>>(0);

        for (int i = 0; i < 3; i++) {
            buttons.add(new ArrayList<GameSpace>(0));
            for (int j = 0; j < 3; j++) {
                buttons.get(i).add(new GameSpace(i, j));
                panel.add(buttons.get(i).get(j));
            }

        }
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons.get(i).get(j).reset();
            }
        }
        logic.reset();
    }

    private class GameSpace extends JButton {

        private int row;    
        private int col;
        private int status = 0;

        public GameSpace(int row, int col) {
            this.row = row;
            this.col = col;

            addActionListener(new GameSpaceListener());
        }

        public void takeTurn() {
            if (status == 0) {
                if (logic.isXTurn()) {
                    status = 1;
                    setText("X");
                } else {
                    status = -1;
                    setText("O");
                }
                logic.nextTurn(row, col, status);
            }
        }

        public void reset() {
            setText("");
            status = 0;
        }

        private class GameSpaceListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                takeTurn();
                if (logic.gameOver()) {
                    logic.displayEndMessage();
                    resetGame();
                }
            }

        }

    }

}