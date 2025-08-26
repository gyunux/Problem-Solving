
import java.util.*;
import java.io.*;


public class Main {
    //정적 변수 선언
    static int result = 0;
    static int[][] arr;
    static boolean[] isVisited;
    static int netCnt;
    static int a;
    static int b;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //컴퓨터 갯수
        netCnt = Integer.parseInt(br.readLine());

        //쌍 갯수
        int netCoupleCnt = Integer.parseInt(br.readLine());

        //정적 변수 초기화
        arr = new int[netCnt+1][netCnt+1];
        isVisited = new boolean[netCnt+1];
       

        for(int i = 0;i < netCoupleCnt;i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(result - 1);
        
    }
    
    public static void dfs(int n){
        isVisited[n] = true;
        result++;
        for(int i = 0;i <= netCnt;i++ ){
            if(arr[n][i] == 1 && !isVisited[i]){
                dfs(i);
            }
        }
    }
}
