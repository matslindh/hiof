package no.lindh.prototypeexample;

public class MainBuiltin {
    public static void main(String[] args) {
        // this shows that we can use the built-in support for cloning in Java as well
        MyPrototypeBuiltIn mpb = new MyPrototypeBuiltIn(42);
        System.out.println("mpb.value: " + mpb.value);

        // mpb2 is now a separate object with its own values copied over
        MyPrototypeBuiltIn mpb2 = mpb.clone();
        System.out.println("Changing value in mpb2");
        mpb2.value = 1337;

        System.out.println("mbp.value is now: " + mpb.value);
        System.out.println("mbp2.value is now: " + mpb2.value);
    }
}
