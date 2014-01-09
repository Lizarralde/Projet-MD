/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Launcher {

    public static void main(String[] args) {

        int i;

        int j;

        Parser p = new Parser(System.in);

        System.out.println("Quelle solution voulez-vous afficher ?");

        System.out.println("1 - FkSolution");

        System.out.println("2 - F2kSolution");

        System.out.println("3 - F3kSolution");

        System.out.println("4 - F4kSolution");

        i = p.getInt();

        System.out.println("Quelle profondeur voulez-vous ?");

        j = p.getInt();

        switch (i) {

        case 1:

            new FkSolution(j);

            break;

        case 2:

            new F2kSolution(j);

            break;

        case 3:

            new F3kSolution(j);

            break;

        case 4:

            new F4kSolution(j);

            break;
        }
    }
}
