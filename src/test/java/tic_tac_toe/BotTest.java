package tic_tac_toe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {


    Board board = new Board();
    Bot bot = new Bot(board);
    PrintingBord printingBord = new PrintingBord(board);

    @BeforeEach
    void createArray(){
        try {
            bot.move();
            bot.move();
            bot.move();
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void move_FullArray_returnAllFieldsWithValue5(){

        int array[][]=board.getBoard();
        for(int i = 0 ; i < array.length ; i++){
            for(int j = 0 ; j <array.length ; j++){
                array[i][j]=5;
            }
        }

        try {
            bot.move();
        } catch (FailArgumentException e) {
            e.printStackTrace();
            fail("Method draws lots from not correct range");
        }
        for(int i = 0 ; i < array.length ; i++){
            for(int j = 0 ; j < array.length ; j++) {
                assertEquals(5, array[i][j]);
            }
        }
    }

    @Test
    void move_aFewEmptyFields_returnTrue(){

        try {
            bot.move();
        } catch (FailArgumentException e) {
            e.printStackTrace();
            fail("Method draws lots from not correct range");
        }




    }

}