package java_programming_construct.programming_construct;


public class SnakeLadder{
    //UC 3
    public static void main(String[] args) {
        int position = 0;
        int dice = (int)(Math.random() * 6) + 1;
        int option = (int)(Math.random() * 3);

        switch(option) {
            case 0:
                System.out.println("No Play. Position stays: " + position);
                break;
            case 1:
                position += dice;
                System.out.println("Ladder Moved forward by " + dice + ". New position: " + position);
                break;
            case 2:
                position -= dice;
                if(position < 0) position = 0;
                System.out.println("Snake Moved backward by " + dice + ". New position: " + position);
                break;
        }
    }
}
