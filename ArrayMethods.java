
import java.util.Arrays;

public class ArrayMethods
{
    /* Pushes `element` to the end of the provided array */
    public static<T> T[] pushBack(T[] arr, T element) {
        T[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = element;
        return newArr;
    }

    /* Pushes `element` to the start of the provided array */
    public static<T> T[] pushFront(T[] arr, T element) {
        T[] newArr = Arrays.copyOf(arr, arr.length + 1);

        newArr[0] = element;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    /* Pops the element at the end of the array */
    public static<T> T[] popBack(T[] arr) {
        T[] newArr = Arrays.copyOf(arr, arr.length - 1);
        for (int i = 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        return newArr;
    }

    /* Pops the element at the front of the array */
    public static<T> T[] popFront(T[] arr) {
        T[] newArr = Arrays.copyOf(arr, arr.length - 1);
        return newArr;
    }

    /* Pops the element of the array at specified index */
    public static<T> T[] remove(T[] arr, int index) {
        T[] newArr = Arrays.copyOf(arr, arr.length - 1);
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                m = 1;
                continue;
            }
            newArr[i - m] = arr[i];
        }
        return newArr;
    }

    /* Inserts `element` into index `index` of the array */
    public static<T> T[] insert(T[] arr, int index, T element) {
        T[] newArr = Arrays.copyOf(arr, arr.length + 1);

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        newArr[index] = element;
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    /* Inserts `element` into index `index` of the array */
    public static<T> T[] swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    /* Bubble sort algorithm with `reverse` argument */
    public static<T extends Comparable<? super T>> T[] bubbleSort(T[] arr, boolean reverse) {
        for (int t = 0; t < arr.length; t++) {
            for (int i = 1; i < arr.length - t; i++) {
                if ((reverse && arr[i - 1].compareTo(arr[i]) < 0)
                    || (!reverse && arr[i - 1].compareTo(arr[i]) > 0)
                ) {
                    swap(arr, i - 1, i);
                }
            }
        }
        return arr;
    }

    /* Bubble sort algorithm */
    public static<T extends Comparable<? super T>> T[] bubbleSort(T[] arr) {
        return bubbleSort(arr, false);
    }

    /* Returns the maximum value within the array */
    public static<T extends Comparable<? super T>> T max(T[] arr) {
        T maximum = arr[0];
        for (T element : arr) {
            if (element.compareTo(maximum) > 0) {
                maximum = element;
            }
        }
        return maximum;
    }

    /* Returns the minimum value within the array */
    public static<T extends Comparable<? super T>> T min(T[] arr) {
        T minimum = arr[0];
        for (T element : arr) {
            if (element.compareTo(minimum) < 0) {
                minimum = element;
            }
        }
        return minimum;
    }

    /* Returns the index of an element in an array, returns -1 if element does not exist */
    public static<T> int indexOf(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /* Reverse the array */
    public static<T> T[] reverse(T[] arr) {
        T[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - i - 1];
        }
        return newArr;
    }

    /* Prints out an array in a formatted manner */
    public static<T> void printArr(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c", "d"};
        printArr(pushFront(arr1, "!"));
        printArr(pushBack(arr1, "!"));
        printArr(insert(arr1, 2, "!"));

        printArr(popFront(arr1));
        printArr(popBack(arr1));
        printArr(remove(arr1, 2));

        System.out.println("Index of \"c\": " + indexOf(arr1, "c"));
        printArr(reverse(arr1));

        Integer[] arr2 = {4, 2, 5, 1};
        printArr(bubbleSort(arr2));
        printArr(bubbleSort(arr2, true));
        System.out.println("Minimum: " + max(arr2));
        System.out.println("Maximum: " + min(arr2));
    }
}
