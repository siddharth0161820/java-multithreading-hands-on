package JAVA_Multithreading.VolatileKeyword;

public class TestingVolatileKeyword {
    private static volatile boolean flag = false;
    public static void main(String[] args) {
                // Thread 1: Sets flag to true after 2 seconds
                Thread t1 = new Thread(() -> {
                    try {
                        Thread.sleep(2000); // Simulate some work
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = true;
                    System.out.println("Thread 1: flag is set to true");
                });

                // Thread 2: Waits for flag to become true and then prints a message
                Thread t2 = new Thread(() -> {
                    while (!flag) {
                        // Waiting for flag to become true
                    }
                    System.out.println("Thread 2: flag is true, now proceeding.");
                });

                t1.start();
                t2.start();
            }
        }


