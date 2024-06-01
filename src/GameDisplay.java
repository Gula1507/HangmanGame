import java.util.List;

public class GameDisplay {
    private HangmanPicture hangmanPicture;
    Game game;
    private static final int MAX_MISTAKE_LEVEL = 13;
    
    private List<Character> usedLetters;

    public GameDisplay(String cachedWord, List<Character> usedLetters) {

        this.game=new Game();
        this.hangmanPicture = new HangmanPicture(game.getCurrentMistakeNumber());
        this.cachedWord = cachedWord;
        this.usedLetters = usedLetters;
    }


    public void showGameStatus() {
        System.out.println("The word to guess is: " + cachedWord);
        if (usedLetters.size() > 0) {
            System.out.println("Letters that you have already used: " + usedLetters);
        }
        hangmanPicture.setStageNumber(game.getCurrentMistakeNumber());
        hangmanPicture.drawHangman();

    }

    public void showGameEnd(String wordToGuess) {
        if (cachedWord.equals(wordToGuess)) {
            System.out.println("\nYou are won! The word was " + wordToGuess);
        } else {
            System.out.println("\nYou are lost, the word was " + wordToGuess);

        }
    }

    public void proofForMatch(String cachedWordBeforeNewMatches) {
        if (cachedWordBeforeNewMatches.equals(cachedWord)) {
            System.out.println("\nOh no, it was a false letter!");
            game.setCurrentMistakeNumber(game.getCurrentMistakeNumber()+1);
        } else {
            System.out.println("\nIt was a match!");

        }
    }

}

