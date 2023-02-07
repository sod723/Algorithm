import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        q.add(new Edge(K, 0));
        distance[K] = 0;
        while (!q.isEmpty()) {
            Edge node = q.poll();
            int now = node.vertex;
            if (visited[now]) continue;
            visited[now] = true;
            for (int i = 0; i < list[now].size(); i++) {
                Edge tmp = list[now].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if (distance[next] > distance[now] + value) {
                    distance[next] = value + distance[now];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex, value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}

