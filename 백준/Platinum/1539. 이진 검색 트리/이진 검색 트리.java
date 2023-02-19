import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    static int N;
    static int[] len;
    static long ans = 0;
    static TreeSet<Integer> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        len = new int[N];
        tree = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (tree.higher(num) == null) {
                if (tree.lower(num) == null) {
                    len[num] = 1;
                } else {
                    len[num] = len[tree.lower(num)]+1;
                }
            } else {
                if (tree.lower(num) == null) {
                    len[num] = len[tree.higher(num)] + 1;
                } else {
                    len[num] = Math.max(len[tree.higher(num)], len[tree.lower(num)]) + 1;
                }
            }
            ans += len[num];
            tree.add(num);
        }
        System.out.println(ans);
    }
}
