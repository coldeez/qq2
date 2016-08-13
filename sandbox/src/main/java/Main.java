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

        try {
          ResetQuest(serialPort, "ResetQuest", "ResetQuest");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          StartQuest(serialPort, "StartQuest", "StartQuest");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        SystemPause(4000);
        try {
          TurnOnDevice(serialPort, "PushkaTurnOn", "PushkaTurnOn", manager.getPushkaTurnOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(1);
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "PerenoskaOn", "PerenoskaOn", manager.getPerenoskaOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "AccumlyatorOn", manager.getAccumlyatorOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SvetShitok", "SvetShitok", manager.getSvetShitok());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "KartaActivate", "KartaActivate", manager.getKartaActivate());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "TumblersReady", manager.getTumblersReady());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SvetVezdeOn", "SvetVezdeOn", manager.getSvetVezdeOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SchitivatelKartiActivate", "SchitivatelKartiActivate", manager.getSchitivatelKartiActivate());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "KapsulaOpen", "KapsulaOpen", manager.getKapsulaOpen());
        } catch (SerialPortException e) {


        }
        try {
          TurnOnDevice(serialPort, "TimersOn", "TimersOn", manager.getTimersOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "SchitivatelOn", manager.getSchitivatelOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "PlanshetLaunch", "PlanshetLaunch", manager.getPlanshetLaunch());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "PlanshetCodeOn", manager.getPlanshetCodeOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "DoorOpen", "DoorOpen", manager.getDoorOpen());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "VideoOk", manager.getVideoOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "ButtonShkafOk", manager.getButtonShkafOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "ShkafOpen", "ShkafOpen", manager.getShkafOpen());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
/*    WaitForDevicesOn(serialPort, new HashSet<String>(Arrays.asList("RukaOk", "KeyOk")), KeyOk, RukaOk);*/
        try {
          TurnOnDevice(serialPort, "DoorShluzOneOpen", "DoorShluzOneOpen", manager.getDoorShluzOneOpen());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "DoorShluzOneClose", manager.getDoorShluzOneClose());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
/*    WaitForDevicesOn(serialPort, ("ShluzButtonInsideOk","ShluzButtonOutsideOk"),ShluzButtonOutsideOk, ShluzButtonInsideOk);*/
        try {
          TurnOnDevice(serialPort, "DoorShluzOneBlock", "DoorShluzOneBlock", manager.getDoorShluzOneBlock());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "DoorShluzTwoOpen", "DoorShluzTwoOpen", manager.getDoorShluzTwoOpen());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "SuperComputersModulesOk", manager.getSuperComputersModulesOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "YashikClose", manager.getYashikClose());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SuperComputerLaunch", "SuperComputerLaunch", manager.getSuperComputerLaunch());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(2);
        } catch (IOException e) {
          e.printStackTrace();
        }
/*    ChangeImageTwo();*/
        try {
          WaitForDeviceOn(serialPort, "LasersOK", manager.getLasersOK());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
/*    ChangeImageThree();*/
        try {
          WaitForDeviceOn(serialPort, "VentiliOk", manager.getVentiliOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "EletrichestvoOff", "EletrichestvoOff", manager.getEletrichestvoOff());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(3);
        } catch (IOException e) {
          e.printStackTrace();
        }
/*    ChangeImageTouch();*/
        try {
          TurnOnDevice(serialPort, "RichagBroke", "RichagBroke", manager.getRichagBroke());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "RichagOk", manager.getRichagOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "EmergeSvetOk", "EmergeSvetOk", manager.getEmergeSvetOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(4);
        } catch (IOException e) {
          e.printStackTrace();
        }
/*    ChangeImageFive();*/
        try {
          WaitForDeviceOn(serialPort, "DataOk", manager.getDataOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "RubilnikSuperCompOn", manager.getRubilnikSuperCompOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "YashikSuperCompOn", "YashikSuperCompOn", manager.getYashikSuperCompOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "SvetMigaet", "SvetMigaet", manager.getSvetMigaet());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "HardDriveOk", manager.getHardDriveOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        }
        try {
          PlayAudio(5);
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          TurnOnDevice(serialPort, "DoorWinOn", "DoorWinOn", manager.getDoorWinOn());
        } catch (SerialPortException e) {
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

  private static void WaitForDeviceOn(SerialPort serialPort, String otvet, int button) throws SerialPortException {
    while (serialPort.readString() != otvet  && button == 1 ) {
         }
  }

  private static void TurnOnDevice(SerialPort serialPort, String zapros, String otvet, int button) throws SerialPortException {
    while (serialPort.readString() != otvet && button == 1) {
      serialPort.writeString(zapros);
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
