package JAVA_Multithreading.Synchronization;

public class TetinRaceCondition {
    public static void main(String[] args) {
        System.out.println("Showing Race Condition");
        //Obj for the class
        Withdrawal withdrawal=new Withdrawal();
        Thread person1=new Thread(()->withdrawal.Withdrawal(800),"Person1");
        Thread person2 =  new Thread(()->withdrawal.Withdrawal(800),"Person2");

        person1.start();
        person2.start();

    }
}


class Withdrawal{
    //1>Attributes
    public int balance=1000;

    //2>Methods()
    public void Withdrawal(int amount){
        if (amount<=balance){
            System.out.println(Thread.currentThread().getName()+" can withdraw successfully");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+"  withdrawn successfully");
            System.out.println("Remaining Amount: "+balance);
        }else {
            System.out.println(Thread.currentThread().getName()+ " can't withdraw amount insufficient");
        }

    }
}