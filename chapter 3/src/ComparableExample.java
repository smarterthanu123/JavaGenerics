import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,2);
        System.out.println(findMax(ints));
    }

    static <T extends Comparable<T>> T findMax(Collection<T> collection) {
        T maxi = null;
        for(T item: collection) {
            if(maxi == null) {
                maxi = item;
            } else if (item.compareTo(maxi) > 0){
                maxi = item;
            }
        }
        return maxi;
    }

}