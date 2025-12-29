package java_programming_construct.basic_core_java_functional_program;

//PROBLEM 3(Power of 2)
public class PowerOf2 {
    public static void main(String args[]){
        int N=Integer.parseInt(args[0]);
        if(N<0 || N>=31) {
            System.out.println("N must be between 0 to 30");
        }
        for(int i=1;i<=N;i++){
            System.out.println("2*" + i + "=" + (2 * i));
        }
    }
}
