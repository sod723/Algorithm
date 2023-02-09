import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, leaf;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        leaf = 1;
        while (leaf < 1000000) leaf *= 2;
        tree = new long[leaf * 2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int candy = find(b);
                System.out.println(candy);
                updateTree(candy+leaf-1, -1);

            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                updateTree(b+leaf-1, c);
            }
        }
    }

    static void updateTree(int node, int cnt) {
        if (node == 0) return;
        tree[node] += cnt;
        updateTree(node / 2, cnt);
    }

    static int find(int a) {
        int x = 1;
        while (x < leaf) {
            if (tree[x * 2] >= a) {
                x = x * 2;
            } else {
                a -= tree[x * 2];
                x = x * 2 + 1;
            }
        }
        return x - leaf + 1;
    }
}
