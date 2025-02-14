public class BingoRowChecker extends BingoChecker{
    int row;

    public BingoRowChecker(BingoCard c, int row) {
        super(c);
        this.row = row;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            int num = c.card[row][i];
            while(!BingoGame.array[num]){
                try {
                    synchronized (BingoGame.array){
                        BingoGame.array.wait();
                    }
                }catch (InterruptedException e){
                    if(!BingoGame.isBingo || BingoGame.isBingo && !c.isWinner) {
                        System.out.println("Card " + c.id + " was waiting for " + num);
                    }
                    return;
                }
            }
        }
    }
}
