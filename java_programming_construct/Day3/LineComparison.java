package Day3;

public class LineComparison {
    public static void main(String[] args) {
        System.out.println("Enter line points");
        Scanner sc=new Scanner(System.in);
        int x1=sc.nextInt();
        int y1=sc.nextInt();
        int x2=sc.nextInt();
        int y2=sc.nextInt();
        int x3=sc.nextInt();
        int y3=sc.nextInt();
        int x4=sc.nextInt();
        int y4=sc.nextInt();

        Double length1 = Math.sqrt(
                Math.pow(x2 - x1, 2) +
                        Math.pow(y2 - y1, 2)
        );

        Double length2 = Math.sqrt(
                Math.pow(x4 - x3, 2) +
                        Math.pow(y4 - y3, 2)
        );

        int result = length1.compareTo(length2);

        if (result == 0) {
            System.out.println("Both lines are equal");
        } else if (result > 0) {
            System.out.println("Line 1 is greater than Line 2");
        } else {
            System.out.println("Line 1 is less than Line 2");
        }
    }
}
