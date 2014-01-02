import java.util.Scanner;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Parser {

    private Scanner s;

    public Parser() {

        s = new Scanner(System.in);
    }

    public int getInt() {

        int i;

        System.out.println("Profondeur k ?");

        i = s.nextInt();

        s.close();

        return i;
    }
}
