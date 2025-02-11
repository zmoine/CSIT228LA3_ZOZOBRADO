import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class BingoGame implements  Runnable{
   boolean[] array;
   boolean isBingo;
   List<BingoCard> cards;
    BingoGame(){
        cards = new ArrayList<BingoCard>();
        array = new boolean[76];
        array[0] = true;
        for(int i=1; i<76; i++){
            array[i] = false;
        }
        isBingo = false;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players? ");
        int p = sc.nextInt();
        sc.next();
        List<Thread> threads = new ArrayList<>();
        for(int i=0; i<p; i++){
            cards.add(new BingoCard());
            threads.add(new Thread(new BingoPatternPlus()));
        }

        for(Thread t: threads){
            t.start();
        }

        int min = 1, max = 75;
        while(isBingo == false){
            Random random = new Random();
            int num = random.nextInt(max-min+1)+min;
            array[num] = true;
            System.out.println("Chosen number: " + num);
        }
    }
}