import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int boonja = A*D + B*C;
        int boonmo = B * D ;

        int mod = gcd(boonja,boonmo);
        boonja /=mod;
        boonmo /=mod;
        System.out.print(boonja + " " +boonmo);
    }

    private static int gcd(int a, int b) {
        if(a<=b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}