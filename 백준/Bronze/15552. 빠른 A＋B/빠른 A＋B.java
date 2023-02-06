import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = 0;
        int a = 0, b = 0;
        
        t = Integer.parseInt(bfr.readLine());
        
        for(int i=0; i<t; i++){
            st = new StringTokenizer(bfr.readLine());
            bfw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
        }
        bfw.flush();
    }
}