package game.connect4oop;

public class OutputInitiator {
    public void noEmptyCell(int col) {
        System.out.println("No empty cell for col: " + col);
    }

    public void outputBoard(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

    public void outputWin(Player currPlayer) {
        System.out.println("Player " + currPlayer.getId() + " Wins !!!");
    }

    public void outputDraw() {
        System.out.println("Board is drawn. Terminating");
    }
}
