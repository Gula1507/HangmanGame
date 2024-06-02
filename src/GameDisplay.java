public class GameDisplay {

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

    public static void showCurrentGuess(Game game, String cachedWordBeforeNewMatches) {
        if (cachedWordBeforeNewMatches.equals(game.getCachedWord())) {
            System.out.println("\nOh no, it was a false letter!");
        } else {
            System.out.println("\nIt was a match!");

        }
    }

}

