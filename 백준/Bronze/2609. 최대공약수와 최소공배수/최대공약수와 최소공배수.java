import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int result = func(a,b);
        int result2 = (a/result) * (b/result) * result;
        System.out.println(result);
        System.out.println(result2);
 
    }
    public static int func(int a,int b){
        if(a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b == 0){
            return a;
        }
        if(a % b == 0){
            return b;
        }
        else{
            return func(b, a % b);
        }
    }
}