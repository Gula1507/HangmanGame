import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final String FILENAME_WITH_WORDS = "resources/Words.txt";
    private String wordToGuess;
    private String cachedWord;
    private List<Character> usedLetters;
    private List<String> words;
    private int currentMistakeNumber;

    public Game() {
        this.usedLetters = new ArrayList<>();
        this.words = getWordsFromFile();
        this.wordToGuess = generateWordToGuess();
        this.cachedWord = generateCachedWord();
        this.currentMistakeNumber = 0;
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

    public void setCurrentMistakeNumber(int currentMistakeNumber) {
        this.currentMistakeNumber = currentMistakeNumber;
    }

    public void startGameLoop() {
        GameDisplay.showGameStatus(this);
        while (isGameProcessing()) {
            tryToGuessWord();
            GameDisplay.showGameStatus(this);
        }
        GameDisplay.showGameEnd(this, wordToGuess);
    }

    public List<String> getWordsFromFile() {
        List<String> words = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME_WITH_WORDS));
            String word = bufferedReader.readLine();
            while (word != null) {
                words.add(word.toUpperCase());
                word = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    public String generateWordToGuess() {
        Random r = new Random();
        int randomWordNumber = r.nextInt(words.size());
        String wordToGuess = words.get(randomWordNumber);
        return wordToGuess;
    }

    public String generateCachedWord() {
        String cachedWord = "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            result.append("*");
        }
        cachedWord = result.toString();
        return cachedWord;


    }

    private boolean isGameProcessing() {
        return !cachedWord.equals(wordToGuess) && currentMistakeNumber < 13;
    }

    private void tryToGuessWord() {
        String cachedWordBeforeNewMatches = cachedWord;
        char inputLetter = getInputLetter();
        inputLetter = getNewLetterIfRepeat(inputLetter);
        cachedWord = actualiseCachedWordWithMatches(inputLetter);
        GameDisplay.proofForMatch(this, cachedWordBeforeNewMatches);
        usedLetters.add(inputLetter);

    }

    private static char getInputLetter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the letter");
        String input = sc.nextLine();
        while (input.length() != 1 || !input.matches("[a-zA-Z]")) {
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
