import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main {
    static int[] a = new int [4001],  b = new int [4001], c = new int [4001], d = new int [4001];
    static int[] ab = new int [16000002],  cd = new int [16000002];
    static int abc, cdc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            a[i] = Integer.parseInt(line[0]);
            b[i] = Integer.parseInt(line[1]);
            c[i] = Integer.parseInt(line[2]);
            d[i] = Integer.parseInt(line[3]);
        }

        int i,j;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                ab[++abc] = a[i]+b[j];
                cd[++cdc] = c[i]+d[j];
            }
        }

        Arrays.sort(ab,1,abc+1);
        Arrays.sort(cd,1,cdc+1);

        i = 1;
        j = cdc;
        ab[abc + 1] = Integer.MAX_VALUE;
        cd[0] = Integer.MIN_VALUE;

        long ans = 0;

        while(i<=abc&&j>0)
        {
            if(ab[i]+cd[j]==0)
            {
                long c1=1,c2=1;
                while(ab[i]==ab[i+1])
                {
                    i++;
                    c1++;
                }
                while(cd[j]==cd[j-1])
                {
                    j--;
                    c2++;
                }
                ans += c1*c2;
                i++;
                j--;
            }
            else if(ab[i]+cd[j]>0)j--;
            else i++;
        }
        System.out.println(ans);
    }
}
