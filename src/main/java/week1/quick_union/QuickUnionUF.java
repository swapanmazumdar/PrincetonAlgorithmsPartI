package week1.quick_union;

public class QuickUnionUF {

    private int[] id;

    /**
     * Set id of each object to itself.
     * (N array accesses)
     */
    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Chase parent pointers until reach root.
     * (depth of i array accesses)
     */
    public int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /**
     * Check of p and q have same root.
     * (depth of p and q array accesses)
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * Change root of p to root of q.
     * (depth of p and q array accesses)
     */
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

}
