package java_programming_construct.basic_core_java_functional_program;
//PROBLEM 4(find the roots of the equation a*x*x + b*x + c)
public class Distance {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        System.out.println("Distance = " + distance);
    }
}

