package Tutorial_5;

import java.awt.*;

import javax.swing.*;

public class ButtonLayout {
	public static void main(String[] args) {
		//Create a frame and set it layout to FlowLayout
		JFrame myFrame = new JFrame("My Frame");
		myFrame.setLayout (new FlowLayout());
		myFrame.setSize (1280,968);
		myFrame.setVisible(true);
		//Create 2 panel and add them to the frame
		MyJPanel p1 = new MyJPanel(1);
		MyJPanel p2 = new MyJPanel(4);
		//Each panel contains three buttons (1-3,4-6)
		Color p1Color = new Color(0,0,0);
		Color p2Color = new Color(0,0,0);
		p1.setBackground(p1Color);
		p2.setBackground(p2Color);
		ImageIcon iC1 = new ImageIcon ("H:\\Untitled-1.jpg");
		
		
		//The panel uses FlowLayout
		myFrame.setLayout(new BorderLayout());
		myFrame.add(p1, BorderLayout.EAST);
		myFrame.add(p2, BorderLayout.WEST);
		myFrame.add(new JLabel(iC1), BorderLayout.CENTER);
		myFrame.validate();
	}

}
class MyJPanel extends JPanel {
	public MyJPanel(int start){
		for (int i = start; i<start+3;i++){
			JButton button1 = new JButton ("Button "+i);
			super.add(button1);
		}
	}
}
