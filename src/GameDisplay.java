import java.util.List;

public class GameDisplay {
//    Game game;
//    private static final int MAX_MISTAKE_LEVEL = 13;
//    String cachedWord;
//    private List<Character> usedLetters;

//    public GameDisplay(String cachedWord, List<Character> usedLetters) {
//        this.game=new Game();
//        this.cachedWord = cachedWord;
//        this.usedLetters = usedLetters;
//    }


    public static void showGameStatus(Game game) {
        System.out.println("The word to guess is: " + game.getCachedWord());
        if (!game.getUsedLetters().isEmpty()) {
            System.out.println("Letters that you have already used: " + game.getUsedLetters());
        }
        HangmanPicture.stageNumber =game.getCurrentMistakeNumber();
        HangmanPicture.drawHangman();

    }

    public static void showGameEnd(Game game,String wordToGuess) {
        if (game.getCachedWord().equals(wordToGuess)) {
            System.out.println("\nYou are won! The word was " + wordToGuess);
        } else {
            System.out.println("\nYou are lost, the word was " + wordToGuess);

        }
    }

    public static void proofForMatch(Game game,String cachedWordBeforeNewMatches) {
        if (cachedWordBeforeNewMatches.equals(game.getCachedWord())) {
            System.out.println("\nOh no, it was a false letter!");
            game.setCurrentMistakeNumber(game.getCurrentMistakeNumber()+1);
        } else {
            System.out.println("\nIt was a match!");

        }
    }

}

