package week1.quick_union;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Modify quick union to avoid tall trees.
 * Keep track of size of each tree (number of obects).
 * Balance by linking root of smaller tree to root of larger tree.
 */
public class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = i;
        }
        Arrays.stream(parent).forEach(System.out::print);
    }

    public int count() {
        return this.count;
    }

    /**
     * Chase parent pointers until reach root.
     * (depth of i array accesses)
     */
    public int find(int p) {
        validate(p);
        while (p != this.parent[p]) {
            p = this.parent[p];
        }
        return p;
    }

    private void validate(int p) {
        int n = this.parent.length;
        if (n < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    /**
     * Check of p and q have same root.
     * (depth of p and q array accesses)
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Link root of smaller tree to root of larger tree.
     * Update the sz[] array.
     */
    public void union(int p, int q) {
        int i = this.find(p);
        int j = this.find(q);
        if (i == j) return;
        if (this.size[i] < this.size[j]) {
            this.parent[i] = j;
            this.size[j] += this.size[j];
        } else {
            this.parent[j] = i;
            this.size[i] += this.size[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);

        while (!scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }

        System.out.println(uf.count() + " components");
    }
}
