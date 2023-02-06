import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int L, C;
    public static char[] input;
    public static char[] pwd;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new char[C];
        pwd = new char[L];
        for(int i =0; i < C; i++){
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);
        combination(0,0);

    }

    public static void combination(int cnt, int start) {
        if(cnt == L){
            if(check(pwd)){
                for(char c:pwd) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }
        for(int i = start; i<C; i++){
            pwd[cnt] = input[i];
            combination(cnt+1,i+1);
        }
    }

    public static boolean check(char[] pwd){
        int j = 0;
        int m = 0;
        for (int i = 0; i< pwd.length; i++){
            if( pwd[i] =='a' ||pwd[i] =='e'||pwd[i] =='i'||pwd[i] =='o'||pwd[i] =='u') m++;
            else j++;
        }
        if(j >=2 && m>=1) return true;
        else return false;
    }
}
