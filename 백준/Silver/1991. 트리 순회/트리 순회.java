import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int child[][] = new int[27][3];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char node,left,right;
        for(int i=1;i<=n;i++)
        {
            String tmp = br.readLine();
            node = tmp.charAt(0);
            left = tmp.charAt(2);
            right = tmp.charAt(4);
            if(left!='.')
                child[node-'A'+1][0]=left-'A'+1;
            if(right!='.')
                child[node-'A'+1][1]=right-'A'+1;
        }
        preorder(1);
        System.out.println();
        inorder(1);
        System.out.println();
        postorder(1);
    }

    static void preorder(int node){
        if(node == 0) return;
        System.out.print((char)('A'+node-1));
        preorder(child[node][0]);
        preorder(child[node][1]);
    }

    static void inorder(int node){
        if(node == 0) return;
        inorder(child[node][0]);
        System.out.print((char)('A'+node-1));
        inorder(child[node][1]);
    }

    static void postorder(int node){
        if(node == 0) return;
        postorder(child[node][0]);
        postorder(child[node][1]);
        System.out.print((char)('A'+node-1));
    }
}
