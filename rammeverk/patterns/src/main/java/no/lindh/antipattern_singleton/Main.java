package no.lindh.antipattern_singleton;

public class Main {
    public static void main(String[] args) {
        Application app = ApplicationSingleton.getInstance();
        System.out.println("First app instance id is " + app.getInstanceId());

        Application app2 = ApplicationSingleton.getInstance();
        System.out.println("Second app instance id is " + app2.getInstanceId());

        Application app3 = ApplicationSingleton.getInstance();
        System.out.println("Third app instance id is " + app3.getInstanceId());
    }
}
