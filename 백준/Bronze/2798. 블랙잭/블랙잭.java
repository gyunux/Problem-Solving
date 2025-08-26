import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * 1. 첫째줄에 전체 카드 갯수,목표 숫자
        * 2. 둘째줄에 카드 목록
        * 3. 2중 반복문으로 전체 더해서 최대값 찾기
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        
        int cardLength = line2.length;
        int[] arr = new int[cardLength];

        for(int i = 0;i < cardLength; i++){
            arr[i] = Integer.parseInt(line2[i]);
        }

        int targetNum = Integer.parseInt(line1[1]);

        int max = 0;
        for(int i = 0;i < cardLength ; i++){
            for(int j = i+1; j < cardLength; j++){
                for(int k = j+1 ; k < cardLength; k++){
                    int total = arr[i] + arr[j] + arr[k];
                    if(total <= targetNum && total > max){
                        max = total;
                    }
                }
            }
        }
        System.out.println(max);

    }
}