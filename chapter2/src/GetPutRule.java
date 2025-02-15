package chapter2.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Get Put Principal says the same thing that ? extends X cannot have elements added and ? super X
 * cannot have elemnts get. But there is 1 exception to each of these rules. [See in code].
 */
public class GetPutRule {

  public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3));
    List<? extends Number> nums = ints;
//        nums.add(1); // Does not work.
    nums.add(null); // Works!! because null belongs to every reference type!

    List<? super Integer> numSuper = ints;
    System.out.println(
        numSuper); // [1,2,3,null] but how did printing work? cannot get elements from super? :P
    // Here comes the exception. You can get the elements out as Object because its super type of every reference type.
    // And this is obviously allowed because there is no risk of runtime error as any object that <? super X> is pointing to will
    // be definitely subtype of object.

    for (Object obj : numSuper) {
      System.out.println(obj);
    }
  }

}
