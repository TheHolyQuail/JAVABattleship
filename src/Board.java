import java.util.Random;
import java.util.Scanner;

public class Board {
    String[][] grid = new String[8][8];
    boolean type;
    int ships = 4;

    public Board(boolean player) {
        this.type = player;
        for(int i = 0; i < 8; i++){
            for(int ii = 0; ii < 8; ii++){
                this.grid[i][ii] = "🌊";
            }
        }
    }
    public String[][] getGrid() {
        return grid;
    }
    public boolean getType() {
        return type;
    }

    public void setGridP() {
        //player set up

        //instructions
        System.out.println("choose where to put your ships");
        System.out.println("answers must be whole numbers between 1 and 8 (inclusive)");

        //input collection
        Scanner userInput = new Scanner(System.in);
        String inputX;
        String inputY;
        int X;
        int Y;
        boolean z;

        for(int i = 0; i < 4; i++) {
            z = false;
            while (z == false) {
                System.out.println("x coordinate of ship " + (i + 1));
                inputX = userInput.nextLine();
                X = Integer.parseInt(inputX) - 1;
                if(X <= 7 && X >= 0) {
                    System.out.println("y coordinate of ship " + (i + 1));
                    inputY = userInput.nextLine();
                    Y = Integer.parseInt(inputY) - 1;
                    if(Y <= 7 && Y >= 0) {
                        if (grid[Y][X] != "🛥") {
                            grid[Y][X] = "🛥";
                            z = true;
                        } else {
                            System.out.println("you already have a ship there");
                        }
                    } else {
                        System.out.println("invalid coordinate");
                    }
                } else {
                    System.out.println("invalid coordinate");
                }
            }
        }

        printGrid();
    }

    public void setGridO() {
        //opponent set up
        int boats = 4;
        int n;
        int nn;

        while(boats > 0){
            Random rand = new Random();
            n = rand.nextInt(8);
            nn = rand.nextInt(8);
            //if(this.grid[n][nn].equals("🌊")) {
            this.grid[n][nn] = "🛥";
            boats--;
            //}
        }
    }

    public int guess(int[] guess){
        if (grid[guess[0]][guess[1]].equals("🛥")){
            grid[guess[0]][guess[1]] = "💥";
            ships --;
        }else if (grid[guess[0]][guess[1]].equals("💥")){
        } else {
            grid[guess[0]][guess[1]] = "〰️";
        }
        return this.ships;
    }

    public void printGrid() {
        //displays the updated game to the player
        if(this.type){
            System.out.println("//your fleet//");
        }else{
            System.out.println("//opponents sea//");
        }
        String line;
        System.out.println("////////////////////////");
        for(int i = 0; i < 8;i++){
            line = "/"+ (i+1) +"/";
            for(int ii = 0; ii < 8;ii++){
                if(this.type){
                    line += grid[i][ii];
                } else {
                    if(grid[i][ii].equals("🛥")){
                        line += "🌊";
                    }else{
                        line += grid[i][ii];
                    }
                }
            }
            line += "//";
            System.out.println(line);
        }
        System.out.println("///1/2//3/4/5//6/7/8//");
        System.out.println("ships remaining: " + ships);
    }
}
