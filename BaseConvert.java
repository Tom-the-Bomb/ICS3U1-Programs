public class BaseConvert {
    /* Converts a decimal number into a string containing the number in `base` base
     * Only works for 2 <= base <= 10
     * It repeatedly divides the number by `base`
     * and appends the remainder each time to the left side of the output string
     * until the whole quotient is 0
    */
    public static String convert(int n, int base) throws Exception {
        if (base > 10 || base < 2) {
            throw new Exception("Bases under 2 and greater than 10 are not allowed");
        }
        int rem;
        String output = "";
        while (n > 0) {
            int temp = n / base;
            rem = n % base;
            n = temp;

            output = rem + output;
        }
        return output;
    }
}
