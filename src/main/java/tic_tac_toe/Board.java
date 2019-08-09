package tic_tac_toe;

public class Board {

    private int board[][];

    public Board() {
        create();
    }

    // access can should private, name of method should be more descriptive
    public int[][] create() {
        // instead of hardcode it should be extracted to constants and moved to properties file
        board = new int[3][3];
        return board;
    }


    public int[][] getBoard() {
        return board;
    }

// method name should be more descriptive
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
// empty spaces should be removed

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                if (board[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // access should be private
    // name should be more descriptive
    public boolean isNotDuplicate(int x, int y) {

        if (board[x][y] == 1 || board[x][y] == 2) {
            return false;
        }
        return true;
    }

    // as above
    public boolean isInsideTheBoard(int x, int y) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            return true;
        }
        return false;
    }

    // access should be private
    public boolean isMoveCorrect(int x, int y) {
        if (isInsideTheBoard(x, y) && isNotDuplicate(x, y)) {
            return true;
        }
        return false;
    }


    // as above
    //
    public void move(int x, int y) throws FailArgumentException {
        if (isMoveCorrect(x, y)) {
            board[x][y] = 2;
        } else {
            throw new FailArgumentException(); // what if coordinates are already taken? should it still throw expetion?
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
