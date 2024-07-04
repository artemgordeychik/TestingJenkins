package tests;

import org.testng.annotations.Test;

import java.util.function.*;

public class FuncInterfacesTest {
    @Test
    public void predicate() {
        //Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия.
        // Если оно соблюдается, то возвращается значение true.
        // В качестве параметра лямбда-выражение принимает объект типа T
        Predicate<Integer> isPositive = x -> x > 0;
    }

    @Test
    public void BinaryOperator() {
        //BinaryOperator<T> принимает в качестве параметра два объекта типа T,
        // выполняет над ними бинарную операцию и возвращает ее результат также в виде объекта типа T
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
    }

    @Test
    public void UnaryOperator() {
        //UnaryOperator<T> принимает в качестве параметра объект типа T,
        // выполняет над ними операции и возвращает результат операций в виде объекта типа T
        UnaryOperator<Integer> square = x -> x * x;
    }

    @Test
    public void function() {
        //Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R
        Function<Integer, String> convert = x -> String.valueOf(x) + " долларов";
    }

    @Test
    public void consumer() {
        //Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая
        Consumer<Integer> printer = x -> System.out.printf("%d долларов \n", x);
    }

    @Test
    public void supplier() {
        //Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T:
        Supplier<Integer> intFactory = () -> {
            Integer a = 5 * 5;
            return a;

        };
    }

    @Test
    //отличие от обычных интерфейсов - есть только 1 абстрактный метод
    public void customInterface(){
        printAverage((a, b, c) -> (a + b + c) / 3.0);
    }

    interface IAverage {
        double avg(double a, double b, double c);
    }

    public void printAverage(IAverage ref) {
        System.out.println("ref = " + ref.avg(3, 7, 8));
    }

    public String checkFunction(Integer i, Function<Integer, String> function) {
        return function.apply(i);
    }
}
