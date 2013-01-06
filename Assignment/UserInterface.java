import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class UserInterface extends JFrame {
	//ArrayList
	ArrayList custList = new ArrayList();
	
	//TextField
	JTextField name = new JTextField();
	JTextField address = new JTextField();
	JTextField city = new JTextField();
	JTextField state = new JTextField();
	JTextField country = new JTextField();
	
	//JPanel
	JPanel centerPanel = new JPanel(new GridLayout(0,2));
	JPanel jpRadioButton = new JPanel(new GridLayout(1,0));
	JPanel jpCheckBox = new JPanel (new GridLayout(1,0));
	
	//JLabel
	JLabel jlCustSelect = new JLabel("Customer Select:");
	JLabel jlShipping  = new JLabel ("Shipping:");
	JLabel jlCountry = new JLabel ("Country:");
	JLabel jlFreight = new JLabel ("Freight forwarder:");
	
	
	
	
	//JComBox
	JComboBox jcbCust = new JComboBox(custList.toArray());
	JComboBox jcbShipping = new JComboBox(new String[]{"Air","Road","Rail"});
	
	//RadioButton
	JRadioButton rbDomestic = new JRadioButton("Domestic", true);
	JRadioButton rbImport = new JRadioButton("Importer", false);
	
	//Group
	ButtonGroup group = new ButtonGroup();
	
	//JCheckBox
	JCheckBox inspection = new JCheckBox("Inspection");
	JCheckBox fumigation = new JCheckBox("Fumigation");
	
	//JMenuBar
	JMenuBar jmbMain = new JMenuBar();
	
	//JMenu
	JMenu newSubM = new JMenu("New");
	JMenu openSubM = new JMenu("Open");
	JMenu saveSubM = new JMenu("Save");
	JMenu orderSubM = new JMenu ("Orders");
	JMenu custSubM = new JMenu ("Customers");
	JMenu fileMenu = new JMenu("File");
	JMenu editMenu = new JMenu("Edit");
	
	//String
	String CustOrder = "Customers and Orders";
	String FlowerVar = "Flower Varieties";
	
	//JMenuItem
	JMenuItem oAdd = new JMenuItem("Add");
	JMenuItem oEdit = new JMenuItem("Edit");
	JMenuItem oDelete = new JMenuItem("Delete");
	
	JMenuItem cAdd = new JMenuItem("Add");
	JMenuItem cEdit = new JMenuItem("Edit");
	JMenuItem cDelete = new JMenuItem("Delete");
	
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem nCustOrder = new JMenuItem (CustOrder);
	JMenuItem nVariety = new JMenuItem (FlowerVar);
	JMenuItem oCustOrder = new JMenuItem (CustOrder);
	JMenuItem oVariety = new JMenuItem (FlowerVar);
	JMenuItem sCustOrder = new JMenuItem (CustOrder);
	JMenuItem sVariety = new JMenuItem (FlowerVar);
	
	public UserInterface(){
		
		custList.add("NoX");
		custList.add("Zor");
		custList.add("blah");
		
		
		this.setLayout(new BorderLayout());
		this.setSize(400, 300);
		
		newSubM.add(nCustOrder);
		newSubM.add(nVariety);
		openSubM.add(oCustOrder);
		openSubM.add(oVariety);
		saveSubM.add(sCustOrder);
		saveSubM.add(sVariety);
		
		fileMenu.add(newSubM);
		fileMenu.add(openSubM);
		fileMenu.add(saveSubM);
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		orderSubM.add(oAdd);
		orderSubM.add(oEdit);
		orderSubM.add(oDelete);
		custSubM.add(cAdd);
		custSubM.add(cEdit);
		custSubM.add(cDelete);
		editMenu.add(orderSubM);
		editMenu.add(custSubM);
		
		jmbMain.add(fileMenu);
		jmbMain.add(editMenu);
		this.add(jmbMain, BorderLayout.NORTH);
		
		
		
		//Create radio button for Domestic and Import Customer
		
		jpRadioButton.add(rbDomestic);
		jpRadioButton.add(rbImport);
		group.add(rbDomestic);
		group.add(rbImport);
		
		
		centerPanel.add(jlCustSelect);
		centerPanel.add(jcbCust);
		centerPanel.add(new JLabel("Customer Type:"));
		centerPanel.add(jpRadioButton);
		centerPanel.add(new JLabel ("Name:"));
		centerPanel.add(name);
		centerPanel.add(new JLabel ("Address:"));
		centerPanel.add(address);
		centerPanel.add(new JLabel ("City:"));
		centerPanel.add(city);
		centerPanel.add(new JLabel ("State:"));
		centerPanel.add(state);
		
		//Text field name, address, city, state
		jpCheckBox.add(inspection);
		jpCheckBox.add(fumigation);
		
	
		
		//Create a shipping combo box
		centerPanel.add(jlCountry).setVisible(false);
		centerPanel.add(country).setVisible(false);
		centerPanel.add(jlShipping).setVisible(true);
		centerPanel.add(jcbShipping).setVisible(true);
		
		rbDomestic.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				centerPanel.remove(jlFreight);
				centerPanel.remove(jpCheckBox);
				centerPanel.validate();
				centerPanel.add(jlShipping).setVisible(true);
				centerPanel.add(jcbShipping).setVisible(true);
				
				jlCountry.setVisible(false);
				country.setVisible(false);
				
			}
			
		});
		
		rbImport.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				centerPanel.remove(jlShipping);
				centerPanel.remove(jcbShipping);
				centerPanel.validate();
				
				jlCountry.setVisible(true);
				country.setVisible(true);
				centerPanel.add(jlFreight).setVisible(true);
				centerPanel.add(jpCheckBox).setVisible(true);
				
			}
			
		});
		
		//Create button in the corner of the frame 
		JPanel bPanel = new JPanel (new GridLayout(1,0));
		bPanel.add(new JLabel());
		JButton button1 = new JButton("Button");
		bPanel.add(button1);
		this.add(bPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
}
