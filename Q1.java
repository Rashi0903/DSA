/*
 * You're given an array A of n integers and q queries. Each query can be one of the following two types:
	• Type 1 Query: (1, l, r) - Replace A[i] with (i-l+1)*A[l] for each index i, where l <= i <= r.
	• Type 2 Query: (2, l, r) - Calculate the sum of the elements in A from index l to index r.
Find the sum of answers to all type 2 queries. Since answer can be large, return it modulo 10^9+7.
Constraints:
	• 1 <= n <= 10^5
	• 1 <= A[i] <= 10^5
	• 1 <= q <= 10^5
	• 0 <= queries[i][j] <= 10^5

    Segment Tree

 */

import java.util.*;

public class Q1 {
    static final int mod = 1000000007;
    static int[] tree;
    static int n;

    // Build the segment tree
    public static void build(int[] arr, int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
        } else {
            int mid = (l + r) / 2;
            build(arr, 2 * node, l, mid);
            build(arr, 2 * node + 1, mid + 1, r);
            tree[node] = (tree[2 * node] + tree[2 * node + 1]) % mod;
        }
    }

    // Point update
    public static void update(int ind, int val, int node, int l, int r) {
        if (l == r) {
            tree[node] = val;
        } else {
            int mid = (l + r) / 2;
            if (ind <= mid) {
                update(ind, val, 2 * node, l, mid);
            } else {
                update(ind, val, 2 * node + 1, mid + 1, r);
            }
            tree[node] = (tree[2 * node] + tree[2 * node + 1]) % mod;
        }
    }

    // Range sum query
    public static int sum(int ql, int qr, int node, int l, int r) {
        if (qr < l || ql > r) {
            return 0;
        }
        if (ql <= l && qr >= r) {
            return tree[node];
        }
        int mid = (l + r) / 2;
        int left = sum(ql, qr, 2 * node, l, mid);
        int right = sum(ql, qr, 2 * node + 1, mid + 1, r);
        return (left + right) % mod;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // length of the array

        // Input array
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        tree = new int[4 * n];
        build(A, 1, 0, n - 1);

        int q = sc.nextInt(); // number of queries
        long ans = 0;

        for (int qq = 0; qq < q; qq++) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            l--; r--; // 0-based indexing

            if (type == 1) {
                // Type 1: update A[i] = (i-l+1)*A[l] for l <= i <= r
                // First, get A[l]
                int base = sum(l, l, 1, 0, n - 1);
                for (int i = l; i <= r; i++) {
                    int val = (int)(((long)(i - l + 1) * base) % mod);
                    update(i, val, 1, 0, n - 1);
                }
            } else if (type == 2) {
                // Type 2: sum query
                ans = (ans + sum(l, r, 1, 0, n - 1)) % mod;
            }
        }
        System.out.println(ans);
    }
}
