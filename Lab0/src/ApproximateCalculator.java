class ApproximateCalculator {
    void calculate(TaylorEquation eq) {
        double A = eq.getX();
        int counter = 1;
        double sum = 0;
        while (Math.abs(A) - eq.getEpsilon() > 0) {
            sum += A;
            counter += 2;
            A = Math.pow(eq.getX(), counter) / counter;
        }
        sum *= 2;
        eq.setValue(sum);
    }
}
