import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer,Integer> parentMap;
    static Map<Integer,List<Integer>> tree;
    static boolean[] isVisited;
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        parentMap = new HashMap<>();
        tree = new HashMap<>();
        isVisited = new boolean[nodeCount + 1];
        for(int i = 1; i <= nodeCount; i++ ){
            List<Integer> tempList = new ArrayList<>();
            tree.put(i,tempList);
        }

        for(int i = 0;i < nodeCount - 1; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);

        }
        dfs(1);

        for(int i = 2; i <= nodeCount; i++){
            System.out.println(parentMap.get(i));
        }
    }

    public static void dfs(int n){
         isVisited[n] = true;

         for(int num : tree.get(n)){
             if(!isVisited[num]){
                 parentMap.put(num,n);
                 dfs(num);
             }
         }


    }
}