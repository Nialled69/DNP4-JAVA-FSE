import java.util.*;

public class exercise7 {
    public static double futureValue(double initialVal, double growth, int years) {
        if (years == 0) {
            return initialVal; 
        }
        return futureValue(initialVal, growth, years - 1) * (1 + growth);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the initial value of the item/product -> ");
        double initialValue = sc.nextDouble();
        System.out.print("Enter the annual growth rate (e.g., 0.05 for 5%) -> ");
        double growthRate = sc.nextDouble();
        System.out.print("Enter the number of years -> ");
        int years = sc.nextInt();
        double result = futureValue(initialValue, growthRate, years);
        System.out.printf("Future value after %d years: %.2f\n", years, result);
        sc.close();
    }
}