import javax.swing.*;
public class FileChooserExample {
  public static void main(String[] args) {
    String message;
    JFileChooser chooser = new JFileChooser();
    int selectedFile = chooser.showOpenDialog(null);
    if (selectedFile == 
      JFileChooser.APPROVE_OPTION)
      message = "You have selected ";
    else
      message = "You have not selected ";
    message += chooser.getSelectedFile().getPath();
    JOptionPane.showMessageDialog(null,message);
  }
}
