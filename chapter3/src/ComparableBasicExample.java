package chapter3.src;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ComparableBasicExample {

  public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(1, 2, 3, 2);
    System.out.println(findMax(ints)); // 3

    List<String> strings = Arrays.asList("make", "world", "better");
    System.out.println(findMax(strings)); // world

    List<Number> nums = Arrays.asList(1, 2, 3);
//        System.out.println(findMax(nums)); // Error as Number does not extend Comparable.
  }

  static <T extends Comparable<T>> T findMax(Collection<T> collection) {
    T maxi = null;
    for (T item : collection) {
      if (maxi == null) {
        maxi = item;
      } else if (item.compareTo(maxi) > 0) {
        maxi = item;
      }
    }
    return maxi;
  }
}