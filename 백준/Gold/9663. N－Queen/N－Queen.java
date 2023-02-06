import java.io.*;
class Main{
    static boolean[][] visit;
    public static int[][] arr;
    public static int N;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        arr = new int[N][N];
        dfs(0);
        System.out.println(count);
    }
    public static void dfs(int n){
        if(n == N){
            count++;
            return;
        }
        for (int j = 0; j < N; j++){
            if(!visit[n][j]){
                visit[n][j] = true;
                arr[n][j] = 1;
                checkQueen(n, j);
                dfs(n+1);
                arr[n][j] = 0;	
                init_visit();
                for (int i = 0; i < N; i++) {
                    for (int p = 0; p < N; p++) {
                        if (arr[i][p] == 1)
                            checkQueen(i, p);
                    }
                }
            }
        }
    }

    private static void init_visit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = false;
            }
        }
    }

    public static void checkQueen(int a, int b){
        for (int i = a; i < N; i++) {
            visit[i][b] = true;
        }
        //왼쪽 대각선
        int c = a;
        int d = b;
        while (0 <= d && d < N & 0 <= c & c < N) {
            visit[c++][d--] = true;
        }
        //오른쪽
        while ((0 <= a && a < N & (0 <= b && b < N))) {
            visit[a++][b++] = true;
        }
    }
}