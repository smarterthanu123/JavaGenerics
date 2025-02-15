package chapter1.src;

import java.util.ArrayList;
import java.util.List;

public class ConvertAnyArrayToList {

  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 4};
    System.out.println(toList(arr));
    List<Integer> ints = toList();
    System.out.println(toList("Hello", "World"));
    List<Comparable> comparables = ConvertAnyArrayToList.<Comparable>toList("Hello", 1);

    // Use -ea in VM options in run configuration (Run > Edit Configurations) to enable assertions.
    assert comparables.toString().equals("[Hello, 1]");
  }

  private static <T> List<T> toList(T... arr) {
    List<T> list = new ArrayList<T>();
    for (T ele : arr) {
      list.add(ele);
    }
    return list;
  }
}
