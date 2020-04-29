package week1.quick_find;

import java.util.Arrays;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i; // set id of each object to itself
        }
    }

    public void display() {
        Arrays.stream(id).forEach(System.out::print);
        System.out.println();
    }

    /**
     * Checks whether p and q are in the same component (2 array accesses)
     */
    public boolean connected(int p, int q) {
        return (id[p] == id[q]);
    }

    /**
     * Change all entries with id[p] to id[q].
     * At most 2N + 2 array accesses.
     */
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);
        quickFindUF.display();
        quickFindUF.union(0, 9);
        quickFindUF.display();
        System.out.println(quickFindUF.connected(0, 9));
        quickFindUF.union(5, 9);
        quickFindUF.display();
        System.out.println(quickFindUF.connected(5, 9));
    }

}
