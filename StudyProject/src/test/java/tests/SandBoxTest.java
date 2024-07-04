package tests;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SandBoxTest {
    @Test
    public void SandBoxTest() {
        int[] testArray = new int[] { 20, 20, 37, 37, 21, 21 };
       Arrays.stream(testArray).distinct().forEach(System.out::println);


    }

}
