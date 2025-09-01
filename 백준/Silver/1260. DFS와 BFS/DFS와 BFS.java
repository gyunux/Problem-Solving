import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] isVisitedDfs;
    private static boolean[] isVisitedBfs;
    private static Map<Integer,List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int length = Integer.parseInt(line[0]);
        int pair = Integer.parseInt(line[1]);
        int start = Integer.parseInt(line[2]);

        isVisitedDfs = new boolean[length+1];
        isVisitedBfs = new boolean[length+1];
        graph = new HashMap<>();
        for(int i = 1; i <= length; i++){
            List<Integer> list = new ArrayList<>();
            graph.put(i,list);
        }

        for(int i = 1;i <= pair; i++){
            String[] pairStr = br.readLine().split(" ");
            int l = Integer.parseInt(pairStr[0]);
            int r = Integer.parseInt(pairStr[1]);
            graph.get(l).add(r);
            graph.get(r).add(l);
        }

        for(int i = 1;i <= length; i++){
            List<Integer> list = graph.get(i);
            Collections.sort(list);
        }
        dfs(start);

        System.out.println();

        bfs(start);
    }

    public static void dfs(int n){
        if(isVisitedDfs[n]){
            return;
        }
        isVisitedDfs[n] = true;
        System.out.print(n + " ");

        for(int num : graph.get(n)){
            if(!isVisitedDfs[num]){
                dfs(num);
            }
        }
    }

    public static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        isVisitedBfs[n] = true;
        System.out.print(n + " ");

        while(!queue.isEmpty()){
            int curN = queue.poll();

            for(int num : graph.get(curN)){
                if(!isVisitedBfs[num]){
                    isVisitedBfs[num] = true;
                    queue.add(num);
                    System.out.print(num + " ");
                }
            }
        }
    }
}