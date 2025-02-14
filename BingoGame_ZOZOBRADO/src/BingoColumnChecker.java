public class BingoColumnChecker extends BingoChecker{
    int col;

    public BingoColumnChecker(BingoCard c, int col) {
        super(c);
        this.col = col;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            int num = c.card[i][col];
            while(!BingoGame.array[num]){
                try {
                    synchronized (BingoGame.array){
                        BingoGame.array.wait();
                    }
                }catch (InterruptedException e){
                    if(!BingoGame.isBingo || BingoGame.isBingo && !c.isWinner) {
                        System.out.println("Card " + c.id + " was waiting for " + num);
                    }
                }
            }
        }
    }
}
