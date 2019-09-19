public class Main {
    public static void main(String [] args){
        Matrice testMatrice = new Matrice();
        testMatrice.readData();
        testMatrice.fillWithRandomNumbers();
        testMatrice.print();
        MaxDiagSumAnalyzer diagCalculator = new MaxDiagSumAnalyzer();
        diagCalculator.calculate(testMatrice);
        diagCalculator.writeMaxSum();
    }
}
