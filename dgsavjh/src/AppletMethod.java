import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class AppletMethod extends JApplet {
  private int totalInits=0;
  private int totalStarts=0;
  private int totalStops=0;
  private int totalDestroys=0;

  public void init() {
    totalInits++;
    showStats("init");
  }

  public void start() {
    totalStarts++;
    showStats("start");
  }

  public void stop() {
    totalStops++;
    showStats("stop");
  }

  public void destroy() {
    totalDestroys++;
    showStats("destroy");
  }

  private void showStats(String operation) {
    JOptionPane.showMessageDialog(null,"A total of " + totalInits +
    " inits, " + totalStarts + " starts, " + totalStops + " stops " +
    totalDestroys + " destroys have occurred after running " + operation);

  }
}
