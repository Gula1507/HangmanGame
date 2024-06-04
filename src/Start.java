import java.util.List;
import java.util.Scanner;

public class Start {
    public static String askQuestionWithAnswerKeys(String questionToStart, String questionToRepeat, List<String> keys) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(questionToStart);
            String answer = scanner.nextLine().toUpperCase();
            for (String key : keys) {
                if (answer.equals(key)) {
                    return key;
                }
            }
            System.out.println(questionToRepeat);
        }
    }
    public static String askToStartTheGame() {
        return askQuestionWithAnswerKeys("Do you want to start the game (Y/N)?",
                "Please consider that you tipped 'Y' or 'N'", List.of("Y", "N")

        );
    }

    public static String selectLanguageRusOrEng() {
        return askQuestionWithAnswerKeys("Would you like to guess English or Russian words (ENG/RUS)?",
                "Please consider that you tipped 'ENG' or 'RUS'", List.of("ENG", "RUS")
        );
    }
}