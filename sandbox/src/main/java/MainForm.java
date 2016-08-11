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

  public MainForm() throws InterruptedException {
    setContentPane(mainPanel);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(1000, 1000);





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


  }

