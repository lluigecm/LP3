import java.util.Scanner;


public class Battleship {

    static class IntObj{
        int value = 0;
    }

    public static void main(String[] args){
        System.out.println("\t\t\t\tWelcome to Battleship");

        char[][] p1 = new char[5][5];//, p1_hist = new char[5][5];
        char[][] p2 = new char[5][5];//, p2_hist = new char[5][5];
        char[][] historico_p1 = new char[5][5];//, p1_hist = new char[5][5];
        char[][] historico_p2 = new char[5][5];//, p2_hist = new char[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++) {
                p1[i][j] = '_';
                p2[i][j] = '_';
                historico_p1[i][j] = '_';
                historico_p2[i][j] = '_';
            }
        }

        putShips(1, p1);
        putShips(2, p2);

        IntObj hitP1 = new IntObj(), hitP2 = new IntObj();

        while(true){
            attackShip(1, 2, p2, historico_p1, hitP1);
            if(hitP1.value == 5){
                System.out.println("PLAYER 1 WINS!! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!!");
                break;
            }
            attackShip(2, 1, p1, historico_p2, hitP2);
            if(hitP2.value == 5){
                System.out.println("PLAYER 2 WINS!! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!!");
                break;
            }
        }

        System.out.println("\t\t\t\tEND GAME");

    }


    public static void attackShip(int player, int enemy, char [][] table, char [][] targetHist, IntObj hits){
        System.out.println("\n\nPlayer " + player + " , enter hit row/column:");
        Scanner scan = new Scanner(System.in);

        while(true){
            int lin = scan.nextInt(), col = scan.nextInt();

            if(lin > 4 || lin < 0 || col > 4 || col < 0){
                System.out.println("Invalid coordinates. Choose different coordinates");
            }else if(targetHist[lin][col] == 'O' || targetHist[lin][col] == 'X' ){
                System.out.println("You already fired on this spot. Choose different coordinates");
            }else{
                if(table[lin][col] == '_'){
                    targetHist[lin][col] = 'O';
                    System.out.println("PLAYER " + player + " MISSED!");
                } else{
                    targetHist[lin][col] = 'X';
                    System.out.println("PLAYER " + player + " HIT PLAYER " + enemy + "'s SHIP!!!");
                    hits.value++;
                }
                break;
            }
        }
        System.out.println("\n\n");
        prettyPrint(targetHist);
    }

    public static void putShips(int i, char [][] table){
        Scanner scan  = new Scanner(System.in);
        int lin, col, cont = 0;

        System.out.println("\n\nPlayer " + i + " choosing coordinates");

        while(cont < 5){
            System.out.println("Enter ship " + (cont+1) + " location");
            lin = scan.nextInt();
            col = scan.nextInt();
            if(lin > 4 || lin < 0 || col > 4 || col < 0) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }else if(table[lin][col] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
            }else {
                table[lin][col] = '@';
                cont++;
            }
        }
        System.out.println();
        prettyPrint(table);

    }
    public static void prettyPrint(char[][] arr) {
        for (char[] row : arr) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
