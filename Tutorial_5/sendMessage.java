package Tutorial_5;

import java.awt.*;
import javax.swing.*;

public class sendMessage {

	public static void main(String[] args) {
		JFrame sendMessage = new JFrame("Send Message");
		sendMessage.setSize(250,250);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,2));
		p1.add(new JLabel("Network: "));
		p1.add(new JComboBox(new String[]{"Optus","Telstra","Virgin"}));
		p1.add(new JLabel("Message: "));
		p1.add(new JTextArea("Enter message here"));
		
		JPanel p2 = new JPanel();
		p2.setLayout (new GridLayout(4,3));
		for (int i=1; i<10;i++)
			p2.add(new JButton(""+i));
		p2.add(new JButton("*"));
		p2.add(new JButton("0"));
		p2.add(new JButton("#"));
		
		sendMessage.setLayout(new BorderLayout());
		sendMessage.add(p2, BorderLayout.CENTER);
		sendMessage.add(p1, BorderLayout.NORTH);
		
		sendMessage.setVisible(true);


	}

}
