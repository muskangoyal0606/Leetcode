class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0; // No primes less than 2

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false; // 0 is not a prime
        isPrime[1] = false; // 1 is not a prime

        int count = 0;
        for (int i = 2; i * i < n; i++) { // Ensure i * i does not exceed n
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) { // Prevent overflow
                    isPrime[j] = false; // Mark multiples of i as non-prime
                }
            }
        }

        // Count primes
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }
}