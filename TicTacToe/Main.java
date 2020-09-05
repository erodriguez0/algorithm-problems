import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        Scanner in = new Scanner(System.in);
        int row, col, player;

        /*
          Enter a while loop until the game is over or either
          player types quit.
         */
        while(!t.isGameOver()) {
            t.printBoard();
            System.out.printf("Player %d's turn\n", t.getTurn());

            System.out.print("Enter row: ");
            while(!in.hasNextInt()) {
                System.out.print("Enter row: ");
                in.next();
            }
            row = in.nextInt();

            System.out.print("Enter column: ");
            while(!in.hasNextInt()) {
                System.out.print("Enter column: ");
                in.next();
            }
            col = in.nextInt();

            t.updateBoard(row, col);
        }

        t.printBoard();
        player = t.getWinner();
        if(player != 0) {
            System.out.printf("PLAYER %d WON!\n", player);
        } else {
            System.out.println("NO WINNER");
        }
    }
}
