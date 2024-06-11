public class Main {
    public static String filename;
    public static boolean isEnglishWord;

    public static void main(String[] args) {
        if (Start.askToStartTheGame().equals("Y")) {
            if (Start.selectLanguageRusOrEng().equals("ENG")) {
                filename = "resources/words.txt";
                isEnglishWord = true;
            } else {
                filename = "resources/russian_words.txt";
                isEnglishWord = false;
            }
        }
        Game game = new Game(filename, isEnglishWord);
        game.startGameLoop();
    }
}


