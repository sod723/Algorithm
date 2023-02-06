import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k,leafCnt;
    static long[] indexedTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        leafCnt = 1;
        while (leafCnt < n) {
            leafCnt *= 2;
        }

        indexedTree = new long[leafCnt*2];
        leafCnt = leafCnt - 1;

        for (int i = 1; i<= n; i++){
            indexedTree[leafCnt + i] = Long.parseLong(br.readLine());
        }

        initTree(leafCnt+1, n);

        for (int i = 0; i< (m+k); i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1){
                updateTree(leafCnt+b, c);
            }
            else{
                long sum = query(leafCnt + b, (int) (leafCnt + c));
                System.out.println(sum);
            }
        }
    }
    static void initTree(int start, int end){
        for (int i = start; i < start + end; i++){
            int idx = i/2;
            while(idx!=0){
                indexedTree[idx] += indexedTree[i];
                idx /= 2;
            }
        }
    }

    static void updateTree(int idx, long val){
        val -= indexedTree[idx];
        while (idx != 0) {
            indexedTree[idx] += val;
            idx /= 2;}
    }

    public static long query(int start, int end) {
        long result = 0;
        while (start < end) {
            if(start % 2 == 1) result += indexedTree[start];
            if(end % 2 == 0) result += indexedTree[end];
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        if(start == end) result += indexedTree[start];
        return result;
    }
}
