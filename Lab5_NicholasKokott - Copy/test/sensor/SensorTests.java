package sensor;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.parameterized.*;

@RunWith(Parameterized.class)
public class SensorTests {
	private EmbeddedSensor e;
	
	@Before
	public void create() {
		e = new EmbeddedSensor();
		e.reset();
	}
	
	@Test
	public void tempTest() {
		e.setTemp(12);
		e.setTemp(56);
		assertTrue(e.currentTemp == 56);
		assertTrue(e.maxTemp == 56);
		assertTrue(e.minTemp == 12);
		assertTrue(e.tempTrend().equals("Up"));
	}
	
	@Test
	public void humidTest() {
		e.setHumid(76);
		e.setHumid(11);
		assertTrue(e.currentHumidity == 11);
		assertTrue(e.minHumid == 11);
		assertTrue(e.maxHumid == 76);
		assertTrue(e.humidStatus().equals("Low"));
		assertTrue(e.humidTrend().equals("Down"));
	}
	
}
