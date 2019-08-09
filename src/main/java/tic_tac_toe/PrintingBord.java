package tic_tac_toe;

public class PrintingBord {

    private Board board;

    public PrintingBord(Board board) {
        this.board = board;
    }

    public void printCurrentBoard() {
        int counter = 0;
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                System.out.print(board.getBoard()[i][j] + " ");
                counter++;
                if (counter % 3 == 0) {
                    System.out.println();
                }
            }
        }
    }

}
