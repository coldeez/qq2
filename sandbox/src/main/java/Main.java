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
    WaitForDevicesOn(serialPort, ("RukaOk","KeyOk"), KeyOk);
    TurnOnDevice(serialPort, "DoorShluzOneOpen", "DoorShluzOneOpen", DoorShluzOneOpen);
    WaitForDeviceOn(serialPort, "DoorShluzOneClose", DoorShluzOneClose);
    WaitForDevicesOn(serialPort, ("ShluzButtonInsideOk","ShluzButtonOutsideOk"),ShluzButtonOutsideOk);
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
    WaitForDeviceOn(serialPort, "RichagOk");
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


  private void WaitForDevicesOn(SerialPort serialPort, Set<String> devices, int button) throws SerialPortException {
    Set<String> readDevices = Collections.emptySet();
    while (devices != readDevices button == 1) {
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
      private JButton PushkaTurnOn;
    private JButton button10;
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

    public Arktika() {
          button10.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  PushkaTurnOn = 1;
              }
          });
      }
  }
}
