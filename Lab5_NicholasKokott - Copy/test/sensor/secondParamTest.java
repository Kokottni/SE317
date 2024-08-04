package sensor;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.parameterized.*;

@RunWith(Parameterized.class)
public class secondParamTest {

	@Parameters
	public static Collection<Object[]> parameters(){
		return Arrays.asList(new Object[][] {
//			{66, 53, 66, 53},
//			{68, 51, 68, 51},
//			{69, 48, 69, 48},
//			{67, 49, 69, 48},
//			{63, 54, 69, 48},
//			{59, 56, 69, 48},
//			{53, 56, 69, 48}
			{66, 53, 66, 66, 66, "Stable", 53, 53, 53, "Stable", "OK"},
			{68, 51, 68, 68, 66, "Up", 53, 51, 51, "Down", "OK"},
			{69, 48, 69, 69, 66, "Up", 53, 48, 48, "Down", "OK"},
			{67, 49, 67, 69, 66, "Down", 53, 48, 49, "Up", "OK"},
			{63, 54, 63, 69, 63, "Down", 54, 48, 54, "Up", "OK"},
			{59, 56, 59, 69, 59, "Down", 56, 48, 56, "Up", "High"},
			{53, 56, 53, 69, 53, "Down", 56, 48, 56, "Stable", "High"}
		});
	}
	
	private int tempIn;
	private int humidIn;
	private int expectedCurrT;
	private int expectedTMax;
	private int expectedTmin;
	private String expectedTtrend;
	private int expectedHMax;
	private int expectedHMin;
	private int expectedCurrH;
	private String expectedHtrend;
	private String expectedHstatus;
	
	public secondParamTest(int tempIn, int humidIn, int expectedCurrT, int expectedTMax, int expectedTmin,
			String expectedTtrend, int expectedHMax, int expectedHMin, int expectedCurrH,
			String expectedHtrend, String expectedHstatus) {
		this.tempIn = tempIn;
		this.humidIn = humidIn;
		this.expectedCurrT = expectedCurrT;
		this.expectedTtrend = expectedTtrend;
		this.expectedTMax = expectedTMax;
		this.expectedTmin = expectedTmin;
		this.expectedHMax = expectedHMax;
		this.expectedHMin = expectedHMin;
		this.expectedCurrH = expectedCurrH;
		this.expectedHstatus = expectedHstatus;
		this.expectedHtrend = expectedHtrend;
	}
	
	@Test
	public void dataTestStyle2() {
		EmbeddedSensor.setHumid(humidIn);
		EmbeddedSensor.setTemp(tempIn);
		assertTrue("Max Temp", expectedTMax == EmbeddedSensor.maxTemp);
		assertTrue("Min Temp", expectedTmin == EmbeddedSensor.minTemp);
		assertTrue("Current Temp", expectedCurrT == EmbeddedSensor.currentTemp);
		assertTrue("Temp trend", expectedTtrend.equals(EmbeddedSensor.tempTrend()));
		assertTrue("Max Humidity", expectedHMax == EmbeddedSensor.maxHumid);
		assertTrue("Min Humidity", expectedHMin == EmbeddedSensor.minHumid);
		assertTrue("Current Humidity", expectedCurrH == EmbeddedSensor.currentHumidity);
		assertTrue("Humidity trend", expectedHtrend.equals(EmbeddedSensor.humidTrend()));
		assertTrue("Humidity Status", expectedHstatus.equals(EmbeddedSensor.humidStatus()));
	}

}
