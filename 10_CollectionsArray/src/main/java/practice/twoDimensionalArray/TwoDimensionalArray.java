package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        // Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] ggg = new char[size][size];

        for (int i = 0; i < ggg.length; i++) {
            for (int j = 0; j < ggg.length; j++) {
                if (i == j || i + j == (size - 1)) {
                    ggg[i][j] = SYMBOL;
                } else {
                    ggg[i][j] = ' ';
                }
            }
        }
        return ggg;
    }
}
