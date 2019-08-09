package tic_tac_toe;

public class Result {

    private Board board;

    public Result(Board board) {
        this.board = board;
    }

    public String showResult() {

        if (!board.isFull() && !hasPlayerWon() && !hasBotWon()) {
            return null;
        } else
            return "$";
    }
        // incorrect method name
    public boolean hasPlayerWon() {
        int array[][] = board.getBoard();

        if (array[0][0] == 2 && array[0][1] == 2 && array[0][2] == 2
                || array[1][0] == 2 && array[1][1] == 2 && array[1][2] == 2
                || array[2][0] == 2 && array[2][1] == 2 && array[2][2] == 2

                || array[0][0] == 2 && array[1][1] == 2 && array[2][2] == 2
                || array[0][2] == 2 && array[1][1] == 2 && array[2][0] == 2

                || array[0][0] == 2 && array[1][0] == 2 && array[2][0] == 2
                || array[0][1] == 2 && array[1][1] == 2 && array[2][1] == 2
                || array[0][2] == 2 && array[1][2] == 2 && array[2][2] == 2
        ) {
            return true;
        }
        return false;

    }

    // as above
    public boolean hasBotWon() {
        int array[][] = board.getBoard();
        if (


                array[0][0] == 2 && array[0][1] == 2 && array[0][2] == 2
                        || array[1][0] == 1 && array[1][1] == 1 && array[1][2] == 1
                        || array[2][0] == 1 && array[2][1] == 1 && array[2][2] == 1
                        || array[0][0] == 1 && array[1][1] == 1 && array[2][2] == 1
                        || array[0][2] == 1 && array[1][1] == 1 && array[2][0] == 1
                        || array[0][0] == 1 && array[1][0] == 1 && array[2][0] == 1
                        || array[0][1] == 1 && array[1][1] == 1 && array[2][1] == 1
                        || array[0][2] == 1 && array[1][2] == 1 && array[2][2] == 1

        ) {
            return true;
        }
        return false;
    }


}
















