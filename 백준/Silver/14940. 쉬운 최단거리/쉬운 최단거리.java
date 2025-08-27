
import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] isVisited;
    static int endN;
    static int endM;
    static int[][] result;
    static int n;
    static int m;
    static int startN;
    static int startM;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        isVisited = new boolean[n][m];
        result = new int[n][m];
        for(int i = 0;i < n; i ++){
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for(int j = 0;j < m; j ++){
                arr[i][j] = Integer.parseInt(nums.nextToken());
                if(arr[i][j] == 2){
                    startN = i;
                    startM = j;
                }
            }
        }
        bfs(startN,startM);
        
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < m ; j++){
                if (arr[i][j] == 1 && !isVisited[i][j]) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            System.out.println(sb.toString());
        }
        
    }
    public static void bfs(int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        int[] dy = new int[]{0,0,-1,1};
        int[] dx = new int[]{-1,1,0,0};
        while(queue.size() > 0){
            int[] temp = queue.poll();
            int curY = temp[0];
            int curX = temp[1];

            if(!isVisited[curY][curX]){
                isVisited[curY][curX] = true;
                for(int i = 0;i < 4; i++){
                    int nY = curY + dy[i];
                    int nX = curX + dx[i];
                    if((0 <= nY && nY < n) && (0 <= nX && nX < m) &&
                    !isVisited[nY][nX] && arr[nY][nX] == 1){
                        result[nY][nX] = result[curY][curX] + 1;
                        queue.add(new int[]{nY,nX});
                    }
                }
            }

        }
    }
}
