package layout;

import java.util.ArrayList;

import gui.guiCalc;
import observe.StringObserve;

public class TextEvaluator {

	private String value;
	private boolean isTempMessage; 
	private ArrayList<StringObserve> observers = new ArrayList<>();
	
	public TextEvaluator() {
		isTempMessage = false;
		value = "";
	}

	/**
	 * Adds an observer object to the register
	 * @param calc
	 */
	public void addObserver(StringObserve calc) {
		observers.add(calc);
	}
	
	/**
	 * Gets the value of the register
	 * @return Register value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the register
	 * @param value Register value
	 */
	public void setValue(String value) {
		if (isTempMessage) resetTempMessage();
		
		this.value = value;
		update(value);
	}
	
	public void addToValue(String addition) {
		if (isTempMessage) resetTempMessage();
		this.value += addition;
		update(value);
	}
	
	/*
	 * Sets the error flag for the register
	 * @param tempMessage The message to display
	 */
	public void setTempMessage(String tempMessage) {
		isTempMessage = true;
		update(tempMessage);
	}
	
	/*
	 * Resets the temporary flag for the register
	 */
	public void resetTempMessage() {
		isTempMessage = false;
		update(value);
	}
	
	/**
	 * Returns the status of the temporary flag
	 * @return Temporary flag
	 */
	public boolean isTempMessage() {
		return isTempMessage;
	}
	
	/**
	 * Update all observers depending on register state
	 * @param message Message to display to observers
	 */
	private void update(String message) {
		for (StringObserve ob : observers) ob.update(message);
	}
}
