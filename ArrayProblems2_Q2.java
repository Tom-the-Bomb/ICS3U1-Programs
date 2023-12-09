import java.util.Arrays;

public class ArrayProblems2_Q2 {
    public static int sumSome(int[] arr, int howMany) {
        if (howMany < 0 || howMany > arr.length) {
            howMany = arr.length;
        }
        int sum = 0;
        for (int i = 0; i < howMany; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int[] mirror(int[] arr) {
        int[] new_arr = Arrays.copyOf(arr, arr.length * 2);

        for (int i = 1; i <= arr.length; i++) {
            new_arr[i + arr.length - 1] = arr[arr.length - i];
        }
        return new_arr;
    }

    public static void print(int[] arr, int space) {
        for (int element : arr) {
            System.out.print(element);
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        System.out.println("Original list");
        print(arr, 4);
        System.out.printf(
            "Sum of the first 4 values is: %d%n",
            sumSome(arr, 4)
        );
        System.out.println("The mirror list");
        print(mirror(arr), 4);
    }
}
