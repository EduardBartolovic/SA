import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MultipleMethodsAndThrows {
    MultipleMethodsAndThrows(){}
    private int first() throws IOException {
        try {
            final int amount = (int) Files.walk(Paths.get("C:\\")).count();
        } catch(IOException io) {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                throw new IllegalArgumentException();
            }
        }
        throw new IOException();
    }
    void scnd() throws Exception{
        final int k = (int)Math.random();
        try {
            if(k == 0)
                throw new InterruptedException();
        } catch (InterruptedException intr) {
            System.out.println();
        } finally {
            throw new IllegalArgumentException();
        }
    }

    protected double thrd() throws Exception{
        try {
            throw new IOException();
        } catch(IOException e) {
            System.out.println("a");
        }
        return -1.0;
    }
}
