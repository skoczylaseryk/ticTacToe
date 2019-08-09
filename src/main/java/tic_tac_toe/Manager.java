package tic_tac_toe;

public class Manager {

    Board board;
    Bot bot;
    Human human;
    Menu menu;
    PrintingBord printingBord;
    Result result;

    public Manager() {
        this.board = new Board();
        this.bot = new Bot(board);
        this.human = new Human(board);
        this.printingBord = new PrintingBord(board);
        this.menu = new Menu(printingBord);
        this.result = new Result(board);

    }


    public void playAGame() {
        menu.showMenu();
        human.makeMove();


        try {
            bot.move();
        } catch (FailArgumentException e) {
            e.printStackTrace();
        }

        printingBord.printCurrentBoard();
        while (result.showResult() == null) {

            human.makeMove();
            try {
                bot.move();
            } catch (FailArgumentException e) {
                e.printStackTrace();
            }
            printingBord.printCurrentBoard();
        }
        if (result.hasPlayerWon()) {
            System.out.println("The game is over, you win ");
        } else if (result.hasBotWon()) {
            System.out.println("The game is over, bot won");
        } else {
            System.out.println("The game is over");
        }


    }
}
