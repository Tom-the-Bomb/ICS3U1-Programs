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
    
    /* Returns the index of an element in an array, returns -1 if element does not exist */
    public static<T> int indexOf(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
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
        
        String[] arr5 = {"a", "b", "c", "d"};
        System.out.println(indexOf(arr5, "c"));
    }
}
