package no.lindh.prototypeexample;

public class MyExplicitPrototypeConcrete implements MyExplicitPrototypeIsCloneable {
    int value;

    public MyExplicitPrototypeConcrete() { }

    public MyExplicitPrototypeConcrete(MyExplicitPrototypeConcrete prototype) {
        MyExplicitPrototypeConcrete n = new MyExplicitPrototypeConcrete();
        this.value = prototype.value;
    }

    public MyExplicitPrototypeConcrete cloneMe() {
        return new MyExplicitPrototypeConcrete(this);
    }
}
