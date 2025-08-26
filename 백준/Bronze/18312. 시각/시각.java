import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int hour = Integer.parseInt(line[0]);
        String target = line[1];

        int[] time = new int[3];
        int result = 0;

        while(time[0] <= hour){
            String hourStr = time[0] < 10 ? "0"+time[0] : String.valueOf(time[0]);
            String minStr = time[1] < 10 ? "0"+time[1] : String.valueOf(time[1]);
            String secStr = time[2] < 10 ? "0"+time[2] : String.valueOf(time[2]);
            if(secStr.contains(target) || minStr.contains(target) || hourStr.contains(target)){
                result++;
            }
            time[2]++;
            if(time[2] == 60){
                time[2] = 0;
                time[1]++;
            }
            if(time[1] == 60){
                time[1] = 0;
                time[0]++;
            }
        }
        System.out.println(result);
    }
}