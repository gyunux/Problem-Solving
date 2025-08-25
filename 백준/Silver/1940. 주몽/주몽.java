
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   
        int M = Integer.parseInt(br.readLine()); 
        String str = br.readLine();
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(str);
        for(int i = 0;i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(arr);

        int idxL = 0;
        int idxR = N-1;
        int left = arr[idxL];
        int right = arr[idxR];

        int result = 0;

        while(left < right){
            if((left + right) == M ){
                result += 1;
                idxL += 1;
                left = arr[idxL];

            }
            else if((left + right) < M){
                idxL += 1;
                left = arr[idxL];
            }
            else if((left + right) > M){
                idxR -= 1;
                right = arr[idxR];
            }
        }
        System.out.println(result);
    }
}
