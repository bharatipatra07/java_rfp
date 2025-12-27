package java_programming_construct.Day2;

public class OperatorSpringSeason {
    public static void main(String args[]){
        int month=Integer.parseInt(args[0]);
        int day=Integer.parseInt(args[1]);
        boolean isSpring=((month==3 && day>=20)||(month==4)||(month==5)||(month==6 && day<=20)) ;
        System.out.println(isSpring);
    }
}
