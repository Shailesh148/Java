package thread;

public class Thread1 extends Thread{

    public void run() {
        for(int i=0; i<5 ;i++) {
            System.out.println("showing thread1 class" + i);
        }
    }
}
