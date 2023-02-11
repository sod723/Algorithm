import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 9 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; st.hasMoreTokens();j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
    }
    static void dfs(int row, int col){
        if(col == 9){
            dfs(row+1,0);
            return;
        }

        if(row == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(arr[row][col] == 0){
            for(int i =1; i<=9; i++){
                if(check(row, col, i)){
                    arr[row][col] = i;
                    dfs(row, col+1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        dfs(row, col+1);
    }
    static boolean check(int row, int col, int value){
        for(int i = 0; i<9; i++){
            if(arr[row][i] == value) return false;
        }
        for(int i = 0; i<9; i++){
            if(arr[i][col] == value) return false;
        }
        int idxrow = (row/3)*3;
        int idxcol = (col/3)*3;

        for(int i = idxrow ; i < idxrow+3 ; i ++) {
            for(int j = idxcol ; j < idxcol +3 ; j++) {
                if(arr[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}
