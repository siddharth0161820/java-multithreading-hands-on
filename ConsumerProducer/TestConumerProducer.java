package JAVA_Multithreading.ConsumerProducer;

public class TestConumerProducer {
    public static void main(String[] args) {
        Buffer buffer=new Buffer();
        Thread producer=new Thread(()->{
            for (int i = 0; i <11; i++) {
                try {
                    buffer.Producer(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer=new Thread(()->{
            for (int i = 0; i <11; i++) {
                try {
                    buffer.consumer();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}


class Buffer{
    public int data;
    boolean isEmpty=true;

    //1>Methods()
    public synchronized void Producer(int piece) throws InterruptedException {
        while (!isEmpty){ //buffer is full
            wait(1000); //wait till consumer eats it
        }
        data=piece;
        isEmpty=false;
        System.out.println("Producer: "+data);
        notifyAll();//makes consumer thread awake
    }

    //2>Methods()
    public synchronized void consumer() throws InterruptedException {
        while (isEmpty){ //buffer is empty
            wait(1000); //wait till producer fulls it
        }
        System.out.println("Consumer "+data);
        isEmpty=true;
        notifyAll();//makes producer thread awake
    }
}