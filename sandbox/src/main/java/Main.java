import javazoom.jl.player.Player;
import jssc.SerialPort;
import jssc.SerialPortException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
/**
 * Created by vity on 24.07.2016.
 */
public class Main {

  public static Manager manager;
  public static SerialPort serialPort;
  public static TouchPanel touchPanel;
  public static MainForm myWindow;
  public static Timer1 timer1;


  public static Logger getLog() {
    return log;
  }

  public static final Logger log = Logger.getLogger(Main.class);


  public static void main(String[] args) throws SerialPortException, IOException, InterruptedException {

    System.out.println("git");
    
    manager = new Manager();
    myWindow = new MainForm();
    myWindow.setVisible(true);

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          touchPanel = new TouchPanel();
        } catch (IOException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        touchPanel.setVisible(true);
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          timer1 = new Timer1();
        } catch (IOException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        timer1.setVisible(true);
        timer1.timer1.stop();
       }
    }).start();







    new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("Serial IN");
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
          Main.log.info(ex);
        }
        log.info("Serial OUT");


/*        try {
          ResetQuest(serialPort, "ResetQuest", "ResetQuest");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/

        log.info("StartQuest IN");
        try {
          StartQuest();
        } catch (IOException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("StartQuest OUT");


        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Dver IN");
        try {
          WaitForDverClose(serialPort, "j");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Dver OUT");
        log.info("Pushka IN");
        try {
          Pushka(serialPort, "r", "q");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Pushka OUT");
        try {
          Thread.sleep(3500);
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Audio1 IN");
        PlayAudio1();
        myWindow.getAudio1().setBackground(Color.GREEN);
        log.info("Audio1 OUT");
        log.info("Perenoska IN");
        try {
          Perenoska(serialPort, "r", "s");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Perenoska OUT");
        log.info("Timers IN");
        TimersOn();
        myWindow.getTimers().setBackground(Color.GREEN);
        log.info("Timers OUT");

        log.info("MonitorButton IN");
        try {
          WaitForMonitorButton();
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("MonitorButton OUT");
/*        try {
          OpenShkaf(serialPort, "a", "b");
        } catch (InterruptedException | SerialPortException e) {
          e.printStackTrace();
        }*/
        log.info("SuperComp IN");
        try {
          WaitForSuperComp(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("SuperComp OUT");
        log.info("ShowImage2 IN");
        try {
          ShowImage("2");
        } catch (IOException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("ShowImage2 OUT");
        myWindow.getImage2().setBackground(Color.GREEN);
        log.info("Audio2 IN");
        PlayAudio2();
        log.info("Audio2 OUT");
        myWindow.getAudio2().setBackground(Color.GREEN);

        log.info("ShkafPodsvetka IN");
        try {
          ShkafPodsvetkaOn(serialPort, "a", "b");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("ShkafPodsvetka OUT");
        log.info("Lasers IN");
        try {
          WaitForLasers(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Lasers OUT");
        log.info("Image3 IN");
        try {
          ShowImage("3");
        } catch (IOException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Image3 OUT");
        myWindow.getImage3().setBackground(Color.GREEN);
        log.info("Ventils IN");
        try {
          WaitForVentils(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Ventils OUT");
        log.info("SvetVezdeOff IN");
        try {
          SvetVezdeOff(serialPort, "a", "b");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("SvetVezdeOff OUT");
        log.info("Audio3 IN");
        PlayAudio3();
        log.info("Audio3 OUT");
        myWindow.getAudio3().setBackground(Color.GREEN);
        log.info("Image2 IN");
        try {
          ShowImage("2");
        } catch (IOException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Image2 OUT");
/*        try {
          SetTumblers(serialPort, "a", "b");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
        }*/
        log.info("ShitokButton IN");
        try {
          WaitForShitokButton(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("ShitokButton OUT");
        log.info("Sirena IN");
        try {
          SirenaOn(serialPort, "a", "b");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Sirena OUT");
        log.info("EmergySvet IN");
        try {
          EmergySvet(serialPort, "a", "b");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("EmergySvet OUT");
        log.info("Audio4 IN");
        PlayAudio4();
        log.info("Audio4 OUT");
        myWindow.getAudio4().setBackground(Color.GREEN);
        log.info("Image5 IN");
        try {
          ShowImage("5");
        } catch (IOException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Image5 OUT");
        myWindow.getImage5().setBackground(Color.GREEN);
        log.info("Code IN");
        WaitForCode();
        log.info("Code OUT");
        log.info("Rubilnik IN");
        try {
          WaitForRubilnik(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Rubilnik OUT");
        log.info("YashikFlash IN");
        try {
          YashikFlashOpen(serialPort, "a", "b");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("YashikFlash OUT");
        log.info("Flash IN");
        try {
          WaitForFlash(serialPort, "a");
        } catch (InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("Flash OUT");
        log.info("Audio5 IN");
        PlayAudio5();
        log.info("Audio5 OUT");
        myWindow.getAudio5().setBackground(Color.GREEN);
        log.info("OpenDoor IN");
        try {
          OpenDoor(serialPort, "a", "b");
        } catch (SerialPortException | InterruptedException e) {
          e.printStackTrace();
          Main.log.info(e);
        }
        log.info("OpenDoor OUT");

      }


    }).start();
  }

 synchronized public static void PlayAudio5() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try{

          FileInputStream fis5 = new FileInputStream("C:\\test\\audio\\test5.mp3");
          Player playMP35 = new Player(fis5);

          playMP35.play();

        } catch(Exception e) {
          System.out.println(e);
          Main.log.info(e);
        }
      }
    }).start();

  }

synchronized public static void PlayAudio4() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try{

          FileInputStream fis4 = new FileInputStream("C:\\test\\audio\\test4.mp3");
          Player playMP34 = new Player(fis4);

          playMP34.play();

        } catch(Exception e) {
          System.out.println(e);
          Main.log.info(e);
        }
      }
    }).start();

  }

 synchronized public static void PlayAudio3() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try{

          FileInputStream fis3 = new FileInputStream("C:\\test\\audio\\test3.mp3");
          Player playMP33 = new Player(fis3);

          playMP33.play();

        } catch(Exception e) {
          System.out.println(e);
          Main.log.info(e);
        }
      }
    }).start();

  }

  synchronized public static void PlayAudio2() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try{

          FileInputStream fis2 = new FileInputStream("C:\\test\\audio\\test2.mp3");
          Player playMP32 = new Player(fis2);

          playMP32.play();

        } catch(Exception e) {
          System.out.println(e);
          Main.log.info(e);
        }
      }
    }).start();

  }

  private static void WaitForCode() {
    timer1.getCode().requestFocus();
  }

synchronized public static void ShowImage(String s) throws IOException {
    touchPanel.getComponent().setPic(ImageIO.read(new File("C:\\test\\img\\" + s + ".jpg")));
  }

  private static void OpenDoor(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    myWindow.getDoorClose().setBackground(Color.RED);
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
        Main.log.info(e);
      }
      Thread.sleep(2000);
    }
    myWindow.getFlashDisk().setBackground(Color.GREEN);
    
  }

 synchronized public static void YashikFlashOpen(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    myWindow.getYashikFlash().setBackground(Color.GREEN);
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
        Main.log.info(e);
      }
      Thread.sleep(2000);
    }
    myWindow.getRubilnikSuperComp().setBackground(Color.GREEN);
  }

  synchronized public static void SirenaOn(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    myWindow.getSirena().setBackground(Color.GREEN);

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
        Main.log.info(e);
      }
      Thread.sleep(2000);
    }
    myWindow.getShitokButton().setBackground(Color.GREEN);

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
        Main.log.info(e);
      }
      Thread.sleep(2000);
    }
    myWindow.getVentili().setBackground(Color.GREEN);

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
        Main.log.info(e);
      }
      Thread.sleep(2000);
    }
    myWindow.getLasers().setBackground(Color.GREEN);


  }

 synchronized public static void ShkafPodsvetkaOn(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
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
        Main.log.info(e);
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

  synchronized public static void PlayAudio1() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try{

          FileInputStream fis = new FileInputStream("C:\\test\\audio\\test1.mp3");
          Player playMP3 = new Player(fis);

          playMP3.play();

        } catch(Exception e) {
          System.out.println(e);
          Main.log.info(e);
        }
      }
    }).start();

  }

  synchronized public static void PlayMainTheme() throws IOException {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try{

          FileInputStream fism = new FileInputStream("C:\\test\\audio\\maintheme.mp3");
          Player playMP3m = new Player(fism);

          playMP3m.play();

        } catch(Exception e) {
          System.out.println(e);
          Main.log.info(e);
        }
      }
    }).start();

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
        Main.log.info(e);
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
        Main.log.info(e);
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
 synchronized public static void Perenoska(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
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
        Main.log.info(e);
      }
      serialPort.writeString(zapros);
      Thread.sleep(2000);
    }
  }
  synchronized  public static void SvetVezdeOff(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    Thread.sleep(2000);
    myWindow.getSvetVezde().setBackground(Color.RED);
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
        Main.log.info(e);
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
        Main.log.info(e);
      }
      Thread.sleep(2000);
    }
    Main.myWindow.getDoorClose().setBackground(Color.GREEN);
  }

 synchronized public static void EmergySvet(SerialPort serialPort, String zapros, String disconnect) throws SerialPortException, InterruptedException {
    serialPort.writeString(disconnect);
    Thread.sleep(500);
    serialPort.writeString(zapros);
    Thread.sleep(2000);
    myWindow.getEmergySvet().setBackground(Color.GREEN);
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
     Main.log.info(e);
   }
 return true;}


  /**
   * Created by kosty on 02.08.2016.
   */

}
