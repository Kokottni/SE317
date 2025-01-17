package lab6;

import static org.junit.Assert.*;

import java.awt.Point;

import static org.hamcrest.CoreMatchers.*;
import static lab6.ConstrainsSidesTo.constrainsSidesTo;
import org.junit.*;
public class RectangleTest {
	private Rectangle rectangle;
	 @After
	public void ensureInvariant() {
		 assertThat(rectangle, constrainsSidesTo(100));
	 }
	@Test
	public void answersArea() {
		rectangle = new Rectangle(new Point(5, 5), new Point (15, 10));
		assertThat(rectangle.area(), equalTo(50));
	}
	
	@Test
	public void allowsDynamicallyChangingSize() {
		rectangle = new Rectangle(new Point(5, 5));
		rectangle.setOppositeCorner(new Point(105, 105));
		assertThat(rectangle.area(), equalTo(10000));
	}
}