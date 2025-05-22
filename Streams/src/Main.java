import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        //Predicate is a Functional Interface that returns a boolean value
        Predicate<Integer> isEven = x -> x%2 == 0;
        System.out.println(isEven.test(10));

        Predicate<String> startsWithA = x -> x.toLowerCase().startsWith("a");
        System.out.println(startsWithA.test("Abc"));

        Predicate<String> endsWithB = x -> x.toLowerCase().endsWith("b");
        System.out.println(endsWithB.test("Abc"));

        Predicate<String> and = startsWithA.and(endsWithB);
        System.out.println(and.test("abb"));

        // Function does some work, takes input and returns some output
        Function<Integer, Integer> addTwo =x -> x+2;
        Function<Integer, Integer> addThree =x -> x+3;

        System.out.println(addTwo.andThen(addThree).apply(2));
        System.out.println(addTwo.compose(addThree).apply(30));

        // Consumer -> Accepts arguments but doesn't return anything
        Consumer<Integer> consume = System.out::println;
        consume.accept(25);

        Consumer<List<Integer>> printList = x -> {
            for(int i : x) {
                System.out.println(i);
            }
        };
        printList.accept(Arrays.asList(1,2,3));
        printList.andThen(printList).accept(Arrays.asList(1,2,3));

        // Supplier -> Doesn't accept arguments but returns some value
        Supplier<String> hello = () -> "Hello";
        System.out.println(hello.get());

        // BiPredicate, BiConsumer, BiFunction take two arguments
        BiPredicate<Integer, Integer> isSumEven = (x,y) -> (x+y) % 2 == 0;
        BiFunction<Integer, Integer, Integer> addNumbersThree = (x,y) -> x+y+3;
        BiConsumer<Integer, Integer> printTwoNumbers = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        // Unary(extends Function Interface) and Binary(extends BiFunction Interface) operators
        UnaryOperator<Integer> add = x -> x+2;
        BinaryOperator<Integer> addTwoNumbers = Integer::sum;

        // Method Reference -> use method without invoking and in place of lambda expression
        List<String> names = Arrays.asList("A", "B", "C");
        names.forEach(System.out::println);

        // If you use normal for loop and try to remove elements while iterating it will throw exception
        // But if you use iterator to loop through and remove elements it will work fine

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));;

        // error
//        for(int i : list) {
//            if(i%2 == 0) {
//                list.remove(i);
//            }
//        }

        Iterator<Integer> itr = list.iterator();
        // will work
        while(itr.hasNext()) {
            Integer num = itr.next();
            if(num%2 == 0) {
                itr.remove();
            }
        }

        list.removeIf(num -> num % 2 == 0);

        System.out.println(list);

        System.out.println(list.stream().map(x -> x*2).toList());
    }
}
