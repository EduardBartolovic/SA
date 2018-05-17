package edu.hm.bartolov.a07_undercut_threaded;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.stream.Stream;

/**
 * Generic Factoryclass.
 * @author Felix Peither, Eduard Bartolovic
 */
public class Factory {
/**
     * Produziert ein Objekt eines vorgegebenen Typs.
     * Wenn der Typ nicht existiert, sucht die Klasse in einem Defaultpackage.
     * Wenn er dort auch nicht existiert, gibt die Methode auf.
     * Die Methode erzeugt das Objekt mit einem Konstruktor.
     * @param <T> Type des produzierten Objektes.
     * @param clazz Type of the class which will be prodcued.
     * @param typenameArg String mit einem Klassennamen mit oder ohne Packagepfad, ohne Konstruktorargumenten.
     * @return Ein Objekt vom typ T.
     * @exception ReflectiveOperationException wenn beim Erzeugen des Objektes etwas schief geht.
     */
    @SuppressWarnings("unchecked")
    public static <T> T make(Class<T> clazz ,String typenameArg) throws ReflectiveOperationException {
        final String[] token = typenameArg.split("[^-\\w\\./;]");
        final String typename = token[0].replace(File.separatorChar, '.');
        final Class<?> type = Class.forName(typename);
        return clazz.cast(Stream.of(type.getDeclaredConstructors())
            .filter(ctor -> ctor.getParameterTypes().length == 0)
            .peek(ctor -> ctor.setAccessible(true))
            .peek(ctor -> logCtor(ctor))
            .findAny()
            .orElseThrow(IllegalArgumentException::new)
            .newInstance());
    }
    
    /** Protokolliert die Argumente auf der Konsole.
     * @param constructor Konstruktor.
     */
    private static void logCtor(Constructor<?> constructor) {
            System.out.printf("make: %s %n",
                              stripPackages(constructor.toString()));
    }

    /** Ersetzt in einem String FQCN durch einfache Klassennamen.
     * @param string String mit FQCN.
     * @return String mit einfachen Klassennamen.
     */
    private static String stripPackages(String string) {
        return string.replaceAll("(?:[_a-z0-9]+\\.)+([A-Z]\\w+)", "$1")
            .replace("public ", "");
    }
}
