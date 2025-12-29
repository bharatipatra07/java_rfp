package java_programming_construct.programming_construct;


public class SnakeLadder{
    //UC 5
    public static void main(String[] args) {
        int position = 0, diceCount = 0;
        int WIN = 100;

        while(position < WIN) {
            int dice = (int)(Math.random() * 6) + 1;
            diceCount++;

            int option = (int)(Math.random() * 3);
            switch(option) {
                case 1: if(position + dice <= WIN) position += dice; break;
                case 2: position -= dice; if(position < 0) position = 0; break;
            }

            System.out.println("Dice: " + dice + ", Position: " + position);
        }
        System.out.println("Player reached 100 Total dice rolls: " + diceCount);
    }
}
