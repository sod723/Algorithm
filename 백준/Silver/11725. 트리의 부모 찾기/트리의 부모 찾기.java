import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        ans = new int[N + 1];
        for(int i = 0; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        for(int i = 2; i<=N; i++){
            System.out.println(ans[i]);
        }
    }
    static void dfs(int num){
        visited[num] = true;
        for(int i : tree[num]){
            if(!visited[i]){
                ans[i] = num;
                dfs(i);
            }
        }
    }
}
