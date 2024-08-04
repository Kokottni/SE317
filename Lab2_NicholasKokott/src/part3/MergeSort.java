package part3;

public class MergeSort {
    public static void goodMergeSort(int[] array, int left, int right) {
        if (left < right) {
        	//finds mid and does the recursive merge sort
            int mid = (left + right) / 2;
            goodMergeSort(array, left, mid);
            goodMergeSort(array, mid + 1, right);
            goodMerge(array, left, mid, right);
        }
    }
    
    public static void goodMerge(int[] array, int left, int mid, int right) {
        
    	int n1 = mid - left + 1;
        int n2 = right - mid;
        //makes two smaller arrays of sorted integers
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        //merges those smaller arrays into one returned array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    public static void faultyMergeSort(int[] array, int left, int right) {
        if (left < right) {
        	//Finds the middle of the array and then does recursion
            int mid = (left + right) / 2;
            faultyMergeSort(array, left, mid);
            faultyMergeSort(array, mid + 1, right);
            faultyMerge(array, left, mid, right);
        }
    }
    
    public static void faultyMerge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + j];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            /*
             * Here I removed the line ++k. This causes
             * k to never be incremented and for array[k] to 
             * end up being array[n2 -1]. This effects most of the
             * array and changes many elements.
             */
            //k++;
        }
    }
    
    public static void correctedMergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            correctedMergeSort(array, left, mid);
            correctedMergeSort(array, mid + 1, right);
            correctedMerge(array, left, mid, right);
        }
    }
    
    public static void correctedMerge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            /*
             * I added the k++ back into the program so 
             * the array can be looped through properly
             * and values will be put into their correct
             * positions.
             */
            k++;
        }
    }
}
