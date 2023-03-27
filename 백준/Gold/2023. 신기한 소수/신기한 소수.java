import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }
    static void dfs(int num, int jari){
        if(jari == N) {
            if(isPrime(num))System.out.println(num);
            return;
        }
        for(int i = 1; i<10; i++ ){
            int next = num*10 + i;
            if(isPrime(next)) dfs(next, jari+1);
        }
    }

    static boolean isPrime(int num){
        for(int i = 2; i<= num/2; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}