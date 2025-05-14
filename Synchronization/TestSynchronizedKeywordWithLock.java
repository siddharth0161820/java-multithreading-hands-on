package JAVA_Multithreading.Synchronization;

public class TestSynchronizedKeywordWithLock {
    public static void main(String[] args) {
Capital capital=new Capital();
Thread person1= new Thread(()->capital.Withdrawal(800),"Peron1");
Thread person2= new Thread(()->capital.Withdrawal(800),"Peron2");
person1.start();
person2.start();

    }
}
class Capital{
    public int balance=1000;
    //2>Methods()
    public void Withdrawal(int amount){
        synchronized (this){  //Lock is the current object of the class
            if(amount<=balance){
                System.out.println(Thread.currentThread().getName()+"Can withdraw successfully");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                balance-=amount;
                System.out.println(Thread.currentThread().getName()+" withdrew done successfully");
                System.out.println("Remaining Balance: "+balance);
            }else {
                System.out.println(Thread.currentThread().getName()+" Insufficient Balance");
            }

        }
        }

}