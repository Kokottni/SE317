package part1;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 1, 9, 4, 7, 6};
        
        goodBubbleSort(array);
    }
    
    public void goodBubbleSort(int[] array) {
        int[] originalArray = array.clone(); // Copy of the original array
        //the actual sorting happens here
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        //prints the old array
    	System.out.print("Old Array: ");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        //prints the new array
        System.out.print("New Sorted Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public void faultyBubbleSort(int[] array) {
        int[] originalArray = array.clone(); // Copy of the original array
        //the actual sorting happens here
        int n = array.length;
        //Modified the starting bound of the for loop to be one higher
        //This then makes the last element of the array not swapped
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        //prints the old array
    	System.out.print("Old Array: ");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        //prints the new array
        System.out.print("New Sorted Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public void correctedBubbleSort(int[] array) {
        int[] originalArray = array.clone(); // Copy of the original array
        //the actual sorting happens here
        int n = array.length;
        //corrected by adjusting i to 0 so the last element will be sorted
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        //prints the old array
    	System.out.print("Old Array: ");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        //prints the new array
        System.out.print("New Sorted Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}