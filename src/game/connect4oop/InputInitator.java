package game.connect4oop;

import java.util.Scanner;

public class InputInitator {
    public int initiateInputForPlayer(Player player, int[][] board) {
        System.out.println("Player " + player.id + " enter your choice of column:");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++) {
            int col = sc.nextInt();
            if (col >= 0 && col < board[0].length) {
                // assuming valid col
                return col;
            }
        }
        System.out.println("Too many instances of wrong column choice");
        return -1;
    }
}
