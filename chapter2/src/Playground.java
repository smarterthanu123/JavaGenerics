import java.util.ArrayList;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
        Parent parent1 = new Parent(3);
        Child child = new Child(3, 3.0);
        Child child2 = new Child(1, 1.0);
        Child child3 = new Child(2, 1.0);
        MyList<Parent> parentMyList = new MyList<Parent>();
        parentMyList.add(parent1);
        System.out.println(parentMyList.contains(child)); // True as parent1.equals(child) is true.

        parentMyList.add(child2);
        System.out.println(parentMyList.contains(child3)); // TRUE again!!
        // Child.equals is called here, dynamic method dispatch.

        Parent childParent = new Child(2, 3.0);
        MyList<Child> childList = new MyList<Child>();
        childList.add(child);

//        System.out.println(childList.contains(childParent)); // This is not possible in contains.
        System.out.println(childList.containsObject(childParent));
    }
}

class Parent {
    int pObj;

    Parent(int pObj) {
        this.pObj = pObj;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Comparing parents");
        if (!(o instanceof Parent)) {
            return false;
        }

        Parent oParent = (Parent) o;
        return oParent.pObj == this.pObj;
    }
}

class Child extends Parent {
    double cObj;

    Child(int pObj, double cObj) {
        super(pObj);
        this.cObj = cObj;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Comparing children");
        if (!(o instanceof Child)) {
            return false;
        }

        Child oChild = (Child) o;
        return oChild.cObj == this.cObj;
//        && super.equals(o);
    }
}

class MyList<T> {
    List<T> parentExtensionObjs;

    MyList() {
        parentExtensionObjs = new ArrayList<T>();
    }

    public <O extends T> void add(O obj) {
        parentExtensionObjs.add(obj);
    }

    public <O extends T> boolean contains(O obj) {
        for (T item : parentExtensionObjs) {
            if (item.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsObject(Object obj) {
        for (T item : parentExtensionObjs) {
            if (item.equals(obj)) {
                return true;
            }
        }
        return false;
    }
}
