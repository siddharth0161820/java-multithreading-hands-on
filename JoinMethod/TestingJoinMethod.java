package JAVA_Multithreading.JoinMethod;

public class TestingJoinMethod {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Starting");
        Thread t1=new Thread(()->{
            for (int i = 0; i <11; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running Thread t1: "+Thread.currentThread().getName()+""+i);

            }
        });

        Thread t2=new Thread(()->{
            for (int i = 11; i <21; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running Thread t2: "+Thread.currentThread().getName()+""+i);

            }
        });

        Thread t3=new Thread(()->{
            for (int i = 21; i <=31; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running Thread t3: "+Thread.currentThread().getName()+""+i);

            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Main Thread Exiting");
    }
}
