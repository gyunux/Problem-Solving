
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String coinsAndTotal = br.readLine();
        StringTokenizer cAT = new StringTokenizer(coinsAndTotal);

        //코인 종류,총 금액
        int coinCount = Integer.parseInt(cAT.nextToken());
        int total = Integer.parseInt(cAT.nextToken());
        

        //코인 배열 세팅
        int[] coins = new int[coinCount];
        for(int i = 0 ; i < coinCount ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int reverseIdx = coinCount - 1;
        while(total > 0){
            if(total >= coins[reverseIdx]){
                result += total / coins[reverseIdx];
                total %= coins[reverseIdx];
            }
            else{
                reverseIdx -= 1;
            }
        }
        System.out.println(result);

    }
}
