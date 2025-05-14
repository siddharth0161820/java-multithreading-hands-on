package JAVA_Multithreading.ExecutorServiceDemo;
import  java.util.concurrent.*;
import java.util.*;
public class TestExecutorService {
    public static void main(String[] args)throws Exception {
      ExecutorService executorService=Executors.newFixedThreadPool(4);
      executorService.submit(()-> System.out.println("Runnable task running"));
      Future<Integer>result=executorService.submit(()->10+20);
        System.out.println("Result: "+result.get());
        executorService.shutdown();
        System.out.println("Radhe Radhe");
    }
}
