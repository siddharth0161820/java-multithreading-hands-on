package JAVA_Multithreading.ThreadCreation;

public class TestingExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


class Testinggg{
    public static void main(String[] args) {
        Thread t=new TestingExtendsThread();
        t.start();
    }
}