import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        while (startGame().equals("Y")) {
            List<Character> usedLetters = new ArrayList<>();
            List<String> words = new ArrayList<>();
            words = generateWordsList();
            String wordToGuess = generateWordToGuess((ArrayList<String>) words);
            String customerWord = generateCustomerWord(wordToGuess);
            int counter = 0;
            while (!customerWord.equals(wordToGuess) && counter < 13) {
                String counterWord = customerWord;
                char usedLetter = doToUpperCase(getInputText());
                while (usedLetters.contains(usedLetter)) {
                    System.out.println("You have already used this letter. Try another one.");
                    usedLetter = doToUpperCase(getInputText());
                }
                customerWord = findLetterMatch(usedLetter,
                        wordToGuess, customerWord);
                if (counterWord.equals(customerWord)) {
                    System.out.println("\n\nOh no, it was a false letter. Drawing the hangman..");
                    counter++;
                } else {
                    System.out.println("It was a match!");
                }
                drawHangman(counter);
                System.out.println("The word to guess is: " + customerWord);
                usedLetters.add(usedLetter);
            }
            if (customerWord.equals(wordToGuess)) {
                System.out.println("You are won! The word was " + wordToGuess);
            } else {
                System.out.println("You are lost, the word was " + wordToGuess);
                drawHangman(counter);
            }
        }
    }

    private static String startGame() {
        Scanner sc = new Scanner(System.in);
        String reply = "";
        while (!reply.equals("Y") && !reply.equals("N")) {
            System.out.println("Do you like to start the game (Y/N) ?");
            reply = sc.nextLine().toUpperCase();
            switch (reply) {
                case "N":
                    System.out.println("Bye, see you the next time!");
                    break;

                case "Y":
                    System.out.println("Starting the game...");
                    break;
                default:
                    System.out.println("Please consider that you tipped 'Y' or 'N'");
                    break;
            }
        }
        return reply;
    }

    private static char getInputText() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the letter");
        char a = (sc.next().charAt(0));
        return a;

    }

    private static char doToUpperCase(char inputLetter) {
        if (inputLetter != 0 && !Character.isWhitespace(inputLetter)) {
            inputLetter = Character.toUpperCase(inputLetter);
        }
        return inputLetter;
    }


    public static String findLetterMatch(char inputLetter, String wordToGuess, String customerWord) {
        StringBuilder result = new StringBuilder(customerWord);
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == inputLetter) {
                result.setCharAt(i, inputLetter);
            }
        }

        return result.toString();
    }

    public static void drawHangman(int counter) {
        switch (counter) {
            case 1:
                System.out.println("\n\n\n");
                System.out.println("|");
                break;
            case 2:
                System.out.println("\n\n\n");
                System.out.println("|\n|");
                break;
            case 3:
                System.out.println("\n\n\n");
                System.out.println("|\n|\n|");
                break;
            case 4:
                System.out.println("\n\n\n");
                System.out.println("|\n|\n|\n|");
                break;
            case 5:
                System.out.println("\n\n\n");
                System.out.println("____\n|\n|\n|\n|");
                break;
            case 6:
                System.out.println("\n\n\n");
                System.out.println("________\n|\n|\n|\n|");
                break;
            case 7:
                System.out.println("________\n|      |\n|\n|\n|");
                break;
            case 8:
                System.out.println("________\n|      |\n|      0\n|\n|");
                break;
            case 9:
                System.out.println("________\n|      |\n|      0\n|      |\n|");
                break;
            case 10:
                System.out.println("________\n|      |\n|     \\0\n|      |\n|");
                break;
            case 11:
                System.out.println("________\n|      |\n|     \\0/\n|      |\n|");
                break;
            case 12:
                System.out.println("________\n|      |\n|     \\0/\n|      |\n|     /");
                break;
            case 13:
                System.out.println("________\n|      |\n|     \\0/\n|      |\n|     / \\");
                break;
            default:
                break;

        }
    }

    public static ArrayList<String> generateWordsList() throws IOException {

        File file = new File("resources/Words.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String word = br.readLine();
        List<String> words = new ArrayList<>();
        while (word != null) {
            words.add(word.toUpperCase());
            word = br.readLine();
        }

        return (ArrayList<String>) words;
    }

    public static String generateWordToGuess(ArrayList<String> words) {
        Random r = new Random();
        int randomWordNumber = r.nextInt(words.size());
        String wordToGuess = words.get(randomWordNumber);
        return wordToGuess;
    }

    public static String generateCustomerWord(String wordToGuess) {
        String customerWord = "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {

            result.append("*");
        }
        customerWord = result.toString();
        System.out.println("The word to guess: " + customerWord);
        return customerWord;


    }
}








