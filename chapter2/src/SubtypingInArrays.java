public class SubtypingInArrays {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        Number[] num;
        num = arr; // Possible because array subtyping is covariant meaning type S[] is considered to subtype of T[]
        // whenever S is subtype of T.

        num[2] = 1.2; // Runtime error;

        // There is no way to do something like <? super S> type of thing in Array.
    }
}
