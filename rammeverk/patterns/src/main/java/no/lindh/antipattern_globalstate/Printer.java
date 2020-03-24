package no.lindh.antipattern_globalstate;

class Printer {
    // This is package wide, global state - it can be changed from anywhere
    //  - if the class was public, it'd be true global state
    public static String state;

    // This doesn't help - even if the string is private / protected, the
    // value can still be manipulated from anywhere - but it's encapsulated?
    //
    // It will however allow us to at least add some kind of verification in
    // the future when we discover we've borked our software
    public static void setState(String state) {
        Printer.state = state;
    }
}
