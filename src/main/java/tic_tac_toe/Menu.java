package tic_tac_toe;

public class Menu {
    PrintingBord printingBord;


    public Menu(PrintingBord printingBord) {
        this.printingBord = printingBord;
    }

    public void showMenu() {
        printingBord.printCurrentBoard();
        System.out.println("Input coordinates: x, y");


    }
}
