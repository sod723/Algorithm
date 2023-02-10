import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] tree;
    static int[] A;
    static HashMap<Integer,Integer> B;
    static int leaf;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        B = new HashMap<>();
        leaf = 1;
        while (leaf < N){
            leaf *=2;
        }
        tree = new long[leaf*2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            B.put(Integer.parseInt(st.nextToken()), i);
        }
        int idx;
        for(int i = 1; i<= N; i++){
            idx = B.get(A[i]);
            ans += getSum(idx+1, N);
            updateTree(idx, 1);
        }
        System.out.println(ans);
    }
    private static void updateTree(int index, int value) {
        index = index + (leaf-1);
        tree[index] += value;
        while (index > 1) {
            index = index / 2;
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }
    }

    private static long getSum(int left, int right) {
        long sum = 0;
        left += (leaf-1); 
        right += (leaf-1); 

        while (left <= right) {
            if (left % 2 == 1) { 
                sum += tree[left]; 
                left++;
            }
            if (right % 2 == 0) { 
                sum += tree[right];
                right--;
            }
            left >>= 1;   
            right >>= 1;  
        }
        return sum;
    }
}
