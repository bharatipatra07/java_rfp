package java_programming_construct.programming_construct;


public class SnakeLadder{
    //UC6 and UC7
    public static void main(String[] args) {
        int p1 = 0, p2 = 0, WIN = 100, diceCount = 0;
        boolean p1Turn = true;

        while(p1 < WIN && p2 < WIN) {
            int dice = (int)(Math.random() * 6) + 1;
            int option = (int)(Math.random() * 3);
            diceCount++;

            if(p1Turn) {
                switch(option) {
                    case 1: if(p1 + dice <= WIN) p1 += dice; break;
                    case 2: p1 -= dice; if(p1 < 0) p1 = 0; break;
                }
                System.out.println("Player 1 dice: " + dice + ", position: " + p1);
                if(option != 1) p1Turn = false;
            } else {
                switch(option) {
                    case 1: if(p2 + dice <= WIN) p2 += dice; break;
                    case 2: p2 -= dice; if(p2 < 0) p2 = 0; break;
                }
                System.out.println("Player 2 dice: " + dice + ", position: " + p2);
                if(option != 1) p1Turn = true;
            }
        }

        if(p1 == WIN) System.out.println("Player 1 WON");
        else System.out.println("Player 2 WON");

        System.out.println("Total dice rolls: " + diceCount);
    }
}
