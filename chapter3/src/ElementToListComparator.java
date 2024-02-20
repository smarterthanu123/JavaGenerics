package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ElementToListComparator {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Integer> ints2 = Arrays.asList(4, 2, 1);
        List<Integer> ints3 = Arrays.asList(3, 2, 1);

        System.out.println(getListComparator(Comparator.<Integer>naturalOrder()).compare(ints, ints2));
        System.out.println(getListComparator(Comparator.<Integer>naturalOrder()).compare(ints3, ints));
        System.out.println(getListComparator(Comparator.<Integer>naturalOrder()).compare(ints2, ints3));
    }

    public static <T> Comparator<List<T>> getListComparator(Comparator<? super T> eleComparator) {
        return (o1, o2) -> eleComparator.compare(Collections.max(o1, eleComparator), Collections.max(o2, eleComparator));
    }


}
