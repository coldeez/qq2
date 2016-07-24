import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vity on 24.07.2016.
 */
public class Interface {
  private JButton button1;
  private JPanel panel1;
  private JTextField textField1;
  private JButton STATUSButton;
  String a="0";
  String b="0";


  public Interface() {
    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
       if (a=="0")
        a="1";
        else if(a=="1")
         a="0";else JOptionPane.showMessageDialog(null,"ComPort ne opredelen");
        textField1.setText(a);

      }
    }

    );

    STATUSButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                  if (b=="0")
                                    b="0";
                                  else if(b=="1")
                                    b="0";else JOptionPane.showMessageDialog(null,"ComPort ne opredelen");
                                  textField1.setText(b);

                                }
                              }

    );

  }
  public static void main (String[] args){
    JFrame frame=new JFrame("Interface");
    frame.setContentPane(new Interface().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  }
