
import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int H;
    static int[][][] arr;
    static boolean[][][] isVisited;
    static int count = 0;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        isVisited = new boolean[H][N][M];

        for(int i = 0;i < H; i++){
            for(int j = 0;j < N; j++){
                StringTokenizer nums = new StringTokenizer(br.readLine());
                for(int k = 0;k < M; k++){
                    arr[i][j][k] = Integer.parseInt(nums.nextToken());
                    if(arr[i][j][k] == 1){
                        queue.add(new int[]{i,j,k});
                    }
                }
            }
        }
        bfs();
        int count = 0;
        for(int i = 0;i < H; i++){
            for(int j = 0;j < N; j++){
                for(int k = 0;k < M ; k++){
                    if(arr[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    count = Math.max(count,arr[i][j][k]);
                }
            }
        }
        System.out.println(count - 1);

    }
    public static void bfs(){
        int[] dz = {0,0,0,0,-1,1};
        int[] dy = {0,0,-1,1,0,0};
        int[] dx = {-1,1,0,0,0,0};

        while(queue.size() > 0){
            int[] temp = queue.poll();
            int curZ = temp[0];
            int curY = temp[1];
            int curX = temp[2];
            
            for(int i = 0;i < 6; i++){
                int nZ = curZ + dz[i];
                int nY = curY + dy[i];
                int nX = curX + dx[i];
                if((0 <= nZ && nZ < H) && (0 <= nY && nY < N) && (0 <= nX && nX < M)){
                    if(arr[nZ][nY][nX] == 0){
                    arr[nZ][nY][nX] = arr[curZ][curY][curX] + 1;
                    queue.add(new int[]{nZ,nY,nX});
                    }
                }
                }
            }

        }
    }
