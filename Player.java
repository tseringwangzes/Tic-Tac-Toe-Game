import java.util.Scanner;

public class Player {
    static Scanner scan = new Scanner(System.in);
    thegrid threethreeboard = new thegrid();

    void playervsplayer() {
        threethreeboard.startNewGame();
        int posn;
        System.out.println("This is a new game");
        System.out.printf("Player 1= X\nplayer 2 = O\n");
        System.out.println("The board numbers are as follows:");
        threethreeboard.display(true);
        int i = 9; // i== odd, play1 i==even, play2
        while (i != 0) {
            System.out.println("Enter your desired location:");
            posn = scan.nextInt();
            while (!threethreeboard.ifavailable(posn)) {
                System.out.println("Invalid input or location already occupied");
                System.out.println("Enter your desired location:");
                posn = scan.nextInt();
            }
            threethreeboard.setposition(i, posn);
            threethreeboard.display(false);
            if (threethreeboard.check())
                break;
            // threethreeboard.ifcheck(threethreeboard.check());
            i--;
        }
        if (i == 0 && !threethreeboard.check())
            System.out.println("Game is a tie.");
    }

    void computervsplayer() {
        threethreeboard.startNewGame();
        System.out.println("This is a new game");
        System.out.printf("Player 1= X\nComputer = O\n");
        System.out.println("The board numbers are as follows:");
        threethreeboard.display(true);
        int i = 9; // i== odd, play1 i==even, play2
        while (i != 0) {
            int posn;
            System.out.println("Enter your desired location:");
            posn = scan.nextInt();
            while (!threethreeboard.ifavailable(posn)) {
                System.out.println("Invalid input or location already occupied");
                System.out.println("Enter your desired location:");
                posn = scan.nextInt();
            }
            threethreeboard.setposition(i, posn);
            threethreeboard.display(false);
            i--;
            if (threethreeboard.check())
                break;

            threethreeboard.computerturn();
            System.out.println("Computer has chose this location");
            threethreeboard.display(false);
            i--;
            if (threethreeboard.check())
                break;
            if (i == 0 && !threethreeboard.check())
                System.out.println("Game is a tie.");

        }
    }

}
