import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kosty on 13.08.2016.
 */
public class Timer1 extends JFrame{
    private JPanel panel1;
    public JLabel getTimerLabel1() {
        return timerLabel1;
    }



    private JLabel timerLabel1;

    public JTextField getCode() {
        return code;
    }

    private JTextField code;
    public Timer timer1;

    public Timer1() throws IOException {
        BufferedImage myImage = ImageIO.read(new File("C:\\test\\bg_timer.jpg"));
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1300, 1000));
        setContentPane(new ImagePanel(myImage));
        setBackground(Color.BLACK);
        code.setForeground(Color.RED);
        code.setFont(new Font("Tahoma", Font.PLAIN, 80));
        code.setBackground(Color.BLACK);
        code.setSize(350, 100);
        code.setLocation(900, 750);
        code.setDocument(new JTextFieldLimit((10)));
        add(code);
        timerLabel1.setForeground(Color.RED);
        timerLabel1.setFont(new Font("Tahoma", Font.PLAIN, 80));
        timerLabel1.setSize(400, 400);
        timerLabel1.setLocation(450, 0);
        timer1 = new Timer(1000, new TimerTick());
        add(timerLabel1);
        add(panel1);
        setTitle("Timer1");
         pack();
         timer1.start();

        code.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (code.getText().length() >= 4) {
                    if (code.getText().equals("1234")) {
                        code.setText("ЗАГР..");
                    } else if (!code.getText().equals("1234")) {
                        code.setText(null);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                            Main.log.info(e);
                        }
                    }
                }


            }
        });
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
                    timer1.stop();
                }


        }

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

    class JTextFieldLimit extends PlainDocument {
        private int limit;
        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }

        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null)
                return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }
}
