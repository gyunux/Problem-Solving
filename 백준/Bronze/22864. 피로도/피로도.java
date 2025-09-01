import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int A = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);
        int C = Integer.parseInt(line[2]);
        int M = Integer.parseInt(line[3]);

        int hour = 0;
        int result = 0;
        int exhaustion = 0;
        while(hour < 24){
            if(exhaustion + A > M){
                exhaustion -= C;
                if(exhaustion < 0){
                    exhaustion = 0;
                }
            } else{
                exhaustion += A;
                result += B;
            }
            hour++;
        }

        System.out.println(result);
    }
}