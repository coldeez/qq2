/**
 * Created by kbal on 03.08.2016.
 */
public class Manager {


  private int AccumlyatorOn = 0;

  private int TumblersReady = 0;

  private int SchitivatelKartiActivate = 0;
  private int KapsulaOpen = 0;
  private int TimersOn = 0;
  private int SchitivatelOn = 0;

  private int DoorOpen = 0;
  private int VideoOk = 0;
  private int ButtonShkafOk = 0;
  private int ShkafOpen = 0;
  private int KeyOk = 0;
  private int DoorShluzOneOpen = 0;


  private int DoorShluzOneBlock = 0;
  private int DoorShluzTwoOpen = 0;

  private int YashikClose = 0;


  private int VentiliOk = 0;
  private int EletrichestvoOff = 0;
  private int RichagBroke = 0;

  private int DataOk = 0;
  private int RubilnikSuperCompOn = 0;

  private int SvetMigaet = 0;
  private int HardDriveOk = 0;
  private int DoorWinOn = 0;

  volatile private int doorClose = 0;

  volatile private int monitorButton = 0;
  volatile private int flashOn = 0;
  volatile private int PushkaTurnOn = 0;
  volatile private int Kartinka3 = 0;
  volatile private int Kartinka2 = 0;
  volatile private int Timers = 0;
  volatile private int SuperComputersModulesOk = 0;
  volatile private int PerenoskaOn = 0;
  volatile private int SvetShitok = 0;
  volatile private int KartaActivate = 0;
  volatile private int SvetVezdeOn = 0;
  volatile private int LasersOK = 0;
  volatile private int EmergeSvetOk = 0;
  volatile private int ShitokButton = 0;
  volatile private int RadioStation = 0;

  private int RukaOk = 0;
  volatile private int Audio1 = 0;
  volatile private int Audio2 = 0;
  volatile private int Audio3 = 0;
  volatile private int Audio4 = 0;
  volatile private int Audio5 = 0;
  volatile private int StartQuestOk = 0;
  volatile private int  ResetQuestOk = 0;


synchronized   public int getTimersGo() {
    return timersGo;
  }

synchronized   public void setTimersGo(int timersGo) {
    this.timersGo = timersGo;
  }

  volatile private int timersGo = 0;


synchronized   public int getPushkaTurnOn() {
    return PushkaTurnOn;
  }

synchronized   public void setPushkaTurnOn(int pushkaTurnOn) {
    PushkaTurnOn = pushkaTurnOn;
  }

  synchronized public int getPerenoskaOn() {
    return PerenoskaOn;
  }

  synchronized public void setPerenoskaOn(int perenoskaOn) {
    PerenoskaOn = perenoskaOn;
  }

  public int getAccumlyatorOn() {
    return AccumlyatorOn;
  }

  public void setAccumlyatorOn(int accumlyatorOn) {
    AccumlyatorOn = accumlyatorOn;
  }

  synchronized public int getSvetShitok() {
    return SvetShitok;
  }

  synchronized public void setSvetShitok(int svetShitok) {
    SvetShitok = svetShitok;
  }

  synchronized public int getKartaActivate() {
    return KartaActivate;
  }

  synchronized public void setKartaActivate(int kartaActivate) {
    KartaActivate = kartaActivate;
  }

  public int getTumblersReady() {
    return TumblersReady;
  }

  public void setTumblersReady(int tumblersReady) {
    TumblersReady = tumblersReady;
  }

  synchronized public int getSvetVezdeOn() {
    return SvetVezdeOn;
  }

  synchronized public void setSvetVezdeOn(int svetVezdeOn) {
    SvetVezdeOn = svetVezdeOn;
  }

  public int getSchitivatelKartiActivate() {
    return SchitivatelKartiActivate;
  }

  public void setSchitivatelKartiActivate(int schitivatelKartiActivate) {
    SchitivatelKartiActivate = schitivatelKartiActivate;
  }

  public int getKapsulaOpen() {
    return KapsulaOpen;
  }

  public void setKapsulaOpen(int kapsulaOpen) {
    KapsulaOpen = kapsulaOpen;
  }

  public int getTimersOn() {
    return TimersOn;
  }

  public void setTimersOn(int timersOn) {
    TimersOn = timersOn;
  }

  public int getSchitivatelOn() {
    return SchitivatelOn;
  }

  public void setSchitivatelOn(int schitivatelOn) {
    SchitivatelOn = schitivatelOn;
  }

synchronized   public int getKartinka3() {
    return Kartinka3;
  }

synchronized   public void setKartinka3(int kartinka3) {
    Kartinka3 = kartinka3;
  }

synchronized   public int getKartinka2() {
    return Kartinka2;
  }

synchronized   public void setKartinka2(int kartinka2) {
    Kartinka2 = kartinka2;
  }

  public int getDoorOpen() {
    return DoorOpen;
  }

  public void setDoorOpen(int doorOpen) {
    DoorOpen = doorOpen;
  }

  public int getVideoOk() {
    return VideoOk;
  }

  public void setVideoOk(int videoOk) {
    VideoOk = videoOk;
  }

  public int getButtonShkafOk() {
    return ButtonShkafOk;
  }

  public void setButtonShkafOk(int buttonShkafOk) {
    ButtonShkafOk = buttonShkafOk;
  }

  public int getShkafOpen() {
    return ShkafOpen;
  }

  public void setShkafOpen(int shkafOpen) {
    ShkafOpen = shkafOpen;
  }

  public int getKeyOk() {
    return KeyOk;
  }

  public void setKeyOk(int keyOk) {
    KeyOk = keyOk;
  }

  public int getDoorShluzOneOpen() {
    return DoorShluzOneOpen;
  }

  public void setDoorShluzOneOpen(int doorShluzOneOpen) {
    DoorShluzOneOpen = doorShluzOneOpen;
  }

synchronized   public int getDoorClose() {
    return doorClose;
  }

synchronized   public void setDoorClose(int doorClose) {
    this.doorClose = doorClose;
  }

  synchronized public int getMonitorButton() {
    return monitorButton;
  }

  synchronized public void setMonitorButton(int monitorButton) {
    this.monitorButton = monitorButton;
  }

  public int getDoorShluzOneBlock() {
    return DoorShluzOneBlock;
  }

  public void setDoorShluzOneBlock(int doorShluzOneBlock) {
    DoorShluzOneBlock = doorShluzOneBlock;
  }

  public int getDoorShluzTwoOpen() {
    return DoorShluzTwoOpen;
  }

  public void setDoorShluzTwoOpen(int doorShluzTwoOpen) {
    DoorShluzTwoOpen = doorShluzTwoOpen;
  }

  synchronized public int getSuperComputersModulesOk() {
    return SuperComputersModulesOk;
  }

  synchronized public void setSuperComputersModulesOk(int superComputersModulesOk) {
    SuperComputersModulesOk = superComputersModulesOk;
  }

  public int getYashikClose() {
    return YashikClose;
  }

  public void setYashikClose(int yashikClose) {
    YashikClose = yashikClose;
  }

synchronized   public int getTimers() {
    return Timers;
  }

synchronized   public void setTimers(int timers) {
    Timers = timers;
  }

  synchronized public int getLasersOK() {
    return LasersOK;
  }

  synchronized public void setLasersOK(int lasersOK) {
    LasersOK = lasersOK;
  }

  public int getVentiliOk() {
    return VentiliOk;
  }

  public void setVentiliOk(int ventiliOk) {
    VentiliOk = ventiliOk;
  }

  public int getEletrichestvoOff() {
    return EletrichestvoOff;
  }

  public void setEletrichestvoOff(int eletrichestvoOff) {
    EletrichestvoOff = eletrichestvoOff;
  }

  public int getRichagBroke() {
    return RichagBroke;
  }

  public void setRichagBroke(int richagBroke) {
    RichagBroke = richagBroke;
  }

  synchronized public int getEmergeSvetOk() {
    return EmergeSvetOk;
  }

  synchronized public void setEmergeSvetOk(int emergeSvetOk) {
    EmergeSvetOk = emergeSvetOk;
  }

  public int getDataOk() {
    return DataOk;
  }

  public void setDataOk(int dataOk) {
    DataOk = dataOk;
  }

  public int getRubilnikSuperCompOn() {
    return RubilnikSuperCompOn;
  }

  public void setRubilnikSuperCompOn(int rubilnikSuperCompOn) {
    RubilnikSuperCompOn = rubilnikSuperCompOn;
  }

synchronized   public int getFlashOn() {
    return flashOn;
  }

synchronized   public void setFlashOn(int flashOn) {
    this.flashOn = flashOn;
  }

  public int getSvetMigaet() {
    return SvetMigaet;
  }

  public void setSvetMigaet(int svetMigaet) {
    SvetMigaet = svetMigaet;
  }

  public int getHardDriveOk() {
    return HardDriveOk;
  }

  public void setHardDriveOk(int hardDriveOk) {
    HardDriveOk = hardDriveOk;
  }

  synchronized public int getShitokButton() {
    return ShitokButton;
  }

  synchronized public void setShitokButton(int shitokButton) {
    ShitokButton = shitokButton;
  }

  public int getDoorWinOn() {
    return DoorWinOn;
  }

  public void setDoorWinOn(int doorWinOn) {
    DoorWinOn = doorWinOn;
  }

  synchronized public int getRadioStation() {
    return RadioStation;
  }

  synchronized public void setRadioStation(int radioStation) {
    RadioStation = radioStation;
  }

  public int getRukaOk() {
    return RukaOk;
  }

  public void setRukaOk(int rukaOk) {
    RukaOk = rukaOk;
  }

  synchronized public int getStartQuestOk() {
    return StartQuestOk;
  }

  synchronized public void setStartQuestOk(int startQuestOk) {
    StartQuestOk = startQuestOk;
  }

  synchronized public int getResetQuestOk() {
    return ResetQuestOk;
  }

  synchronized public void  setResetQuestOk(int resetQuestOk) {
    ResetQuestOk = resetQuestOk;
  }
}
