import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int V, E;
    static ArrayList<Integer>[] Map;
    static int[] searchOrder;
    static boolean[] isCutVertax;
    static int order, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        searchOrder = new int[V + 1];
        isCutVertax = new boolean[V + 1];
        Map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            Map[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Map[a].add(b);
            Map[b].add(a);
        }

        order = 0;
        for (int i = 1; i <= V; i++) {
            if (searchOrder[i] == 0) {
                dfs(i,true);
            }
        }
        ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (isCutVertax[i]) {
                ans++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(ans);
        System.out.println(sb);
    }

    static int dfs(int now, boolean isRoot) {
        order++;
        searchOrder[now] = order;
        int rtn = order;
        int child = 0;

        for (int next : Map[now]) {
            if (searchOrder[next] == 0) {
                child++;
                int low = dfs(next, false);
                if (!isRoot && low >= searchOrder[now]) isCutVertax[now] = true;
                rtn = Math.min(rtn, low);
            }
            else rtn = Math.min(rtn, searchOrder[next]);
        }
        if(isRoot&&child>=2) isCutVertax[now] = true;
        return rtn;
    }
}
