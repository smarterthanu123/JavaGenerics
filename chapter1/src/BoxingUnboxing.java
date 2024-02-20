import java.util.Arrays;
import java.util.List;

// Small values -128 to +127 are cached and thus same boxed object might get returned.
public class BoxingUnboxing {
    public static void main(String[] args) {
        List<Integer> bigs = Arrays.asList(100, 200, 300);
        System.out.println(sumInteger(bigs) == sumInteger(bigs));

        List<Integer> smalls = Arrays.asList(1, 2, 3);
        System.out.println(sumInteger(smalls) == sumInteger(smalls));
    }

    public static Integer sumInteger(List<Integer> ints) {
        Integer s = 0;
        for (Integer n : ints) {
            // Every n is first unboxed and s is unboxed everytime and then added and then boxed again and stored in s.
            // A more optimized (and correct) implementation would be with int s and int n.
            s += n;
        }
        return s;
    }
}