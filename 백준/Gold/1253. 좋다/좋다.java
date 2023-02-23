import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int check = arr[i];
            int a = 0;
            int b = N - 1;
            while (a < b) {
                if (arr[a] + arr[b] == check) {
                    if (a != i && b != i) {
                        ans++;
                        break;
                    } else if (a == i) {
                        a++;
                    } else if (b == i) {
                        b--;
                    }
                } else if (arr[a] + arr[b] < check) {
                    a++;
                } else {
                    b--;
                }
            }
        }
        System.out.println(ans);
    }
}
