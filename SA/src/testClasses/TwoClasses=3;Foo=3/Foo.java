public class Foo {
    Foo() {
        System.out.println(1);
    }
    
    @Override public String toString() {
        return this == new Foo()? "1": "";
    }
}
