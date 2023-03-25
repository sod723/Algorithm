import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; // 좌, 좌상, 상, 우상, 우, 우하, 하, 좌하
    static Queue<Cloud> clouds = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clouds.offer(new Cloud(N - 1, 0));
        clouds.offer(new Cloud(N - 1, 1));
        clouds.offer(new Cloud(N - 2, 0));
        clouds.offer(new Cloud(N - 2, 1));

        for (int i = 0; i < M; i++) {
            visited = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            moveCloud(d, s);
            waterMagic();
            removeWater();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }

    static void moveCloud(int d, int s) {
        for (Cloud cloud : clouds) {
            cloud.x = (N + cloud.x + dx[d] * (s % N)) % N;
            cloud.y = (N + cloud.y + dy[d] * (s % N)) % N;
            arr[cloud.x][cloud.y]++;
        }
    }

    static void waterMagic() {
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();
            int cnt = 0;
            visited[cloud.x][cloud.y] = true;
            for (int i = 1; i <= 7; i += 2) {
                int nx = cloud.x + dx[i];
                int ny = cloud.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (arr[nx][ny] >= 1) cnt++;
                }
            }
            arr[cloud.x][cloud.y] += cnt;
        }
    }

    static void removeWater() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] >= 2 && !visited[i][j]) {
                    arr[i][j] -= 2;
                    clouds.offer(new Cloud(i, j));
                }
            }
        }
    }

    static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
