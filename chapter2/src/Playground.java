package chapter2.src;

import java.util.ArrayList;
import java.util.List;

public class Playground {

  public static void main(String[] args) {
    Parent parent1 = new Parent(3);
    Child child = new Child(3, 3.0);
    Child child2 = new Child(1, 1.0);
    Child child3 = new Child(2, 1.0);
    Parent childParent = new Child(2, 3.0);

    // Basics - although childParent is stored as Parent, it is pointing to child object.
    System.out.println(childParent instanceof Parent);
    System.out.println(childParent instanceof Child);
    System.out.println(parent1 instanceof Child);

    MyList<Parent> parentMyList = new MyList<Parent>();
    parentMyList.add(parent1);
    System.out.println(parentMyList.contains(child)); // True as parent1.equals(child) is true.

    parentMyList.add(child2);
    System.out.println(parentMyList.contains(child3)); // TRUE again!!
    // Child.equals is called here, dynamic method dispatch.

    MyList<Child> childList = new MyList<Child>();
    childList.add(child);

//        System.out.println(childList.contains(childParent)); // This is not possible in contains.
    System.out.println(childList.containsObject(childParent));
    System.out.println(childList.containsObject(parent1));
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

  List<T> listObjects;

  MyList() {
    listObjects = new ArrayList<T>();
  }

  public <O extends T> void add(O obj) {
    listObjects.add(obj);
  }

  public <O extends T> boolean contains(O obj) {
    for (T item : listObjects) {
      if (item.equals(obj)) {
        return true;
      }
    }
    return false;
  }

  public boolean containsObject(Object obj) {
    for (T item : listObjects) {
      if (item.equals(obj)) {
        return true;
      }
    }
    return false;
  }
}
