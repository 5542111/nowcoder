public class a1175numPrimeArrangements {
    public int numPrimeArrangements(int n) {
        int MOD = 1000000007;
        int countOfPrimes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) countOfPrimes++;
        }
        long count1 = 1L;
        long count2 = 1L;
        for (int i = 1; i <= countOfPrimes; i++) {
            count1 *= i;
            count1 %= MOD;
        }
        for (int i = 1; i <= n - countOfPrimes; i++) {
            count2 *= i;
            count2 %= MOD;
        }
        return (int) (count1* count2 % MOD);
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if ((num % i) == 0) return false;
        }
        return true;
    }
}
