
import java.util.*;
import java.io.*;
public class Main {
    static int[][] countArr;
    static int[][] arr;
    static boolean[][] isVisited;
    static int y;
    static int x;
    static int endY;
    static int endX;
    static boolean find;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        endY = y - 1;
        endX = x - 1;

        countArr = new int[y][x];
        arr = new int[y][x];
        isVisited = new boolean[y][x];

        for(int i = 0;i < y; i++){
            String[] str = br.readLine().split("");
            for(int j = 0;j < x;j ++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        countArr[0][0] = 1;
        bfs(0,0);
        System.out.println(countArr[endY][endX]);
       
    }
    public static void bfs(int ty,int tx){
        int[] point = new int[] {ty,tx};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(point);

        int[] dy = new int[]{0,0,-1,1};
        int[] dx = new int[]{-1,1,0,0};
        while(queue.size() > 0){
            int[] temp = queue.poll();
            int curY = temp[0];
            int curX = temp[1];
            if(isVisited[curY][curX] == false){
                isVisited[curY][curX] = true;
                if(curY == endY && curX == endX){
                    return;
                }
                for(int i = 0;i < 4;i ++){
                    int nY = curY + dy[i];
                    int nX = curX + dx[i];
                    if((0 <= nY && nY < y) && (0 <= nX && nX < x) 
                    && ((isVisited[nY][nX]) == false) && (arr[nY][nX] == 1)){
                        int[] nextP = new int[]{nY,nX};
                        countArr[nY][nX] = countArr[curY][curX] + 1;
                        queue.add(nextP); 
                    }
                }
            }
        }
        
    }

}
