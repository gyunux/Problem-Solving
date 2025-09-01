import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> total = new ArrayList<>();
        grid = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i = 0;i < N; i++){
            String[] line = br.readLine().split("");
            for(int j = 0;j < N; j++){
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0;i < N; i++){
            for(int j = 0;j < N; j++){
                if(!isVisited[i][j] && grid[i][j] == 1){
                    int result = bfs(i,j,grid.length);
                    total.add(result);
                }
            }
        }
        Collections.sort(total);
        System.out.println(total.size());
        for(int num : total){
            System.out.println(num);
        }

    }

    public static int bfs(int h,int w,int length){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{h,w});
        int count = 0;
        int[] dy = {0,0,-1,1};
        int[] dx = {-1,1,0,0};

        while(!queue.isEmpty()){
            int[] curPos = queue.poll();
            int curY = curPos[0];
            int curX = curPos[1];

            if(!isVisited[curY][curX]){
                isVisited[curY][curX] = true;
                count ++;
                for(int i = 0;i < 4; i++){
                    int nY = curY + dy[i];
                    int nX = curX + dx[i];
                    if(0 <= nY && nY < length && 0 <= nX && nX < length
                    && !isVisited[nY][nX] && grid[nY][nX] == 1){
                        queue.add(new int[]{nY,nX});
                    }
                }
            }
        }
        return count;
    }
}