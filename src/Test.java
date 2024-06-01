import java.util.List;
import java.util.Scanner;

public class Test {
    public static String questionToStart;
    public static String questionToRepeat;
    public static List<String> answerKeys;



    public static String inputStartOrExitCommand() {
        questionToStart = "Do you like to start the game (Y/N)?";
        questionToRepeat = "Please consider that you tipped 'Y' or 'N'";
        answerKeys = List.of("Y", "N");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(questionToStart);
            String answer = scanner.nextLine().toUpperCase();
            for (String key : answerKeys) {
                if (answer.equals(key)) {
                    return key;
                }
            }
            System.out.println(questionToRepeat);
        }

    }

    public static String inputLanguageRusOrEnCommand() {

        questionToStart = "Would you like to guess english or russian words (ENG/RUS)?";
        questionToRepeat = "Please consider that you tipped 'ENG' or 'RUS'";
        answerKeys = List.of("EN", "RUS");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(questionToStart);
            String answer = scanner.nextLine().toUpperCase();
            for (String key : answerKeys) {
                if (answer.equals(key)) {
                    return key;
                }
            }
            System.out.println(questionToRepeat);
        }
    }
}