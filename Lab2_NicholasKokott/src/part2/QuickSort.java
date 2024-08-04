package part2;

public class QuickSort {
	public static void goodQuickSort(int[] array, int low, int high) {
		if (low < high) {
			//Does its partition
            int pi = partition(array, low, high);
            //Uses itself recursively
            goodQuickSort(array, low, pi - 1);
            goodQuickSort(array, pi + 1, high);
        }
    }
    
    public static int partition(int[] array, int low, int high) {
    	//Finds pivot point
    	int pivot = array[high];
        int i = low - 1;
        
        //swaps elements around the pivot point
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        //Swaps the temp position and high element
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
        
    }
    
    public static void faultyQuickSort(int[] array, int low, int high) {
		if (low < high) {
			//Does its partition
            int pi = faultyPartition(array, low, high);
            //Uses itself recursively
            faultyQuickSort(array, low, pi - 1);
            faultyQuickSort(array, pi + 1, high);
        }
    }
    
    public static int faultyPartition(int[] array, int low, int high) {
    	//Finds pivot point
    	int pivot = array[high];
        int i = low - 1;
        
        //swaps elements around the pivot point
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        /*
         * Here I removed the temp element all together.
         * This ensures that all elements at i + 1 just become
         * whatever is at array[high]. So when duplicates are in the
         * list a certain number of times they will be put in the 
         * correct order.
         */
        //int temp = array[i + 1];
        array[i + 1] = array[high];
        //array[high] = temp;
        
        return i + 1;
        
    }
    
    public static void correctedQuickSort(int[] array, int low, int high) {
		if (low < high) {
			//Does its partition
            int pi = correctedPartition(array, low, high);
            //Uses itself recursively
            correctedQuickSort(array, low, pi - 1);
            correctedQuickSort(array, pi + 1, high);
        }
    }
    
    public static int correctedPartition(int[] array, int low, int high) {
    	//Finds pivot point
    	int pivot = array[high];
        int i = low - 1;
        
        //swaps elements around the pivot point
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        //Readded the temp variable so elements swap properly
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
        
    }
}
