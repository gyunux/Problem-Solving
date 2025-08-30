import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        if(N == 1 || N == 3){
            System.out.println(-1);
            return;
        }

        for(int i = 2;i <= N; i++){
            if(i % 5 == 0){
                arr[i] = i / 5;
            } else if(i % 2 == 0){
                arr[i] = arr[i-2] + 1;
            } else{
                if(i == 3) continue;
                arr[i] = arr[i-5] + 1;
            }
        }



        System.out.println(arr[N]);
    }
}