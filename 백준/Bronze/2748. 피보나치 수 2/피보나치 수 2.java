import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] numArr = new long[num+1];
        numArr[0] = 0;
        numArr[1] = 1;
        for(int i = 2;i < num + 1; i++){
            numArr[i] = numArr[i-1] + numArr[i-2];
        }
        System.out.println(numArr[num]);
    }
}