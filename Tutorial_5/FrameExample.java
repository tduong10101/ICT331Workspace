package Tutorial_5;
import java.awt.*;
import javax.swing.*;
public class FrameExample {
  public static void main(String[] args) {
    JFrame exampleJFrame = new JFrame("An example of JFrame");
    exampleJFrame.setSize(200,400);
    exampleJFrame.setDefaultCloseOperation(
		JFrame.EXIT_ON_CLOSE);
    JPanel exampleJPanel = new JPanel();
    exampleJPanel.setLayout(new FlowLayout());
    for (int i=0; i<6; i++) {
    	 exampleJPanel.add(new JButton("Button " + i));
    }
    JPanel exampleJPanel2 = new JPanel();
    exampleJPanel2.setLayout(new BorderLayout());
    exampleJPanel2.add(exampleJPanel,BorderLayout.NORTH);
    exampleJPanel2.add(new JButton("blah"),BorderLayout.CENTER);
    
    exampleJFrame.setLayout(new BorderLayout());
    exampleJFrame.add(exampleJPanel2, BorderLayout.CENTER);
    exampleJFrame.setVisible(true);
  }
}