import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by kosty on 11.08.2016.
 */
public class TouchPanel extends JFrame{

    private Timer timer;


    public TouchPanel() {

        timer = new Timer(1000, new TimerTick());
        setTitle("ImagePanel");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageComponent component = new ImageComponent();
        add(component);



   }

    class ImageComponent extends JComponent
    {
        private Image image;
        private Image pic;

        public ImageComponent()
        {
            try
            {
                image = ImageIO.read(new File("C:\\test\\test1.jpg"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if(image == null) return;
            g.drawImage(image, 0, 0, null);
        }

        public void setPic(Image pic) {
            this.pic = pic;
            repaint();
        }


         }

    class TimerTick implements ActionListener {

        int countdown = 3600;

        @Override
        public void actionPerformed(ActionEvent e) {
            countdown--;
            try {
                component.setPic(ImageIO.read(new File("C:\\test\\test2.jpg")));
            } catch (IOException e1) {
                e1.printStackTrace();
            };
            if (countdown == 0) {
                timer.stop();
            }
        }

    }


}
