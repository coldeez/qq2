import jssc.SerialPortException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kbal on 03.08.2016.
 */
public class MainForm extends JFrame {
  private JButton resetQuestButton;
  private JButton startQuestButton;
  private JPanel mainPanel;

  public JButton getPushka() {
    return pushka;
  }

  public JButton pushka;

  public JButton getFlashDisk() {
    return flashDisk;
  }

  private JButton flashDisk;

  public JButton getYashikFlash() {
    return yashikFlash;
  }

  private JButton yashikFlash;
  private JButton button4;

  public JButton getPerenoska() {
    return perenoska;
  }

  private JButton perenoska;

  public JButton getImage2() {
    return image2;
  }

  private JButton image2;

  public JButton getEmergySvet() {
    return emergySvet;
  }

  private JButton emergySvet;
  private JButton button8;

  public JButton getLasers() {
    return lasers;
  }

  private JButton lasers;

  public JButton getSuperCompModules() {
    return superCompModules;
  }

  private JButton superCompModules;

  public JButton getShitokButton() {
    return shitokButton;
  }

  private JButton shitokButton;

  public JButton getSvetVezde() {
    return svetVezde;
  }

  private JButton svetVezde;
  private JButton button13;

  public JButton getTimers() {
    return timers;
  }

  private JButton timers;

  public JButton getAudio1() {
    return audio1;
  }

  private JButton audio1;

  public JButton getAudio2() {
    return audio2;
  }

  private JButton audio2;

  public JButton getAudio3() {
    return audio3;
  }

  private JButton audio3;

  public JButton getAudio4() {
    return audio4;
  }

  private JButton audio4;

  public JButton getAudio5() {
    return audio5;
  }

  private JButton audio5;

  public JButton getImage3() {
    return image3;
  }

  private JButton image3;

  public JButton getDoorClose() {
    return doorClose;
  }

  private JButton doorClose;

  public JButton getRubilnikSuperComp() {
    return rubilnikSuperComp;
  }

  private JButton rubilnikSuperComp;
  private JButton button23;

  public JButton getVentili() {
    return ventili;
  }

  private JButton ventili;

  public JButton getSirena() {
    return sirena;
  }

  private JButton sirena;

  public JButton getPodsvetka() {
    return podsvetka;
  }

  private JButton podsvetka;
  private JButton button27;

  public JButton getImage5() {
    return image5;
  }

  private JButton image5;

  public JButton getMonitorButton() {
    return monitorButton;
  }

  private JButton monitorButton;
  private Color color1;
  private Color color2;
  private Color color3;
  private Color color4;
  private Color color5;
  private Color color6;
  private Color color7;
  private Color color8;
  private Color color9;
  private Color color10;
  private Color color11;
  private Color color12;
  private Color color13;
  private Color color14;
  private Color color15;
  private Color color16;
  private Color color17;
  private Color color18;
  private Color color19;
  private Color color20;
  private Color color21;
  private Color color22;
  private Color color23;
  private Color color24;
  private Color color25;
  private Color color26;
  private Color color27;
  private Color color28;
  private Color color29;



  public MainForm() throws InterruptedException, IOException {
    BufferedImage myImage = ImageIO.read(new File("C:\\test\\plan.jpg"));
    setContentPane(mainPanel);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(1300, 800);
    setContentPane(new ImagePanel(myImage));
    resetQuestButton.setSize(100, 45);
    resetQuestButton.setLocation(809, 660);
    add(resetQuestButton);
    startQuestButton.setSize(100, 45);
    startQuestButton.setLocation(25, 660);
    add(startQuestButton);



    color1 = Color.PINK;
    color2 = Color.PINK;
    color3 = Color.PINK;
    color4 = Color.PINK;
    color5 = Color.PINK;
    color6 = Color.PINK;
    color7 = Color.PINK;
    color8 = Color.PINK;
    color9 = Color.PINK;
    color10 = Color.PINK;
    color11 = Color.PINK;
    color12 = Color.PINK;
    color13 = Color.PINK;
    color14 = Color.PINK;
    color15 = Color.PINK;
    color16 = Color.PINK;
    color17 = Color.PINK;
    color18 = Color.PINK;
    color19 = Color.PINK;
    color20 = Color.PINK;
    color21 = Color.PINK;
    color22 = Color.PINK;
    color23 = Color.PINK;
    color24 = Color.PINK;
    color25 = Color.PINK;
    color26 = Color.PINK;
    color27 = Color.PINK;
    color28 = Color.PINK;
    color29 = Color.PINK;
    pushka.setBackground(color1);
    flashDisk.setBackground(color2);
    yashikFlash.setBackground(color3);
    button4.setBackground(color4);
    perenoska.setBackground(color5);
    image2.setBackground(color6);
    emergySvet.setBackground(color7);
    button8.setBackground(color8);
    lasers.setBackground(color9);
    superCompModules.setBackground(color10);
    shitokButton.setBackground(color11);
    svetVezde.setBackground(color12);
    button13.setBackground(color13);
    timers.setBackground(color14);
    audio1.setBackground(color15);
    audio2.setBackground(color16);
    audio3.setBackground(color17);
    audio4.setBackground(color18);
    audio5.setBackground(color19);
    image3.setBackground(color20);
    doorClose.setBackground(color21);
    rubilnikSuperComp.setBackground(color22);
    button23.setBackground(color23);
    ventili.setBackground(color24);
    sirena.setBackground(color25);
    podsvetka.setBackground(color26);
    button27.setBackground(color27);
    image5.setBackground(color28);
    monitorButton.setBackground(color29);

    pushka.setSize(100, 45);
    pushka.setLocation(705, 5);
    add(pushka);
    flashDisk.setSize(150, 45);
    flashDisk.setLocation(590, 380);
    add(flashDisk);
    yashikFlash.setSize(150, 45);
    yashikFlash.setLocation(590, 320);
    add(yashikFlash);
    button4.setSize(100, 45);
    button4.setLocation(915, 340);
    add(button4);
    perenoska.setSize(100, 45);
    perenoska.setLocation(750, 150);
    add(perenoska);
    image2.setSize(100, 45);
    image2.setLocation(10, 5);
    add(image2);
    emergySvet.setSize(100, 45);
    emergySvet.setLocation(350, 240);
    add(emergySvet);
    button8.setSize(100, 45);
    button8.setLocation(354, 450);
    add(button8);
    lasers.setSize(100, 45);
    lasers.setLocation(230, 450);
    add(lasers);
    superCompModules.setSize(100, 45);
    superCompModules.setLocation(120, 330);
    add(superCompModules);
    shitokButton.setSize(100, 45);
    shitokButton.setLocation(10, 330);
    add(shitokButton);
    svetVezde.setSize(100, 45);
    svetVezde.setLocation(630, 210);
    add(svetVezde);
/*    button13.setSize(100, 45);
    button13.setLocation(750, 480);
    add(button13);*/
    timers.setSize(100, 45);
    timers.setLocation(520, 5);
    add(timers);
    audio1.setSize(100, 45);
    audio1.setLocation(1150, 50);
    add(audio1);
    audio2.setSize(100, 45);
    audio2.setLocation(1150, 120);
    add(audio2);
    audio3.setSize(100, 45);
    audio3.setLocation(1150, 190);
    add(audio3);
    audio4.setSize(100, 45);
    audio4.setLocation(1150, 260);
    add(audio4);
    audio5.setSize(100, 45);
    audio5.setLocation(1150, 330);
    add(audio5);
    image3.setSize(100, 45);
    image3.setLocation(130, 5);
    add(image3);

    doorClose.setSize(100, 45);
    doorClose.setLocation(470, 530);
    add(doorClose);
    rubilnikSuperComp.setSize(100, 45);
    rubilnikSuperComp.setLocation(470, 330);
    add(rubilnikSuperComp);
    button23.setSize(100, 45);
    button23.setLocation(360, 330);
    add(button23);
    ventili.setSize(100, 45);
    ventili.setLocation(245, 330);
    add(ventili);
    sirena.setSize(100, 45);
    sirena.setLocation(460, 240);
    add(sirena);
    podsvetka.setSize(100, 45);
    podsvetka.setLocation(10, 450);
    add(podsvetka);
    button27.setSize(100, 45);
    button27.setLocation(10, 60);
    add(button27);
    image5.setSize(100, 45);
    image5.setLocation(130, 60);
    add(image5);
    monitorButton.setSize(100, 45);
    monitorButton.setLocation(350, 5);
    add(monitorButton);





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
    button13.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setKartaActivate(1);
      }
    });
    button4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setSvetShitok(1);
      }
    });
    svetVezde.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (Main.manager.getSvetVezdeOn() == 1) {
          Main.manager.setSvetVezdeOn(0);
        }
        Main.manager.setSvetVezdeOn(1);
      }
    });
    perenoska.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setPerenoskaOn(1);
      }
    });
    timers.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setTimersGo(1);
      }
    });
    image3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setKartinka3(1);
      }
    });
    image2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setKartinka2(1);
      }
    });
    emergySvet.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.manager.setEmergeSvetOk(1);
      }
    });





    pushka.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
          if (pushka.getModel().isPressed()) {
          if (color1 == Color.GREEN) {
            color1 = Color.PINK;
          } else if (color1 == Color.PINK) {
            try {
              Main.Pushka(Main.serialPort, "r", "q");
            } catch (SerialPortException e) {
              e.printStackTrace();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            color1 = Color.GREEN;
            Main.manager.setPushkaTurnOn(1);
          }
          pushka.setBackground(color1);
        }
      }
    });
    flashDisk.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (flashDisk.getModel().isPressed()) {
          if (color2 == Color.GREEN) {
            color2 = Color.PINK;
            Main.manager.setFlashOn(0);

          } else if (color2 == Color.PINK) {
            color2 = Color.GREEN;
            Main.manager.setFlashOn(1);
          }
          flashDisk.setBackground(color2);
        }
      }
    });
    yashikFlash.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (yashikFlash.getModel().isPressed()) {
          if (color3 == Color.GREEN) {
            color3 = Color.PINK;
          } else if (color3 == Color.PINK) {
            color3 = Color.GREEN;
          }
          yashikFlash.setBackground(color3);
        }
      }
    });
    button4.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (button4.getModel().isPressed()) {
          if (color4 == Color.GREEN) {
            color4 = Color.PINK;
          } else if (color4 == Color.PINK) {
            color4 = Color.GREEN;
          }
          button4.setBackground(color4);
        }
      }
    });
    perenoska.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (perenoska.getModel().isPressed()) {
          if (color5 == Color.GREEN) {
            color5 = Color.PINK;
          } else if (color5 == Color.PINK) {
            color5 = Color.GREEN;
          }
          perenoska.setBackground(color5);
        }
      }
    });
    image2.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (image2.getModel().isPressed()) {
          if (color6 == Color.GREEN) {
            color6 = Color.PINK;
          } else if (color6 == Color.PINK) {
            color6 = Color.GREEN;
          }
          image2.setBackground(color6);
        }
      }
    });
    emergySvet.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (emergySvet.getModel().isPressed()) {
          if (color7 == Color.GREEN) {
            color7 = Color.PINK;
          } else if (color7 == Color.PINK) {
            color7 = Color.GREEN;
          }
          emergySvet.setBackground(color7);
        }
      }
    });
    button8.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (button8.getModel().isPressed()) {
          if (color8 == Color.GREEN) {
            color8 = Color.PINK;
          } else if (color8 == Color.PINK) {
            color8 = Color.GREEN;
          }
          button8.setBackground(color8);
        }
      }
    });
    lasers.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (lasers.getModel().isPressed()) {
          if (color9 == Color.GREEN) {
            color9 = Color.PINK;
            Main.manager.setLasersOK(0);
          } else if (color9 == Color.PINK) {
            color9 = Color.GREEN;
            Main.manager.setLasersOK(1);
          }
          lasers.setBackground(color9);
        }
      }
    });
    superCompModules.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (superCompModules.getModel().isPressed()) {
          if (color10 == Color.GREEN) {
            color10 = Color.PINK;
            Main.manager.setSuperComputersModulesOk(0);
          } else if (color10 == Color.PINK) {
            color10 = Color.GREEN;
            Main.manager.setSuperComputersModulesOk(1);
          }
          superCompModules.setBackground(color10);
        }
      }
    });
    shitokButton.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (shitokButton.getModel().isPressed()) {
          if (color11 == Color.GREEN) {
            color11 = Color.PINK;
            Main.manager.setShitokButton(0);
          } else if (color11 == Color.PINK) {
            color11 = Color.GREEN;
            Main.manager.setShitokButton(1);
          }
          shitokButton.setBackground(color11);
        }
      }
    });
    svetVezde.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (svetVezde.getModel().isPressed()) {
          if (color12 == Color.GREEN) {

            color12 = Color.PINK;
          } else if (color12 == Color.PINK) {
            color12 = Color.GREEN;
          }
          svetVezde.setBackground(color12);
        }
      }
    });
    button13.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (button13.getModel().isPressed()) {
          if (color13 == Color.GREEN) {
            color13 = Color.PINK;
          } else if (color13 == Color.PINK) {
            color13 = Color.GREEN;
          }
          button13.setBackground(color13);
        }
      }
    });
    timers.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (timers.getModel().isPressed()) {
          if (color14 == Color.GREEN) {
            color14 = Color.PINK;
          } else if (color14 == Color.PINK) {
            color14 = Color.GREEN;
          }
          timers.setBackground(color14);
        }
      }
    });
    audio1.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (audio1.getModel().isPressed()) {
          if (color15 == Color.GREEN) {
            color15 = Color.PINK;
          } else if (color15 == Color.PINK) {
            color15 = Color.GREEN;
          }
          audio1.setBackground(color15);
        }
      }
    });
    audio2.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (audio2.getModel().isPressed()) {
          if (color16 == Color.GREEN) {
            color16 = Color.PINK;
          } else if (color16 == Color.PINK) {
            color16 = Color.GREEN;
          }
          audio2.setBackground(color16);
        }
      }
    });
    audio3.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (audio3.getModel().isPressed()) {
          if (color17 == Color.GREEN) {
            color17 = Color.PINK;
          } else if (color17 == Color.PINK) {
            color17 = Color.GREEN;
          }
          audio3.setBackground(color17);
        }
      }
    });
    audio4.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (audio4.getModel().isPressed()) {
          if (color18 == Color.GREEN) {
            color18 = Color.PINK;
          } else if (color18 == Color.PINK) {
            color18 = Color.GREEN;
          }
          audio4.setBackground(color18);
        }
      }
    });
    audio5.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (audio5.getModel().isPressed()) {
          if (color19 == Color.GREEN) {
            color19 = Color.PINK;
          } else if (color19 == Color.PINK) {
            color19 = Color.GREEN;
          }
          audio5.setBackground(color19);
        }
      }
    });
    image3.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (image3.getModel().isPressed()) {
          if (color20 == Color.GREEN) {
            color20 = Color.PINK;
          } else if (color1 == Color.PINK) {
            color20 = Color.GREEN;
          }
          image3.setBackground(color20);
        }
      }
    });

    doorClose.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (doorClose.getModel().isPressed()) {
          if (color21 == Color.GREEN) {
            color21 = Color.PINK;
            Main.manager.setDoorClose(0);
          } else if (color1 == Color.PINK) {
            color21 = Color.GREEN;
            Main.manager.setDoorClose(1);
          }
          doorClose.setBackground(color21);
        }
      }
    });
    rubilnikSuperComp.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (rubilnikSuperComp.getModel().isPressed()) {
          if (color22 == Color.GREEN) {
            color22 = Color.PINK;
            Main.manager.setRubilnikSuperCompOn(0);
          } else if (color1 == Color.PINK) {
            color22 = Color.GREEN;
            Main.manager.setRubilnikSuperCompOn(1);
          }
          image3.setBackground(color22);
        }
      }
    });
    button23.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (button23.getModel().isPressed()) {
          if (color23 == Color.GREEN) {
            color23 = Color.PINK;
          } else if (color1 == Color.PINK) {
            color23 = Color.GREEN;
          }
          button23.setBackground(color23);
        }
      }
    });
    ventili.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (ventili.getModel().isPressed()) {
          if (color24 == Color.GREEN) {
            color24 = Color.PINK;
            Main.manager.setVentiliOk(0);
          } else if (color1 == Color.PINK) {
            color24 = Color.GREEN;
            Main.manager.setVentiliOk(1);
          }
          ventili.setBackground(color24);
        }
      }
    });
    sirena.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (sirena.getModel().isPressed()) {
          if (color25 == Color.GREEN) {
            color25 = Color.PINK;
          } else if (color1 == Color.PINK) {
            color25 = Color.GREEN;
          }
          sirena.setBackground(color25);
        }
      }
    });
    podsvetka.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (podsvetka.getModel().isPressed()) {
          if (color26 == Color.GREEN) {
            color26 = Color.PINK;
          } else if (color1 == Color.PINK) {
            color26 = Color.GREEN;
          }
          podsvetka.setBackground(color26);
        }
      }
    });
    button27.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (button27.getModel().isPressed()) {
          if (color27 == Color.GREEN) {
            color27 = Color.PINK;
          } else if (color1 == Color.PINK) {
            color27 = Color.GREEN;
          }
          button27.setBackground(color27);
        }
      }
    });
    image5.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (image5.getModel().isPressed()) {
          if (color28 == Color.GREEN) {
            color28 = Color.PINK;
          } else if (color1 == Color.PINK) {
            color28 = Color.GREEN;
          }
          image5.setBackground(color28);
        }
      }
    });
    monitorButton.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent evt) {
        if (monitorButton.getModel().isPressed()) {
          if (color29 == Color.GREEN) {
            color29 = Color.PINK;
            Main.manager.setMonitorButton(0);
          } else if (color1 == Color.PINK) {
            color29 = Color.GREEN;
            Main.manager.setMonitorButton(1);
          }
          monitorButton.setBackground(color29);
        }
      }
    });


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

