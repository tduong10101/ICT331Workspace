package Tutorial_9;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class ShippingOptions extends JFrame{
	JList jlstWrap = new JList(new String[]{"Wrapped","Card Include"});
	JTextArea jtaMessage = new JTextArea();
	JPanel jpShippingType = new JPanel();
	JPanel jpCenter = new JPanel();
	JRadioButton jrbSea = new JRadioButton("Sear Parcel");
	JRadioButton jrbAir = new JRadioButton("Economiy Air");
	JRadioButton jrbCourier = new JRadioButton("Express Courier");
	ButtonGroup gShipping = new ButtonGroup();
	
	public ShippingOptions(){
		this.setTitle("Shipping Options");
		this.setLayout(new BorderLayout());
		this.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(0,2));
		jpCenter.add(new JLabel ("Wrapping Options:"));
		jpCenter.add(jlstWrap);
		jpCenter.add(new JLabel("Message for recipient:"));
		jpCenter.add(jtaMessage);
		
		gShipping.add(jrbSea);
		gShipping.add(jrbAir);
		gShipping.add(jrbCourier);
		jpShippingType.add(jrbSea);
		jpShippingType.add(jrbAir);
		jpShippingType.add(jrbCourier);
		
		this.add(jpShippingType, BorderLayout.SOUTH);
		Border myBorder = BorderFactory.createLineBorder(Color.lightGray);
		TitledBorder myTitle = BorderFactory.createTitledBorder(myBorder ,"Shipping Type");

		jpShippingType.setBorder(myTitle);


		this.pack();
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShippingOptions myShippingOptions = new ShippingOptions();
	}

}
