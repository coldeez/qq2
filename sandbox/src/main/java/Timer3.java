import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kosty on 13.08.2016.
 */
public class Timer3 extends JFrame{
    private JPanel panel3;
    private JLabel timerLabel3;
    private Timer timer;

    public Timer3() {
        add(panel3);
        panel3.setBackground(Color.BLACK);
        panel3.setLayout(new FlowLayout());
        setTitle("Timer3");
        setPreferredSize(new Dimension(300, 300));
        pack();
        timerLabel3.setFont(new Font("Tahoma", Font.PLAIN, 80));
        timerLabel3.setForeground(Color.RED);
        timerLabel3.setBackground(Color.BLACK);
        timerLabel3.setOpaque(true);

        timer = new Timer(1000, new TimerTick());
        panel3.add(timerLabel3);

        timer.start();
    }
















    class TimerTick implements ActionListener {

        int countdown = 3600;

        @Override
        public void actionPerformed(ActionEvent e) {
            countdown--;
            int mins = countdown / 60;
            int sec = countdown % 60;

            timerLabel3.setText(Integer.toString(mins) + ":" + Integer.toString(sec));
            if (countdown == 0) {
                timer.stop();
            }
        }

    }
}
