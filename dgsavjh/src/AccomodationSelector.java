import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class AccomodationSelector extends JApplet {

    private static String[] REGION_ARRAY = { "Brisbane", "Gold Coast",
            "Sunshine Coast" };

    private static String[] BRISBANE_LOCATION_ARRAY = { "CBD",
            "Western Suburbs", "Eastern Suburbs" };

    private static String[] GOLD_COAST_LOCATION_ARRAY = { "Surfers Paradise",
            "Broadbeach", "Main Beach" };

    private static String[] SUNSHINE_COAST_LOCATION_ARRAY = { "Maroochydore",
            "Mooloolaba", "Buderim" };

    private static String[] ROOM_TYPE_ARRAY = { "All", "1 bed", "2 bed" };

    private JLabel roomTypeLabel = new JLabel("Room Type:");

    private JComboBox roomTypeComboBox = new JComboBox(ROOM_TYPE_ARRAY);

    private JPanel roomTypePanel = new JPanel();

    private JLabel accomodationDestinationLabel = new JLabel("Destination: ");

    private JList accomodationRegion = new JList(REGION_ARRAY);

    private JList accomodationLocation = new JList(BRISBANE_LOCATION_ARRAY);

    private JPanel accomodationRegionLocationPanel = new JPanel();

    private JPanel accomodationLabelRegionLocationPanel = new JPanel();

    private JLabel accomodationSelectedLabel = new JLabel(
            "Selected Accomodation: ");

    private JTextArea accomodationSelectedTextArea = new JTextArea(3, 20);

    private JPanel accomodationSelectedPanel = new JPanel();

    public AccomodationSelector() {
       
		this.setSize(new Dimension(420,135));
        this.accomodationRegionLocationPanel.setLayout(new GridLayout(0, 2));
        this.accomodationRegionLocationPanel.add(accomodationRegion);
        this.accomodationRegionLocationPanel.add(accomodationLocation);
        this.accomodationLabelRegionLocationPanel
                .setLayout(new GridLayout(0, 2));
        this.accomodationLabelRegionLocationPanel
                .add(accomodationDestinationLabel);
        this.accomodationLabelRegionLocationPanel
                .add(accomodationRegionLocationPanel);
        this.getContentPane().setLayout(new BorderLayout(5, 5));
        this.roomTypePanel.setLayout(new GridLayout(0, 2));
        this.roomTypePanel.add(roomTypeLabel);
        this.roomTypePanel.add(roomTypeComboBox);
        this.getContentPane().add(roomTypePanel, BorderLayout.NORTH);
        this.getContentPane().add(accomodationLabelRegionLocationPanel,
                BorderLayout.CENTER);
        this.accomodationSelectedPanel.setLayout(new GridLayout(0, 2));
        this.accomodationSelectedPanel.add(accomodationSelectedLabel);
        this.accomodationSelectedPanel.add(accomodationSelectedTextArea);
        this.getContentPane()
                .add(accomodationSelectedPanel, BorderLayout.SOUTH);
        accomodationSelectedTextArea.setEditable(false);
        accomodationRegion
                .addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        String[] locationArray;
                        if (accomodationRegion.getSelectedValue() == "Brisbane") {
                            locationArray = BRISBANE_LOCATION_ARRAY;
                        }

                        else if (accomodationRegion.getSelectedValue() == "Gold Coast") {
                            locationArray = GOLD_COAST_LOCATION_ARRAY;
                        }

                        else {
                            locationArray = SUNSHINE_COAST_LOCATION_ARRAY;
                        }

                        accomodationLocation.setListData(locationArray);
                    }
                });
        accomodationLocation
                .addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        String message = "";
                        for (int i = 0; i < accomodationLocation
                                .getSelectedValues().length; i++) {
                            message += accomodationRegion.getSelectedValue()
                                    + " "
                                    + accomodationLocation.getSelectedValues()[i]
                                    + ", " + roomTypeComboBox.getSelectedItem()
                                    + "\n";
                        }
                        if (accomodationRegion.getSelectedValue() != null)
                            accomodationSelectedTextArea.setText(message);
                    }
                });
        accomodationRegion
                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        //this.pack();
        this.setVisible(true);
    }
    public void init() {
        try {
        	this.setSize(new Dimension(420,135));
          accomodationSelectedTextArea.setText("Accomodation Selected");
          
        }
        catch(Exception e) {
          e.printStackTrace();
        }
      }

      //Component initialization
      
    public static void main(String[] args) {
    	JFrame myJFrame = new JFrame();
    	AccomodationSelector accomodationSelector = new AccomodationSelector();
    	accomodationSelector.accomodationSelectedTextArea.setText("Accomodation Selected");
    	myJFrame.add(accomodationSelector);
    	myJFrame.setTitle("Accomodation Selector");
    	myJFrame.setVisible(true);
    	myJFrame.pack();
        //AccomodationSelector accomodationSelector = new AccomodationSelector();
        
    }

}
