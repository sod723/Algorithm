import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        int ans = dp[0];
        for(int i = 1; i < N; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
}
