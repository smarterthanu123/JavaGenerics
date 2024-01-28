import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DotProduct {
    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1,2,3);
        List<Integer> v2 = Arrays.asList(1,2,3);


        System.out.println(dotProduct(v1,v2));
    }

    private static Integer dotProduct(List<Integer> v1, List<Integer> v2) {
        if(v1.size() != v2.size()) {
            throw new IllegalArgumentException("Both the vectors should be of same size");
        }

        int d = 0;

        Iterator<Integer> v1It = v1.iterator();
        Iterator<Integer> v2It = v2.iterator();

        while(v1It.hasNext()) {
            d += v1It.next()*v2It.next();
        }

        return d;
    }

}
