import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static Set<Integer> numSet = new HashSet<>();
    static String[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];

        for(int i = 0; i < n ; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0;i < n; i++){
            visited = new boolean[n];
            visited[i] = true;
            dfs(1,arr[i]);
        }
        System.out.println(numSet.size());
    }

    public static void dfs(int count,String str){
        if(count == k){
            int num = Integer.parseInt(str);
            numSet.add(num);
            return;
        }
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(count + 1,str + arr[i]);
                visited[i] = false;
            }
        }
    }
}