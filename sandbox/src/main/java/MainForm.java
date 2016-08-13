import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kbal on 03.08.2016.
 */
public class MainForm extends JFrame {
  private JButton resetQuestButton;
  private JButton startQuestButton;
  private JPanel mainPanel;
  private JButton button1;
  private JButton button2;
  private JButton button3;
  private JButton button4;
  private JButton button5;
  private JButton button6;
  private JButton button7;
  private JButton button8;
  private JButton button9;
  private JButton button10;
  private JButton button11;
  private JButton button12;
  private JButton button13;
  private JButton button14;
  private JButton button15;
  private JButton button16;
  private JButton button17;
  private JButton button18;
  private JButton button19;
  private Color color;

  public MainForm() throws InterruptedException, IOException {
    BufferedImage myImage = ImageIO.read(new File("C:\\test\\plan.jpg"));
    setContentPane(mainPanel);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(1300, 800);
    setContentPane(new ImagePanel(myImage));
    resetQuestButton.setSize(100, 45);
    resetQuestButton.setLocation(809, 660);
    add(resetQuestButton);
    startQuestButton.setSize(100, 45);
    startQuestButton.setLocation(25, 660);
    add(startQuestButton);
    button1.setSize(100, 45);
    button1.setLocation(600, 480);
    color = Color.RED;
    button1.setBackground(color);
    add(button1);
    button2.setSize(150, 45);
    button2.setLocation(590, 380);
    add(button2);
    button3.setSize(100, 45);
    button3.setLocation(915, 410);
    add(button3);
    button4.setSize(100, 45);
    button4.setLocation(915, 340);
    add(button4);
    button5.setSize(100, 45);
    button5.setLocation(705, 5);
    add(button5);
    button6.setSize(100, 45);
    button6.setLocation(380, 5);
    add(button6);
    button7.setSize(100, 45);
    button7.setLocation(350, 240);
    add(button7);
    button8.setSize(100, 45);
    button8.setLocation(354, 450);
    add(button8);
    button9.setSize(100, 45);
    button9.setLocation(230, 450);
    add(button9);
    button10.setSize(100, 45);
    button10.setLocation(160, 330);
    add(button10);
    button11.setSize(100, 45);
    button11.setLocation(50, 330);
    add(button11);
    button12.setSize(100, 45);
    button12.setLocation(630, 210);
    add(button12);
    button13.setSize(100, 45);
    button13.setLocation(750, 480);
    add(button13);
    button14.setSize(100, 45);
    button14.setLocation(520, 5);
    add(button14);
    button15.setSize(100, 45);
    button15.setLocation(1150, 50);
    add(button15);
    button16.setSize(100, 45);
    button16.setLocation(1150, 120);
    add(button16);
    button17.setSize(100, 45);
    button17.setLocation(1150, 190);
    add(button17);
    button18.setSize(100, 45);
    button18.setLocation(1150, 260);
    add(button18);
    button19.setSize(100, 45);
    button19.setLocation(1150, 330);
    add(button19);





    resetQuestButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setResetQuestOk(1);


      }
    });

    startQuestButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setStartQuestOk(1);
      }
    });

    button1.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
          if (button1.getModel().isPressed()) {
          if (color == Color.LIGHT_GRAY) {
            color = Color.RED;
          } else if (color == Color.RED) {
            color = Color.LIGHT_GRAY;
          }
          button1.setBackground(color);
        }
      }
    });


  }

  class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
      this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(image, 0, 0, this);
    }
  }


}

