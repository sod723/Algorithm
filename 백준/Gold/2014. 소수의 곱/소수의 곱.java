import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int K,N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<K; i++){
            arr[i] = Long.parseLong(st.nextToken());
            pq.offer(arr[i]);
        }

        for(int i =0; i<N-1; i++){
            long n = pq.poll();
            for(int j = 0; j<K; j++){
                long tmp = n*arr[j];
                if(tmp >= 2147483647) {
                    break;
                }
                pq.offer(tmp);
                if(n%arr[j]==0) {
                    break;
                }
            }
        }
        System.out.println(pq.poll());
    }
}
