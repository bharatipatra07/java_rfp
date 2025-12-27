package java_programming_construct.Day2;
//4. Write a program Distance.java that takes two integer command-line arguments x and y and
//prints the Euclidean distance from the point (x, y) to the origin (0, 0).
//The formulae to calculate distance = sqrt(x*x + y*y). Use Math.power function
public class Distance {
    public static void main(String args[]){
        int num1=Integer.parseInt(args[0]);
        int num2=Integer.parseInt(args[1]);
        double distance=Math.sqrt(Math.pow(num1,2)+Math.pow(num2,2));
        System.out.println(distance);
    }
}
