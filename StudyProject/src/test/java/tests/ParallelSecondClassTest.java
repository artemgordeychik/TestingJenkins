//package tests;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class ParallelSecondClassTest {
//
//    @BeforeMethod
//    public void beforeMethod() {
//        long id = Thread.currentThread().getId();
//        System.out.println("2 - Before test-method. Thread id is: " + id);
//    }
//
//    @Test
//    public void testMethodsOne() {
//        long id = Thread.currentThread().getId();
//        System.out.println("2 - Simple test-method One. Thread id is: " + id);
//    }
//
//    @Test
//    public void testMethodsTwo() {
//        long id = Thread.currentThread().getId();
//        System.out.println("2 - Simple test-method Two. Thread id is: " + id);
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        long id = Thread.currentThread().getId();
//        System.out.println("2 - After test-method. Thread id is: " + id);
//    }
//}
