package part2;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ComboTests {

	@Test
	public void twoTest() {
		ArrayList<String> combos = (ArrayList<String>) Combos.twoLetterCombos();
		boolean begin = combos.contains("aa");
		boolean random = combos.contains("bt");
		boolean end = combos.contains("zz");
		boolean inList = false;
		if(begin == true && random == true && end == true) inList = true;
		assertTrue(inList);
	}
	
	@Test
	public void threeTest() {
		ArrayList<String> combos = (ArrayList<String>) Combos.threeLetterCombos();
		boolean begin = combos.contains("aaa");
		boolean random = combos.contains("bty");
		boolean end = combos.contains("zzz");
		boolean inList = false;
		if(begin == true && random == true && end == true) inList = true;
		assertTrue(inList);
	}

	@Test
	public void chooseNumTest1() {
		int letters = 5;
		ArrayList<String> combos = (ArrayList<String>) Combos.xLetterCombos(letters);
		boolean begin = combos.contains("aaaaa");
		boolean random = combos.contains("btyun");
		boolean end = combos.contains("zzzzz");
		boolean inList = false;
		if(begin == true && random == true && end == true) inList = true;
		assertTrue(inList);
	}
	
	@Test
	public void chooseNumTest2() {
		int letters = 6;
		ArrayList<String> combos = (ArrayList<String>) Combos.xLetterCombos(letters);
		boolean begin = combos.contains("a");
		boolean random = combos.contains("b");
		boolean end = combos.contains("z");
		boolean inList = false;
		if(begin == true && random == true && end == true) inList = true;
		assertTrue(inList);
	}
}
