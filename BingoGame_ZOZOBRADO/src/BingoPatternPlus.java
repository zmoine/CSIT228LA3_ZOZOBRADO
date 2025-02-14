public class BingoPatternPlus extends BingoPattern{
    public BingoPatternPlus(BingoCard c) {
        super(c);
        checkers.add(new BingoRowChecker(c, 2));
        checkers.add(new BingoColumnChecker(c, 2));
    }
}
