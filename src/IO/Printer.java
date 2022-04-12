package IO;

public interface Printer {

    default void printer (String text){
        System.out.println(text);
    }
}
