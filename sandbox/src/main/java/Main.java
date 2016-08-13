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



  public static void main(String[] args) throws SerialPortException, IOException, InterruptedException {
    manager = new Manager();
    JFrame myWindow = new MainForm();
    myWindow.setVisible(true);

    new Thread(new Runnable() {
      @Override
      public void run() {
        new TouchPanel().setVisible(true);
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        new Timer1().setVisible(true);
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        new Timer3().setVisible(true);
      }
    }).start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        new Timer2().setVisible(true);
      }
    }).start();


    new Thread(new Runnable() {
      @Override
      public void run() {
        SerialPort serialPort = new SerialPort("COM4");
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
          StartQuest(serialPort, "StartQuest", "StartQuest");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
        SystemPause(4000);
        try {
          TurnOnDevice(serialPort, "PushkaTurnOn", "PushkaTurnOn1", manager.getPushkaTurnOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        try {
          PlayAudio(1);
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "PerenoskaOn", "PerenoskaOn1", manager.getPerenoskaOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "AccumlyatorOn1", manager.getAccumlyatorOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SvetShitok", "SvetShitok1", manager.getSvetShitok());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "KartaActivate", "KartaActivate1", manager.getKartaActivate());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "TumblersReady1", manager.getTumblersReady());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SvetVezdeOn1", "SvetVezdeOn1", manager.getSvetVezdeOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SchitivatelKartiActivate", "SchitivatelKartiActivate1", manager.getSchitivatelKartiActivate());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "KapsulaOpen", "KapsulaOpen1", manager.getKapsulaOpen());
        } catch (SerialPortException e) {


        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "TimersOn", "TimersOn1", manager.getTimersOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "SchitivatelOn1", manager.getSchitivatelOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "PlanshetLaunch", "PlanshetLaunch1", manager.getPlanshetLaunch());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "PlanshetCodeOn1", manager.getPlanshetCodeOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "DoorOpen", "DoorOpen1", manager.getDoorOpen());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "VideoOk1", manager.getVideoOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "ButtonShkafOk1", manager.getButtonShkafOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "ShkafOpen", "ShkafOpen1", manager.getShkafOpen());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
/*    WaitForDevicesOn(serialPort, new HashSet<String>(Arrays.asList("RukaOk", "KeyOk")), KeyOk, RukaOk);*/
        try {
          TurnOnDevice(serialPort, "DoorShluzOneOpen", "DoorShluzOneOpen1", manager.getDoorShluzOneOpen());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "DoorShluzOneClose1", manager.getDoorShluzOneClose());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
/*    WaitForDevicesOn(serialPort, ("ShluzButtonInsideOk","ShluzButtonOutsideOk"),ShluzButtonOutsideOk, ShluzButtonInsideOk);*/
        try {
          TurnOnDevice(serialPort, "DoorShluzOneBlock", "DoorShluzOneBlock1", manager.getDoorShluzOneBlock());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "DoorShluzTwoOpen", "DoorShluzTwoOpen1", manager.getDoorShluzTwoOpen());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "SuperComputersModulesOk1", manager.getSuperComputersModulesOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "YashikClose1", manager.getYashikClose());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SuperComputerLaunch", "SuperComputerLaunch1", manager.getSuperComputerLaunch());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(2);
        } catch (IOException e) {
          e.printStackTrace();
        }
/*    ChangeImageTwo();*/
        try {
          WaitForDeviceOn(serialPort, "LasersOK1", manager.getLasersOK());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
/*    ChangeImageThree();*/
        try {
          WaitForDeviceOn(serialPort, "VentiliOk1", manager.getVentiliOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "EletrichestvoOff", "EletrichestvoOff1", manager.getEletrichestvoOff());
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
/*    ChangeImageTouch();*/
        try {
          TurnOnDevice(serialPort, "RichagBroke", "RichagBroke1", manager.getRichagBroke());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "RichagOk1", manager.getRichagOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "EmergeSvetOk", "EmergeSvetOk1", manager.getEmergeSvetOk());
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
/*    ChangeImageFive();*/
        try {
          WaitForDeviceOn(serialPort, "DataOk1", manager.getDataOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "RubilnikSuperCompOn1", manager.getRubilnikSuperCompOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "YashikSuperCompOn", "YashikSuperCompOn1", manager.getYashikSuperCompOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SvetMigaet", "SvetMigaet1", manager.getSvetMigaet());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "HardDriveOk1", manager.getHardDriveOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(5);
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "DoorWinOn", "DoorWinOn1", manager.getDoorWinOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          serialPort.closePort();//Close serial port
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
      }

    }).start();
  }

  private static void PlayAudio(int s) throws IOException {

    Runtime.getRuntime().exec("cmd /c start C:\\bats\\audio"+ s + ".bat");
  }


  private void WaitForDevicesOn(SerialPort serialPort, Set<String> devices, int button1, int button2) throws SerialPortException {
    Set<String> readDevices = Collections.emptySet();
    while (devices != readDevices && (button1 == 1 && button2 == 1)) {
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

  public static void ResetQuest(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    while (serialPort.readString() != otvet && Main.manager.getResetQuestOk() != 1) {
      Thread.sleep(500);
      System.out.println(manager.getResetQuestOk()+" reset");
      serialPort.writeString(zapros);
    }
  }

  public static void StartQuest(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, IOException, InterruptedException {
    /*startWMP();*/
    while (serialPort.readString() != otvet && Main.manager.getStartQuestOk() == 1) {
      Thread.sleep(500);
      System.out.println(manager.getStartQuestOk()+"start");
      serialPort.writeString(zapros);
    }
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
