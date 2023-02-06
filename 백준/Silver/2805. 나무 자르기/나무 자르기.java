import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] tree = new int[n];

        int start = 0;
        int end = 0;

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<tree.length; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
        }

        Arrays.sort(tree);

        int result = 0;

        while (start <= end) {

            long total = 0;
            int mid = (start+end)/2;

            for (int i=0; i<n; i++) {
                if (tree[i] > mid) {
                    total += tree[i] - mid;
                }
            }

            if (total < m) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);

    }
}
