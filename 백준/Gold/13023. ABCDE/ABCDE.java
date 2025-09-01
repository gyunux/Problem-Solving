import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer,List<Integer>> graph = new HashMap<>();
    static boolean[] isVisited;
    static boolean found = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int people = Integer.parseInt(line[0]);
        int vertex = Integer.parseInt(line[1]);

        isVisited = new boolean[people];

        for(int i = 0;i < people; i++){
            List<Integer> list = new ArrayList<>();
            graph.put(i,list);
        }

        for(int i = 0;i < vertex; i++){
            String[] pair = br.readLine().split(" ");
            int l = Integer.parseInt(pair[0]);
            int r = Integer.parseInt(pair[1]);
            graph.get(l).add(r);
            graph.get(r).add(l);
        }

        for (int i = 0; i < people; i++) {
            dfs(i, 1);
            if (found) {
                break;
            }
        }

        if(!found){
            System.out.println(0);
        }
    }
    public static void dfs(int n,int depth){
        if(depth == 5){
            System.out.println(1);
            found = true;
            return;
        }

        isVisited[n] = true;
        for(int num : graph.get(n)){
            if(!isVisited[num]){
                dfs(num,depth + 1);
                if(found) return;
            }
        }
        isVisited[n] = false;
    }
}