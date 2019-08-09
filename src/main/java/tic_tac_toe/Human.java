package tic_tac_toe;

import java.util.Scanner;

public class Human {

    Board board;

    public Human(Board board) {
        this.board = board;
    }

    public Board makeMove() {
        Scanner scanner = new Scanner(System.in);

        // name should be more descriptive
        boolean flag = true;
        int x = 4;
        int y = 4;


        // too long predicate
        while (x > 2 || x < 0 || y > 2 || y < 0) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (x > 2 || x < 0 || y > 2 || y < 0) {
                System.out.println("Input coordinates one more time  from 0 to 2");
            }
        }
        while (flag) {
            try {
                board.move(x, y);
                flag = false;
            } catch (FailArgumentException e) {
                e.printStackTrace();
                System.out.println("Input coordinates one more time with empty field");
                x = scanner.nextInt();
                y = scanner.nextInt();
                flag = true;

            }
        }
        return board;
    }


}
