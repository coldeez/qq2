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
/*        try {
          PlayMainTheme();
        } catch (IOException e) {
          e.printStackTrace();
        }*/
        SystemPause(4000);
        try {
          Pushka(serialPort, "q");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        try {
          DverOpen(serialPort, "");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        try {
          DverClose(serialPort, "");
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
          Perenoska(serialPort, "PerenoskaOn", "PerenoskaOn1");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
/*        try {
          WaitForDeviceOn(serialPort, "AccumlyatorOn1", manager.getAccumlyatorOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
        try {
          SvetShitok(serialPort, "SvetShitok", "SvetShitok1");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          Karta(serialPort, "KartaActivate", "KartaActivate1");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
/*         try {
         WaitForDeviceOn(serialPort, "TumblersReady1", manager.getTumblersReady());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
          try {
            SvetVezde(serialPort, "SvetVezdeOn1", "SvetVezdeOn1");
          } catch (SerialPortException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

          TimersOn();
/*        try {
          TurnOnDevice(serialPort, "SchitivatelKartiActivate", "SchitivatelKartiActivate1", manager.getSchitivatelKartiActivate());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
/*        try {
          TurnOnDevice(serialPort, "KapsulaOpen", "KapsulaOpen1", manager.getKapsulaOpen());
        } catch (SerialPortException e) {


        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
/*          try {
            TurnOnDevice(serialPort, "TimersOn", "TimersOn1", manager.getTimersOn());
          } catch (SerialPortException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }*/

/*        try {
          WaitForDeviceOn(serialPort, "SchitivatelOn1", manager.getSchitivatelOn());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
/*        try {
          TurnOnDevice(serialPort, "PlanshetLaunch", "PlanshetLaunch1", manager.getKartinka3());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          WaitForDeviceOn(serialPort, "PlanshetCodeOn1", manager.getKartinka2());
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
*//*    WaitForDevicesOn(serialPort, new HashSet<String>(Arrays.asList("RukaOk", "KeyOk")), KeyOk, RukaOk);*//*
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
*//*    WaitForDevicesOn(serialPort, ("ShluzButtonInsideOk","ShluzButtonOutsideOk"),ShluzButtonOutsideOk, ShluzButtonInsideOk);*//*
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
        }*/
          try {
            SuperComp(serialPort, "SuperComputersModulesOk1");
          } catch (SerialPortException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
/*        try {
          WaitForDeviceOn(serialPort, "YashikClose1", manager.getYashikClose());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
/*        try {
          TurnOnDevice(serialPort, "SuperComputerLaunch", "SuperComputerLaunch1", manager.getTimers());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
          try {
            PlayAudio(2);
          } catch (IOException e) {
            e.printStackTrace();
          }
/*    ChangeImageTwo();*/
          try {
            Lasers(serialPort, "LasersOK1");
          } catch (SerialPortException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
/*    ChangeImageThree();*/
/*        try {
          WaitForDeviceOn(serialPort, "VentiliOk1", manager.getVentiliOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
/*        try {
          TurnOnDevice(serialPort, "EletrichestvoOff", "EletrichestvoOff1", manager.getEletrichestvoOff());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
          try {
            PlayAudio(3);
          } catch (IOException e) {
            e.printStackTrace();
          }
/*    ChangeImageTouch();*/
/*        try {
          TurnOnDevice(serialPort, "RichagBroke", "RichagBroke1", manager.getRichagBroke());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
          try {
            ShitokButton(serialPort, "ShitokButton1");
          } catch (SerialPortException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        try {
          SvetVezdeOff(serialPort, "SvetVezdeOff", "SveVezdeOff1");
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

          try {
            EmergySvet(serialPort, "EmergeSvetOk", "EmergeSvetOk1");
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
/*        try {
          WaitForDeviceOn(serialPort, "DataOk1", manager.getDataOk());
        } catch (SerialPortException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
/*          try {
            WaitForDeviceOn(serialPort, "RubilnikSuperCompOn1", manager.getRubilnikSuperCompOn());
          } catch (SerialPortException | InterruptedException e) {
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
          }*/

          try {
            HardDrive(serialPort, "HardDriveOk1");
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
  private static void Pushka(SerialPort serialPort, String zapros) throws SerialPortException, InterruptedException {
    while (Main.manager.getPushkaTurnOn() == 0) {
      serialPort.writeString(zapros);
      Thread.sleep(20000);
    }
  }
  private static void Perenoska(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getPerenoskaOn() == 0) {
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
  private static void Karta(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getKartaActivate() == 0) {
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
  }  private static void SvetVezdeOff(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getSvetVezdeOn() == 1) {
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
  private static void SvetShitok(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getSvetShitok() == 0) {
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

  private static void SuperComp(SerialPort serialPort, String otvet) throws SerialPortException, InterruptedException {
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
  private static void DverClose(SerialPort serialPort, String otvet) throws SerialPortException, InterruptedException {
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
  private static void Lasers(SerialPort serialPort, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getLasersOK() == 0) {
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
  private static void HardDrive(SerialPort serialPort, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getHardDriveOk() == 0) {
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

  private static void ShitokButton(SerialPort serialPort, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getShitokButton() == 0) {
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

  private static void EmergySvet(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, InterruptedException {
    String otvetSerial = "bad";
    while (!otvetSerial.equals(otvet) && Main.manager.getEmergeSvetOk() == 0) {
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
    while (serialPort.readString().equals(otvet) && Main.manager.getResetQuestOk() != 0) {
      Thread.sleep(500);
      System.out.println(manager.getResetQuestOk()+" reset");
      serialPort.writeString(zapros);
    }
  }

  public static void StartQuest(SerialPort serialPort, String zapros, String otvet) throws SerialPortException, IOException, InterruptedException {
    /*startWMP();*/
    while (serialPort.readString().equals(otvet) && Main.manager.getStartQuestOk() == 0) {
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
