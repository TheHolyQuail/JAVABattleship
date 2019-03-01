import java.util.Scanner;

public class Player {

    public Player(){

    }
    public int[] guess() {
        int[] x = {0, 0};
        boolean z = false;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Guess where an opponent ship is");
        System.out.println("answers must be whole numbers between 1 and 8 (inclusive)");
        System.out.println("-");

        while (!z) {
            System.out.println("guess x coordinate");
            String inputX = userInput.nextLine();
            if(inputX.length() > 0 && inputX.length() < 2) {
                x[1] = Integer.parseInt(inputX) - 1;
                if (x[1] <= 7 && x[1] >= 0) {
                    System.out.println("guess y coordinate");
                    String inputY = userInput.nextLine();
                    if(inputX.length() > 0 && inputX.length() < 2) {
                        x[0] = Integer.parseInt(inputY) - 1;
                        if (x[0] <= 7 && x[0] >= 0) {
                            z = true;
                        } else {
                            System.out.println("invalid coordinate");
                        }
                    }else{
                        System.out.println("invalid coordinate");
                    }
                } else {
                    System.out.println("invalid coordinate");
                }
            }else{
                System.out.println("invalid coordinate");
            }
        }
        return x;
    }
}
