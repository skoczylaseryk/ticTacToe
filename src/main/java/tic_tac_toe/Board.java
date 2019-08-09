package tic_tac_toe;

public class Board {

    private int board[][];

    public Board() {
        create();
    }

    public int[][] create() {
        board = new int[3][3];
        return board;
    }


    public int[][] getBoard() {
        return board;
    }


    public boolean isFull() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasOnlyEmptyFields() {


        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                if (board[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isNotDuplicate(int x, int y) {

        if (board[x][y] == 1 || board[x][y] == 2) {
            return false;
        }
        return true;
    }

    public boolean isInsideTheBoard(int x, int y) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            return true;
        }
        return false;
    }

    public boolean isMoveCorrect(int x, int y) {
        if (isInsideTheBoard(x, y) && isNotDuplicate(x, y)) {
            return true;
        }
        return false;
    }

    public void move(int x, int y) throws FailArgumentException {
        if (isMoveCorrect(x, y)) {
            board[x][y] = 2;
        } else {
            throw new FailArgumentException();
        }
    }

    public int getValueFromField(int x, int y) throws FailArgumentException {

        if (isInsideTheBoard(x, y)) {
            return board[x][y];
        } else {
            throw new FailArgumentException();
        }
    }


}
