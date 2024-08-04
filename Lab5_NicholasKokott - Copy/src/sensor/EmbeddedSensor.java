package sensor;

import java.util.Scanner;

class runner{
	public static void main(String[] args) {
		int inVal = 0;
		Scanner in = new Scanner(System.in);
		EmbeddedSensor e = new EmbeddedSensor();
		while(true) {
			System.out.println("Hello user! Please enter the following data.");
			System.out.println("Would you like to reset the system (0 for yes and 1 for no)");
			int answer = in.nextInt();
			if(answer == 0) {
				e.reset();
			}
			System.out.println("What is your temperature reading?");
			inVal = in.nextInt();
			e.setTemp(inVal);
			System.out.println("What is your humidity reading?");
			inVal = in.nextInt();
			e.setHumid(inVal);
			if(inVal < 0) {break;}
			System.out.println(e.output());
			//This will got on a loop constantly with a one minute interval between each given reading
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

public class EmbeddedSensor {

	public static int currentHumidity;
	public static int prevCurrHumid;
	public static int minHumid;
	public static int maxHumid;
	public static int currentTemp;
	public static int prevCurrTemp;
	public static int minTemp;
	public static int maxTemp;
	public static int started;
	public static String humidityTrend;
	public static String temperatureTrend;
	
	public EmbeddedSensor() {
		currentHumidity = 0;
		minHumid = 0;
		maxHumid = 0;
		currentTemp = 0;
		minTemp = 0;
		maxTemp = 0;
		started = 0;
		humidityTrend = "";
		temperatureTrend = "";
	}
	
	public EmbeddedSensor(int humid, int temp) {
		currentHumidity = prevCurrHumid = humid;
		minHumid = humid;
		maxHumid = humid;
		currentTemp = prevCurrTemp = temp;
		minTemp = temp;
		maxTemp = temp;
		started = 0;
		humidityTrend = "";
		temperatureTrend = "";
	}
	
	public static String humidTrend() {
		String trend;
		if(currentHumidity > prevCurrHumid) {
			trend = "Up";
		}else if(currentHumidity < prevCurrHumid) {
			trend = "Down";
		}else {
			trend = "Stable";
		}
		return trend;
	}
	
	public static String tempTrend() {
		String trend;
		if(currentTemp > prevCurrTemp) {
			trend = "Up";
		}else if(currentTemp < prevCurrTemp) {
			trend = "Down";
		}else {
			trend = "Stable";
		}
		return trend;
	}
	
	public static String humidStatus() {
		String check;
		if(currentHumidity < 55 && currentHumidity > 25) {
			check = "OK";
		}else if(currentHumidity >= 55) {
			check = "High";
		}else {
			check = "Low";
		}
		return check;
	}
	
	public void reset() {
		minHumid = maxHumid = currentHumidity;
		minTemp = maxTemp = currentTemp;
		started = 0;
	}
	
	public static void setHumid(int humid) {
		prevCurrHumid = currentHumidity;
		currentHumidity = humid;
		if(started == 0) {
			prevCurrHumid = humid;
		}
		if(humid > maxHumid || maxHumid == 0) {
			maxHumid = humid;
		}if(humid < minHumid || minHumid == 0) {
			minHumid = humid;
		}
	}

	public static void setTemp(int temp) {
		prevCurrTemp = currentTemp;
		currentTemp = temp;
		if(started == 0) {
			prevCurrTemp = temp;
		}
		if(temp > maxTemp || maxTemp == 0) {
			maxTemp = temp;
		}if(temp < minTemp || minTemp == 0) {
			minTemp = temp;
		}
		started = 1;
	}
	
	/*
	 * This is the refactored part of my code
	 * I am leaving the previous parts of my code to show where I got my merged portions from
	 */
	//My refactoring for the inputs and calculation of the min, max, and trend of both temperature and humidity
	public void doAllTempandHumidCalculations(int temp, int humid) {
		//Temperature calculations happen in this chunk for min and max.
		prevCurrTemp = currentTemp;
		currentTemp = temp;
		if(started == 0) {
			prevCurrTemp = temp;
		}
		if(temp > maxTemp || maxTemp == 0) {
			maxTemp = temp;
		}if(temp < minTemp || minTemp == 0) {
			minTemp = temp;
		}
		//Humidity calculations happen in this chunk for min and max.
		prevCurrHumid = currentHumidity;
		currentHumidity = humid;
		if(started == 0) {
			prevCurrHumid = humid;
		}
		if(humid > maxHumid || maxHumid == 0) {
			maxHumid = humid;
		}if(humid < minHumid || minHumid == 0) {
			minHumid = humid;
		}
		started = 1;
		//The trend calculations begin here
		//This is the humidity trend calculation
		if(currentHumidity < 55 && currentHumidity > 25) {
			humidityTrend = "OK";
		}else if(currentHumidity >= 55) {
			humidityTrend = "High";
		}else {
			humidityTrend = "Low";
		}
		//This is the temperatureTrend calculation
		if(currentTemp > prevCurrTemp) {
			temperatureTrend = "Up";
		}else if(currentTemp < prevCurrTemp) {
			temperatureTrend = "Down";
		}else {
			temperatureTrend = "Stable";
		}
	}
	
	public String output() {
		String output;
		output = "For Relative Humidity: \n 1. Current Humidity: " + currentHumidity + "% \n 2. Max Humidity: " + maxHumid + "% \n"
				+ "3. Minimum Humidity: " + minHumid + "% \n 4. Humidity Trend: " + humidTrend() + "\n 5. Humidity Check: " + humidStatus() +
				"\n For Temperature: \n 1. Current Temperature: " + currentTemp + " degrees. \n 2. Maximum Temp: " + maxTemp + " degrees \n"
						+ "3. Minumum Temp: " + minTemp + " degrees. \n 4. Temperature Trend: " + tempTrend();
		return output;
	}
	
}
