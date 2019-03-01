import java.util.Random;

public class Opponent {
    public Opponent(){

    }
    public int[] guess(){
        Random rand = new Random();
        int n = rand.nextInt(8);
        int nn = rand.nextInt(8);
        int[] x = {n,nn};
        return x;
    }
}
