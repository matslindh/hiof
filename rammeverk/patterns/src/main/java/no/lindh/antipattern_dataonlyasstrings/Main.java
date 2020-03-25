package no.lindh.antipattern_dataonlyasstrings;

public class Main {
    public static void main(String[] args) {
        Framework fw = new Framework();
        System.out.println(fw.getInstance());
        System.out.println(fw.getInstanceId());
    }
}
