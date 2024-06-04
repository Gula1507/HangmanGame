import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final String wordToGuess;
    private String cachedWord;
    private final List<Character> usedLetters;
    private int currentMistakeNumber;
    boolean isEnglishWord = true;

    public Game(String filename, boolean isEnglishWord) {
        this.usedLetters = new ArrayList<>();
        WordsGenerator wordGenerator = new WordsGenerator(filename);
        this.wordToGuess = wordGenerator.generateWordToGuess();
        this.cachedWord = wordGenerator.generateCachedWord(this.wordToGuess);
        this.currentMistakeNumber = 0;
        this.isEnglishWord = isEnglishWord;
    }

    public List<Character> getUsedLetters() {
        return usedLetters;
    }

    public String getCachedWord() {
        return cachedWord;
    }

    public int getCurrentMistakeNumber() {
        return currentMistakeNumber;
    }

    public void startGameLoop() {
        GameDisplay.showGameStatus(this);
        while (isGameProcessing()) {
            tryToGuessWord();
            GameDisplay.showGameStatus(this);
        }
        GameDisplay.showGameEnd(this, wordToGuess);
    }

    private boolean isGameProcessing() {
        return !cachedWord.equals(wordToGuess) && currentMistakeNumber < 13;
    }

    private void tryToGuessWord() {
        String cachedWordBeforeNewMatches = cachedWord;
        char inputLetter = getInputLetter();
        inputLetter = getNewLetterIfRepeat(inputLetter);
        cachedWord = actualiseCachedWordWithMatches(inputLetter);
        GameDisplay.showCurrentGuess(this, cachedWordBeforeNewMatches);
        usedLetters.add(inputLetter);
    }

    private char getInputLetter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the letter");
        String input = sc.nextLine();
        String acceptedLetter;
        if (this.isEnglishWord) {
            acceptedLetter = "[a-zA-Z]";
        } else {
            acceptedLetter = "[а-яА-ЯёЁ]";
        }
        while (input.length() != 1 || !input.matches(acceptedLetter)) {
            System.out.println("Please consider that you enter a letter");
            input = sc.nextLine();
        }
        return Character.toUpperCase((input.charAt(0)));

    }

    private String actualiseCachedWordWithMatches(char inputLetter) {
        StringBuilder wordWithMatches = new StringBuilder(cachedWord);
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == inputLetter) {
                wordWithMatches.setCharAt(i, inputLetter);
            }
        }
        if (wordWithMatches.toString().equals(cachedWord)) {
            currentMistakeNumber++;
        }
        return wordWithMatches.toString();
    }

    private char getNewLetterIfRepeat(char inputLetter) {
        while (usedLetters.contains(inputLetter)) {
            System.out.println("You have already used this letter. Try another one.");
            inputLetter = getInputLetter();
        }
        return inputLetter;
    }
}
