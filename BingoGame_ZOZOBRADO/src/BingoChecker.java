public abstract class BingoChecker implements Runnable {
    BingoCard c;
    public BingoChecker(BingoCard c){
        this.c = c;
    }
}
