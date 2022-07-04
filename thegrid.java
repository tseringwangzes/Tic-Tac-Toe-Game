public class thegrid {
    char[] arr;

    thegrid() {
        arr = new char[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = '_';
        }

    } // a constructor

    computer aiturn = new computer();

    void setposition(int k, int location) {
        if (k % 2 == 0) {
            arr[location - 1] = 'O'; // k==2 implies its computer turn so the location will be filled by 'o'

        } else {
            arr[location - 1] = 'X';
        }
    }

    void display(boolean begin) {

        for (int m = 0; m < 9; m++) {
            if (begin) {
                System.out.printf(" %d ", m + 1);
            } else {
                System.out.print(" " + arr[m] + " ");
            }
            if ((m + 1) % 3 == 0)
                System.out.println("");

        }
    }

    void startNewGame() {
        for (int i = 0; i < 9; i++) {
            arr[i] = '_';
        }
    }

    boolean ifavailable(int i) {
        if (i >= 1 && i <= 9) {
            if (arr[i - 1] == '_')
                return true;

        }
        return false;
    }

    boolean check() {

        for (int i = 0; i < 3; i++) {
            if (arr[i] == arr[i + 3] && arr[i] == arr[i + 6] && arr[i] != '_') {

                System.out.printf("Player %c won the game\n", arr[i]);
                return true;
            } // to check if any column is filled with x or o or not

        }
        for (int j = 0; j < 9; j = j + 3) {
            if ((arr[j] == arr[j + 1] && arr[j] == arr[j + 2] && arr[j] != '_')) {
                System.out.printf("Player %c won the game\n", arr[j]);
                return true;
            } // to check if any row is filled with x or o or not

        }
        if ((arr[0] == arr[4] && arr[0] == arr[8] && arr[0] != '_')
                || (arr[2] == arr[4] && arr[2] == arr[6] && arr[2] != '_')) {
            System.out.printf("Player %c won the game\n", arr[4]);

            return true;
        } // to check diagonally
        return false;
    }

    void computerturn() {
        setposition(2, aiturn.bestposition(arr) + 1);
    }

}
