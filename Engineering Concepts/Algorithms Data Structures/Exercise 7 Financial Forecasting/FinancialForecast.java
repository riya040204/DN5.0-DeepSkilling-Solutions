public class FinancialForecast {

    // RECURSIVE method - calculates future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return presentValue;
        }
        // Recursive case
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // MEMOIZATION - optimized recursive approach
    static double[] memo;

    public static double calculateFutureValueMemo(double presentValue, double growthRate, int years) {
        memo = new double[years + 1];
        return memoHelper(presentValue, growthRate, years);
    }

    private static double memoHelper(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = memoHelper(presentValue, growthRate, years - 1) * (1 + growthRate);
        return memo[years];
    }
}
