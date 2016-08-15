import jssc.SerialPort;
import jssc.SerialPortException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
/**
 * Created by vity on 24.07.2016.
 */
public class Main {

  public static Manager manager;
  public static SerialPort serialPort;
  public static TouchPanel touchPanel;
  public static MainForm myWindow;
  public static Timer1 timer1;




  public static void main(String[] args) throws SerialPortException, IOException, InterruptedException {
    manager = new Manager();
    myWindow = new MainForm();
    myWindow.setVisible(true);

    new Thread(new Runnable() {
      @Override
      public void run() {
        touchPanel = new TouchPanel();
        touchPanel.setVisible(true);
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        timer1 = new Timer1();
        timer1.setVisible(true);
       }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        serialPort = new SerialPort("COM4");
        try {
          serialPort.getPortName();
          serialPort.openPort();//Open serial port
          serialPort.setParams(SerialPort.BAUDRATE_9600,
                  SerialPort.DATABITS_8,
                  SerialPort.STOPBITS_1,
                  SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);

        } catch (SerialPortException ex) {
          System.out.println(ex);
        }

/*        try {
          ResetQuest(serialPort, "ResetQuest", "ResetQuest");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
/*        try {
          StartQuest();
        } catch (IOException e) {
          e.printStackTrace();
        }*/

        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        try {
          WaitForDverClose(serialPort, "j");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
        }
        try {
          Pushka(serialPort, "r", "q");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
        }
        try {
          Thread.sleep(3500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        try {
          PlayAudio(1, 10000);
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
        }
        myWindow.getAudio1().setBackground(Color.GREEN);


        try {
          Perenoska(serialPort, "r", "s");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
        }

        TimersOn();
        myWindow.getTimers().setBackground(Color.GREEN);


        try {
          WaitForMonitorButton();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

/*        try {
          OpenShkaf(serialPort, "a", "b");
        } catch (InterruptedException | SerialPortException e) {
          e.printStackTrace();
        }*/
        try {
          WaitForSuperComp(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          ShowImage("2");
        } catch (IOException e) {
          e.printStackTrace();
        }
        myWindow.getImage2().setBackground(Color.GREEN);
        try {
          PlayAudio(2, 10000);
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
        }
        myWindow.getAudio2().setBackground(Color.GREEN);

        try {
          ShkafPodsvetkaOn(serialPort, "a", "b");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForLasers(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          ShowImage("3");
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          WaitForVentils(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          SvetVezdeOff(serialPort, "a", "b");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(3, 10000);
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          ShowImage("2");
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          SetTumblers(serialPort, "a", "b");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForShitokButton(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          SirenaOn(serialPort, "a", "b");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          EmergySvet(serialPort, "a", "b");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(4, 10000);
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          ShowImage("5");
        } catch (IOException e) {
          e.printStackTrace();
        }
/*        WaitForCode();*/
        try {
          WaitForRubilnik(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          YashikFlashOpen(serialPort, "a", "b");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForFlash(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(5, 10000);
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          OpenDoor(serialPort, "a", "b");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        }


    }).start();
  }

  private static void ShowImage(String s) throws IOException {
    touchPanel.getComponent().setPic(ImageIO.read(new File("C:\\test\\test" + s + ".png")));
  }

  private static void OpenDoor(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
  }

  private static void OpenShluz(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
  }

  private static void WaitForFlash(SerialPort serialPort, String otvet) throws InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getFlashOn() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException | SerialPortException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }
    
  }

  private static void YashikFlashOpen(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
  }

  private static void WaitForRubilnik(SerialPort serialPort, String otvet) throws InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getRubilnikSuperCompOn() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException | SerialPortException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }
  }

  private static void SirenaOn(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);

  }

  private static void WaitForShitokButton(SerialPort serialPort, String otvet) throws InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getShitokButton() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException | SerialPortException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }

  }

  private static void SetTumblers(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);

  }

  private static void WaitForVentils(SerialPort serialPort, String otvet) throws InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getVentiliOk() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException | SerialPortException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }

  }

  private static void WaitForLasers(SerialPort serialPort, String otvet) throws InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getLasersOK() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException | SerialPortException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }


  }

  private static void ShkafPodsvetkaOn(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    myWindow.getPodsvetka().setBackground(Color.GREEN);
  }

  private static void WaitForSuperComp(SerialPort serialPort, String otvet) throws InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getSuperComputersModulesOk() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException | SerialPortException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }
    myWindow.getSuperCompModules().setBackground(Color.GREEN);


  }

  private static void OpenShkaf(SerialPort serialPort, String zapros, String disconnect) throws InterruptedException, SerialPortException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);


  }

  private static void WaitForMonitorButton() throws InterruptedException {

       while (Main.manager.getMonitorButton() == 0) {
         Thread.sleep(2000);

      }
    myWindow.getMonitorButton().setBackground(Color.GREEN);

  }



  private static void TimersOn() {

    timer1.getTimerLabel1().setForeground(Color.RED);
    timer1.timer1.start();


  }

  synchronized public static void PlayAudio(int s, int n) throws IOException, InterruptedException {

    Runtime.getRuntime().exec("cmd /c start C:\\test\\bats\\audio"+ s + ".bat");
    Thread.sleep(n);
  }

  private static void PlayMainTheme() throws IOException {
    Runtime.getRuntime().exec("cmd /c start C:\\test\\bats\\mainaudio.bat");
  }


  private void WaitForDevicesOn(SerialPort serialPort, Set<String> devices, int button1, int button2) throws SerialPortException {
    Set<String> readDevices = Collections.emptySet();
    while (devices != readDevices && (button1 == 0 && button2 == 0)) {
      readDevices.add(serialPort.readString());
    }
  }


  private static void WaitForDeviceOn(SerialPort serialPort, String otvet, int button) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && button == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }
  }

  private static void TurnOnDevice(SerialPort serialPort, String zapros, String otvet, int button) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && button == 0) {
      System.out.println(button);
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException e) {
        e.printStackTrace();
      }
      serialPort.writeString(zapros);
      Thread.sleep(2000);
    }
  }
  synchronized public static void Pushka(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
      serialPort.writeString(disconnect);
      Thread.sleep(500);
      serialPort.writeString(zapros);
      myWindow.getPushka().setBackground(Color.GREEN);

  }
  private static void Perenoska(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
     Thread.sleep(500);
     serialPort.writeString(zapros);
     Thread.sleep(2000);
     myWindow.getPerenoska().setBackground(Color.GREEN);

  }

  private static void SvetVezde(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getSvetVezdeOn() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException e) {
        e.printStackTrace();
      }
      serialPort.writeString(zapros);
      Thread.sleep(2000);
    }
  }
  private static void SvetVezdeOff(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    Thread.sleep(2000);
  }


  private static void DverOpen(SerialPort serialPort, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getSuperComputersModulesOk() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }
  }
  private static void WaitForDverClose(SerialPort serialPort, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.contains(otvet) && Main.manager.getDoorClose() == 0) {
      try {
        otvetSerial = serialPort.readString();
        if (otvetSerial == null) {
          otvetSerial = "bad";
        }
      } catch (NullPointerException e) {
        e.printStackTrace();
      }
      Thread.sleep(2000);
    }
    Main.myWindow.getDoorClose().setBackground(Color.GREEN);
  }

  private static void EmergySvet(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    Thread.sleep(2000);
  }

  public static void ResetQuest(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    while (serialPort.readString().contains(otvet) && Main.manager.getResetQuestOk() != 0) {
      Thread.sleep(500);
      System.out.println(manager.getResetQuestOk()+" reset");
      serialPort.writeString(zapros);
    }
  }

  public static void StartQuest() throws IOException {
    while (Main.manager.getStartQuestOk() == 0) {

    }
    PlayMainTheme();

  }

  private static void startWMP() throws IOException {
    Runtime.getRuntime().exec("cmd /c start C:\\bats\\wmp.bat");
  }


  static public boolean SystemPause(int n){
   try {
     Thread.sleep(n);
   } catch (InterruptedException e) {
     e.printStackTrace();
   }
 return true;}


  /**
   * Created by kosty on 02.08.2016.
   */

}
