public class Main {
    public static void main(String[] args) {
        BingoGame game = new BingoGame();
        Thread t = new Thread(game);
        t.start();
    }
}
