package JAVA_Multithreading.ThreadCreation;

public class ImplemetingRuunable {
    public static void main(String[] args) {
        System.out.println("Starting Main Thread");
        Runnable r=()->{
            System.out.println("Creating Threads Using Lambda"+Thread.currentThread().getName());
        };
        Thread t1= new Thread(r);
        t1.start();
        System.out.println("Exiting Main Thread");
    }
}
