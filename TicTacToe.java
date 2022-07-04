import java.util.Scanner;

public class TicTacToe {
    static Player type = new Player();
    static boolean isover = true;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int choice;
        while (isover == true) {
            System.out.println("Welcome to TicTacToe");
            System.out.println("This is a new game");
            System.out.printf("Enter\n1 for player vs player\n2 for computer vs player\n3 to quit\n");

            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    type.playervsplayer();
                    break;
                case 2:
                    type.computervsplayer();
                    break;
                case 3:
                    isover = false;
                    System.out.println("You quit the game");
                    break;
                default:
                    System.out.println("Enter a valid input");

            }
        }
    }

}
