import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by kbal on 03.08.2016.
 */
public class MainForm extends JFrame {
  private JButton resetQuestButton;
  private JButton startQuestButton;
  private JPanel mainPanel;

  public MainForm() {
/*    setContentPane(mainPanel);*/
    setContentPane(new BgPanel());
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(1000, 1000);
    /* important Statement */
    setUndecorated(true);


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


  }

  class BgPanel extends JPanel {
    public void paintComponent(Graphics g) {
      Image im = null;
      try {
        im = ImageIO.read(new File("C:\\test\\test.jpg"));
      } catch (IOException e) {
      }
      g.drawImage(im, 0, 0, null);
    }


  }
}
