import java.util.Random;

public class Fibonacci {
    public static void main(String[] args) {
        Random r = new Random();
        long start, end;
        long fib;

        //Recursive method
        int n = r.nextInt(25);
        start = System.nanoTime();
        fib = recursiveFib(n);
        end = System.nanoTime();
        System.out.printf("Recursive: Fib(%d) = %d | Runtime: %d ns\n", n, fib, end - start);

        //Iterative method
        n = r.nextInt(25);
        start = System.nanoTime();
        fib = iterativeFib(n);
        end = System.nanoTime();
        System.out.printf("Iterative: Fib(%d) = %d | Runtime: %d ns\n", n, fib, end - start);
    }

    /**
     * Find nth element in Fibonacci sequence using a recursive method
     *
     * @param n the element to find fib(n)
     * @return the value at the nth position
     */
    public static long recursiveFib(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    /**
     * Iterative method to find nth element in Fibonacci sequence
     *
     * @param n the element to find fib(n)
     * @return the value at the nth position
     */
    public static long iterativeFib(int n) {
        long fib = 0, fib1 = 1, fib2 = 1;
        for(int i = 0; i < n; i++) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        return fib;
    }
}
