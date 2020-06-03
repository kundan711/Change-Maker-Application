package changeMaker;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class changeMaker extends JFrame implements ActionListener {
	
	//Define all variables used in the program

	JLabel toPayLabel, withLabel, dollarLabel, quarterLabel, dimeLabel, nickleLabel, pennyLabel;
	JTextField toPayTextField, withTextField, dollarTextField, quarterTextField, dimeTextField, nickleTextField, pennyTextField;
	JButton changeButton, clearButton;
	
	double topay, with, change;
	int  dollar, quarter, dime, nickel, penny;
	String stringValue, stringValue2, S1, S2, S3, S4, S5, S6, S7;
	int round;
	
	public changeMaker() {
		
		//Set Window 
		
		setSize(300, 400);
		setTitle("Change Maker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(8, 2));
		
		//Defines all JLabel.
		
		toPayLabel = new JLabel("To pay", JLabel.CENTER);
		withLabel = new JLabel("With", JLabel.CENTER);
		dollarLabel = new JLabel("Dollar   ", JLabel.RIGHT);
		quarterLabel = new JLabel("Quarter   ", JLabel.RIGHT);
		dimeLabel = new JLabel("Dime   ", JLabel.RIGHT);
		nickleLabel = new JLabel("Nickel   ", JLabel.RIGHT);
		pennyLabel = new JLabel("Penny   ", JLabel.RIGHT);
		
		//Defines all JTextField.
		
		toPayTextField = new JTextField();
		withTextField = new JTextField();
		dollarTextField = new JTextField();
		dollarTextField.setEditable(false);
		quarterTextField = new JTextField();
		quarterTextField.setEditable(false);
		dimeTextField = new JTextField();
		dimeTextField.setEditable(false);
		nickleTextField = new JTextField();
		nickleTextField.setEditable(false);
		pennyTextField = new JTextField();
		pennyTextField.setEditable(false);
		
		//Defines all JButton.
		
		changeButton = new JButton("Change");
		clearButton = new JButton("Clear");
		
		//Add listeners to the buttons.
		
		changeButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		//add all the variables to the program.
		
		add(toPayLabel);
		add(withLabel);
		add(toPayTextField);
		add(withTextField);
		add(changeButton);
		add(clearButton);
		add(dollarLabel);
		add(dollarTextField);
		add(quarterLabel);
		add(quarterTextField);
		add(dimeLabel);
		add(dimeTextField);
		add(nickleLabel);
		add(nickleTextField);
		add(pennyLabel);
		add(pennyTextField);
		
		//Display();
		
		setVisible(true);
	}
	
	//Listener Method
	public void actionPerformed (ActionEvent ae) {
		Object ob = ae.getSource();
		if (ob == changeButton) {
			calculate();
		}
		else if (ob == clearButton) {
			reset();
		}
	}
	
	//Calculation Method
	public void calculate() {
		
		//Gets value from user
		stringValue = toPayTextField.getText();
		stringValue2 = withTextField.getText();
				
		//Calculation part
		topay = Double.parseDouble(stringValue);
		with = Double.parseDouble(stringValue2);
		change = with - topay;
		
		round = (int) Math.round(change * 100);
		dollar = round / 100;
		penny = round % 100;
		quarter = penny / 25;
		penny = penny % 25;
		dime = penny / 10;
		penny = penny % 10;
		nickel = penny / 5;
		penny = penny % 5;
		
		//Changes the numbers into strings
		S1 = "" + topay;
		S2 = "" + with;
		S3 = "" + dollar;
		S4 = "" + quarter;
		S5 = "" + dime;
		S6 = "" + nickel;
		S7 = "" + penny;
		
		//Adds the string to their respective text fields.
		toPayTextField.setText(S1);
		withTextField.setText(S2);
		dollarTextField.setText(S3);
		quarterTextField.setText(S4);
		dimeTextField.setText(S5);
		nickleTextField.setText(S6);
		pennyTextField.setText(S7);
		
	}
	
	//Resets the program
	public void reset() {
		
		//Erases every value
		toPayTextField.setText("");
		withTextField.setText("");
		dollarTextField.setText("");
		quarterTextField.setText("");
		dimeTextField.setText("");
		nickleTextField.setText("");
		pennyTextField.setText("");
	}
	
	//Executes the program
	public static void main(String args[]) {
		new changeMaker();
	}

	
}