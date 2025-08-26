
import java.util.*;
import java.io.*;

public class Main {
    static int xLen;
    static int yLen;
    static boolean[][] isVisited;
    static int[][] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0;i < tc; i++){
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            xLen = Integer.parseInt(st.nextToken());
            yLen = Integer.parseInt(st.nextToken());
            int bCnt = Integer.parseInt(st.nextToken());
            
            arr = new int[yLen][xLen];
            isVisited = new boolean[yLen][xLen];

            for(int j = 0;j < bCnt;j++){
                StringTokenizer temp = new StringTokenizer(br.readLine());
                int tempX = Integer.parseInt(temp.nextToken());
                int tempY = Integer.parseInt(temp.nextToken());
                arr[tempY][tempX] = 1;
            }
            
            for(int j = 0;j < yLen; j++){
                for(int k = 0;k < xLen; k++){
                    if(arr[j][k] == 1 && !isVisited[j][k]){
                        bfs(j,k);
                        count += 1;
                    }
                }
            }

            System.out.println(count);


        }
    }
    public static void bfs(int y,int x){
        int[] temp = new int[] {y,x};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(temp);

        int[] dy = new int[]{0,0,1,-1};
        int[] dx = new int[]{1,-1,0,0};

        while(queue.size() > 0){
            int[] qPoll = queue.poll();
            int curY = qPoll[0];
            int curX = qPoll[1];
            if(!isVisited[curY][curX]){

                isVisited[curY][curX] = true;
                for(int i = 0;i < 4;i++){
                    int nY = curY + dy[i];
                    int nX = curX + dx[i];
                    if((0 <= nY && nY < yLen) && (0 <= nX && nX < xLen) && arr[nY][nX] == 1 && !isVisited[nY][nX]){
                        int[] nextLocation = new int[]{nY,nX};
                        queue.offer(nextLocation);
                }
            }
        }
        }
    }
}
