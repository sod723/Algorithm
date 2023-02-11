import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int arr[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
           arr[i] = i;
        }
        recursion(0);
    }

    static void recursion(int n){
        if(n == M){
            for(int i =1; i<= n; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <=N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[n+1] = i;
                recursion(n+1);
                visited[i] = false;
            }
        }
    }
}
