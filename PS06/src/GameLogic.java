import javax.swing.*;

public class GameLogic {

    private boolean xTurn = true;
    private char winner = '0';

    private boolean rows = false;
    private boolean cols = false;
    private boolean diags = false;
    private boolean full = false;

    private int[][] spaces = new int[3][3];

    public void nextTurn(int row, int col, int status) {
        xTurn = !xTurn;
        spaces[row][col] = status;
        checkRows();
        checkCols();
        checkDiags();
        checkFull();
    }

    public boolean isXTurn() {
        return xTurn;
    }

    public void checkRows() {
        for (int i = 0; i < 3; i++) {
            if (spaces[i][0] + spaces[i][1] + spaces[i][2] == 3) {
                rows = true;
                winner = 'X';
                break;
            } else if (spaces[i][0] + spaces[i][1] + spaces[i][2] == -3) {
                rows = true;
                winner = 'O';
            }
        }
    }

    public void checkCols() {
        for (int i = 0; i < 3; i++) {
            if (spaces[0][i] + spaces[1][i] + spaces[2][i] == 3) {
                rows = true;
                winner = 'X';
                break;
            } else if (spaces[0][i] + spaces[1][i] + spaces[2][i] == -3) {
                rows = true;
                winner = 'O';
            }
        }
    }

    public void checkDiags() {
        if (spaces[0][0] + spaces[1][1] + spaces[2][2] == 3) {
            diags = true;
            winner = 'X';
        } else if (spaces[0][0] + spaces[1][1] + spaces[2][2] == -3) {
            diags = true;
            winner = 'O';
        } else if (spaces[0][2] + spaces[1][1] + spaces [2][0] == 3) {
            diags = true;
            winner = 'X';
        } else if (spaces[0][2] + spaces[1][1] + spaces [2][0] == -3) {
            diags = true;
            winner = 'O';
        }
    }

    public void checkFull() {
        full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (spaces[i][j] == 0) {
                    full = false;
                    break;
                }
            }
        }
    }

    public boolean gameOver() {
        return rows || cols || diags || full;
    }

    public void displayEndMessage() {
        if (winner == 'X') {
            JOptionPane.showMessageDialog(null, "X wins!\nResetting...");
        } else if (winner == 'O'){
            JOptionPane.showMessageDialog(null, "O wins!\nResetting...");
        } else if (full) {
            JOptionPane.showMessageDialog(null, "Cat's game\nResetting...");
        } else {
            JOptionPane.showMessageDialog(null, "You broke it");
            System.out.println(winner);
        }
    }

    public void reset() {
        rows = false;
        cols = false;
        diags = false;
        full = false;
        winner = '0';
        xTurn = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                spaces[i][j] = 0;
            }
        }
    }

}
