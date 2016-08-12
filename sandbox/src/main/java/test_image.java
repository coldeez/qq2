import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kbal on 12.08.2016.
 */
public class test_image  extends JFrame{

  private JButton button1;

  public test_image() throws IOException {
    BufferedImage myImage = ImageIO.read(new File("C:\\test\\test2.jpg"));
    setTitle("test");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setContentPane(new ImagePanel(myImage));
    button1.setSize(100, 100);
    add(button1);


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



}
