package lab7;

import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SparseArrayTestClass {
	private SparseArray<Object> array;
	
	@Before
	public void create() {
		array = new SparseArray<Object>();
	}
	
	@Test 
	public void handlesInsertionInDescendingOrder() { 
		array.put(7, "seven");  
		array.checkInvariants();
		array.put(6, "six");  
		array.checkInvariants();
		assertThat(array.get(6), equalTo("six")); 
		assertThat(array.get(7), equalTo("seven")); 
	} 

	@Test
	public void handlesNullInsertion() {
		array.put(0, null);
		array.checkInvariants();
		assertThat(array.size(), equalTo(0));
	}
	
	@Test
	public void insertRepeatValue() {
		array.put(6, "seis");  
		array.put(6, "six");  
		assertThat(array.get(6), equalTo("six"));
	}
}
