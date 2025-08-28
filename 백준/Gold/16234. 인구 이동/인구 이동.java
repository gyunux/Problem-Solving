import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static boolean[][] isVisited;
    static boolean moved;
    static int day = 0;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            isVisited = new boolean[N][N];
            moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if (!moved) break;
            day++;
        }

        System.out.println(day);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> union = new LinkedList<>();

        queue.add(new int[]{y, x});
        union.add(new int[]{y, x});
        isVisited[y][x] = true;

        int sum = arr[y][x];
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !isVisited[ny][nx]) {
                    int diff = Math.abs(arr[ny][nx] - arr[cy][cx]);
                    if (L <= diff && diff <= R) {
                        queue.add(new int[]{ny, nx});
                        union.add(new int[]{ny, nx});
                        isVisited[ny][nx] = true;
                        sum += arr[ny][nx];
                        count++;
                    }
                }
            }
        }

        if (count > 1) {
            moved = true;
            int avg = sum / count;
            for (int[] pos : union) {
                arr[pos[0]][pos[1]] = avg;
            }
        }
    }
}
