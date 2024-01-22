
public class QuadraticSolver extends LinearSolver {
    // solves for the roots of a standard quadratic equation in the format of:
    // ax^2 + bx + c
    //
    // using the quadratic formula:
    // (-b +- sqrt(b^2 - 4ac)) / (2a)
    // to find either 0, 1 or 2 real roots.
    //
    public static void main(String[] args) {
        System.out.printf(
            "Enter values for:%nax^2 + bx + c%n"
        );
        double a = input("a");
        double b = input("b");
        double c = input("c");
        System.out.println();

        double discriminant = b*b - 4*a*c;
        if (discriminant < 0) {
            System.out.print("There are no real solutions (discriminant < 0).");
            return;
        }
        System.out.println(discriminant);
        double x1 = (-b + Math.sqrt(discriminant)) / (2*a);
        if (discriminant == 0) {
            System.out.printf("There is 1 real root (3 decimal places): [x = %.3f]%n", x1);
            return;
        }

        double x2 = (-b - Math.sqrt(discriminant)) / (2*a);
        System.out.printf(
            "There are 2 real roots (3 decimal places): [x = %.3f, %.3f]%n",
            Math.min(x1, x2),
            Math.max(x1, x2)
        );
    }
}