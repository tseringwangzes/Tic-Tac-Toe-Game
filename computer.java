public class computer {

    int score(char arr[]) {

        for (int i = 0; i < 3; i++) {
            if (arr[i] == arr[i + 3] && arr[i] == arr[i + 6] && arr[i] != '_') {
                if (arr[i] == 'O') {
                    return 10;
                } else {
                    return -10;
                }

            } // to check if any column is filled with x or o or not

        }
        for (int j = 0; j < 9; j = j + 3) {
            if ((arr[j] == arr[j + 1] && arr[j] == arr[j + 2] && arr[j] != '_')) {
                if (arr[j] == 'O') {
                    return 10;
                } else {
                    return -10;
                }
            } // to check if any row is filled with x or o or not

        }
        if ((arr[0] == arr[4] && arr[0] == arr[8] && arr[0] != '_')
                || (arr[2] == arr[4] && arr[2] == arr[6] && arr[2] != '_')) {
            if (arr[4] == 'O') {
                return 10;
            }

            else {
                return -10;
            }
        } // to check diagonally
        return 0;
    }

    boolean moveleft(char arr[]) {
        for (int i = 0; i < 9; i++) {
            if (arr[i] == '_') {
                return true;
            }
        }
        return false;
    }

    int minimax(char arr[], boolean ismax) {
        int value = score(arr);
        if (value == 10 | value == -10) {
            return value;
        }
        if (moveleft(arr) == false) {
            return 0;
        }

        if (ismax) {
            int best = -1000;
            for (int i = 0; i < 9; i++) {
                if (arr[i] == '_') {
                    arr[i] = 'O';
                    best = Math.max(best, minimax(arr, !ismax));
                    arr[i] = '_';

                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 9; i++) {
                if (arr[i] == '_') {
                    arr[i] = 'X';
                    best = Math.min(best, minimax(arr, !ismax));
                    arr[i] = '_';
                }
            }
            return best;
        }

    }

    int bestposition(char arr[]) {
        int bestvalue = -1000;
        int theposition = -1;
        for (int i = 0; i < 9; i++) {
            if (arr[i] == '_') {
                arr[i] = 'O';
                int thevalue = minimax(arr, true);
                arr[i] = '_';
                if (thevalue > bestvalue) {
                    bestvalue = thevalue;
                    theposition = i;
                }
            }
        }
        return theposition;
    }

}
