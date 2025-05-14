package JAVA_Multithreading.ThreadCreation.Interview;

public class Testing {
    public static void main(String[] args) {
        System.out.println("Main Thread Starting");

        Thread t=new Thread(()->{
            for (int i = 0; i <11 ; i++) {
                System.out.println("Running Threads: "+Thread.currentThread().getName()+i);
            }
        });
     //   t.setDaemon(true);
        t.start();
        System.out.println("Main Thread Exiting");
    }
}
