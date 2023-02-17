import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, leaf = 1;
    static long[] tree;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        while (leaf < N) {
            leaf *= 2;
        }
        tree = new long[leaf * 2 + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            tree[leaf + i] = Integer.parseInt(br.readLine());
        }
        int idx = leaf * 2 - 1;
        while (idx != 1) {
            tree[idx / 2] = tree[idx / 2] * tree[idx] % MOD;
            idx--;
        }
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) updateTree(b, c);
            else printMul(b, c);
        }
    }

    static void updateTree(int b, int c) {
        int idx = leaf + b - 1;
        tree[idx] = c;
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx*2]%MOD * tree[idx*2+1]%MOD;
        }
    }

    static void printMul(int b, int c) {
        long ans = 1;
        int start = leaf + b - 1;
        int end = leaf + c - 1;
        while (start < end) {
            if (start % 2 == 1) ans = ans * tree[start] % MOD;
            if (end % 2 == 0) ans = ans * tree[end] % MOD;
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        if (start == end) ans = ans * tree[start] % MOD;
        ans = (ans % MOD);
        System.out.println(ans);
    }
}
