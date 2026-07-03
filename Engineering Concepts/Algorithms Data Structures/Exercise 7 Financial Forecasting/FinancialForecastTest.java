public class FinancialForecastTest {
    public static void main(String[] args) {

        double presentValue = 1000.0;
        double growthRate   = 0.05; // 5% annual growth
        int years           = 10;

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Present Value : $" + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println();

        // Recursive result
        double result1 = FinancialForecast.calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Recursive  Future Value : $%.2f%n", result1);

        // Memoized result
        double result2 = FinancialForecast.calculateFutureValueMemo(presentValue, growthRate, years);
        System.out.printf("Memoized   Future Value : $%.2f%n", result2);

        System.out.println();
        System.out.println("=== Year by Year Forecast ===");
        for (int i = 1; i <= years; i++) {
            double value = FinancialForecast.calculateFutureValue(presentValue, growthRate, i);
            System.out.printf("Year %2d : $%.2f%n", i, value);
        }

        System.out.println();
        System.out.println("=== Time Complexity Analysis ===");
        System.out.println("Recursive  : O(n) - one call per year");
        System.out.println("Memoized   : O(n) time, O(n) space - avoids recomputation");
        System.out.println("Conclusion : Memoization optimizes overlapping subproblems");
    }
}
