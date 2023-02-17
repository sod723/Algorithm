import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, leaf = 1;
    static long[] treeMin, treeMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while (leaf < N) {
            leaf *= 2;
        }
        treeMin = new long[leaf * 2];
        treeMax = new long[leaf * 2];
        for (int i = 0; i < leaf * 2; i++) {
            treeMin[i] = Integer.MAX_VALUE;
            treeMax[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(br.readLine());
            treeMin[leaf + i] = a;
            treeMax[leaf + i] = a;
        }

        int idx = leaf * 2 - 1;
        while (idx != 1) {
            if (treeMin[idx] < treeMin[idx / 2]) {
                treeMin[idx / 2] = treeMin[idx];
            }
            if (treeMax[idx] > treeMax[idx / 2]) {
                treeMax[idx / 2] = treeMax[idx];
            }
            idx--;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            findMin(a, b);
            findMax(a, b);
        }
    }

    static void findMin(int a, int b) {
        long min = Long.MAX_VALUE;
        int start = leaf + a - 1;
        int end = leaf + b - 1;
        while (start < end) {
            if (start % 2 == 1) min = Math.min(min, treeMin[start]);
            if (end % 2 == 0) min = Math.min(min, treeMin[end]);
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        if (start == end) min = Math.min(min, treeMin[start]);
        System.out.print(min + " ");
    }

    static void findMax(int a, int b) {
        long max = Long.MIN_VALUE;
        int start = leaf + a - 1;
        int end = leaf + b - 1;
        while (start < end) {
            if (start % 2 == 1) max = Math.max(max, treeMax[start]);
            if (end % 2 == 0) max = Math.max(max, treeMax[end]);
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        if (start == end) max = Math.max(max, treeMax[start]);
        System.out.println(max);
    }
}
