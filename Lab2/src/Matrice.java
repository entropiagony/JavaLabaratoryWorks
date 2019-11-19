import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

class Matrice {
    private int[][] matriceArray;
    private int m;
    private int n;

    void readData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of lines in your matrice: ");
        this.m = in.nextInt();
        System.out.println("Enter number of columns in your matrice: ");
        this.n = in.nextInt();
        this.matriceArray = new int[m][n];
    }

    void fillWithRandomNumbers() {
        Random rnd = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.matriceArray[i][j] = rnd.nextInt(21) - 10;
            }
        }
    }

    void print() {
        System.out.print("Your matrice looks this way: ");
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(this.matriceArray[i][j] + " \t");
            }
        }
        System.out.println();
    }


    private int getDiagonalSum(int pos) {
        int diagSum = 0;
        if (pos > 0) {
            for (int i = 0; i < Math.min(m, n) - pos; i++) {
                diagSum += this.matriceArray[i + pos][i];
            }
        }
        if (pos < 0) {
            for (int i = 0; i < Math.min(m, n) + pos; i++) {
                diagSum += this.matriceArray[i][i - pos];
            }
        }
        return diagSum;
    }

    ArrayList getAllDiagonalSums() {
        ArrayList<Integer> diagonalSums = new ArrayList<Integer>();
        int i;
        for (i = 1 - Math.min(m, n); i < Math.min(m, n); i++) {
            if (i == 0) {
                i++;
            }
            diagonalSums.add(this.getDiagonalSum(i));
        }
        return diagonalSums;
    }
}
