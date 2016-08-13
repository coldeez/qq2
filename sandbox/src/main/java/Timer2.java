import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kosty on 13.08.2016.
 */
public class Timer2 extends JFrame{
    private JPanel panel2;
    private JLabel timerLabel2;
    private Timer timer;

    public Timer2() {
        add(panel2);
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(new FlowLayout());
        setTitle("Timer3");
        setPreferredSize(new Dimension(300, 300));
        pack();
        timerLabel2.setFont(new Font("Tahoma", Font.PLAIN, 80));
        timerLabel2.setForeground(Color.RED);
        timerLabel2.setBackground(Color.BLACK);
        timerLabel2.setOpaque(true);

        timer = new Timer(1000, new TimerTick());
        panel2.add(timerLabel2);

        timer.start();
    }
















    class TimerTick implements ActionListener {

        int countdown = 3600;

        @Override
        public void actionPerformed(ActionEvent e) {
            countdown--;
            int mins = countdown / 60;
            int sec = countdown % 60;

            timerLabel2.setText(Integer.toString(mins) + ":" + Integer.toString(sec));
            if (countdown == 0) {
                timer.stop();
            }
        }

    }
}
