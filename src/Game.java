public class Game {
    public static void main(String[] args){
        Board gameP = new Board(true);
        Board gameO = new Board(false);
        Player play = new Player();
        Opponent oppo = new Opponent();
        System.out.println("☣️ Welcome to battleship ☢️");
        gameO.setGridO();
        gameP.setGridP();
        boolean win = false;
        int w = 4;

        int[] oppoGuess = {1,1};
        int[] playGuess;
        while (win == false) {
            gameP.printGrid();
            gameO.printGrid();

            playGuess = play.guess();
            w = gameO.guess(playGuess);
            //check for player win
            if(w <= 0){
                System.out.println("YOU WIN!!!");
                win = true;
            }
            boolean z = true;
            while(z) {
                oppoGuess = oppo.guess();
                int a = oppoGuess[0];
                int b = oppoGuess[1];
                z = false;
                if (gameP.grid[a][b].equals("〰️")){
                    z = true;
                }
            }
            w = gameP.guess(oppoGuess);
            if(w <= 0){
                System.out.println("YOU LOOSE");
                win = true;
            }
            //check for opponent win
        }

    }
}
