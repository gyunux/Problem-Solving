import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            if(line.equals("0")){
                break;
            }
            String[] strArr = line.split(" ");
            int length = Integer.parseInt(strArr[0]);
            isVisited = new boolean[length + 1];
            for(int i = 1;i <= length; i++){
                if(!isVisited[i]){
                    dfs(0,i,strArr[i],length,strArr);
                }
            }
            System.out.println();
        }
    }

    public static void dfs(int count,int idx,String str,int length,String[] arr){
        if(count == 5){
            System.out.println(str);
            return;
        }
        count++;
        isVisited[idx] = true;
        for(int i = idx+1; i <= length; i++ ){
            dfs(count,i,str + " " + arr[i],length,arr);
            isVisited[idx] = false;
        }
    }
}