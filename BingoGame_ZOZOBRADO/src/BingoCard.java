import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoCard {
    int id;
    int[][] card;
    boolean isWinner;
    static int ID = 0;

    public BingoCard() {
        id = ++ID;
        this.card = generateCard();
        isWinner = false;
    }

    private int[][] generateCard(){
        int[][] card = new int[5][5];
        for(int i=0; i<5; i++){
            List<Integer> numbers = new ArrayList<>();
            for(int n= 1 + i * 15; n <= 15 + i*15; n++){
                numbers.add(n);
            }
            Collections.shuffle(numbers);
                for(int j=0; j<5; j++){
                    if(i==2 && j==2){
                        card[j][i] = 0;
                    }else{
                        card[j][i] = numbers.remove(0);
                    }
                }
            }
        return card;
    }

    @Override
    public String toString() {
        return  "\t" + "B   I   N   G   O" +  "\n" +
        "\t" + card[0][0] + "\t" + card[0][1] + "\t" + card[0][2] + "\t" + card[0][3] + "\t" + card[0][4] + "\n" +
        "\t" + card[1][0] + "\t" + card[1][1] + "\t" + card[1][2] + "\t" + card[1][3] + "\t" + card[1][4] + "\n" +
        "\t" + card[2][0] + "\t" + card[2][1] + "\t" + card[2][2] + "\t" + card[2][3] + "\t" + card[2][4] + "\n" +
        "\t" + card[3][0] + "\t" + card[3][1] + "\t" + card[3][2] + "\t" + card[3][3] + "\t" + card[3][4] + "\n" +
        "\t" + card[4][0] + "\t" + card[4][1] + "\t" + card[4][2] + "\t" + card[4][3] + "\t" + card[4][4];
    }
}
