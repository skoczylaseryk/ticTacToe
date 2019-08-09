package tic_tac_toe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class BoardTest {

    Board board = new Board();

    @Test
    void create_correctIndexes_testingMethod(){
        int array[][]= board.create();


        try{
            array[2][2]=2;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            fail();

        }

    }
    @Test
    void create_incorrectIndexes_testingMethod(){
        int array[][]= board.create();
        try{


            array[0][3]=1;
            fail();
            array[1][3]=1;
            fail();
            array[2][3]=1;
            fail();
            array[3][0]=1;
            fail();
            array[3][1]=1;
            fail();
            array[3][2]=1;
            fail();

        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }


    @Test
    void getBoard_returnBoardInstance() {

       assertThat(board.getBoard()).isNotNull();

    }

    @Test
    void isFull_fullArray_returnTrue(){
            for(int i = 0 ; i < board.getBoard().length ; i++){
               for(int j = 0 ; j < board.getBoard().length ; j++) {
                   try {
                       board.move(i,j);
                   } catch (FailArgumentException e) {
                       e.printStackTrace();
                   }
               }

            }

            boolean flag = board.isFull();
            assertThat(flag).isTrue();

    }
    @Test
    void isFull_notFullArray_returnFalse(){
        for(int i = 0 ; i < board.getBoard().length-1 ; i++){
            for(int j = 0 ; j < board.getBoard().length-1 ; j++) {
                try {
                    board.move(i,j);
                } catch (FailArgumentException e) {
                    e.printStackTrace();
                }
            }

        }

        boolean flag = board.isFull();
        assertThat(flag).isFalse();

    }

    @Test
    void hasOnlyEmptyFields_emptyFields_returnTrue(){
        boolean flag = board.hasOnlyEmptyFields();
        assertThat(flag).isTrue();
    }
    @Test
    void hasOnlyEmptyFields_oneNotEmptyField_returnFalse(){
        try {
            board.move(1,1);
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }
        boolean flag = board.hasOnlyEmptyFields();
        assertThat(flag).isFalse();
    }

    @Test
    void isDuplicate_FullField_returnFalse(){
        try {
            board.move(1,1);
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }
        boolean flag = board.isNotDuplicate(1,1);
        assertThat(flag).isFalse();
    }
    @Test
    void isDuplicate_EmptyField_returnTrue(){
        try {
            board.move(1,1);
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }
        boolean flag = board.isNotDuplicate(2,2);
        assertThat(flag).isTrue();
    }

    @Test
    void isInsideTheBoard_argumentBeyondArray_returnFalse(){
        boolean flag = board.isInsideTheBoard(10,5);
        assertThat(flag).isFalse();
    }
    @Test
    void isInsideTheBoard_argumentInsideArray_returnTrue(){
        boolean flag = board.isInsideTheBoard(2,2);
        assertThat(flag).isTrue();
    }

    @Test
    void isMoveCorrect_fullField_returnFalse(){
        try {
            board.move(1,1);
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }
        boolean flag = board.isMoveCorrect(1,1);
        assertThat(flag).isFalse();
    }
    @Test
    void isMoveCorrect_beyondArray_returnFalse(){
        boolean flag = board.isMoveCorrect(3,3);
        assertThat(flag).isFalse();
    }

    @Test
    void isMoveCorrect_InsideArrayAndArgumentToEmptyField_returnTrue(){
        try {
            board.move(1,1);
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }

        boolean flag = board.isMoveCorrect(2,2);
        assertThat(flag).isTrue();
    }

    @Test
    void move_argumentBeyondArray_returnFailArgumentException(){
        try {
            board.move(3,3);
            fail();
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }

    }
    @Test
    void getValueFromField_argumentBeyondArray_returnCatchedException(){
        try {
            board.getValueFromField(5, 5);
            fail();
        }catch(FailArgumentException a){
            a.printStackTrace();
        }
    }

    @Test
    void getValueFromField_argumentInsideArray_return(){
        try{
            board.move(2,2);
           int x = board.getValueFromField(2,2);
           assertThat(x).isEqualTo(2);
        }catch(FailArgumentException a){
            fail();
            a.printStackTrace();
        }
    }



}