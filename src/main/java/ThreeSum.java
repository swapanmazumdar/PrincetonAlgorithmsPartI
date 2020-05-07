import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * A program with cubic running time. Reads in n integers and counts the number of triples that sum to exactly 0.
 * 3-SUM. Given N distinct integers, how many triples sum to exactly zero?
 * Context. Deeply related to problems in computational geometry
 */
public class ThreeSum {

    /**
     * 3-SUM: brute-force algorithm
     * Return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
     **/
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] eight_ints = In.readInts("8ints.txt");
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(count(eight_ints));
        System.out.println("elapsed time = " + stopwatch.elapsedTime());
        eight_ints = null;

        int[] oneK_ints = In.readInts("1Kints.txt");
        stopwatch = new Stopwatch();
        System.out.println(count(oneK_ints));
        System.out.println("elapsed time = " + stopwatch.elapsedTime());
        oneK_ints = null;

        int[] twoK_ints = In.readInts("2Kints.txt");
        stopwatch = new Stopwatch();
        System.out.println(count(twoK_ints));
        System.out.println("elapsed time = " + stopwatch.elapsedTime());
        twoK_ints = null;


        int[] eightK_ints = In.readInts("8Kints.txt");
        stopwatch = new Stopwatch();
        System.out.println(count(eightK_ints));
        System.out.println("elapsed time = " + stopwatch.elapsedTime());
        eightK_ints = null;

        int[] eighteenK_ints = In.readInts("18Kints.txt");
        stopwatch = new Stopwatch();
        System.out.println(count(eighteenK_ints));
        System.out.println("elapsed time = " + stopwatch.elapsedTime());
        eighteenK_ints = null;

        int[] thirty2K_ints = In.readInts("32Kints.txt");
        stopwatch = new Stopwatch();
        System.out.println(count(thirty2K_ints));
        System.out.println("elapsed time = " + stopwatch.elapsedTime());
        thirty2K_ints = null;
    }
}
