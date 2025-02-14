import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable{
    static boolean[] array;
    static boolean isBingo;
    List<BingoCard> cards;

    public BingoGame(){
        array = new boolean[76];
        array[0] = true;
        cards = new ArrayList<>();
        isBingo = false;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players? : ");
        int players = sc.nextInt();
        for(int i=0; i<players; i++){
            cards.add(new BingoCard());
        }
        System.out.println("What pattern? (1. Plus or 2. Hash) : ");
        int pattern = sc.nextInt();
        sc.nextLine();
        List<Thread> threads = new ArrayList<>();
        if(pattern==1){
            for(BingoCard c: cards){
                threads.add(new Thread(new BingoPatternPlus(c)));
            }
        }else{
            for(BingoCard c: cards){
                threads.add(new Thread(new BingoPatternHash(c)));
            }
        }

        for (Thread t : threads){
            t.start();
        }

        Random random = new Random();
        while (!isBingo){
            int num;
            do{
                num = random.nextInt(75)+1;
            }while (array[num]);
            array[num] = true;

            System.out.println("Number picked: " + num);
            System.out.print("All numbers: ");
            for(int i=1; i<=75; i++){
                if(array[i]){
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            synchronized (array){
                array.notifyAll();
            }
            try {
                Thread.sleep(300);
            }catch (InterruptedException e){
                return;
            }
        }
        System.out.println("BINGO!");
        System.out.print("Final numbers: ");
        for(int i=1; i<=75; i++){
            if(array[i]){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for(Thread t : threads){
            t.interrupt();
        }
    }
}
