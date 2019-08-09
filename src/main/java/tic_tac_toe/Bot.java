package tic_tac_toe;

import java.util.Random;

public class Bot {

    private Random r = new Random();
    // name should be more descriptive name


    private Board board;

    public Bot(Board board) {
        this.board = board;
    }

    public void move() throws FailArgumentException {

        int array[][] = board.getBoard();

        // as above
        boolean flag = true;
        // as above
        while (flag) {

            int x = r.nextInt(3);
            int y = r.nextInt(3);

            if (board.getValueFromField(x, y) == 0) {
                array[x][y] = 1;
                flag = false;
            } else if (board.isFull()) {
                flag = false;
            } else {
                flag = true;

            }
        }
    }
}


