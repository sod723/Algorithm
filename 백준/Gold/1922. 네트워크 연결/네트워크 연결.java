import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, cnt=0;
    static int[] parent;
    static PriorityQueue<pEdge> queue = new PriorityQueue<>();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new pEdge(a,b,c));
        }
        int useEdge = 0;
        while(useEdge < N-1){
            pEdge now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                cnt += now.v;
                useEdge++;
            }
        }
        System.out.println(cnt);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) parent[b] = a;
    }

    static int find(int a){
        if(a==parent[a])return a;
        else return parent[a] = find(parent[a]);
    }

    static class pEdge implements Comparable<pEdge>{
        int s,e,v;
        pEdge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }
        @Override
        public int compareTo(pEdge o) {
            return this.v - o.v;
        }
    }
}
