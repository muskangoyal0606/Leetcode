class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the case where dividend and divisor are equal
        if (dividend == divisor)
            return 1;

        // Determine the sign of the result
        boolean sign = true;
        if ((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0))
            sign = false;

        // Convert dividend and divisor to their absolute values
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        // Perform the division using bitwise operations
        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }

            quotient += (1L << count);
            n -= (d << count);
        }

        // Handle overflow cases
        if (quotient == (1L << 31) && sign)
            return Integer.MAX_VALUE;

        if (quotient == (1L << 31) && !sign)
            return Integer.MIN_VALUE;

        // Return the final result with the correct sign
        return sign ? (int) quotient : (int) -quotient;
    }
}
