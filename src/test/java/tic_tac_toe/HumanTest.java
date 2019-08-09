package tic_tac_toe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HumanTest {

    Board board = new Board();
    Human human = new Human(board);

    @BeforeEach
    void createArray(){
        board.create();
        try {
            board.move(2,1);
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void makeMove() {

        human.makeMove();

    }
}