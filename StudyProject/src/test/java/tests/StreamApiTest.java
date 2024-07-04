package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Listeners({AllureTestNg.class})
public class StreamApiTest {

    @Test
    @Description("This is a test description")
    @Feature("My Feature")
    @Story("My Story")
    public void createStreams(){
        //empty stream
        Stream.empty();

        //elements stream
        Stream.of("1", "2", "3");

        //list stream
        List<Integer> list = Arrays.asList(2, 3, 4, 5);
        list.stream();

        //map stream
        Map<Integer, Integer> map = new HashMap<>();
        map.entrySet().stream();

        //array stream
        String[] array  = {""};
        Arrays.stream(array);
    }
    @Test
    public void mapCollectorsToList() {
        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        // demonstration of map method
        List<Integer> square
                = number.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    @Test
    public void filter() {
        // create a list of String
        List<String> names = Arrays.asList(
                "Reflection", "Collection", "Stream");
        // demonstration of filter method
        List<String> result
                = names.stream()
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void uniqueElements() {
        // create a list of String
        List<String> names = Arrays.asList(
                "Reflection", "Collection", "Stream");
        // demonstration of filter method
        List<String> result
                = names.stream().distinct().collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void sorted() {
        List<String> names = Arrays.asList(
                "Reflection", "Collection", "Stream");
        // demonstration of sorted method
        List<String> show
                = names.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(show);
    }

    @Test
    public void collectorsToSet() {

        // create a list of integers
        List<Integer> numbers
                = Arrays.asList(2, 3, 4, 5, 2);

        // collect method returns a set
        Set<Integer> squareSet
                = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toSet());

        System.out.println(squareSet);
    }

    @Test
    public void foreach() {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        // demonstration of forEach method
        number.stream()
                .map(x -> x * x)
                .forEach(y -> System.out.println(y));
    }

    @Test
    public void reduce() {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        // demonstration of forEach method
        number.stream()
                .map(x -> x * x)
                .forEach(y -> System.out.println(y));
        // demonstration of reduce method
        int even
                = number.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (ans, i) -> ans + i);

        System.out.println(even);
    }
}

