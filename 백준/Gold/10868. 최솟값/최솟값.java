import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, leaf = 1;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while (leaf < N) {
            leaf *= 2;
        }
        tree = new long[leaf * 2];
        for (int i = 0; i < leaf * 2; i++) {
            tree[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            tree[leaf + i] = Long.parseLong(br.readLine());
        }

        int idx = leaf * 2 - 1;
        while (idx != 1) {
            if (tree[idx] < tree[idx / 2]) {
                tree[idx / 2] = tree[idx];
            }
            idx--;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            findMin(a, b);
        }
    }

    static void findMin(int a, int b) {
        long min = Long.MAX_VALUE;
        int start = leaf + a - 1;
        int end = leaf + b - 1;
        while (start < end) {
            if (start % 2 == 1) min = Math.min(min, tree[start]);
            if (end % 2 == 0) min = Math.min(min, tree[end]);
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        if (start == end) min = Math.min(min, tree[start]);
        System.out.println(min);
    }
}
