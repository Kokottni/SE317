package part1;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	public void correctOutputTest() {
		BubbleSort bsort = new BubbleSort();
		int[] testArray = {6, 5, 3, 2, 1, 8, 9, 0, 4};
		int[] correctArray = {0, 1, 2, 3, 4, 5, 6, 8, 9};
		bsort.goodBubbleSort(testArray);
		boolean isSame = true;
		for(int i = 0; i < correctArray.length; ++i) {
			if(correctArray[i] != testArray[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
	
	@Test
	public void correctOutputTest2() {
		BubbleSort bsort = new BubbleSort();
		int[] testArray2 = {11, 4, 6, 8, 0, 2, 5};
		int[] correctArray2 = {0, 2, 4, 5, 6, 8, 11};
		bsort.goodBubbleSort(testArray2);
		boolean isSame = true;
		for(int i = 0; i < correctArray2.length; ++i) {
			if(correctArray2[i] != testArray2[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
	
	@Test
	public void faultyFailingTest1() {
		BubbleSort bsort = new BubbleSort();
		int[] test = {4, 2, 6, 8, 9, 0, 1};
		int[] correct = {0, 1, 2, 4, 6, 8, 9};
		bsort.correctedBubbleSort(test);
		boolean isSame = true;
		for(int i = 0; i < test.length; ++i) {
			if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
	
	@Test
	public void faultyFailingTest2() {
		BubbleSort bsort = new BubbleSort();
		int[] test = {7, 8, 5, 3, 2, 11, 4};
		int[] correct = {2, 3, 4, 5, 7, 8, 11};
		bsort.correctedBubbleSort(test);
		boolean isSame = true;
		for(int i = 0; i < test.length; ++i) {
			if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}

	@Test
	public void faultyPassTest1() {
		BubbleSort bsort = new BubbleSort();
		int[] test = {7, 8, 5, 3, 2, 11, 12};
		int[] correct = {2, 3, 5, 7, 8, 11, 12};
		bsort.correctedBubbleSort(test);
		boolean isSame = true;
		for(int i = 0; i < test.length; ++i) {
			if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
	
	@Test
	public void faultyPassTest2() {
		BubbleSort bsort = new BubbleSort();
		int[] test = {1, 6, 8, 3, 2, 4, 15};
		int[] correct = {1, 2, 3, 4, 6, 8, 15};
		bsort.correctedBubbleSort(test);
		boolean isSame = true;
		for(int i = 0; i < test.length; ++i) {
			if(correct[i] != test[i]) {
				isSame = false;
			}
		}
		assertEquals(true, isSame);
	}
}
