import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.util.TimerTask;
/**
 * Created by vity on 24.07.2016.
 */
public class Main {

  public void init() {




    Devices Svet = new Devices(1,"light",0,"default");
    Devices Pushka = new Devices(2,"gun",0,"default");
    Devices Akkamulyator=new Devices(3,"Akkum",0,"default");
    Devices SvetNaprotivShitka=new Devices(4,"SvetNaprotivShitka",0,"default");
    Devices Map=new Devices(5,"Map",0,"default");
    Devices Tumbler=new Devices(6,"Tumbler",0,"default");
    Devices CheckCardReader=new Devices(7,"CheckCardReader",0,"default");
    Devices[] Room = new Devices[4];
    Room[0]=new Devices(8,"Room1",0,"default");
    Room[1]=new Devices(9,"Room2",0,"default");
    Room[2]=new Devices(10,"Room3",0,"default");
    Room[3]=new Devices(11,"Room4",0,"default");
    Devices CapsulaSRukoi=new Devices(12,"CapsulaSRukoi",0,"default");
    Devices[]Timer=new Devices[2];
    Timer[0]=new Devices(13,"Timer1",0,"default");
    Timer[0]=new Devices(14,"Timer2",0,"default");
    Timer[0]=new Devices(15,"Timer3",0,"default");
    Devices Planchet1=new Devices(16,"Planchet1",0,"default");
    Devices TheDoor=new Devices(17,"TheDoor",0,"default");
    Devices Shkaf=new Devices(18,"Shkaf",0,"default");
    Devices Planchet2=new Devices(16,"Planchet2",0,"default");
    Devices DverShluz1=new Devices(17,"DverShluz1",0,"default");
    Devices KnopkaVnutriShluza1=new Devices(17,"KnopkaVnutriShluza1",0,"default");
    Devices KnopkaSnaruji=new Devices(18,"KnopkaSnaruji",0,"default");
    Devices DverShluz2=new Devices(19,"DverShluz2",0,"default");
    Devices SuperComputer=new Devices(20,"SuperComputer",0,"default");
    Devices Lazer=new Devices(21,"Lazer",0,"default");
    Devices VentiliSystemiOhl=new Devices(22,"VentiliSystemiOhl",0,"default");
    Devices[] Electrichestvo = new Devices[4];
    Electrichestvo[0]=new Devices(23,"Electrichestvo1",0,"default");
    Electrichestvo[1]=new Devices(24,"Electrichestvo2",0,"default");
    Electrichestvo[2]=new Devices(25,"Electrichestvo3",0,"default");
    Electrichestvo[3]=new Devices(26,"Electrichestvo4",0,"default");
    Devices RichagvSysteme=new Devices(27,"RichagvSysteme",0,"default");
    Devices AvariunieSvet=new Devices(28,"AvariunieSvet",0,"default");
    Devices RubilnikOnTheSuperComputer=new Devices(29,"RubilnikOnTheSuperComputer",0,"default");
    Devices RadioStation=new Devices(30,"RadioStation",0,"default");

  }
   // init();
    //Turn(Svet, 1);
/*
    static public void Turn(Devices device, int status) {

       int ComportValue = ReadComPortStatus();
      if (ComportValue = 1) {
        device.status=1;
      } else if (ComportValue=0)
      {
        device.status=0;
      }else JOptionPane.showMessageDialog(null,"ComPort ne opredelen");
    }
*/


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
}
