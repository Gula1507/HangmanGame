import java.util.List;
import java.util.Scanner;

public class Start {
    public static String filename;
    public static boolean isEnglishWord;

    public void execute() {
        if (askToStartTheGame().equals("Y")) {
            if (Start.selectLanguageRusOrEng().equals("ENG")) {
                filename = "resources/words.txt";
                isEnglishWord = true;
            } else {
                filename = "resources/russian_words.txt";
                isEnglishWord = false;
            }
            Game game = new Game(filename, isEnglishWord);
            game.startGameLoop();
        } else {
            System.out.println("Bye! See you the next time");
            System.exit(0);
        }

    }

    public static String askToStartTheGame() {
        String questionToStart = "Do you want to start the game (Y/N)?";
        String questionToRepeat = "Please consider that you tipped 'Y' or 'N'";
        List<String> keys = List.of("Y", "N");
        return askQuestionWithAnswerKeys(questionToStart, questionToRepeat, keys);

    }

    public static String selectLanguageRusOrEng() {
        return askQuestionWithAnswerKeys("Would you like to guess English or Russian words (ENG/RUS)?",
                "Please consider that you tipped 'ENG' or 'RUS'", List.of("ENG", "RUS"));

    }

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


}