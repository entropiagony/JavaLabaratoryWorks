import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MaxDiagSumAnalyzer {
    private List<Integer> diagonalSums;
    private int maxSum;

    public void calculate(Matrice matr) {
        diagonalSums = new ArrayList<Integer>();
        int i;
        for (i = 1 - matr.getSize(); i < matr.getSize(); i++)
        {
            if (i == 0) {
                i++;
            }
            diagonalSums.add(matr.getDiagonalSum(i));
        }

    }

    public void writeMaxSum() {
        System.out.println("Max sum of parallel to main diagonal diagonals: " + Collections.max(diagonalSums));
    }
}
