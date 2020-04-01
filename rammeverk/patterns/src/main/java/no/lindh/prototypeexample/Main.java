package no.lindh.prototypeexample;

public class Main {
    public static void main(String[] args) {
        // These calls illustrate that we can create a object, clone it - and any changes to the cloned object
        // doesn't change the original object. It also shows (for the last cases) that any original values are
        // transferred over to the cloned object.
        MyExplicitPrototypeConcrete mepc = new MyExplicitPrototypeConcrete();
        mepc.value = 42;

        System.out.println("Original value is " + mepc.value);

        MyExplicitPrototypeConcrete mepc2 = mepc.cloneMe();
        mepc2.value = 22;

        System.out.println("Original value is now " + mepc.value);
        System.out.println("Object 2 value is " + mepc2.value);

        MyExplicitPrototypeSubClass mepcsc = new MyExplicitPrototypeSubClass();
        mepcsc.value = 1337;
        mepcsc.subclassValue = 31337;

        System.out.println("Original values are " + mepcsc.value + ", " + mepcsc.subclassValue);

        MyExplicitPrototypeSubClass mepcsc2 = mepcsc.cloneMe();
        mepcsc2.subclassValue = 424242;

        MyExplicitPrototypeSubClass mepcsc3 = mepcsc.cloneMe();
        mepcsc3.value = 123;

        System.out.println("In these cases the original values should be kept intact, but one of other's should change");
        System.out.println("Original values are now " + mepcsc.value + ", " + mepcsc.subclassValue);
        System.out.println("Object 2 value is " + mepcsc2.value + ", " + mepcsc2.subclassValue);
        System.out.println("Object 3 value is " + mepcsc3.value + ", " + mepcsc3.subclassValue);

        // But here's the win - we can clone them both in the same way, even if one is the parent class and one is the
        // sub class, allowing us to handle cloning and an internal registry in the same way - taking ownership of
        // the object and avoiding the object being changed outside of our own control.
        //
        // Since this is a general method that expects the parent object, we can't manipulate `subclassValue` inside
        // generalExplicitClonable - but we _can send_ the subclassed object in, and it'll be cloned just fine!
        generalExplicitCloneable(mepc);
        generalExplicitCloneable(mepcsc);
    }

    public static void generalExplicitCloneable(MyExplicitPrototypeConcrete mep) {
        MyExplicitPrototypeConcrete mepc = mep.cloneMe();
        mepc.value = 328;
        System.out.println("Original mepc.value is " + mep.value);
        System.out.println("Cloned mepc.value is " + mepc.value);
    }
}
