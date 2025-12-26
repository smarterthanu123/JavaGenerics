package chapter2.src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The compiler needs to know exactly what type of elements the list will hold to ensure type
 * safety. If you say "create a list of unknowns," the compiler doesn't know what rules to enforce
 * for that specific object. Why does List<List<?>> works then? because reference of List<Integer>
 * and List<String> is same, thus, compiler knows exactly what rules to enforce. It is creating is a
 * list of references for List<T>, and this is independent of T.
 */
public class RestrictionOnWildcards {

  public static void main(String[] args) {
    // List<?> list = new ArrayList<?>();  Not possible.
    List<List<?>> lists = new ArrayList<List<?>>(); // Possible.

    lists.add(Arrays.asList(1, 2, 3));
    lists.add(Arrays.asList("four", "five"));
    System.out.println(lists);
  }
}
