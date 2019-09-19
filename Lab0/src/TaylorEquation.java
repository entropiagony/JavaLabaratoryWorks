import java.util.Scanner;

class TaylorEquation {

    private double x;
    private double epsilon;
    private double value;

    void setValue(double a) {
        this.value = a;
    }

    double getValue() {
        return this.value;
    }

    double getEpsilon() {
        return this.epsilon;
    }

    double getX() {
        return this.x;
    }

    TaylorEquation() {
        this.x = 0;
        this.epsilon = 0;
        this.value = 0;
    }

    void readData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter x value : ");
        this.x = in.nextDouble();

        while (this.x >= 1 || this.x <= -1) {
            System.out.println("You've entered wrong value of x \nPlease enter x from interval (-1; 1) ");
            this.x = in.nextDouble();
        }

        System.out.println("Enter k value : ");
        int k = in.nextInt();
        this.epsilon = Math.pow(10, -k);
    }


    void writeAndCompare() {
        System.out.printf("Value calculated by our Taylor series class : %.3f \n", this.value);
        System.out.printf("Value calculated by java library : %.3f", Math.log((this.x + 1) / (1 - this.x)));
    }
}
