package ClassTTT;

public class TicTacToeClass {
    // Instance Variables
    private char[][] board;
    private int turns;
    private boolean isWinner;
    private boolean isFull;
    private boolean isCat;

    // Constructors
    public TicTacToeClass() {
        board = new char[3][3];
        turns = 0;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner(char p) {
        // check horizontal WIN
        for (int r = 0; r < 3; r++) {
            if (p == board[r][0] && board[r][0] == board[r][1] && board[r][1] == board[r][2])
                return true;
        }

        // check vertical WIN
        for (int c = 0; c < 3; c++) {
            if (p == board[0][c] && board[0][c] == board[1][c] && board[1][c] == board[2][c])
                return true;
        }

        // check diagonal WIN
        if (p == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        else if (p == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;

        return false;

    }

    public boolean isFull() {
        if (turns < 9) {
            isFull = false;
        } else {
            isFull = true;
        }
        return isFull;
    }

    public boolean isCat() {
        if (isFull && isWinner == false) {
            isCat = true;
        } else {
            isCat = false;
        }
        return isCat;
    }

    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2)
            return true;
        else
            return false;
    }

    public int numTurns() {
        return turns;
    }

    public char playerAt(int r, int c) {
        if (isValid(r, c))
            return board[r][c];
        else
            return '@';
    }

    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public void playMove(char p, int r, int c) {
        if (board[r][c] != 'X' && board[r][c] != 'O') {
            board[r][c] = p;
        }
        turns++;
    }

}