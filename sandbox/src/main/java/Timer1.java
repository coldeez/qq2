import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kosty on 13.08.2016.
 */
public class Timer1 extends JFrame{
    private JPanel panel1;
    private JLabel timerLabel1;
    private Timer timer;

    public Timer1() {
        add(panel1);
        panel1.setBackground(Color.BLACK);
        panel1.setLayout(new FlowLayout());
        setTitle("Timer3");
        setPreferredSize(new Dimension(300, 300));
        pack();
        timerLabel1.setFont(new Font("Tahoma", Font.PLAIN, 80));
        timerLabel1.setForeground(Color.RED);
        timerLabel1.setBackground(Color.BLACK);
        timerLabel1.setOpaque(true);

        timer = new Timer(1000, new TimerTick());
        panel1.add(timerLabel1);

        timer.start();
    }




    class TimerTick implements ActionListener {

        int countdown = 3600;

        @Override
        public void actionPerformed(ActionEvent e) {
            countdown--;
            int mins = countdown / 60;
            int sec = countdown % 60;

            timerLabel1.setText(Integer.toString(mins) + ":" + Integer.toString(sec));
            if (countdown == 0) {
                timer.stop();
            }
        }

    }
}
