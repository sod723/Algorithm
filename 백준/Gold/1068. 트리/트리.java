import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int ans, deleteNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a != -1) {
                tree[i].add(a);
                tree[a].add(i);
            }else
                root = i;
        }
        ans = 0;
        deleteNode = Integer.parseInt(br.readLine());
        if(deleteNode==root){
            System.out.println(0);
        }else{
            dfs(root);
            System.out.println(ans);
        }

    }
    static void dfs(int num){
        visited[num] = true;
        int c = 0;
        for(int i:tree[num]){
            if(!visited[i] && i!=deleteNode){
                c++;
                dfs(i);
            }
        }
        if(c == 0){
            ans++;
        }
    }
}
