package interfaceExample;

interface myCamera {
    void takeSnap();

    void recordVideo();

    private void greet(){
        System.out.println("Good Morning");
    }

    default void record4kVideo (){
        greet();
        System.out.println("recording 4k video");
    }
}

interface myWifi {
    String [] getNetwork();
    void connectToNetwork (String network);

}
    class myCellPhone{
    void callNumber(int phoneNumber) {
        System.out.println("calling" + phoneNumber);
    }
        void pickCall(int phoneNumber) {
            System.out.println("connecting..." );
        }


}
class mySmartPhone extends myCellPhone implements myWifi, myCamera {
          public void takeSnap(){
            System.out.println("taking snap");
        }
    public void recordVideo(){
        System.out.println("taking snap");
    }
    public String [] getNetwork(){
        System.out.println("Getting list of Networks");
        String [] networkList = {"Anup", "bibek" ,"binod"};
        return networkList;
    }
   public void connectToNetwork (String network){
       System.out.println("connecting..." + network );
   }
//   public void record4kVideo(){
//       System.out.println("can be override");
//   }
}
public class interfaceExample {
    public static void main(String[] args) {
        mySmartPhone ms = new mySmartPhone();
        ms.record4kVideo();
//        ms.greet();        Throws an error
        String [] arr = ms.getNetwork();
        for (String item: arr) {
            System.out.println(item);

        }
    }
}
