package JAVA_Multithreading.Synchronization;

public class TestSynchronizedStaticMethod {
        public static void main(String[] args) {
            Capitalll capital=new Capitalll();
            Thread person1= new Thread(()->capital.Withdrawal(800),"Peron1");
            Thread person2= new Thread(()->capital.Withdrawal(800),"Peron2");
            person1.start();
            person2.start();

        }
    }
    class Capitalll{
        public static int balance=1000;
        //2>Methods()
        public static synchronized void Withdrawal(int amount){
            //Lock is the current class name itself
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


