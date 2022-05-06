package game.connect4oop;

public class BoardChecker {

    public boolean checkDraw(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (board[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(int[][] board, int row, int col, Player player) {
        return isWinHorizontal(board, row, col, player) || isWinVertical(board, row, col, player) ||
                isWinForwardDiag(board, row, col, player) || isWinBackwardDiag(board, row, col, player);
    }

    private boolean isWinHorizontal(int[][] board, int row, int col, Player player) {
        String wining = createWinningString(player);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board[0].length; i++) {
            sb.append(board[row][i]);
        }


        return sb.toString().contains(wining);
    }

    private boolean isWinVertical(int[][] board, int row, int col, Player player) {
        String wining = createWinningString(player);
        StringBuilder sb = new StringBuilder();
        for(int i=board.length-1; i>=0; i--) {
            sb.append(board[i][col]);
        }


        return sb.toString().contains(wining);
    }

    private boolean isWinForwardDiag(int[][] board, int row, int col, Player player) {
        String wining = createWinningString(player);
        int upRow = row-1;
        int upCol = col+1;
        StringBuilder sb = new StringBuilder();
        while(row < board.length && col >= 0) {
            sb.append(board[row][col]);
            row++;
            col--;
        }
        sb.reverse();

        while(upRow >= 0 && upCol < board[0].length) {
            sb.append(board[upRow][upCol]);
            upRow--;
            upCol++;
        }

        return sb.toString().contains(wining);
    }

    private boolean isWinBackwardDiag(int[][] board, int row, int col, Player player) {
        String wining = createWinningString(player);
        int downRow = row+1;
        int downCol = col+1;
        StringBuilder sb = new StringBuilder();

        while(row >= 0 && col >= 0) {
            sb.append(board[row][col]);
            row--;
            col--;
        }
        sb.reverse();

        while(downRow < board.length && downCol < board[0].length) {
            sb.append(board[downRow][downCol]);
            downRow++;
            downCol++;
        }

        return sb.toString().contains(wining);
    }

    private String createWinningString(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append(player.getId());
        sb.append(player.getId());
        sb.append(player.getId());
        sb.append(player.getId());
        return sb.toString();
    }
}
