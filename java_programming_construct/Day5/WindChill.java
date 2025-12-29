package java_programming_construct.basic_core_java_functional_program;
//PROBLEM 5(takes two double command-line arguments t
//and v and prints the wind chill. Use Math.pow(a, b) to compute ab. Given the
//temperature t (in Fahrenheit))
public class WindChill {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Please provide temperature (t) and wind speed (v) as arguments.");
            return;
        }

        double t = Double.parseDouble(args[0]);
        double v = Double.parseDouble(args[1]);
        if (Math.abs(t) > 50) {
            System.out.println("Temperature must be <= 50 in absolute value.");
            return;
        }
        if (v < 3 || v > 120) {
            System.out.println("Wind speed must be between 3 and 120 mph.");
            return;
        }

        double windChill = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);

        System.out.printf("The wind chill is: %.2f°F\n", windChill);
    }
}
