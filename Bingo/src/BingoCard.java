import java.util.*;

public class BingoCard {
    private int id, counter  = 1;
    private int[][] card;

    public  BingoCard(){
        this.id = counter++;
        this.card = generateCard();
    }

    private int[][] generateCard() {
        int[][] card = new int[5][5];
        for(int row = 0; row < 5; row++){
            List<Integer> list = new ArrayList<>();
            for (int m = 1 + (row * 15); m <= 15 + (row * 15); m++) {
                list.add(m);
            }
            Collections.shuffle(list);
            for (int col = 0; col < 5; col++) {
                if(row== 2 && col == 2){
                    card[2][2] = 0;
                    continue;
                }
                card[col][row] = list.remove(0);

            }
        }
        return card;
    }
    public  int getId(){return  id;}
    public int[][] getCard() {return card;}

    @Override
    public String toString() {
        return
                "\t" + "B   I   N   G   O" + "\n" +
                "\t" + card[0][0] + "\t" + card[0][1] + "\t" + card[0][2] + "\t" + card[0][3] + "\t" + card[0][4] + "\n" +
                "\t" + card[1][0] + "\t" + card[1][1] + "\t" + card[1][2] + "\t" + card[1][3] + "\t" + card[1][4] + "\n" +
                "\t" + card[2][0] + "\t" + card[2][1] + "\t" + card[2][2] + "\t" + card[2][3] + "\t" + card[2][4] + "\n" +
                "\t" + card[3][0] + "\t" + card[3][1] + "\t" + card[3][2] + "\t" + card[3][3] + "\t" + card[3][4] + "\n" +
                "\t" + card[4][0] + "\t" + card[4][1] + "\t" + card[4][2] + "\t" + card[4][3] + "\t" + card[4][4] + "\n";
    }
}