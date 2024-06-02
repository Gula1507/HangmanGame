import java.util.List;

public class HangmanPicture {
    public static int stageNumber;

//    public HangmanPicture(int stageNumber) {
//        this.stageNumber = stageNumber;
//    }


    public static void drawHangman() {
        if (stageNumber > 0) {
            System.out.println("\nActualising Hangmanpicture.. \n");
        }
        switch (stageNumber) {
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
                System.out.println("");
                break;

        }
    }
}