import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> mnq = new PriorityQueue<>();
        for(int i =0;i<n;i++){
            int input = Integer.parseInt(br.readLine());
            if(input > 0){
                mnq.add(input);

            }else {
                if(!mnq.isEmpty()){
                    System.out.println(mnq.poll());
                }else System.out.println(0);
            }
        }
    }
}
