package main;
import sub.Foo;
public class TwoClasses {
    public static void main(String... args) {
        Foo foo = new Foo();
        if(foo.equals("bar"))
            System.out.println("nope");
    }
}
