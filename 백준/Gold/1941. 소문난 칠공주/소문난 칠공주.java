import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[5][5];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[] visited = new boolean[25];
    static int[] selected = new int[7];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (str.charAt(j) == 'Y') {
                    arr[i][j] = 0;
                } else arr[i][j] = 1;
            }
        }
        dfs(0, 0, 0);
        System.out.println(ans);
    }

    static void dfs(int depth, int start, int S) {
        if (depth - S > 3) return;
        if (depth == 7) {
            ans += bfs();
            return;
        }
        for (int i = start; i < 25; i++) {
            if (visited[i]) continue;
            selected[depth] = i;
            visited[i] = true;
            if (arr[i / 5][i % 5] == 1) dfs(depth + 1, i + 1, S + 1);
            else dfs(depth + 1, i + 1, S);
            visited[i] = false;
            selected[depth] = -1;

        }
    }

    static int bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        boolean vis[][] = new boolean[5][5];
        int cnt = 1;
        q.offer(selected[0] / 5);
        q.offer(selected[0] % 5);
        vis[selected[0] / 5][selected[0] % 5] = true;
        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = X + dx[i];
                int ny = Y + dy[i];

                if (!isRange(nx, ny)) continue;
                if (vis[nx][ny]) continue;
                if (!visited[nx * 5 + ny]) continue;
                cnt++;
                q.offer(nx);
                q.offer(ny);
                vis[nx][ny] = true;
            }
        }
        if (cnt == 7) return 1;
        else return 0;
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
