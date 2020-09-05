public class TicTacToe {
    private int[][] board;
    private int winner, turn, moves;
    private boolean gameOver;

    public TicTacToe() {
        board = new int[3][3];
        winner = 0;
        turn = 1;
        moves = 9;
        gameOver = false;
    }

    public void printBoard() {
        for(int i = 0; i < 3; i++) {
            System.out.print("[");
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 0)
                    System.out.print("_");
                else
                    System.out.print((board[i][j] == 1) ? "X" : "O");

                if(j < 2)
                    System.out.print("|");
            }
            System.out.println("]");
        }
    }

    public int getTurn() { return turn; }

    public int getWinner() { return winner; }

    /**
     * Sets t he next player's turn either player 1 or 2.
     */
    public void updateTurn() { turn = (turn == 1) ? 2 : 1; }

    /**
     * Checks if column and row are a valid cell to play and
     * decrements moves from 9 to 0 which signifies that
     * the players are out of moves. At the end it checks
     * if there is a winner and updates the player to play the
     * next turn.
     *
     * @param row row of the board
     * @param col column of the board
     * @return true if the move was valid to continue the game in the while loop
     */
    public boolean updateBoard(int row, int col) {
        if(isValidMove(row, col)) {
            board[row - 1][col - 1] = turn;
            moves -= 1;
            if(moves == 0) { gameOver = true; }
            checkBoardForWinner();
            updateTurn();
            return true;
        }
        return false;
    }

    /**
     * Checks for a winner using all 4 possible patterns including
     * 3 in a row, 3 in a column, left-to-right diagonal, and right-to-left
     * diagonal.
     */
    private void checkBoardForWinner() {
        for(int i = 0; i < 3; i++) {
            if(board[i][0] != 0 && board[i][0] == board[i][1]
                    && board[i][1] == board[i][2]) {
                this.winner = board[i][0];
                gameOver = true;
            }

            if(board[0][i] != 0 && board[0][i] == board[1][i]
                    && board[1][i] == board[2][i]) {
                this.winner = board[0][i];
                gameOver = true;
            }

            if(board[1][1] != 0 && board[0][0] == board[1][1]
                    && board[1][1] == board[2][2]) {
                this.winner = board[1][1];
                gameOver = true;
            }

            if(board[1][1] != 0 && board[0][2] == board[1][1]
                    && board[1][1] == board[2][0]) {
                this.winner = board[1][1];
                gameOver = true;
            }
        }
    }

    /**
     * Evaluates whether row and column are a number from 1 to 3 and
     * whether the spot on the board [row, col] has not been played yet.
     *
     * @param row row on the tic-tac-toe board
     * @param col column on the board
     * @return true if row/col are between 1-3 and the cell on the board is blank
     */
    public boolean isValidMove(int row, int col) {
        return !(row < 1 || row > 3 || col < 1 || col > 3 || board[row - 1][col - 1] != 0);
    }

    public boolean isGameOver() { return gameOver; }
}
