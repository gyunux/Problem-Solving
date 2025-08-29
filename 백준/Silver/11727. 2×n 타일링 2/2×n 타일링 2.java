
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];
        arr[0] = 1;
        arr[1] = 3;
        for(int i = 2;i < n+1;i ++){
            arr[i] = (arr[i-1] + (2 * arr[i-2])) % 10007;
        }
        System.out.println(arr[n-1]);
    }
}
