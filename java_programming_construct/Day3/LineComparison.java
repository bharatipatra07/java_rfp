package Day3;

public class LineComparison {
    public static void main(String[] args) {
        System.out.println("Enter Line points");
        Scanner sc=new Scanner(System.in);
        int x1=sc.nextInt();
        int y1=sc.nextInt();
        int x2=sc.nextInt();
        int y2=sc.nextInt();
        double length = Math.sqrt(
                Math.pow(x2 - x1, 2) +
                        Math.pow(y2 - y1, 2)
        );

        System.out.println("Length of the line: " + length);
    }
}
