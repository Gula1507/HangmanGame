public class Main {
    public static void main(String[] args) {
        if (Start.askToStartTheGame().equals("Y")) {
            Game game=new Game();
            game.startGameLoop();}
    }

}
