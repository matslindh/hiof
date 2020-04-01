package no.lindh.prototypeexample;

public class MyPrototypeBuiltIn implements Cloneable {
    int value;

    MyPrototypeBuiltIn(int val) {
        this.value = val;
    }

    public MyPrototypeBuiltIn clone() {
        // if we need to perform a more explicit deep copy (i.e. copy lists, nodes, references, etc.) we can
        // do this here, after getting the clone from super.clone().
        //
        // The super.clone() calls will be propagated all the way up to Object.clone() which does most of the
        // work for us.
        try {
            return (MyPrototypeBuiltIn) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
