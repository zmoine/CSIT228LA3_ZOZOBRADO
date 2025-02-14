public class BingoPatternHash extends BingoPattern{
    public BingoPatternHash(BingoCard c) {
        super(c);
        checkers.add(new BingoRowChecker(c, 1));
        checkers.add(new BingoRowChecker(c, 3));
        checkers.add(new BingoColumnChecker(c, 1));
        checkers.add(new BingoColumnChecker(c, 3));
    }
}
