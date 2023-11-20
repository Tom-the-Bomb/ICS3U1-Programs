import java.util.Arrays;

public class ArrayMethods
{
    /* Pushes `element` to the end of the provided array */
    public static<T> T[] pushBack(T[] arr, T element) {
        T[] new_arr = Arrays.copyOf(arr, arr.length + 1);
        new_arr[arr.length] = element;
        return new_arr;
    }
    
    /* Pushes `element` to the start of the provided array */
    public static<T> T[] pushFront(T[] arr, T element) {
        T[] new_arr = Arrays.copyOf(arr, arr.length + 1);
        
        new_arr[0] = element;
        for (int i = 0; i < arr.length; i++) {
            new_arr[i + 1] = arr[i];
        }
        return new_arr;
    }
    
    /* Inserts `element` into index `index` of the array */
    public static<T> T[] insert(T[] arr, int index, T element) {
        T[] new_arr = Arrays.copyOf(arr, arr.length + 1);
        
        for (int i = 0; i < index; i++) {
            new_arr[i] = arr[i];
        }
        new_arr[index] = element;
        for (int i = index; i < arr.length; i++) {
            new_arr[i + 1] = arr[i];
        }
        return new_arr;
    }
    
    /* Inserts `element` into index `index` of the array */
    public static<T> T[] swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    
    /* Bubble sort algorithm */
    public static<T extends Comparable<? super T>> T[] bubbleSort(T[] arr) {
        for (int t = 0; t < arr.length; t++) {
            for (int i = 1; i < arr.length - t; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                }
            }
        }
        return arr;
    }
    
    /* Prints out an array in a formatted manner */
    public static<T> void printArr(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c", "d"};
        printArr(pushFront(arr1, "!"));
        
        String[] arr2 = {"a", "b", "c", "d"};
        printArr(pushBack(arr2, "!"));
        
        String[] arr3 = {"a", "b", "c", "d"};
        printArr(insert(arr3, 2, "!"));
        
        Integer[] arr4 = {4, 2, 5, 1};
        printArr(bubbleSort(arr4));
    }
}
