import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[][] parent;
    static boolean[] visited;
    static int LogN = 17;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[LogN+1][N+1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        bfs(1);
        sparseTable();
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(getLCA(a,b));
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        int level = 1;
        int size = 1;
        int cnt = 0;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int next:tree[now]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    parent[0][next] = now;
                    depth[next] = level;
                }
            }
            cnt++;
            if(cnt == size){
                cnt = 0;
                size = queue.size();
                level++;
            }
        }
    }

    static void sparseTable(){
        for(int i = 1; i <= LogN; i++){
            for(int j = 1; j <= N; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
    }

    static int getLCA(int a, int b){
        if(depth[a] < depth[b]) return getLCA(b,a);
        for(int i = 0; i<= LogN; i++){
            if(((depth[a] - depth[b]) & (1 << i)) >= 1) a = parent[i][a];
        }
        if(a == b) return a;
        for(int i = LogN; i >=0; i--){
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
}
