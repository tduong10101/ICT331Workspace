import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;

import javax.swing.*;

public class UserInterface extends JFrame {

	// Create String path and JFileChooser
	String path;
	JFileChooser jfcOpenCustOrder = new JFileChooser(
			"H:\\eclipse\\ICT331Workspace\\Customers And Orders");
	JFileChooser jfcSaveCustOrder = new JFileChooser(
			"H:\\eclipse\\ICT331Workspace\\Customers And Orders");
	JFileChooser jfcOpenFlowerVar = new JFileChooser(
			"H:\\eclipse\\ICT331Workspace\\Flower Varieties");
	JFileChooser jfcSaveFlowerVar = new JFileChooser(
			"H:\\eclipse\\ICT331Workspace\\Flower Varieties");
	CustomerOrdersManager myCustOrder = new CustomerOrdersManager();

	// String Array
	String[] defaultVariety = { "Banksia", "Kangaroo Paw", "Leucodendron" };

	// TextField
	JTextField jtfName = new JTextField();
	JTextField jtfAddress = new JTextField();
	JTextField jtfCity = new JTextField();
	JTextField jtfState = new JTextField();
	JTextField jtfCountry = new JTextField();
	JTextField jtfQuanReq = new JTextField();
	JTextField jtfQuanSup = new JTextField();
	JTextField jtfStartDate = new JTextField();
	JTextField jtfEndDate = new JTextField();

	// JPanel
	JPanel jpCustomer = new JPanel(new GridLayout(0, 2));
	JPanel jpOrder = new JPanel(new BorderLayout());
	JPanel jpRadioButton = new JPanel(new GridLayout(1, 0));
	JPanel jpCheckBox = new JPanel(new GridLayout(1, 0));
	JPanel jpLable = new JPanel(new GridLayout(0, 1));
	JPanel jpOrderTextField = new JPanel(new GridLayout(0, 1));
	JPanel jpCustButton = new JPanel(new GridLayout(1, 0));

	// JLabel
	JLabel jlCustSelect = new JLabel("Customer Select:");
	JLabel jlOrderSelect = new JLabel("Order Select:");
	JLabel jlShipping = new JLabel("Shipping:");
	JLabel jlCountry = new JLabel("Country:");
	JLabel jlFreight = new JLabel("Freight forwarder:");

	// JButton
	JButton jbCust = new JButton("Button");
	JButton jbOrder = new JButton("Button");

	// JComBox
	JComboBox jcbCust = new JComboBox();
	JComboBox jcbOrderCust = new JComboBox();
	JComboBox jcbOrder = new JComboBox();
	JComboBox jcbVariety = new JComboBox();
	JComboBox jcbShipping = new JComboBox(
			new String[] { "Air", "Road", "Rail" });

	ArrayList<Customer> customer = new ArrayList<Customer>();

	// RadioButton
	JRadioButton jrbDomestic = new JRadioButton("Domestic", true);
	JRadioButton jrbImport = new JRadioButton("Importer", false);

	// Group
	ButtonGroup jrbGroup = new ButtonGroup();

	// JCheckBox
	JCheckBox jcbInspection = new JCheckBox("Inspection");
	JCheckBox jcbFumigation = new JCheckBox("Fumigation");

	// JMenuBar
	JMenuBar jmbMain = new JMenuBar();

	// JMenu
	JMenu jmNew = new JMenu("New");
	JMenu jmOpen = new JMenu("Open");
	JMenu jmSave = new JMenu("Save");
	JMenu jmOrder = new JMenu("Orders");
	JMenu jmCust = new JMenu("Customers");
	JMenu jmFile = new JMenu("File");
	JMenu jmEdit = new JMenu("Edit");

	// String
	String CustOrder = "Customers and Orders";
	String FlowerVar = "Flower Varieties";
	String date = "";

	// Int
	int quanReq = 0;
	int quanSup = 0;
	int x = 0;
	int year = 0;
	int month = 0;
	int day = 0;

	// GregorianCalendar
	GregorianCalendar startDateG = new GregorianCalendar();
	GregorianCalendar endDateG = new GregorianCalendar();

	// JMenuItem
	JMenuItem jmiOrderAdd = new JMenuItem("Add");
	JMenuItem jmiOrderEdit = new JMenuItem("Edit");
	JMenuItem jmiOrderDelete = new JMenuItem("Delete");

	JMenuItem jmiCustAdd = new JMenuItem("Add");
	JMenuItem jmiCustEdit = new JMenuItem("Edit");
	JMenuItem jmiCustDelete = new JMenuItem("Delete");

	JMenuItem jmiExit = new JMenuItem("Exit");
	JMenuItem jmiNewCustOrder = new JMenuItem(CustOrder);
	JMenuItem jmiNewVariety = new JMenuItem(FlowerVar);
	JMenuItem jmiOpenCustOrder = new JMenuItem(CustOrder);
	JMenuItem jmiOpenVariety = new JMenuItem(FlowerVar);
	JMenuItem jmiSaveCustOrder = new JMenuItem(CustOrder);
	JMenuItem jmiSaveVariety = new JMenuItem(FlowerVar);

	// Boolean
	boolean numberCheck = false;

	public UserInterface() {

		this.setLayout(new BorderLayout());
		this.setSize(400, 300);
		this.setTitle("Ausbloom Management System");

		// set up JMenu
		jmFile.setMnemonic('F');
		jmEdit.setMnemonic('E');
		jmNew.setMnemonic('N');
		jmOpen.setMnemonic('O');
		jmSave.setMnemonic('S');

		jmiExit.setMnemonic('x');
		jmiExit.setAccelerator(KeyStroke.getKeyStroke('X', CTRL_DOWN_MASK));
		jmiNewCustOrder.setMnemonic('C');
		jmiNewVariety.setMnemonic('F');
		jmiOpenCustOrder.setMnemonic('C');
		jmiOpenVariety.setMnemonic('F');
		jmiSaveCustOrder.setMnemonic('C');
		jmiSaveVariety.setMnemonic('F');
		jmOrder.setMnemonic('O');
		jmCust.setMnemonic('C');

		jmiOrderAdd.setMnemonic('A');
		jmiOrderEdit.setMnemonic('E');
		jmiOrderDelete.setMnemonic('D');

		jmiCustAdd.setMnemonic('A');
		jmiCustEdit.setMnemonic('E');
		jmiCustDelete.setMnemonic('D');

		jmNew.add(jmiNewCustOrder);
		jmNew.add(jmiNewVariety);
		jmOpen.add(jmiOpenCustOrder);
		jmOpen.add(jmiOpenVariety);
		jmSave.add(jmiSaveCustOrder);
		jmSave.add(jmiSaveVariety);

		jmFile.add(jmNew);
		jmFile.add(jmOpen);
		jmFile.add(jmSave);
		jmFile.add(jmiExit);

		jmiExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});

		jmOrder.add(jmiOrderAdd);
		jmOrder.add(jmiOrderEdit);
		jmOrder.add(jmiOrderDelete);
		jmCust.add(jmiCustAdd);
		jmCust.add(jmiCustEdit);
		jmCust.add(jmiCustDelete);
		jmEdit.add(jmOrder);
		jmEdit.add(jmCust);

		jmbMain.add(jmFile);
		jmbMain.add(jmEdit);
		this.add(jmbMain, BorderLayout.NORTH);

		// Set up InputVerifier for each textbox
		jtfName.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				// TODO Auto-generated method stub
				if ((!jtfName.getText().equals(""))&&(jcbCust.isVisible())){
					return true;
				}else{
				boolean nameCheck = nameCheck();
				return nameCheck;
				}
			}

		});
		// String Verifier ensure text contain more than 0 character
		jtfAddress.setInputVerifier(new StringVerifier());
		jtfCity.setInputVerifier(new StringVerifier());
		jtfCountry.setInputVerifier(new StringVerifier());

		// StateCheck ensure input of state is ACT, NSW, NT, QLD, SA, TAS, VIC,
		// WA
		jtfState.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent input) {
				// TODO Auto-generated method stub
				boolean stateCheck = stateCheck();
				return stateCheck;
			}

		});

		// input verifier ensure input of jtfQuanReq is an integer greater than
		// 0 and quantity supplied
		jtfQuanReq.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent arg0) {
				try {
					quanReq = Integer.parseInt(jtfQuanReq.getText());
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(null,
									"Quantity required must be an integer greater than 0!");
					return false;
				}
				if (quanReq < 0) {
					JOptionPane
							.showMessageDialog(null,
									"Quantity required must be an integer greater than 0!");
					return false;
				} else if ((!jtfQuanSup.getText().equals(""))
						&& (quanReq < quanSup)) {
					JOptionPane
							.showMessageDialog(null,
									"Quantity requried must not be less than quantity supplied!");
					return false;
				}
				return true;
			}

		});

		// input verifier ensure input of jtfQuanSup is an integer greater than
		// 0 and not greater than quantity required
		jtfQuanSup.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent arg0) {
				// TODO Auto-generated method stub
				try {
					quanSup = Integer.parseInt(jtfQuanSup.getText());
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(null,
									"Quantity supplied must be an integer greater than 0!");
					return false;
				}
				if (quanSup < 0) {
					JOptionPane
							.showMessageDialog(null,
									"Quantity supplied must be an integer greater than 0!");
					return false;
				} else if ((!jtfQuanReq.getText().equals(""))
						&& (quanReq < quanSup)) {
					JOptionPane
							.showMessageDialog(null,
									"Quantity supplied must not be greater than quantity required!");
					return false;
				}
				return true;
			}

		});

		// Validate start date in dd/mm/yy format and can not be less than end
		// date
		jtfStartDate.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent arg0) {
				// TODO Auto-generated method stub
				try {
					startDateG = convertDate(jtfStartDate);
					if ((!jtfEndDate.getText().equals(""))
							&& (startDateG.after(endDateG))) {
						JOptionPane
								.showMessageDialog(null,
										"Start date must not occur after end date! Please input correct value!");
						return false;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage()
							+ "\nPlease enter the start date value again!");
					return false;
				}
				return true;
			}

		});

		// Validate end date in dd/mm/yy format and can not be greater than
		// start date
		jtfEndDate.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent arg0) {
				// TODO Auto-generated method stub
				try {
					endDateG = convertDate(jtfEndDate);
					if ((!jtfStartDate.getText().equals(""))
							&& (startDateG.after(endDateG))) {
						JOptionPane
								.showMessageDialog(null,
										"End date must not occur before start date! Please input correct value!");
						return false;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage()
							+ "\nPlease enter the end date value again!");
					return false;
				}
				return true;
			}

		});

		// JPanel Customer Add
		// ------------------------------------

		// Create radio button for Domestic and Import Customer

		jpRadioButton.add(jrbDomestic);
		jpRadioButton.add(jrbImport);
		jrbGroup.add(jrbDomestic);
		jrbGroup.add(jrbImport);

		// Text field name, address, city, state
		jpCustomer.add(jlCustSelect).setVisible(false);
		jpCustomer.add(jcbCust).setVisible(false);
		jpCustomer.add(new JLabel("Customer Type:"));
		jpCustomer.add(jpRadioButton);
		jpCustomer.add(new JLabel("Name:"));
		jpCustomer.add(jtfName);
		jpCustomer.add(new JLabel("Address:"));
		jpCustomer.add(jtfAddress);
		jpCustomer.add(new JLabel("City:"));
		jpCustomer.add(jtfCity);
		jpCustomer.add(new JLabel("State:"));
		jpCustomer.add(jtfState);

		// set up jpCheckBox

		jpCheckBox.add(jcbInspection);
		jpCheckBox.add(jcbFumigation);

		// Create a shipping combo box
		jpCustomer.add(jlCountry).setVisible(false);
		jpCustomer.add(jtfCountry).setVisible(false);
		jpCustomer.add(jlShipping).setVisible(true);
		jpCustomer.add(jcbShipping).setVisible(true);

		addSouth(jpCustButton);
		jpCustButton.setVisible(false);

		// set up jradiobox Domestic to show the right text box when it is
		// selected
		jrbDomestic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				jpCustomer.remove(jlFreight);
				jpCustomer.remove(jpCheckBox);
				validate();
				jpCustomer.add(jlShipping).setVisible(true);
				jpCustomer.add(jcbShipping).setVisible(true);
				validate();
				jlCountry.setVisible(false);
				jtfCountry.setVisible(false);
				validate();

			}

		});

		// set up jradiobox Import to show the right text box when it is
		// selected
		jrbImport.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				jpCustomer.remove(jlShipping);
				jpCustomer.remove(jcbShipping);
				validate();
				jlCountry.setVisible(true);
				jtfCountry.setVisible(true);
				jpCustomer.add(jlFreight).setVisible(true);
				jpCustomer.add(jpCheckBox).setVisible(true);
				validate();

			}

		});

		// If customer edit select display cust combo box and cust info
		jmiCustEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jcbCustItemAdd();
				removePanel(jpOrder);
				validate();
				addCenter(jpCustomer);
				jpCustButton.setVisible(true);
				jlCustSelect.setVisible(true);
				jcbCust.setVisible(true);
				enable = true;
				setEnable();
				setCustInfo();
				jcbCust.addItemListener(setCustInfo);
				jbCust.setText("Edit");
				validate();
			}

		});

		// If customer add select hide cust combo box and clear all the field
		jmiCustAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				removePanel(jpOrder);
				validate();
				addCenter(jpCustomer);
				jpCustButton.setVisible(true);
				jlCustSelect.setVisible(false);
				jcbCust.setVisible(false);
				enable = true;
				setEnable();
				jrbDomestic.setSelected(true);
				jbCust.setText("Add");
				jcbCust.removeItemListener(setCustInfo);
				setTextNull();
				validate();
			}

		});

		// If customer del select show cust combo and set editable of all
		// field false

		jmiCustDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jcbCustItemAdd();
				removePanel(jpOrder);
				validate();
				addCenter(jpCustomer);
				jpCustButton.setVisible(true);
				jlCustSelect.setVisible(true);
				jcbCust.setVisible(true);
				enable = false;
				setEnable();
				setCustInfo();
				jcbCust.addItemListener(setCustInfo);
				jbCust.setText("Delete");
				validate();

			}

		});
		// set text box enable display when jcb cust change
		jcbCust.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setEnable();
			}

		});

		addCenter(jpCustomer);
		jpCustButton.setVisible(true);
		jlCustSelect.setVisible(false);
		jcbCust.setVisible(false);
		enable = true;
		setEnable();
		jrbDomestic.setSelected(true);
		jbCust.setText("Add");
		myCustOrder = new CustomerOrdersManager();
		setTextNull();

		// set up Customer jbutton
		jbCust.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					// if domestic customer radio button select and jcombo
					// customer is not show
					// jbCust action is add Domestic customer
					if (jrbDomestic.isSelected()
							&& (jcbCust.isVisible() == false)) {
						myCustOrder.addCustomer(DomesticCust());

					}
					// if import customer radio button select and jcombo
					// customer is not show
					// jbCust action is add Import customer
					else if (jrbDomestic.isSelected() == false
							&& (jcbCust.isVisible() == false)) {
						myCustOrder.addCustomer(ImportCust());

					}
					// if domestic customer radio button select and jcombo
					// customer is show and textbox is enable
					// jbCust action is edit/update Domestic customer
					else if (jrbDomestic.isSelected()
							&& (jcbCust.isVisible() == true)
							&& jtfName.isEnabled()) {
						myCustOrder.updateCustomer(myCustOrder.getCustomer()
								.get(jcbCust.getSelectedIndex()), ImportCust());
					}
					// if import customer radio button select and jcombo
					// customer is show and textbox is enable
					// jbCust action is edit/update Import customer
					else if ((jrbDomestic.isSelected() == false)
							&& (jcbCust.isVisible() == true)
							&& jtfName.isEnabled()) {

						myCustOrder.updateCustomer(myCustOrder.getCustomer()
								.get(jcbCust.getSelectedIndex()), ImportCust());
					}
					// if textbox is not enable
					// jbCust action is delete select customer in jcombox
					// Customer
					else if (jtfName.isEnabled() == false) {

						myCustOrder.deleteCustomer(myCustOrder.getCustomer()
								.get(jcbCust.getSelectedIndex()));

					}
					// Refresh jcombox after each action
					jcbCust.removeAllItems();
					jcbCustItemAdd();

					// if jcb Customer contain no customer name
					// set all text field to null
					if (jcbCust.getItemCount() == 0) {
						setTextNull();
					}

				}
				// throw ArrayIndexOutOfBoundsException, if there are no
				// customer is select
				catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null,
							"There are no customer selected to "
									+ jbCust.getText().toLowerCase() + "!");
				}
				// cactch exceoption if jbbutton is hit straight away without go
				// into input variable
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}

		});
		// set up actionlistener for jmiOpenVariety
		jmiOpenVariety.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				// set up booelean value for exception catch loop
				boolean exception = true;
				do {
					int selectFile = jfcOpenFlowerVar.showOpenDialog(null);
					// if cancel button press, exit the loop
					if (selectFile == jfcOpenCustOrder.CANCEL_OPTION) {
						myCustOrder = new CustomerOrdersManager();
						exception = true;
					} else {
						try {
							exception = true;
							path = jfcOpenFlowerVar.getSelectedFile().getPath();
							// create a order in customerOrder valuable to add
							// in static variety array
							// remove the order after the value has inputed
							myCustOrder.addOrder(new Order());
							myCustOrder.getOrder().get(0).openVariety(path);
							myCustOrder.getOrder().remove(0);

							// update the variety combo box
							jcbVarietyItemAdd();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage()
									+ "\nPlease select a correct file!");
							exception = false;
						}
					}
				} while (exception == false);
			}

		});
		// set up actionlistener for jmiOpenVariety
		jmiSaveVariety.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jfcSaveFlowerVar.showSaveDialog(null);
				path = jfcSaveFlowerVar.getSelectedFile().getPath();
				try {
					// create a order in customerOrder variable to add in static
					// variety array
					// remove the order after the value has inputed
					myCustOrder.addOrder(new Order());
					myCustOrder.getOrder().get(0).saveVariety(path);
					myCustOrder.getOrder().remove(0);

				} catch (FileNotFoundException e) {

				}
			}

		});
		jmiNewVariety.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				// create a order in customerOrder variable to add in static
				// default variety array
				// remove the order after the value has inputed
				myCustOrder.addOrder(new Order());
				for (int i = 0; i < myCustOrder.getOrder().get(0)
						.getVarieties().size(); i++)
					myCustOrder.getOrder().get(0).getVarieties().remove(i);
				for (int i = 0; i < defaultVariety.length; i++)
					myCustOrder.getOrder().get(0).addVariety(defaultVariety[i]);
				myCustOrder.getOrder().remove(0);

			}

		});

		// Create button in the corner of the frame

		jpCustButton.add(new JLabel(""));
		jpCustButton.add(jbCust);

		// Order JPanel Add
		//----------------------------------------------------------------------
		// ------------------------------------------------

		jpLable.add(jlOrderSelect).setVisible(false);
		jpOrderTextField.add(jcbOrder).setVisible(false);

		jpLable.add(new JLabel("Customer:"));
		jpOrderTextField.add(jcbOrderCust);

		jpLable.add(new JLabel("Variety:"));
		jpOrderTextField.add(jcbVariety);

		jpLable.add(new JLabel("Quantity Required:"));
		jpOrderTextField.add(jtfQuanReq);

		jpLable.add(new JLabel("Quantity Supplied:"));
		jpOrderTextField.add(jtfQuanSup);

		jpLable.add(new JLabel("Start Date:"));
		jpOrderTextField.add(jtfStartDate);

		jpLable.add(new JLabel("EndDate:"));
		jpOrderTextField.add(jtfEndDate);

		jpLable.add(new JLabel(""));
		jpOrderTextField.add(jbOrder);
		jpOrderTextField.add(new JLabel(""));
		jpLable.add(new JLabel(""));

		jmiOrderAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				removePanel(jpCustomer);
				jpCustButton.setVisible(false);
				validate();
				addCenter(jpOrder);
				enable = true;
				setEnable();
				jlOrderSelect.setVisible(false);
				jcbOrder.setVisible(false);

				setTextNull();
				jcbOrderCustItemAdd();
				jcbVarietyItemAdd();
				jbOrder.setText("Add");
				validate();
			}

		});
		jmiOrderEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				removePanel(jpCustomer);
				jpCustButton.setVisible(false);
				validate();
				addCenter(jpOrder);
				enable = true;
				setEnable();
				jlOrderSelect.setVisible(true);
				jcbOrder.setVisible(true);

				setTextNull();
				jcbOrderItemAdd();
				jcbOrderCustItemAdd();
				jcbVarietyItemAdd();
				jcbOrder.addItemListener(setOrderInfo);
				setOrderInfo();
				jbOrder.setText("Edit");
				validate();
			}

		});
		jmiOrderDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				removePanel(jpCustomer);
				jpCustButton.setVisible(false);
				addCenter(jpOrder);
				enable = false;
				setEnable();
				jlOrderSelect.setVisible(true);
				jcbOrder.setVisible(true);

				setTextNull();
				jcbOrderItemAdd();
				jcbOrderCustItemAdd();
				jcbVarietyItemAdd();
				jcbOrder.addItemListener(setOrderInfo);
				setOrderInfo();
				jbOrder.setText("Delete");
				validate();
			}

		});

		jpOrder.add(jpLable, BorderLayout.WEST);
		jpOrder.add(jpOrderTextField, BorderLayout.CENTER);

		jbOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					if (jcbOrder.isVisible() == false) {
						myCustOrder.addOrder(createOrder());
					} else if ((jcbOrder.isVisible() == true)
							&& (jcbOrderCust.isEnabled() == true)) {
						myCustOrder.updateOrder(myCustOrder.getOrder().get(
								jcbOrder.getSelectedIndex()), createOrder());
						jcbOrderItemAdd();
					} else if (jcbOrderCust.isEnabled() == false) {
						myCustOrder.deleteOrder(myCustOrder.getOrder().get(
								jcbOrder.getSelectedIndex()));
						jcbOrderItemAdd();
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,
							"There no order selected to "
									+ jbOrder.getText().toLowerCase() + "!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}

		});

		// File menu - Customer and Order
		// --------------------------------------------------------
		jmiOpenCustOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				jcbCust.removeAllItems();
				boolean exception = true;
				do {
					int selectFile = jfcOpenCustOrder.showOpenDialog(null);
					exception = true;
					if (selectFile == jfcOpenCustOrder.CANCEL_OPTION) {
						myCustOrder = new CustomerOrdersManager();
						exception = true;
					} else {
						try {
							path = jfcOpenCustOrder.getSelectedFile().getPath();
							myCustOrder = new CustomerOrdersManager(path);

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage()
									+ "\nPlease select a correct file!");
							exception = false;
						}
					}
				} while (exception == false);

				jcbOrderItemAdd();
				jcbCustItemAdd();
				jcbOrderCustItemAdd();
				jcbVarietyItemAdd();
				validate();
			}

		});
		jmiSaveCustOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jfcSaveCustOrder.showSaveDialog(null);

				try {
					path = jfcSaveCustOrder.getSelectedFile().getPath();
					myCustOrder.toFile(path);
				} catch (Exception e) {

				}
				validate();
			}

		});
		jmiNewCustOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				setTextNull();
				try {
					myCustOrder = new CustomerOrdersManager();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				validate();
			}

		});
		this.setVisible(true);

	}

	public void validate() {
		super.validate();
	}

	public void removePanel(JPanel myPanel) {
		super.remove(myPanel);
	}

	public void addCenter(JPanel myPanel) {
		super.add(myPanel, BorderLayout.CENTER);
	}

	public void addSouth(JPanel myPanel) {
		super.add(myPanel, BorderLayout.SOUTH);
	}

	boolean enable = true;

	public void setEnable() {

		jrbDomestic.setEnabled(enable);
		jrbImport.setEnabled(enable);
		jtfName.setEnabled(enable);
		jtfAddress.setEnabled(enable);
		jtfCity.setEnabled(enable);
		jtfState.setEnabled(enable);
		jcbShipping.setEnabled(enable);
		jtfCountry.setEnabled(enable);
		jcbInspection.setEnabled(enable);
		jcbFumigation.setEnabled(enable);

		jtfQuanReq.setEnabled(enable);
		jtfQuanSup.setEnabled(enable);
		jtfStartDate.setEnabled(enable);
		jtfEndDate.setEnabled(enable);
		jcbOrderCust.setEnabled(enable);
		jcbVariety.setEnabled(enable);
		validate();
	}
	// create DomesticCustomer from the textbox
	public DomesticCustomer DomesticCust() {
		String name = jtfName.getText();
		String address = jtfAddress.getText();
		String city = jtfCity.getText();
		String state = jtfState.getText();
		int shipping = 0;
		if (jcbShipping.getSelectedItem().equals("Air")) {
			shipping = 0;
		} else if (jcbShipping.getSelectedItem().equals("Road")) {
			shipping = 1;
		} else if (jcbShipping.getSelectedItem().equals("Rail")) {
			shipping = 2;
		}
		DomesticCustomer myCustomer = new DomesticCustomer(name, address, city,
				state, shipping);

		return myCustomer;
	}
	// create ImportCustomer from the textbox
	public ImportCustomer ImportCust() {
		String name = jtfName.getText();
		String address = jtfAddress.getText();
		String city = jtfCity.getText();
		String state = jtfState.getText();
		String country = jtfCountry.getText();
		boolean inspection = jcbInspection.isSelected();
		boolean fumigation = jcbFumigation.isSelected();
		ImportCustomer myCustomer = new ImportCustomer(name, address, city,
				state, country, inspection, fumigation);
		return myCustomer;

	}

	ItemListener setCustInfo = new ItemListener() {

		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			setCustInfo();
		}

	};

	ItemListener setOrderInfo = new ItemListener() {

		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			setOrderInfo();
		}

	};

	// set text box as Customer combo selected item
	public void setCustInfo() {
		try {
			int i = (jcbCust.getSelectedIndex());
			if (jcbCust.isVisible() == false) {

			} else {
				jtfName.setText(myCustOrder.getCustomer().get(i).getName());
				jtfAddress.setText(myCustOrder.getCustomer().get(i)
						.getAddress());
				jtfCity.setText(myCustOrder.getCustomer().get(i).getCity());
				jtfState.setText(myCustOrder.getCustomer().get(i).getState());
				try {
					jrbDomestic.setSelected(true);
					if (((DomesticCustomer) myCustOrder.getCustomer().get(i))
							.getShipping() == 0)
						jcbShipping.setSelectedItem("Air");
					else if (((DomesticCustomer) myCustOrder.getCustomer().get(
							i)).getShipping() == 1)
						jcbShipping.setSelectedItem("Road");
					else if (((DomesticCustomer) myCustOrder.getCustomer().get(
							i)).getShipping() == 2)
						jcbShipping.setSelectedItem("Rail");
				} catch (ClassCastException e) {

					jrbImport.setSelected(true);
					jtfCountry.setText(((ImportCustomer) myCustOrder
							.getCustomer().get(i)).getCountry());
					jcbInspection.setSelected(((ImportCustomer) myCustOrder
							.getCustomer().get(i))
							.isFreightForwarderInspection());
					jcbFumigation.setSelected(((ImportCustomer) myCustOrder
							.getCustomer().get(i))
							.isFreightForwarderFumigation());
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	// set text box as Order combo selected item
	public void setOrderInfo() {
		try {
			if (jcbOrder.isVisible() == false) {

			} else {
				int i = jcbOrder.getSelectedIndex();
				jcbOrderCust.setSelectedItem(myCustOrder.getOrder().get(i)
						.getCustomer().getName());
				jcbVariety.setSelectedItem(myCustOrder.getOrder().get(i)
						.getVariety());
				jtfQuanReq.setText(myCustOrder.getOrder().get(i)
						.getQuantityRequired()
						+ "");
				jtfQuanSup.setText(myCustOrder.getOrder().get(i)
						.getQuantitySupplied()
						+ "");
				jtfStartDate.setText(myCustOrder.getOrder().get(i)
						.getStartDate()
						+ "");
				jtfEndDate.setText(myCustOrder.getOrder().get(i).getEndDate()
						+ "");
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	// set up combo box items for customer combo box
	public void jcbCustItemAdd() {
		jcbCust.removeAllItems();
		for (int i = 0; i < myCustOrder.getCustomer().size(); i++)
			jcbCust.addItem(myCustOrder.getCustomer().get(i).getName());
	}

	// set up combo box items for order combo box
	public void jcbOrderItemAdd() {
		jcbOrder.removeAllItems();
		for (int i = 0; i < myCustOrder.getOrder().size(); i++) {
			String orderName = myCustOrder.getOrder().get(i).getCustomer()
					.getName();
			String orderSDate = myCustOrder.getOrder().get(i).getStartDate();
			String orderEDate = myCustOrder.getOrder().get(i).getEndDate();
			jcbOrder.addItem(orderName + " " + orderSDate + " - " + orderEDate);
		}
	}

	// set up combo box items for order customer combo box
	public void jcbOrderCustItemAdd() {
		jcbOrderCust.removeAllItems();

		if ((jcbOrder.getItemCount() == 0) && (jcbOrder.isVisible())) {
			jcbOrderCust.removeAllItems();
		} else {

			for (int i = 0; i < myCustOrder.getCustomer().size(); i++)
				jcbOrderCust
						.addItem(myCustOrder.getCustomer().get(i).getName());
		}
	}

	public void jcbVarietyItemAdd() {
		jcbVariety.removeAllItems();
		if (myCustOrder.getOrder().size() == 0) {
			myCustOrder.addOrder(new Order());
			for (int i = 0; i < myCustOrder.getOrder().get(0).getVarieties()
					.size(); i++)
				jcbVariety.addItem(myCustOrder.getOrder().get(0).getVarieties()
						.get(i));
			myCustOrder.getOrder().remove(0);
		} else {
			for (int i = 0; i < myCustOrder.getOrder().get(0).getVarieties()
					.size(); i++)
				jcbVariety.addItem(myCustOrder.getOrder().get(0).getVarieties()
						.get(i));
		}
	}

	// reset all text field
	public void setTextNull() {
		jtfName.setText("");
		jtfAddress.setText("");
		jtfCity.setText("");
		jtfState.setText("");
		jcbShipping.setSelectedItem("Air");
		jrbDomestic.setSelected(true);
		jtfCountry.setText("");
		jcbInspection.setSelected(false);
		jcbFumigation.setSelected(false);
		jtfQuanReq.setText("");
		jtfQuanSup.setText("");
		jtfStartDate.setText("");
		jtfEndDate.setText("");
		jcbCust.removeAllItems();
		jcbOrderCust.removeAllItems();
		jcbOrder.removeAllItems();

	}

	public Order createOrder() throws Exception {
		int i = jcbOrderCust.getSelectedIndex();
		Customer orderCustomer = myCustOrder.getCustomer().get(i);
		String variety = (String) jcbVariety.getSelectedItem();
		quanSup = Integer.parseInt(jtfQuanSup.getText());
		quanReq = Integer.parseInt(jtfQuanReq.getText());
		GregorianCalendar startDate = convertDate(jtfStartDate);
		GregorianCalendar endDate = convertDate(jtfEndDate);
		Order myOrder = new Order(orderCustomer, variety, quanReq, quanSup,
				startDate, endDate);
		return myOrder;

	}

	public GregorianCalendar convertDate(JTextField jt) throws Exception {
		date = jt.getText();
		date = date.replaceAll("/", "");
		try {
			x = Integer.parseInt(date);
		} catch (Exception e) {
			throw new Exception("Date must be in dd/mm/yy format!");
		}

		year = x % 100;
		x = (x - year) / 100;
		month = x % 100;
		if ((month == 0) || (month > 12)) {
			throw new IllegalArgumentException(
					"Invalid value! Month can not equals to 0 or greater than 12");
		}
		x = (x - month) / 100;
		day = x;
		if ((day == 0) || (day > 31)) {
			throw new IllegalArgumentException(
					"Invalid value! Day can not equals to 0 or greater than 31");
		}
		return new GregorianCalendar(year + 2000, month - 1, day);

	}

	public boolean nameCheck() {
		boolean nameCheck = true;
		for (int i = 0; i < myCustOrder.getCustomer().size(); i++) {
			if (jtfName.getText().equals(
					myCustOrder.getCustomer().get(i).getName())) {
				JOptionPane.showMessageDialog(null, "Customer with name: "
						+ jtfName.getText() + " is already exist!"
						+ "\n Please input other name!");
				nameCheck = false;
			}

		}
		if (jtfName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Text Field is empty please input value!");
			nameCheck = false;
		} else {
			nameCheck = true;
		}
		return nameCheck;
	}

	class StringVerifier extends InputVerifier {
		@Override
		public boolean verify(JComponent input) {
			// TODO Auto-generated method stub
			JTextField tf = (JTextField) input;
			if (tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Text Field is empty please input value!");
				return false;
			} else {
				return true;
			}
		}

	}

	public boolean stateCheck() {
		boolean stateCheck = false;
		String state = jtfState.getText();
		String[] stateArray = { "ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC",
				"WA" };
		for (int i = 0; i < stateArray.length; i++) {
			if (state.equals(stateArray[i])) {
				stateCheck = true;
			}

		}
		if (stateCheck == false) {
			JOptionPane
					.showMessageDialog(
							null,
							"Domestic customer's state must have one of the following (case sensitive) "
									+ "\nstate values: ACT, NSW, NT, QLD, SA, TAS, VIC, WA");
		}
		return stateCheck;
	}

}
