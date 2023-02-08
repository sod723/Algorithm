import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        bfs(X);
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                ans.add(i);
            }
        }
        if (ans.isEmpty()) System.out.println("-1");
        else {
            ans.sort(Comparator.naturalOrder());
            for (int i : ans) System.out.println(i);
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v]++;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : graph[now]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    q.add(i);
                }
            }
        }
    }
}
