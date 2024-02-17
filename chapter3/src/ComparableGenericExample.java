import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ComparableGenericExample {

    public static void main(String[] args) {
        Parent parent1 = new Parent(1);
        Parent parent2 = new Parent(2);
        Parent parent3 = new Parent(3);
        List<Parent> parents = Arrays.asList(parent1, parent2, parent3);

        System.out.println(findMaxGeneric(parents).pObj);

        Child child1 = new Child(1,1000.0);
        Child child2 = new Child(2, 500.0);
        Child child3 = new Child(3, 200.0);
        List<Child> children = Arrays.asList(child1, child2, child3);

        System.out.println(findMaxGeneric(children).cObj);

        SmallerChild smallerChild1 = new SmallerChild("make", 1,1000.0);
        SmallerChild smallerChild2 = new SmallerChild("world", 2, 500.0);
        SmallerChild smallerChild3 = new SmallerChild("better", 3, 200.0);
        SmallerChild2 smallerChild4 = new SmallerChild2("place", 4, 300.0);
        List<SmallerChild> smallerChildren = Arrays.asList(smallerChild1, smallerChild2, smallerChild3);

        System.out.println(ComparableGenericExample.<Child>findMaxGeneric(smallerChildren).cObj);

        // Just for learning purpose, does not make much sense.
        System.out.println(ComparableGenericExample.findMaxGeneric(Arrays.asList(smallerChild1, smallerChild2, smallerChild3, smallerChild4)).cObj);
    }

    static <T extends Comparable<? super T>> T findMaxGeneric(Collection<? extends  T> collection) {
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

class Parent implements Comparable<Parent> {
    Integer pObj;

    Parent(Integer pObj) {
        this.pObj = pObj;
    }

    @Override
    public int compareTo(Parent o) {
        return this.pObj.compareTo(o.pObj);
    }
}

class Child extends Parent {
    Double cObj;

    Child(Integer pObj, Double cObj) {
        super(pObj);
        this.cObj = cObj;
    }
}

class SmallerChild extends Child {
    String scObj;

    SmallerChild(String scObj, Integer pObj, Double cObj) {
        super(pObj, cObj);
        this.scObj = scObj;
    }

    // This is dangerous and ambiguous, as now a list of Parent object (with SmallChild objects and parent objects in them can be compared in wierd ways).
    // Being done here just for learning purpose.
    @Override
    public int compareTo(Parent o) {
        // Implement comparison logic for SmallerChild
        if (o instanceof SmallerChild) {
            SmallerChild other = (SmallerChild) o;
            return this.scObj.compareTo(other.scObj);
        }

        // Call the compareTo method of the superclass (Child)
        return super.compareTo(o);
    }

}

class SmallerChild2 extends Child {
    String scObj;

    SmallerChild2(String scObj, Integer pObj, Double cObj) {
        super(pObj, cObj);
        this.scObj = scObj;
    }

    @Override
    public int compareTo(Parent o) {
        // Implement comparison logic for SmallerChild
        if (o instanceof SmallerChild2) {
            SmallerChild2 other = (SmallerChild2) o;
            return this.scObj.compareTo(other.scObj);
        }

        // Call the compareTo method of the superclass (Child)
        return super.compareTo(o);
    }

}
