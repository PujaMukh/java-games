package game.connect4oop;

public class Connect4OOP {
    PlayerManager playerManager;
    TurnManager turnManager;
    InputInitator inputInitator;
    OutputInitiator outputInitiator;
    BoardChecker boardChecker;

    int[][] board;

    public Connect4OOP(int numPlayers, int row, int col) {
        this.playerManager = new PlayerManager(numPlayers);
        this.turnManager = new TurnManager(numPlayers);
        this.board = new int[row][col];
        this.inputInitator = new InputInitator();
        this.outputInitiator = new OutputInitiator();
        this.boardChecker = new BoardChecker();
    }

    public void start() {
        outputInitiator.outputBoard(board);
        while(true) {
            int turn = turnManager.getTurn();
            Player currPlayer = playerManager.getPlayer(turn);
            int col = inputInitator.initiateInputForPlayer(currPlayer, board);

            if (col == -1) {
                continue;
            }

            int row = findAvailableRow(col);

            if (row == -1) {
                outputInitiator.noEmptyCell(col);
                continue;
            }

            board[row][col] = currPlayer.getId();

            outputInitiator.outputBoard(board);

            if (boardChecker.checkWin(board, row, col, currPlayer)) {
                outputInitiator.outputWin(currPlayer);
                break;
            }

            if (boardChecker.checkDraw(board)) {
                outputInitiator.outputDraw();
                break;
            }

            turnManager.nextTurn();
        }

    }

    private int findAvailableRow(int col) {
        for(int row = board.length-1; row >= 0; row--) {
            if (board[row][col] == 0) {
                return row;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Connect4OOP connect4 = new Connect4OOP(2, 6, 7);
        connect4.start();
    }
}
