package lab6;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BearingTest {
	   	   
	   @Test
	   public void answersValidBearing() {
	      try {
			assertThat(new Bearing(Bearing.MAX).value(), equalTo(Bearing.MAX));
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   
	   @Test
	   public void answersAngleBetweenItAndAnotherBearing() {
	      try {
			assertThat(new Bearing(15).angleBetween(new Bearing(12)), equalTo(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   
	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller() {
	      try {
			assertThat(new Bearing(12).angleBetween(new Bearing(15)), equalTo(-3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
	     	   
	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller2() throws Exception 
	   {
		   assertThat(new Bearing(5).angleBetween(new Bearing(15)), equalTo(-10));
	   }

	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller3() throws Exception 
	   {
		   assertThat(new Bearing(5).angleBetween(new Bearing(355)), equalTo(-350));
	   }

	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller4() throws Exception 
	   {
		   assertThat(new Bearing(15).angleBetween(new Bearing(0)), equalTo(15));
	   }

	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller5() throws Exception 
	   {
		   assertThat(new Bearing(5).angleBetween(new Bearing(156)), equalTo(-151));
	   }

	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller6() throws Exception 
	   {
		   assertThat(new Bearing(87).angleBetween(new Bearing(98)), equalTo(-11));
	   }

	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller7() throws Exception 
	   {
		   assertThat(new Bearing(47).angleBetween(new Bearing(178)), equalTo(-131));
	   }

	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller8() throws Exception 
	   {
		   assertThat(new Bearing(6).angleBetween(new Bearing(76)), equalTo(-70));
	   }

	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller9() throws Exception 
	   {
		   assertThat(new Bearing(100).angleBetween(new Bearing(248)), equalTo(-148));
	   }


}
