package lecture11;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class SubmitBid extends JApplet {
  private JLabel bidLabel = new JLabel("Bid: $");
  private JTextField bidTextField = new JTextField("1000");
  private JButton bidButton = new JButton("Submit");

  //Construct the applet
  public SubmitBid() {
    this.getContentPane().setLayout(new FlowLayout());
    this.getContentPane().add(bidLabel);
    this.getContentPane().add(bidTextField);
    this.getContentPane().add(bidButton);
  }
}
