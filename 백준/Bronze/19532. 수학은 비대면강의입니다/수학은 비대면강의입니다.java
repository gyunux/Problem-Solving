import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int[] arr = new int[6];

        for(int i = 0;i < 6; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        boolean flag = false;
        for(int x = -999; x <= 999; x++){
            for(int y = -999;y <= 999; y++){
                int num1 = (arr[0] * x) + (arr[1] * y);
                int num2 = (arr[3] * x) + (arr[4] * y);
                if(num1 == arr[2] && num2 == arr[5]){
                    flag = true;
                    System.out.println(x + " " + y);
                    break;
                }
            }
            if(flag){
                break;
            }
        }
    }
}