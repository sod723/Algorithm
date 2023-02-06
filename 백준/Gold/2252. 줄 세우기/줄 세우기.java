import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A.get(a).add(b);
            indegree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()){
            int now = q.poll();
            System.out.print(now+" ");
            for(int x:A.get(now)){
                indegree[x]--;
                if(indegree[x] == 0){
                    q.offer(x);
                }
            }
        }
    }
}
