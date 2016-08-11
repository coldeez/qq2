import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class TimerLabel extends JFrame {

  private JLabel timeLabel;
  private Timer timer;
  private JButton start;

  public TimerLabel() {
    setTitle("TimerDemo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new FlowLayout());
    timeLabel = new JLabel();
    timeLabel.setFont(new Font("Monospaced", Font.BOLD, 80));
    timer = new Timer(1000, new TimerTick());
    start = new JButton("Start");

    start.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        remove(start);
        add(timeLabel);
        validate();
        repaint();
        timer.start();
      }
    });

    add(start);
    setPreferredSize(new Dimension(300, 150));
    setLocationRelativeTo(null);
    pack();
  }

  class TimerTick implements ActionListener {

    int countdown = 3600;

    @Override
    public void actionPerformed(ActionEvent e) {
      countdown--;
      int mins = countdown / 60;
      int sec = countdown % 60;
      timeLabel.setText(Integer.toString(mins) + ":" + Integer.toString(sec));
      if (countdown == 0) {
        timer.stop();
      }
    }

  }
}