import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsGenerator {
    private final String filename;
    private final List<String> words;

    public WordsGenerator(String filename) {
        this.filename=filename;
        this.words = getWordsFromFile();
    }

    public List<String> getWordsFromFile() {
        List<String> words = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
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

    public String generateCachedWord(String wordToGuess) {
        String cachedWord = "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            result.append("*");
        }
        cachedWord = result.toString();
        return cachedWord;
    }
}
