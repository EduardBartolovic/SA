public interface Interface {
    static void foo() {
        System.out.println(1);
    }
    
    default void bar() {
        System.out.println(2);
    }
}
