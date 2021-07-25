package prj01Arrays;

public class WriteXSymbol {
    public static final int SYMBOL_SIZE = 7; // count of rows and cols for symbol

    public static void main(String[] args) {
        char[][] symbol = new char[SYMBOL_SIZE][SYMBOL_SIZE];
        generateSymbolX(symbol);
        showSymbolX(symbol);
    }

    public static void generateSymbolX(char[][] array) {
        char symbol;
        for (int i = 0; i <= SYMBOL_SIZE / 2; i++) {
            for (int j = 0; j <= SYMBOL_SIZE / 2; j++) {
                if (j == i) {
                    symbol = 'X';
                } else {
                    symbol = ' ';
                }
                array[i][j] = symbol;
                array[i][SYMBOL_SIZE - 1 - j] = symbol;
                array[SYMBOL_SIZE - 1 - i][j] = symbol;
                array[SYMBOL_SIZE - 1 - i][SYMBOL_SIZE - 1 - j] = symbol;
            }
        }
    }

    public static void showSymbolX(char[][] array) {
        for (char[] row : array) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
