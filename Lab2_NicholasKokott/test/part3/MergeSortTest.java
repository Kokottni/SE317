package part3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import part2.QuickSort;

class MergeSortTest {

	@Test
	void correctTest1() {
		int[] test = {7,5,4,6,9,0,2};
		int[] correct = {0,2,4,5,6,7,9};
		//Prints original Array
		for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Runs the mergeSort
        MergeSort.goodMergeSort(test, 0, test.length - 1);
        //Prints modified array
        for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        boolean isSame = true;
        for(int i = 0; i < test.length; ++i) {
			if(correct[i] != test[i]) {
				isSame = false;
			}
		}
        //Tells user if the test array became the correct array
		assertEquals(true, isSame);
	}
	
	@Test
	void correctTest2() {
		int[] test = {5,7,4,8,0,3,2};
		int[] correct = {0,2,3,4,5,7,8};
		//Prints original Array
		for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Runs the mergeSort
        MergeSort.goodMergeSort(test, 0, test.length - 1);
        //Prints modified array
        for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        boolean isSame = true;
        for(int i = 0; i < test.length; ++i) {
        	if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
	
	@Test
	void faultyWorkingTest1() {
		int[] test = {0,5,2,5,5,2,0};
		int[] correct = {0,0,2,2,5,5,5};
		//Prints original Array
		for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Runs the mergeSort
        MergeSort.faultyMergeSort(test, 0, test.length - 1);
        //Prints modified array
        for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        boolean isSame = true;
        for(int i = 0; i < test.length; ++i) {
        	if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
	
	@Test
	void faultyWorkingTest2() {
		int[] test = {3,14,7,14,14,7,3};
		int[] correct = {3,3,7,7,14,14,14};
		//Prints original Array
		for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Runs the mergeSort
        MergeSort.goodMergeSort(test, 0, test.length - 1);
        //Prints modified array
        for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        boolean isSame = true;
        for(int i = 0; i < test.length; ++i) {
        	if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}

	@Test
	void faultyFailingTest1() {
		int[] test = {4,6,3,1,8,9,2};
		int[] correct = {1,2,3,4,6,8,9};
		//Prints original Array
		for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Runs the mergeSort
        MergeSort.correctedMergeSort(test, 0, test.length - 1);
        //Prints modified array
        for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        boolean isSame = true;
        for(int i = 0; i < test.length; ++i) {
        	if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
	
	@Test
	void faultyFailingTest2() {
		int[] test = {6,15,7,8,3,4,0};
		int[] correct = {0,3,4,6,7,8,15};
		//Prints original Array
		for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Runs the mergeSort
        MergeSort.correctedMergeSort(test, 0, test.length - 1);
        //Prints modified array
        for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        boolean isSame = true;
        for(int i = 0; i < test.length; ++i) {
        	if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
}
