import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        String[] numStr = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i = 0;i < N; i++){
            arr[i] = Integer.parseInt(numStr[i]);
        }


        int firstValue = 0;
        for(int i = 0;i < K;i++){
            firstValue += arr[i];
        }

        int tempValue = firstValue;
        int result = firstValue;
        for(int i = 1; i <= N - K; i++){
            tempValue = tempValue - arr[i-1] + arr[i+K-1];
            result = Math.max(result,tempValue);
        }
        System.out.println(result);
    }
}