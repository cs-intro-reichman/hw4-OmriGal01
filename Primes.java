public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] primeChecker = new boolean[n + 1];
        int p = 2;
        int primeCount;
        for (int i = 2; i < primeChecker.length; i++) {
            primeChecker[i] = true;
        }
        while (p <= Math.sqrt(n)) {
            for (int i = 2; i <= n / p; i++) {
                primeChecker[p*i] = false;
            }
            p = findNextTrue(primeChecker, p);
        }
        System.out.println("Prime numbers up to " + n + ":");
        printlnAllTrues(primeChecker);
        primeCount = countAllTrues(primeChecker);
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + (int) ((primeCount / (double) n) * 100) + "% are primes)");
    }

    /** Given a boolean array and a starting index, finds the next index where the value is true.
     */
    public static int findNextTrue(boolean[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] == true) {
                return i;
            }
        }
        return -1;
    }

    /** Simply prints all the indexes in a given boolean array where the value is true.
     */
    public static void printlnAllTrues(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }

    /** Counts the amount of true indexes in a given boolean array.
     */
    public static int countAllTrues(boolean[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                count++;
            }
        }
        return count;
    }
}