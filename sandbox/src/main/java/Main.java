import jssc.SerialPort;
import jssc.SerialPortException;

import javax.swing.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
/**
 * Created by vity on 24.07.2016.
 */
public class Main {

  public static Manager manager;
  public static SerialPort serialPort;



  public static void main(String[] args) throws SerialPortException, IOException, InterruptedException {
    manager = new Manager();
    JFrame myWindow = new MainForm();
    myWindow.setVisible(true);

/*    new Thread(new Runnable() {
      @Override
      public void run() {
        new TouchPanel().setVisible(true);
      }
    }).start();*/

    new Thread(new Runnable() {
      @Override
      public void run() {
        new Timer1().setVisible(true);
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
          PlayAudio(1);
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          Thread.sleep(3500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          Perenoska(serialPort, "r", "s");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
        }

/*        ShowFirstImage();
        TimerActivate();*/
        try {
          WaitForMonitorButton(serialPort,"a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          OpenShkaf(serialPort, "a", "b");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForSuperComp(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
/*        ShowSecondImage();*/
        try {
          PlayAudio(2);
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          ShkafPodsvetkaOn(serialPort, "a", "b");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForLasers(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
/*        ShowThirdImage();*/
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
          PlayAudio(3);
        } catch (IOException e) {
          e.printStackTrace();
        }
/*        ShowSecondImage();*/
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
          PlayAudio(4);
        } catch (IOException e) {
          e.printStackTrace();
        }
/*        ShowFifthImage();
        WaitForCode();*/
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
          PlayAudio(5);
        } catch (IOException e) {
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


  }

  private static void OpenShkaf(SerialPort serialPort, String zapros, String disconnect) throws InterruptedException, SerialPortException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);

  }

  private static void WaitForMonitorButton(SerialPort serialPort, String otvet) throws InterruptedException {
       String otvetSerial = "bad";
       while (!otvetSerial.contains(otvet) && Main.manager.getMonitorButton() == 0) {
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



  private static void TimersOn() {
    Main.manager.setTimersGo(1);

  }

  private static void PlayAudio(int s) throws IOException {

    Runtime.getRuntime().exec("cmd /c start C:\\test\\bats\\audio"+ s + ".bat");
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
    while (!otvetSerial.equals(otvet) && button == 0) {
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
    while (!otvetSerial.equals(otvet) && button == 0) {
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


/*    }*/

  }
  private static void Perenoska(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
     Thread.sleep(500);
     serialPort.writeString(zapros);
     Thread.sleep(2000);

  }

  private static void SvetVezde(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getSvetVezdeOn() == 0) {
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
    while (!otvetSerial.equals(otvet) && Main.manager.getSuperComputersModulesOk() == 0) {
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
    System.out.println("dver");
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
  }

  private static void EmergySvet(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    Thread.sleep(2000);
  }

  public static void ResetQuest(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    while (serialPort.readString().equals(otvet) && Main.manager.getResetQuestOk() != 0) {
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
