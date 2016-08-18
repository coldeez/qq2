import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




public class TouchPanel extends JFrame{
    public ImageComponent getComponent() {
        return component;
    }



    private ImageComponent component;

    public JButton getButton1() {
        return button1;
    }

    private JButton button1;


    public TouchPanel() throws IOException {

        BufferedImage myImage = ImageIO.read(new File("C:\\test\\img\\butt.png"));
        setTitle("ImagePanel");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        component = new ImageComponent();
        add(component);
        button1.setIcon(new ImageIcon(myImage));
        button1.setSize(495, 180);
        button1.setLocation(264, 792);
        component.add(button1);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("before");
                    component.setPic(ImageIO.read(new File("C:\\test\\img\\2.jpg")));
                    Main.manager.setMonitorButton(1);
                    button1.setVisible(false);
                    System.out.println("after");
                } catch (IOException e1) {
                    e1.printStackTrace();
                    Main.log.info(e);
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
                image = ImageIO.read(new File("C:\\test\\img\\1.jpg"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
                Main.log.info(e);
            }
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if(image == null) return;
            g.drawImage(image, 0, 0, null);
        }

        public void setPic(Image pic) {
            this.image = pic;
            repaint();
        }


         }



}
