import java.util.Arrays;
import java.util.List;

/**
 * Substitution Principle: A variable of a given type may be assigned a value of any subtype of that type, and a method
 * with a parameter of a given type may be invoked with an argument of any subtype of that type.
 */
public class SubstitutionPrinciple {
    public static void main(String[] args) {
        // Number supertype.
        Number n = 1;

        Integer i = 2;
        n = i; // Assignment possible as Integer is subtype of Number.
        System.out.println(n);
        System.out.println(add(n,i)); // Assigning Integer to Number argument of the method.
        System.out.println(add(n,3.14)); // Assigning double (will be boxed to Double by compiler) to Number argument of
        // the method.

        // Substitution principle works only when a is subtype of b (the whole type).
        // For eg, List<Integer> is not a subtype of List<Number>
        List<Number> nums;
        List<Integer> ints = Arrays.asList(1,2,3);
        // nums = ints; DOES NOT WORK!

        // But interestingly, Integer[] is subtype of Number[]. To make this work in Lists as well, we can use wilcards.
    }

    private static Number add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }
}
