import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BigInteger factorial = factorial(1024);
        System.out.println(factorial);
    }

    public static BigInteger factorial(int n) {
        return factorial(n, primes(n));
    }

    // recursive function with shared primes array
    private static BigInteger factorial(int n, int[] primes) {
        if (n < 2)
            return BigInteger.ONE;
        BigInteger f = factorial(n / 2, primes);
        BigInteger ps = primeSwing(n, primes);
        return f.multiply(f).multiply(ps);
    }

    // swinging factorial function
    private static BigInteger primeSwing(int n, int[] primes) {
        List<BigInteger> multipliers = new ArrayList<>();
        for (int i = 0; i < primes.length && primes[i] <= n; i++) {
            int prime = primes[i];
            BigInteger bigPrime = BigInteger.valueOf(prime);
            BigInteger p = BigInteger.ONE;
            int q = n;
            while (q != 0) {
                q = q / prime;
                if (q % 2 == 1) {
                    p = p.multiply(bigPrime);
                }
            }
            if (!p.equals(BigInteger.ONE)) {
                multipliers.add(p);
            }
        }
        return product(multipliers, 0, multipliers.size() - 1);
    }

    private static BigInteger product(List<BigInteger> multipliers, int i, int j) {
        if (i > j) {
            return BigInteger.ONE;
        }
        if (i == j) {
            return (BigInteger) multipliers.get(i);
        }
        int k = (i + j) >> 1;
        return product(multipliers, i, k).multiply(product(multipliers, k + 1, j));
    }

    // Eratosthenes sieve
    private static int[] primes(int limit) {
        limit++;
        if (limit >= 0 && limit <= 3) {
            return new int[] {};
        }

        int length = limit >> 1;
        boolean[] sieve = new boolean[length];
        for (int i = 1, iterations = (int) Math.sqrt(length - 1); i < iterations; i++) {
            if (!sieve[i]) {
                for (int step = 2 * i + 1, j = i * (step + 1); j < length; j += step) {
                    sieve[j] = true;
                }
            }
        }

        int notPrimes = 0;
        for (boolean notPrime : sieve) {
            if (notPrime) {
                notPrimes++;
            }
        }

        int[] sieves = new int[length - notPrimes];
        sieves[0] = 2;
        for (int i = 1, j = 1; i < length; i++) {
            if (!sieve[i]) {
                sieves[j] = 2 * i + 1;
                j++;
            }
        }
        return sieves;
    }
}