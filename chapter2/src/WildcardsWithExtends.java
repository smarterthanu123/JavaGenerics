import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ? extends X, so basically X and classes that extend X. Now you can get values from this collection, into variable
 * that is super of X. Because X or lower will have all properties of super X and thus it will work fine in runtime.
 * But you cannot add elements in this structure, because ? extends X will be pointing to some subtype of X (lets say Z)
 * and allowing adding can lead to people adding Y to this collection, where Y extends X but Y is not compatible with Z.
 * So adding to this structure can lead to runtime issues and thus are not even allowed by the compiler.
 */
public class WildcardsWithExtends {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0);
        List<Number> numbers = new ArrayList<>(Arrays.asList(1, 2, 1.0)); // Arrays.asList returns unmodifiable lists.
        // ArrayList are modifiable

        addAll(numbers, ints); // Passing List<Integer> as List<? extends Number> param.
        addAll(numbers, doubles);  // Passing List<Double> as List<? extends Number> param.

//        addAllLimited(numbers, ints); // DOES NOT WORK, as List<Integer> is not a subtype of List<Number>
        System.out.println(numbers);

        // ? extend Number can also be used to define variable (and not only restricted to params).
        List<Integer> mutableInts = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<? extends Number> numsExtendible = ints; // Works given List<Integer> is subtype of List<? extends Number>
//        numsExtendible.add(3); // Does not work, although list is mutable. Why? See reason on top of class.
    }

    /**
     * This is a better more general structure than addAllLimited.
     */
    private static void addAll(List<Number> nums, List<? extends Number> extensions) {
        for (Number num : extensions) {
            nums.add(num);
        }
    }

    private static void addAllLimited(List<Number> nums, List<Number> extensions) {
        for (Number num : extensions) {
            nums.add(num);
        }
    }
}
