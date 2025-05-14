package JAVA_Multithreading.DeadLock;

public class TestingDeadLockSolution2 {
    public static void main(String[] args) {
        System.out.println("Showcase DeadLock Situation");
        Object Lock1 = new Object();
        Thread t1=new Thread(()->{
            synchronized (Lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (Lock1) {
                    System.out.println("Lock Acquired");
                }
            }
        });


        Thread t2=new Thread(()->{
            synchronized (Lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

                }
                synchronized (Lock1) {
                    System.out.println("eventually,Lock Acquired");
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println("Radhe Radhe");
    }
}
