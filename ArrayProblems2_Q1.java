public class ArrayProblems2_Q1 {
    public static int[] initialize(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i*i;
        }
        return arr;
    }

    public static int twoDigits(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 10 && arr[i] < 100) {
                count++;
            }
        }
        return count;
    }

    public static int[] splice(int[] arr) {
        int[] new_arr = new int[arr.length];

        for (int i = 0; i < arr.length; i += 2) {
            new_arr[i / 2] = arr[i];
        }
        int offset = (int) Math.round((double) arr.length / 2);
        for (int i = 1; i < arr.length; i += 2) {
            new_arr[offset + i / 2] = arr[i];
        }
        return new_arr;
    }

    public static void print(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = initialize(8);

        System.out.print("List: ");
        print(arr);
        System.out.printf(
            "List has %d two-digit numbers%n",
            twoDigits(arr)
        );
        System.out.print("Spliced: ");
        print(splice(arr));
    }
}
