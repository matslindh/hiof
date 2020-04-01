package no.lindh.prototypeexample;

public class MyExplicitPrototypeSubClass extends MyExplicitPrototypeConcrete {
    int subclassValue;

    MyExplicitPrototypeSubClass() {};

    MyExplicitPrototypeSubClass(MyExplicitPrototypeSubClass prototype) {
        super(prototype);

        this.subclassValue = prototype.subclassValue;
    }

    public MyExplicitPrototypeSubClass cloneMe() {
        return new MyExplicitPrototypeSubClass(this);
    }
}
