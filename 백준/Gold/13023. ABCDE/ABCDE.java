import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean arrive;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        arrive = false;
        for(int i = 0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        for(int i = 1; i<=N; i++){
            dfs(i, 1);
            if(arrive) break;
        }
        if(arrive) System.out.println("1");
        else System.out.println("0");
    }

    private static void dfs(int v, int depth) {
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[v] = true;
        for(int i : graph[v]){
            if(!visited[i]) dfs(i, depth+1);
        }
        visited[v] = false;
    }
}
