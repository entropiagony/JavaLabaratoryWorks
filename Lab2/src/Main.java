import java.util.Collections;

public class Main {
    public static void main(String [] args){
        Matrice testMatrice = new Matrice();
        testMatrice.readData();
        testMatrice.fillWithRandomNumbers();
        testMatrice.print();
        System.out.println("Max sum of parallel to main diagonal diagonals: " + Collections.max(testMatrice.getAllDiagonalSums()));
    }
}
