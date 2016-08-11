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

    private JButton button1;
    private Image pic;


    public TouchPanel() {
        button1 = new JButton();
        setTitle("ImagePanel");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageComponent component = new ImageComponent();
        add(component);
        add(button1);


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Image pic = null;
                try {
                    pic = ImageIO.read(new File("C:\\test\\test2.jpg"));
                    TouchPanel.setPic(pic);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

   }

    class ImageComponent extends JComponent
    {
        private Image image;
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
         }

    public void setPic(Image pic) {
        this.pic = pic;
        repaint();
    }

}
