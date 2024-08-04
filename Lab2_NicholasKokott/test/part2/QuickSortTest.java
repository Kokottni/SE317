package part2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	void firstWorkingTest() {
		int[] test = {4,2,3,1,5,7,9};
		int[] correct = {1,2,3,4,5,7,9};
		//Prints original Array
		for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Runs the quickSort
        QuickSort.goodQuickSort(test, 0, test.length - 1);
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
	void secondWorkingTest() {
		int[] test = {11,4,3,6,1,2,8};
		int[] correct = {1,2,3,4,6,8,11};
		//Prints original Array
		for (int num : test) {
            System.out.print(num + " ");
        }
		System.out.println();
		//Runs the goodQuickSort
		QuickSort.goodQuickSort(test, 0, test.length - 1);
		//Prints the new sorted output
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
	void faultyWorking1(){
		int[] test = {7, 4, 7, 9, 7, 7, 9};
		int[] correct = {4,7,7,7,7,9,9};
		for (int num : test) {
            System.out.print(num + " ");
        }
		System.out.println();
		QuickSort.faultyQuickSort(test, 0, test.length - 1);
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
	void faultyWorking2(){
		int[] test = {6,4,3,4,4,4,6};
		int[] correct = {3,4,4,4,4,6,6};
		for (int num : test) {
            System.out.print(num + " ");
        }
		System.out.println();
		QuickSort.faultyQuickSort(test, 0, test.length - 1);
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
	void faultyFailing1() {
		int[] test = {9,4,3,6,0,1,2};
		int[] correct = {0,1,2,3,4,6,9};
		for (int num : test) {
            System.out.print(num + " ");
        }
		System.out.println();
		QuickSort.correctedQuickSort(test, 0, test.length - 1);
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
	void faultyFailing2() {
		int[] test = {5,8,13,4,7,0,1};
		int[] correct = {0,1,4,5,7,8,13};
		for (int num : test) {
            System.out.print(num + " ");
        }
		System.out.println();
		QuickSort.correctedQuickSort(test, 0, test.length - 1);
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
