package tic_tac_toe;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ResultTest {

    Board board = new Board();
    @Mock
    Bot bot = new Bot(board);
    Result result = new Result(board);

    @Test
    void showResult_playerWon_return$() {
        String result;
        try {
            board.move(0, 0);
            board.move(1, 1);
            board.move(2, 2);
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }
        result = this.result.showResult();
        assertThat(result).contains("$");
    }
    @Test
    void showResult_botWon_return$(){
        String result;
        try {
            bot.move();
            bot.move();
            bot.move();
            bot.move();
            bot.move();
            bot.move();
            bot.move();
            bot.move();
            bot.move();
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }
        result = this.result.showResult();
        assertThat(result).contains("$");

    }

    @Test
    void showResult_emptyBoard_returnNull() {
        String result;
        result = this.result.showResult();
        assertThat(result).isNull();
    }
}