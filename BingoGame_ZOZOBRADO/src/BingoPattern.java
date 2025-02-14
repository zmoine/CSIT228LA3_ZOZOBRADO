import java.util.ArrayList;
import java.util.List;

public abstract class BingoPattern implements Runnable{
    List<BingoChecker> checkers;
    BingoCard c;

    public BingoPattern(BingoCard c) {
        checkers = new ArrayList<>();
        this.c = c;
    }

    @Override
    public void run(){
        List<Thread> threads = new ArrayList<>();
        for(BingoChecker ch: checkers){
            threads.add(new Thread(ch));
        }

        for(Thread t : threads){
            t.start();
        }

        for(Thread t : threads){
            try{
                t.join();
            }catch (InterruptedException e){
                System.out.println("Card " + c.id + " lost");
                for(Thread t0 : threads){
                    t0.interrupt();
                }
                return;
            }
        }

        c.isWinner = true;
        BingoGame.isBingo = true;
        System.out.println("Card " + c.id + " wins!");
        System.out.println(c);

        for(Thread t : threads){
            t.interrupt();
        }
    }
}
