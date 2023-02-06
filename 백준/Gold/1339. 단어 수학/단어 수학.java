import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for (int j =0; j< str.length(); j++){
                char ch = str.charAt(j);
                arr[ch - 'A'] += (int)Math.pow(10, str.length() -1 -j);
            }
        }
        Arrays.sort(arr);

        int num = 9;
        int ans = 0;
        int check = 25;

        while(arr[check] != 0){
            ans += arr[check]*num;
            check --; num --;
        }
        System.out.print(ans);
    }

}