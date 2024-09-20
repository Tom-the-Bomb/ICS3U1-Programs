
import java.util.Scanner;

class LinearSolver {
    private static Scanner scanner = new Scanner(System.in);

    protected static double input(String name) {
        System.out.printf("%s: ", name);
        return scanner.nextDouble();
    }

    // solves a system of 2 linear equations of 2 variables (x, y)
    // [1]: a1(x) + b1(y) = c1
    // [2]: a2(x) + b2(y) = c2
    //
    // uses [Cramer's Rule](https://en.wikipedia.org/wiki/Cramer%27s_rule)
    //
    // Using Ax = b:
    // [a1 b1  * [x  = [c1
    //  a2 b2]    y]    c2]
    //
    public static void main(String[] args) {
        System.out.printf(
            "Enter values for:%na1(x) + b1(y) = c1%na2(x) + b2(y) = c2%n"
        );
        double a1 = input("a1");
        double b1 = input("b1");
        double c1 = input("c1");

        double a2 = input("a2");
        double b2 = input("b2");
        double c2 = input("c2");
        System.out.println();

        double discriminant = a1 * b2 - a2 * b1;
        if (discriminant == 0) {
            System.out.println("Discriminant is 0: (no solutions).");
            return;
        }

        double x = (c1 * b2 - c2 * b1) / discriminant;
        double y = (a1 * c2 - a2 * c1) / discriminant;

        System.out.printf(
            "Point of intersection (3 decimal places): (%.3f, %.3f)%n",
            x, y
        );
    }
}