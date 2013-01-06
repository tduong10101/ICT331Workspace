package Tutorial_8_1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MaximumCal extends JFrame {
	
	int monthlyRepay;
	int year;
	int maximumLoan;
	JTextField jtfMonthlyRepay = new JTextField();
	JTextField jtfYear = new JTextField();
	JTextField jtfMaximumLoan = new JTextField();
	JButton jbCancel = new JButton("Cancel");
	JButton jbCal = new JButton("Calculate");
	boolean btestFocus = false;
	
	public MaximumCal (){
		this.setTitle("Maximum Loan Calculation");
		this.setLayout(new GridLayout(0,2));
		this.add(new JLabel("Monthly repayment:"));
		this.add(jtfMonthlyRepay);
		FocusListener testFocus = new FocusListener(){
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
					if (arg0.getSource()== jtfMonthlyRepay){
						try{
							monthlyRepay = Integer.parseInt(jtfMonthlyRepay.getText());
						} catch (NumberFormatException ex) {
							if (btestFocus == true){
								JOptionPane.showMessageDialog(null, "Please input an Integer!");
								
							}
							btestFocus = false;
						}
					}
					else if (arg0.getSource()== jtfYear){
						try{
							year = Integer.parseInt(jtfYear.getText());
						} catch (NumberFormatException ex) {
							if (btestFocus == true){
								JOptionPane.showMessageDialog(null, "Please input an Integer!");
								
							}
							btestFocus = false;
						}
						
					}
				
			}
			
		};
		jtfMonthlyRepay.addFocusListener(testFocus);
				
		this.add(new JLabel("Year:"));
		this.add(jtfYear);
		
		jtfYear.addFocusListener(testFocus);
		
		this.add(new JLabel("Maximum loan:"));
		jtfMaximumLoan.setEditable(false);
		this.add(jtfMaximumLoan);
		this.add(jbCal);
		jbCal.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				maximumLoan = year*monthlyRepay*12;
				jtfMaximumLoan.setText(""+maximumLoan);
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(jbCancel);
		jbCancel.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				jtfMonthlyRepay.setText("");
				jtfYear.setText("");
				jtfMaximumLoan.setText("");
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.pack();
		this.setVisible(true);
		
	}
	public static void main (String [] args){
		MaximumCal myMaximumCal = new MaximumCal();
	}
}
