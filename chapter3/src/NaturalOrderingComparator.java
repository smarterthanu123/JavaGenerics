package chapter3.src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NaturalOrderingComparator {

  public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(1, 2, 3, 2);
    System.out.println(Collections.max(ints, NaturalOrderingComparator.<Integer>naturalOrder()));
  }

  public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
    return new Comparator<T>() {
      @Override
      public int compare(T o1, T o2) {
        return o1.compareTo(o2);
      }
    };
  }
}
