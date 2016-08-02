import jssc.SerialPort;
import jssc.SerialPortException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Set;
/**
 * Created by vity on 24.07.2016.
 */
public class Main {

  static public int PushkaTurnOn = 0;
  static public int PerenoskaOn = 0;
  static public int AccumlyatorOn = 0;
  static public int SvetShitok = 0;
  static public int KartaActivate = 0;
  static public int TumblersReady = 0;
  static public int SvetVezdeOn = 0;
  static public int SchitivatelKartiActivate = 0;
  static public int KapsulaOpen = 0;
  static public int TimersOn = 0;
  static public int SchitivatelOn = 0;
  static public int PlanshetLaunch = 0;
  static public int PlanshetCodeOn = 0;
  static public int DoorOpen = 0;
  static public int VideoOk = 0;
  static public int ButtonShkafOk = 0;
  static public int ShkafOpen = 0;
  static public int KeyOk = 0;
  static public int DoorShluzOneOpen = 0;
  static public int DoorShluzOneClose = 0;
  static public int ShluzButtonOutsideOk = 0;
  static public int DoorShluzOneBlock = 0;
  static public int DoorShluzTwoOpen = 0;
  static public int SuperComputersModulesOk = 0;
  static public int YashikClose = 0;
  static public int SuperComputerLaunch = 0;
  static public int LasersOK = 0;
  static public int VentiliOk = 0;
  static public int EletrichestvoOff = 0;
  static public int RichagBroke = 0;
  static public int EmergeSvetOk = 0;
  static public int DataOk = 0;
  static public int RubilnikSuperCompOn = 0;
  static public int YashikSuperCompOn = 0;
  static public int SvetMigaet = 0;
  static public int HardDriveOk = 0;
  static public int RichagOk = 0;
  static public int DoorWinOn = 0;
  static public int ShluzButtonInsideOk = 0;
  static public int RukaOk = 0;

  public void init() throws SerialPortException {

    SerialPort serialPort = new SerialPort("COM1");
    try {
      serialPort.openPort();//Open serial port
      serialPort.setParams(SerialPort.BAUDRATE_9600,
              SerialPort.DATABITS_8,
              SerialPort.STOPBITS_1,
              SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
      serialPort.closePort();//Close serial port
    }
    catch (SerialPortException ex) {
      System.out.println(ex);
    }



    serialPort.writeString("StartQuest");
    serialPort.writeString("ResetQuest");
    SystemPause(4000);
    TurnOnDevice(serialPort, "PushkaTurnOn", "PushkaTurnOn",PushkaTurnOn );
    PlayAudioOne();
    TurnOnDevice(serialPort, "PerenoskaOn", "PerenoskaOn",PerenoskaOn);
    WaitForDeviceOn(serialPort,"AccumlyatorOn", AccumlyatorOn);
    TurnOnDevice(serialPort, "SvetShitok","SvetShitok",SvetShitok);
    TurnOnDevice(serialPort,"KartaActivate", "KartaActivate", KartaActivate);
    WaitForDeviceOn(serialPort, "TumblersReady", TumblersReady);
    TurnOnDevice(serialPort, "SvetVezdeOn", "SvetVezdeOn",SvetVezdeOn);
    TurnOnDevice(serialPort, "SchitivatelKartiActivate", "SchitivatelKartiActivate", SchitivatelKartiActivate);
    TurnOnDevice(serialPort, "KapsulaOpen", "KapsulaOpen", KapsulaOpen);
    TurnOnDevice(serialPort, "TimersOn", "TimersOn", TimersOn);
    WaitForDeviceOn(serialPort, "SchitivatelOn", SchitivatelOn);
    TurnOnDevice(serialPort, "PlanshetLaunch", "PlanshetLaunch", PlanshetLaunch);
    WaitForDeviceOn(serialPort, "PlanshetCodeOn", PlanshetCodeOn);
    TurnOnDevice(serialPort, "DoorOpen", "DoorOpen", DoorOpen);
    WaitForDeviceOn(serialPort, "VideoOk", VideoOk);
    WaitForDeviceOn(serialPort, "ButtonShkafOk", ButtonShkafOk);
    TurnOnDevice(serialPort, "ShkafOpen", "ShkafOpen", ShkafOpen);
    WaitForDevicesOn(serialPort, ("RukaOk","KeyOk"), KeyOk, RukaOk);
    TurnOnDevice(serialPort, "DoorShluzOneOpen", "DoorShluzOneOpen", DoorShluzOneOpen);
    WaitForDeviceOn(serialPort, "DoorShluzOneClose", DoorShluzOneClose);
    WaitForDevicesOn(serialPort, ("ShluzButtonInsideOk","ShluzButtonOutsideOk"),ShluzButtonOutsideOk, ShluzButtonInsideOk);
    TurnOnDevice(serialPort, "DoorShluzOneBlock", "DoorShluzOneBlock", DoorShluzOneBlock);
    TurnOnDevice(serialPort, "DoorShluzTwoOpen", "DoorShluzTwoOpen", DoorShluzTwoOpen);
    WaitForDeviceOn(serialPort, "SuperComputersModulesOk", SuperComputersModulesOk);
    WaitForDeviceOn(serialPort, "YashikClose", YashikClose);
    TurnOnDevice(serialPort, "SuperComputerLaunch", "SuperComputerLaunch", SuperComputerLaunch);
    PlayAudioTwo();
/*    ChangeImageTwo();*/
    WaitForDeviceOn(serialPort, "LasersOK", LasersOK);
/*    ChangeImageThree();*/
    WaitForDeviceOn(serialPort, "VentiliOk", VentiliOk);
    TurnOnDevice(serialPort, "EletrichestvoOff", "EletrichestvoOff", EletrichestvoOff);
    PlayAudioThree();
/*    ChangeImageTouch();*/
    TurnOnDevice(serialPort, "RichagBroke", "RichagBroke", RichagBroke);
    WaitForDeviceOn(serialPort, "RichagOk", RichagOk);
    TurnOnDevice(serialPort, "EmergeSvetOk", "EmergeSvetOk", EmergeSvetOk);
    PlayAudioFour();
/*    ChangeImageFive();*/
    WaitForDeviceOn(serialPort, "DataOk", DataOk);
    WaitForDeviceOn(serialPort, "RubilnikSuperCompOn", RubilnikSuperCompOn);
    TurnOnDevice(serialPort, "YashikSuperCompOn", "YashikSuperCompOn", YashikSuperCompOn);
    TurnOnDevice(serialPort, "SvetMigaet", "SvetMigaet", SvetMigaet);
    WaitForDeviceOn(serialPort, "HardDriveOk", HardDriveOk);
    PlayAudioFive();
    TurnOnDevice(serialPort, "DoorWinOn", "DoorWinOn", DoorWinOn);
  }


  private void WaitForDevicesOn(SerialPort serialPort, Set<String> devices, int button1, int button2) throws SerialPortException {
    Set<String> readDevices = Collections.emptySet();
    while (devices != readDevices || (button1 == 1 && button2 == 1)) {
      readDevices.add(serialPort.readString());
    }
  }

  private void WaitForDeviceOn(SerialPort serialPort, String otvet, int button) throws SerialPortException {
    while (serialPort.readString() != otvet  || button == 1 ) {
         }
  }

  private void TurnOnDevice(SerialPort serialPort, String zapros, String otvet, int button) throws SerialPortException {
    while (serialPort.readString() != otvet || button == 1) {
      serialPort.writeString(zapros);
    }



  }

  public void ResetQuest(SerialPort serialPort) {
    serialPort.writeString();
  }



 static public boolean SystemPause(int n){
   try {
     Thread.sleep(n);
   } catch (InterruptedException e) {
     e.printStackTrace();
   }
 return true;}

  static public void TurnTheLightInAllRoom(Devices[] Room,int status,int n){
    for (int i =0;i<n; i++)
      Room[i].status=status;


  }
  static public void TurnTheTimeInAllDisplays(Devices[] Timer,int status,int n){

    for (int i =0;i<n; i++)
      Timer[i].status=status;
  }

  static public void TurnTheEnergyInAllRooms(Devices[]  Electrichestvo,int status,int n){

    for (int i =0;i<n; i++)
      Electrichestvo[i].status=status;
  }

  /**
   * Created by kosty on 02.08.2016.
   */
  public static class Arktika {
    private JButton timersOnButton;
    private JButton pushkaTurnOnButton;
    private JButton perenoskaOnButton;
    private JButton accumlyatorOnButton;
    private JButton svetShitokButton;
    private JButton kartaActivateButton;
    private JButton tumblersReadyButton;
    private JButton svetVezdeOnButton;
    private JButton schitivatelKartiActivateButton;
    private JButton kapsulaOpenButton;
    private JButton schitivatelOnButton;
    private JButton planshetLaunchButton;
    private JButton planshetCodeOnButton;
    private JButton doorOpenButton;
    private JButton videoOkButton;
    private JButton buttonShkafOkButton;
    private JButton shkafOpenButton;
    private JButton keyOkButton;
    private JButton doorShluzOneOpenButton;
    private JButton doorShluzOneCloseButton;
    private JButton shluzButtonOutsideOkButton;
    private JButton doorShluzOneBlockButton;
    private JButton doorShluzTwoOpenButton;
    private JButton superComputersModulesOkButton;
    private JButton yashikCloseButton;
    private JButton superComputerLaunchButton;
    private JButton lasersOKButton;
    private JButton ventiliOkButton;
    private JButton eletrichestvoOffButton;
    private JButton richagBrokeButton;
    private JButton emergeSvetOkButton;
    private JButton dataOkButton;
    private JButton rubilnikSuperCompOnButton;
    private JButton yashikSuperCompOnButton;
    private JButton svetMigaetButton;
    private JButton hardDriveOkButton;
    private JButton doorWinOnButton;
    private JButton richagOkButton;
    private JButton shluzButtonInsideOkButton;
    private JButton rukaOkButton;

    public Arktika() {
      pushkaTurnOnButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  PushkaTurnOn = 1;
              }
          });
      perenoskaOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          PerenoskaOn  = 1;
        }
      });
      accumlyatorOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          AccumlyatorOn = 1;
        }
      });
      svetShitokButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          SvetShitok = 1;
        }
      });
      kartaActivateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          KartaActivate = 1;
        }
      });
      tumblersReadyButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          TumblersReady = 1;
        }
      });
      svetVezdeOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          SvetVezdeOn = 1;
        }
      });
      schitivatelKartiActivateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          SchitivatelKartiActivate = 1;
        }
      });
      kapsulaOpenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          KapsulaOpen = 1;
        }
      });
      timersOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          TimersOn = 1;
        }
      });
      schitivatelOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          SchitivatelOn= 1;
        }
      });
      planshetLaunchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          PlanshetLaunch = 1;
        }
      });
      planshetCodeOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          PlanshetCodeOn = 1;
        }
      });
      doorOpenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          DoorOpen = 1;
        }
      });
      videoOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          VideoOk = 1;
        }
      });
      buttonShkafOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          ButtonShkafOk = 1;
        }
      });
      shkafOpenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          ShkafOpen = 1;
        }
      });
      keyOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          KeyOk = 1;
        }
      });
      doorShluzOneOpenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          DoorShluzOneOpen = 1;
        }
      });
      doorShluzOneCloseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          DoorShluzOneClose = 1;
        }
      });
      shluzButtonOutsideOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          ShluzButtonOutsideOk = 1;
        }
      });
      doorShluzOneBlockButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          DoorShluzOneBlock = 1;
        }
      });
      doorShluzTwoOpenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          DoorShluzTwoOpen = 1;
        }
      });
      superComputersModulesOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          SuperComputersModulesOk = 1;
        }
      });
      yashikCloseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          YashikClose = 1;
        }
      });
      superComputerLaunchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          SuperComputerLaunch = 1;
        }
      });
      lasersOKButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          LasersOK = 1;
        }
      });
      ventiliOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          VentiliOk = 1;
        }
      });
      eletrichestvoOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          EletrichestvoOff = 1;
        }
      });
      richagBrokeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          RichagBroke = 1;
        }
      });
      richagOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          RichagOk = 1;
        }
      });
      emergeSvetOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          EmergeSvetOk = 1;
        }
      });
      dataOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          DataOk = 1;
        }
      });
      rubilnikSuperCompOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          RubilnikSuperCompOn = 1;
        }
      });
      yashikSuperCompOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          YashikSuperCompOn = 1;
        }
      });
      svetMigaetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          SvetMigaet = 1;
        }
      });
      hardDriveOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          HardDriveOk = 1;
        }
      });
      doorWinOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          DoorWinOn = 1;
        }
      });
      rukaOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          RukaOk = 1;
        }
      });
      shluzButtonInsideOkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          ShluzButtonInsideOk = 1;
        }
      });


      }
  }
}
