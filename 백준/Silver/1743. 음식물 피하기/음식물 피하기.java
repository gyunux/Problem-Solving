import java.io.*;
import java.util.*;

public class Main {
    static int height;
    static int width;
    static boolean[][] isVisited;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        height = Integer.parseInt(line[0]);
        width = Integer.parseInt(line[1]);

        isVisited = new boolean[height][width];
        grid = new int[height][width];
        int repeat = Integer.parseInt(line[2]);

        for (int i = 0; i < repeat; i++) {
            String[] trash = br.readLine().split(" ");
            int h = Integer.parseInt(trash[0]);
            int w = Integer.parseInt(trash[1]);
            grid[h - 1][w - 1] = 1;
        }

        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!isVisited[i][j] && grid[i][j] == 1) {
                    int tmp = bfs(i, j);
                    if (tmp > result) {
                        result = tmp;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static int bfs(int h,int w){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{h,w});

        int[] dh = {0,0,-1,1};
        int[] dw = {-1,1,0,0};

        int count = 0;

        while(!queue.isEmpty()){
            int[] curPos = queue.poll();
            int curH = curPos[0];
            int curW = curPos[1];

            if(!isVisited[curH][curW]){
                isVisited[curH][curW] = true;

                count++;
                for(int i = 0;i < 4; i++){
                    int nH = curH + dh[i];
                    int nW = curW + dw[i];
                    if(0 <= nH && nH < height && 0 <= nW && nW < width
                    && !isVisited[nH][nW] && grid[nH][nW] == 1){
                        queue.add(new int[]{nH,nW});

                    }
                }
            }
        }
        return count;
    }
}