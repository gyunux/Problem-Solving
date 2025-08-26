import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> numArr;
    static int targetNum;
    static int length;
    static String[] line1;
    static String[] line2;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numArr = new ArrayList<>();
        line1 = br.readLine().split(" ");
        line2 = br.readLine().split(" ");
        targetNum = Integer.parseInt(line1[0]);
        length = Integer.parseInt(line1[1]);

        for(int i = 0 ; i< length; i++){
            dfs(line2[i]);
        }
        System.out.println(max);
    }
    public static void dfs(String str){
        int temp = Integer.parseInt(str);
        if(temp > targetNum){
            return;
        }
        if(temp > max){
            max = temp;
        }
        numArr.add(temp);
        for(int i = 0;i < length; i++){
            dfs(str + line2[i]);
        }
    }
}