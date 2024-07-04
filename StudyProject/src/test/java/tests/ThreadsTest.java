//package tests;
//
//import org.testng.annotations.Test;
//import threads.JThread;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ThreadsTest {
//    @Test
//    public void threadTest() throws InterruptedException {
//        Thread t = Thread.currentThread(); // получаем главный поток
//        t.setName("t - thread");
//        System.out.println(t.getName()); // t - thread
//        t.setPriority(1);
//        t.getPriority();
//        t.isAlive();
//        t.isInterrupted();
//        t.join();
//        t.run();
//        t.sleep(5000);
//        t.start();
//    }
//
//    @Test
//    public void startThread(){
//        System.out.println("Main thread started...");
//        new JThread("JThread").start();
//        System.out.println("Main thread finished...");
//    }
//
//    @Test
//    public void startMultipleThreads(){
//        System.out.println("Main thread started...");
//        for(int i=1; i < 6; i++)
//            new JThread("JThread " + i).start();
//        System.out.println("Main thread finished...");
//    }
//
//    @Test
//    public void runThreadInThread(){
//        System.out.println("Main thread started...");
//        JThread t= new JThread("JThread ");
//        t.start();
//        try{
//            t.join();
//        }
//        catch(InterruptedException e){
//
//            System.out.printf("%s has been interrupted", t.getName());
//        }
//        System.out.println("Main thread finished...");
//    }
//
//    @Test
//    public void interupt(){
//        JThread t = new JThread("JThread");
//        t.run();
//        t.interrupt();
//    }
//}
