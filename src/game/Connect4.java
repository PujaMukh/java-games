package game;

import java.util.Scanner;

public class Connect4 {
    int row;
    int col;
    int numPlayer;

    int[][] board;
    int lastRow;
    int lastCol;

    public Connect4(int row, int col, int numPlayers) {
        this.row = row;
        this.col = col;
        this.numPlayer = numPlayers;
        this.board = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void start() {
        int turn = 0;
        print(board);
        while(true) {
            if (isBoardFull(board)) {
                System.out.println("Board is full. Its a draw !!!");
                print(board);
                break;
            }

            int currPlayer = turn+1;

            lastCol = takeInput(currPlayer);

            lastRow = placeOnBoard(lastCol, currPlayer);

            if (lastRow == -1) {
                System.out.println("Invalid input - col " + lastCol);
                break;
            }

            print(board);

            if (win(lastRow, lastCol, currPlayer)) {
                System.out.println("Player " + currPlayer + " wins!!!");
                break;
            }

            turn = (turn+1) % numPlayer;
        }
    }

    private void print(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    private boolean win(int lastRow, int lastCol, int currPlayer) {
        StringBuilder sb = new StringBuilder();

        String winning = Integer.toString(currPlayer) + Integer.toString(currPlayer)
                + Integer.toString(currPlayer) + Integer.toString(currPlayer);
        // check horizontal
        for(int i=0; i<board[0].length; i++) {
            sb.append(board[lastRow][i]);
        }
        String rowToCheck = sb.toString();

        if (rowToCheck.contains(winning)) {
            return true;
        }

        sb.setLength(0);
        // check vertical
        for(int i=board.length-1; i>=0; i--) {
            sb.append(board[i][lastCol]);
        }

        String colToCheck = sb.toString();

        if (colToCheck.contains(winning)) {
            return true;
        }

        sb.setLength(0);

        // check forward diagonal

        //go down
        int r = lastRow;
        int c = lastCol;

        while(r < board.length && c >= 0 ) {
            sb.append(board[r][c]);
            r++;
            c--;
        }

        sb.reverse();

        //go up
        r = lastRow-1;
        c = lastCol+1;

        while(r >= 0 && c < board[0].length) {
            sb.append(board[r][c]);
            r--;
            c++;
        }

        String diag = sb.toString();
        if (diag.contains(winning)) {
            return true;
        }

        sb.setLength(0);

        // check backward diagonal

        //go up
        r = lastRow;
        c = lastCol;

        while(r >= 0 && c >= 0) {
            sb.append(board[r][c]);
            r--;
            c--;
        }
        sb.reverse();

        r = lastRow+1;
        c = lastCol+1;

        while(r < board.length && c < board[0].length) {
            sb.append(board[r][c]);
            r++;
            c++;
        }

        diag = sb.toString();
        if (diag.contains(winning)) {
            return true;
        }

        return false;
    }

    private int placeOnBoard(int lastCol, int currPlayer) {
        int r = -1;
        if (lastCol < 0 || lastCol >= board[0].length) {
            return r;
        }
        for(int j=board.length-1; j>=0; j--) {
            if (board[j][lastCol] == 0) {
                r = j;
                board[j][lastCol] = currPlayer;
                break;
            }
        }
        return r;
    }

    private int takeInput(int currPlayer) {

        System.out.println("Player " + currPlayer + " enter the column you wish to choose: ");

        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()) {
            int c = sc.nextInt();
            return c;
        }
        return -1;
    }

    private boolean isBoardFull(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Connect4 game = new Connect4(6, 7, 2);
        game.start();
    }
}
