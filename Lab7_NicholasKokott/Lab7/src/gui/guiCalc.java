package gui;

import javax.swing.*;

import observe.StringObserve;

import layout.CalcModel;
import layout.Button;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guiCalc implements StringObserve{

	public JFrame frame = new JFrame();
    JPanel panel = new JPanel(new FlowLayout());
    JPanel screen = new JPanel(new BorderLayout());
    JTextField text = new JTextField(15);
    
    JButton num0 = new JButton("0");
    JButton num1 = new JButton("1");
    JButton num2 = new JButton("2");
    JButton num3 = new JButton("3");
    JButton num4 = new JButton("4");
    JButton num5 = new JButton("5");
    JButton num6 = new JButton("6");
    JButton num7 = new JButton("7");
    JButton num8 = new JButton("8");
    JButton num9 = new JButton("9");
    
    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton mult = new JButton("x");
    JButton div = new JButton("/");
    
    JButton sqr = new JButton("sqr");
    JButton sqrt = new JButton("sqrt");
    
    JButton mem = new JButton("  M  ");
    JButton memPlus = new JButton("   M+   ");
    JButton memMin = new JButton("   M-   ");
    
    JButton equals = new JButton("=");
    JButton delete = new JButton("del");
    JButton clear = new JButton("C");
    JButton decimal = new JButton(".");
    JButton neg = new JButton("neg");
    JButton memClr = new JButton(" MemC ");
    
    private CalcModel model;
    
    public guiCalc(CalcModel calcModel) {
    	
    	this.model = calcModel;
    	
    	frame.setVisible(true); 
        frame.setSize(180,345);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        text.setSize(500, 30);
        panel.add(text, BorderLayout.NORTH);
        
        
        panel.add(num1);
        panel.add(num2);
        panel.add(num3);
        
        panel.add(num4);
        panel.add(num5);
        panel.add(num6);
        
        panel.add(num7);
        panel.add(num8);
        panel.add(num9);
        
        panel.add(num0);
        panel.add(neg);
        panel.add(decimal);
        
        panel.add(add);
        panel.add(sub);
        panel.add(sqr);
        
        panel.add(mult);
        panel.add(div);
        panel.add(sqrt);
        
        panel.add(mem);
        panel.add(memClr);
        
        panel.add(memPlus);
        panel.add(memMin);
        
        panel.add(delete);
        panel.add(clear);
        panel.add(equals);
        
        
        
        this.num0.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
                    	model.pressButton(Button.BUTTON_0);
                    }
            	}
            );
        this.num1.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_1);
                    }
            	}
            );
        this.num2.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_2);
                    }
            	}
            );
        this.num3.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_3);
                    }
            	}
            );
        this.num4.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_4);
                    }
            	}
            );
        this.num5.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_5);
                    }
            	}
            );
        this.num6.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_6);
                    }
            	}
            );
        this.num7.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_7);
                    }
            	}
            );
        this.num8.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_8);
                    }
            	}
            );
        this.num9.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_9);
                    }
            	}
            );
        
        this.neg.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_NEGATE);
                    }
            	}
            );
        
        this.add.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_ADD);
                    }
            	}
            );
        
        this.sub.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_SUB);
                    }
            	}
            );
        
        this.mult.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_MUL);
                    }
            	}
            );
        
        this.div.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_DIV);
                    }
            	}
            );
        
        this.decimal.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_DOT);
                    }
            	}
            );
        
        this.sqr.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_SQR);
                    }
            	}
            );
        
        this.sqrt.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_SRT);
                    }
            	}
            );
        
        this.delete.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_DEL);
                    }
            	}
            );
        
        this.clear.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_CLS);
                    }
            	}
            );
        
        this.equals.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_EQUAL);
                    }
            	}
            );
        
        this.mem.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_M_RECALL);
                    }
            	}
            );
        
        this.memPlus.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_M_PLUS);
                    }
            	}
            );
        
        this.memMin.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_M_MINUS);
                    }
            	}
            );
        
        this.memClr.addActionListener(
            	new ActionListener(){
            		@Override
                    public void actionPerformed(ActionEvent item) {
            			model.pressButton(Button.BUTTON_M_CLEAR);
                    }
            	}
            );
        /*
         * And so on...  TODO
         */

        
    }

	public void update(String d) {
		// Set the text of text to the string during a update event
		text.setText(d);
		
	}
}
