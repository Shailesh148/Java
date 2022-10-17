package interfaceExample;

interface myCamera2 {
    void takeSnap();

    void recordVideo();

    default void record4kVideo (){

        System.out.println("recording 4k video");
    }
}

interface myWifi2 {
    String [] getNetwork();
    void connectToNetwork (String network);

}
class myCellPhone2{
    void callNumber(int phoneNumber) {
        System.out.println("calling " + phoneNumber);
    }
    void pickCall(int phoneNumber) {
        System.out.println("connecting..." );
    }


}
class mySmartPhone2 extends myCellPhone2 implements myWifi2, myCamera2 {
    public void takeSnap(){
        System.out.println("taking snap");
    }
    public void recordVideo(){
        System.out.println("recording video");
    }
    public String [] getNetwork(){
        System.out.println("Getting list of Networks");
        String [] networkList = {"Anup", "bibek" ,"binod"};
        return networkList;
    }
    public void connectToNetwork (String network){
        System.out.println("connecting..." + network );
    }
}
public class polymorphism {
    public static void main(String[] args) {
        myCamera2 cam1 = new mySmartPhone2();  // using smartphone as camera
//        cam1.getNetwork();  not allowed
            cam1.recordVideo();


myCellPhone2 sp = new mySmartPhone2();
sp.callNumber(65626);   // using smartphone as cell phone
        //        sp.takeSnap();  not allowed
        mySmartPhone2 sm = new  mySmartPhone2();
            sm.record4kVideo();
            sm.getNetwork();
    }
}
