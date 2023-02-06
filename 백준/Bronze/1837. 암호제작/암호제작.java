import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] primes = new boolean[k + 1];
        primes[1] = true;

        for (int i = 2; i < k; i++) {
            if (primes[i]) continue;
            BigInteger now = new BigInteger(Integer.toString(i));
            if (p.mod(now).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("BAD " + now);
                return;
            }
            for (int j = i + i; j <= i; j += i) primes[j] = true;
        }
        System.out.print("GOOD");
    }
}