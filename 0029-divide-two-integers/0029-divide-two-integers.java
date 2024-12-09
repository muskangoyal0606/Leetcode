class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: if the dividend is Integer.MIN_VALUE and the divisor is -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // overflow condition
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) != (divisor < 0);

        // Work with positive values for simplicity, using absolute values
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        long quotient = 0;
        while (dividendL >= divisorL) {
            long tempDivisor = divisorL, multiple = 1;

            // Double the divisor until it becomes greater than the dividend
            while (dividendL >= (tempDivisor << 1)) {
                tempDivisor <<= 1; // Equivalent to multiplying by 2
                multiple <<= 1;    // Keep track of how many times we doubled the divisor
            }

            // Subtract the largest possible multiple of divisor from dividend
            dividendL -= tempDivisor;
            quotient += multiple;
        }

        // If the result is negative, make it negative
        if (isNegative) {
            quotient = -quotient;
        }

        // Return the result, ensuring it's within the 32-bit signed integer range
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
    
}