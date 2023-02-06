import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static double[][] dp = new double[101][101];
    static StringBuilder res=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        double num = combination(N, M);
        if(num<K) System.out.println(-1);
        else{
            getResult(N,M,K);
            System.out.println(res.toString());
        }
        //N+M자리에서 조합 후 K번째 자리 뽑기
    }

    static double combination(int n, int r){
        if(dp[n][r]>0) return dp[n][r];
        else if (n==0 || r==0) return dp[n][r] = 1;
        else return dp[n][r] = combination(n-1,r)+combination(n,r-1);
    }

    static void getResult(int n,int r,double k){
        if(n==0){
            for(int i=0;i<r;i++)
                res.append("z");
            return;
        }
        if(r==0){
            for(int i=0;i<n;i++)
                res.append("a");
            return;
        }

        double check = combination(n - 1, r);

        if(k>check){
            res.append("z");
            getResult(n,r-1,k-check);
        }
        else{
            res.append("a");
            getResult(n-1,r,k);
        }

    }
}
