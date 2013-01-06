import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CarRentalCal extends JFrame {

	// JTextField
	
	JTextField jtfPurchase = new JTextField();
	JTextField jtfTotalDays = new JTextField();
	JTextArea jtaDailyRental = new JTextArea(7, 20);
	int totalDays = 0;
	double purchase = 0;
	double dailyRental = 0;
	JPanel scrollPanel = new JPanel(new GridLayout(0,2));
	JPanel mainPanel = new JPanel(new GridLayout(0, 2));
	
	JScrollBar totalDaysScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
	
	JScrollPane dailyRentalScrollPane = new JScrollPane(jtaDailyRental);

	public CarRentalCal() {
		this.setLayout(new BorderLayout());
		this.setTitle("Car Rental Cal");
		
		mainPanel.add(new JLabel("Purchase Price:"));
		mainPanel.add(jtfPurchase);
		jtfPurchase.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				try {
					purchase = Integer.parseInt(jtfPurchase.getText());
					dailyRental = purchase / 1000;
				} catch (NumberFormatException ex) {
					jtfPurchase.setText("Please input a number");
				}
			}

		});

		mainPanel.add(new JLabel("Total Rental Days:"));
		mainPanel.add(jtfTotalDays);
		jtfTotalDays.setEditable(false);
		totalDaysScrollBar.setVisibleAmount(0);
		totalDaysScrollBar.setMaximum(365);
		totalDaysScrollBar.setMinimum(1);
		totalDaysScrollBar.setUnitIncrement(1);
		totalDaysScrollBar.setValue(0);
		jtfTotalDays.setText("" + 1);
		totalDaysScrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				// TODO Auto-generated method stub
				jtfTotalDays.setText("" + totalDaysScrollBar.getValue());
				totalDays = totalDaysScrollBar.getValue();
				jtaDailyRental.setText("");
				double dailyRentalCopy = dailyRental;

				for (int i = 0; i < totalDays; i++) {
					if (i > 0 && i % 7 == 0) {
						dailyRentalCopy = dailyRentalCopy * 0.9;
					}
					jtaDailyRental.setText(jtaDailyRental.getText()+"Day "+(i+1)+" price: "
							+ dailyRentalCopy + "\n");
					
				}

			}

		});
		mainPanel.add(new JLabel(""));
		mainPanel.add(totalDaysScrollBar);
		scrollPanel.add(new JLabel("Daily Rental Price:"));
		jtaDailyRental.setEditable(false);
		scrollPanel.add(dailyRentalScrollPane);
		this.add(mainPanel, BorderLayout.NORTH);
		this.add(scrollPanel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarRentalCal myCarRentalCal = new CarRentalCal();
	}

}
