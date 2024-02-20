import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ? super X, so basically X and classes that are supertype of X. Now you can put values (that are subtype of X) into
 * this collection. Because X or lower will have all the properties that are needed by super of X and thus it will work
 * fine in runtime. But you cannot get elements from this structure, because ? super X will be pointing to some super
 * of X (lets say Z) and allowing getting value can lead to people getting value into Y, where Y is super X but Y might
 * be lower than Z, which can lead to runtime error.
 */
public class WildcardsWithSuper {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Double> doubles = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0));
        List<Number> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Object> objs = new ArrayList<>(Arrays.asList("something", "5", 6.0));

        // In <? super Number>, putting elements is possible (Number or lower than Number), getting is not possible.
        List<? super Number> doubleSuper = objs;
        Double d = 1.0;
        doubleSuper.add(d); // Works
        doubleSuper.add(1); // Works
//        doubleSuper.add("something"); // Does not work.


        WildcardsWithSuper.<Number>copy(nums, ints);
        System.out.println(nums);

        WildcardsWithSuper.<Number>copy(nums, doubles);
        System.out.println(nums);

        WildcardsWithSuper.copy(objs, ints); // This takes <> as Integer as that is the most specific choice that works.
        WildcardsWithSuper.<Object>copy(objs, ints); // This takes <> as Integer as that is the most specific choice that works.
        WildcardsWithSuper.<Number>copy(objs, ints);
        System.out.println(objs);
    }

    /**
     * "Always use wildcards where you can in a signature, since this permits the widest range of calls."
     */
    private static <T> void copy(List<? super T> dst, List<? extends T> src) {
        assert (dst.size() >= src.size());
        for (int i = 0; i < dst.size(); i++) {
            dst.set(i, src.get(i));
        }
    }
}
