import java.io.InputStream;
import java.util.Scanner;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Parser {

    private Scanner s;

    public Parser(InputStream in) {

        s = new Scanner(in);
    }

    public int getInt() {

        int i;

        i = s.nextInt();

        return i;
    }
}
