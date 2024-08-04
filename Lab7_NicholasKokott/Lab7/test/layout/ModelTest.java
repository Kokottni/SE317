package layout;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {

	private CalcModel calcModel;
	monitor monitor;
	

	@Before
	public void testInit() {
		calcModel = new CalcModel();
		
		monitor = new monitor();
		calcModel.getDisplay().addObserver(monitor);
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality with typing
	 * Test Requirements: Ensure that on the clear of the calculator the only thing remaining
	 * is a 0 for the user
	 */
	@Test
	public void clearTest() {
		calcModel.clearAll();
		
		assertTrue(monitor.getStuff().equals("0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality with typing
	 * Test Requirements: When a single number is pressed ensure that just that number shows up
	 */
	@Test
	public void typeSingleNumberTest() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_1);
		
		assertTrue(monitor.getStuff().equals("1"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality with typing
	 * Test Requirements: When multiple numbers are pressed in succession ensure they show up
	 * in the order they are pressed in
	 */
	@Test
	public void typeMultipleNumberTest() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_1);
		
		assertTrue(monitor.getStuff().equals("21"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality with typing
	 * Test Requirements: When 0 is the only button pressed on the calculator, ensure that
	 * there is only one 0 displayed to the user
	 */
	@Test
	public void typeMultipleZerosTest() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_0);
		calcModel.pressButton(Button.BUTTON_0);
		
		assertTrue(monitor.getStuff().equals("0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality with typing
	 * Test Requirements: Ensure that when any numbers or anything is input that the delete
	 * will remove the last input value to the calculator
	 */
	@Test
	public void typeDeleteTest() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_1);
		calcModel.pressButton(Button.BUTTON_DEL);
		
		assertTrue(monitor.getStuff().equals("2"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality with typing
	 * Test Requirements: Ensure that when we want to use decimals and enter them that they show up
	 * as a "."
	 */
	@Test
	public void typeDecimalTest() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_DOT);
		
		assertTrue(monitor.getStuff().equals("0."));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality with typing
	 * Test Requirements: Ensure that when we want to put numbers after a decimal that we are able to
	 */
	@Test
	public void typeDecimalPlusKeyTest() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_DOT);
		calcModel.pressButton(Button.BUTTON_8);
		
		assertTrue(monitor.getStuff().equals("0.8"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality with typing
	 * Test Requirements: Ensure that when a decimal is hit more than once during a single values input
	 * that it stays where it was placed the first time
	 */
	@Test
	public void typeMultipleDecimalTest() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_DOT);
		calcModel.pressButton(Button.BUTTON_6);
		calcModel.pressButton(Button.BUTTON_DOT);
		
		assertTrue(monitor.getStuff().equals("0.6"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when two numbers are inserted and you hit the addition button that
	 * they actually are added together
	 */
	@Test
	public void typeSimpleAdd() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_ADD);
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_EQUAL);
		
		assertTrue(monitor.getStuff().equals("4.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when two numbers are inserted and you hit the subtraction button that
	 * they actually are subtracted
	 */
	@Test
	public void typeSimpleSub() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_4);
		calcModel.pressButton(Button.BUTTON_SUB);
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_EQUAL);
		
		assertTrue(monitor.getStuff().equals("2.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when two numbers are inserted and you hit the multiplication button that
	 * they actually are multiplied together
	 */
	@Test
	public void typeSimpleMul() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_MUL);
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_EQUAL);
		
		assertTrue(monitor.getStuff().equals("6.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when two numbers are inserted and you hit the division button that
	 * they actually are divided
	 */
	@Test
	public void typeSimpleDiv() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_8);
		calcModel.pressButton(Button.BUTTON_DIV);
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_EQUAL);
		
		assertTrue(monitor.getStuff().equals("4.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when two numbers are inserted and you hit the addition button that
	 * if you add another number it retains the previous value
	 */
	@Test
	public void typeChainAdd() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_5);
		calcModel.pressButton(Button.BUTTON_ADD);
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_ADD);
		
		assertTrue(monitor.getStuff().equals("7.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when two numbers are inserted and you hit the addition button that
	 * if you add another number it retains the previous value when the equals button is hit
	 */
	@Test
	public void typeChainAddWithEqual() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_1);
		calcModel.pressButton(Button.BUTTON_ADD);
		calcModel.pressButton(Button.BUTTON_2);
		calcModel.pressButton(Button.BUTTON_ADD);
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_EQUAL);
		
		assertTrue(monitor.getStuff().equals("6.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when there are values in the calculator and the clear button is hit
	 * that everything is erased from memory and 0 is put in its place
	 */
	@Test
	public void typeClear() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_1);
		calcModel.pressButton(Button.BUTTON_CLS);
		
		assertTrue(monitor.getStuff().equals("0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when you put a number in and you want to negate it, that it
	 * actually gets negated
	 */
	@Test
	public void typeNegate() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_1);
		calcModel.pressButton(Button.BUTTON_NEGATE);
		
		assertTrue(monitor.getStuff().equals("-1.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when a number is put into the calculator and the square root
	 * button is hit that it returns the square root of a number
	 */
	@Test
	public void typeSqrt() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_1);
		calcModel.pressButton(Button.BUTTON_6);
		calcModel.pressButton(Button.BUTTON_SRT);
		
		assertTrue(monitor.getStuff().equals("4.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when a number is put into the calculator and the square 
	 * button is hit that it returns the square of a number
	 */
	@Test
	public void typeSquare() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_SQR);
		
		assertTrue(monitor.getStuff().equals("9.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when a number is put into the calculator and the square 
	 * button is hit multiple times that it returns the variable squared the correct number of times
	 */
	@Test
	public void typeSquareChain() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_SQR);
		calcModel.pressButton(Button.BUTTON_SQR);
		
		assertTrue(monitor.getStuff().equals("81.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that when a number is put into the calculator and the square 
	 * button is hit multiple times and then cleared that it returns 0
	 */
	@Test
	public void typeSquareChainWithClear() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_SQR);
		calcModel.pressButton(Button.BUTTON_SQR);
		calcModel.pressButton(Button.BUTTON_CLS);
		
		assertTrue(monitor.getStuff().equals("0"));
	}

	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that after an operation is completed it can add that value 
	 * into memory clear it from the screen and then recall the original value
	 */
	@Test
	public void testMemoryAddAndRecall() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_EQUAL);
		calcModel.pressButton(Button.BUTTON_M_PLUS);
		calcModel.pressButton(Button.BUTTON_CLS);
		calcModel.pressButton(Button.BUTTON_M_RECALL);
		
		assertTrue(monitor.getStuff().equals("3.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that after an operation is completed it can subtract that value
	 * from the current value in memory and after it's cleared it can be recalled to the screen
	 */
	@Test
	public void testMemorySubAndRecall() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_EQUAL);
		calcModel.pressButton(Button.BUTTON_M_MINUS);
		calcModel.pressButton(Button.BUTTON_CLS);
		calcModel.pressButton(Button.BUTTON_M_RECALL);
		
		assertTrue(monitor.getStuff().equals("-3.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that after an operation is completed it can subtract that value
	 * from the current value in memory and after it's cleared both on screen and memory nothing
	 * will be recalled
	 */
	@Test
	public void testMemorySubAndClear() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_EQUAL);
		calcModel.pressButton(Button.BUTTON_M_MINUS);
		calcModel.pressButton(Button.BUTTON_CLS);
		calcModel.pressButton(Button.BUTTON_M_CLEAR);
		calcModel.pressButton(Button.BUTTON_M_RECALL);
		
		assertTrue(monitor.getStuff().equals("0.0"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that after a value is shown to the screen but never executed on
	 * that it cannot be stored into memory with a memory plus
	 */
	@Test
	public void testInvalidMemoryPlus() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_M_PLUS);

		assertTrue(monitor.getStuff().equals("Error"));
	}
	
	/**
	 * Test Criterion: Basic Calculator Functionality when it comes to actually doing math
	 * Test Requirements: Ensure that after a value is shown to the screen but never executed on
	 * that it cannot be stored into memory with a memory minus
	 */
	@Test
	public void testInvalidMemoryMinus() {
		calcModel.clearAll();
		calcModel.pressButton(Button.BUTTON_3);
		calcModel.pressButton(Button.BUTTON_M_MINUS);

		assertTrue(monitor.getStuff().equals("Error"));
	}

}
