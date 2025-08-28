import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int startY;
    static int startX;
    static int targetY;
    static int targetX;
    static int[][] grid;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0;i < repeat; i++){
            N = Integer.parseInt(br.readLine());
            isVisited = new boolean[N][N];
            grid = new int[N][N];

            String[] start = br.readLine().split(" ");
            startY = Integer.parseInt(start[0]);
            startX = Integer.parseInt(start[1]);

            String[] target = br.readLine().split(" ");
            targetY = Integer.parseInt(target[0]);
            targetX = Integer.parseInt(target[1]);

            int result = bfs(startY,startX);
            System.out.println(result);
        }
    }
    public static int bfs(int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int []{y,x});
        isVisited[y][x] = true;

        int[] dy = {-2,-2,2,2,-1,-1,1,1};
        int[] dx = {-1,1,-1,1,-2,2,-2,2};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            if(curY == targetY && curX == targetX){
                break;
            }

            for(int i = 0;i < 8; i++){
                int nY = curY + dy[i];
                int nX = curX + dx[i];
                if(0 <= nY && nY < N && 0 <= nX && nX < N && !isVisited[nY][nX]){
                    queue.add(new int[]{nY,nX});
                    grid[nY][nX] = grid[curY][curX] + 1;
                    isVisited[nY][nX] = true;
                }
            }
        }
        return grid[targetY][targetX];
    }
}