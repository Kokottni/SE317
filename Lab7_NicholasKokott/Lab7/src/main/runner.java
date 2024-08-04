package main;

import gui.guiCalc;
import layout.CalcModel;

public class runner {

	public static void main(String[] args) {
		// Create calculate model
		CalcModel model = new CalcModel();
		
		// Create GUI
		guiCalc calc = new guiCalc(model);
		calc.frame.setVisible(true);
		
		// Bind calc to model
		model.getDisplay().addObserver(calc);
		
		// Clear all
		model.clearAll();
        
	}
}
