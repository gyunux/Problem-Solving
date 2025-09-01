import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[5][15];
        for(int i = 0;i < 5; i++){
            String[] line = br.readLine().split("");
            for(int j = 0;j < line.length; j++){
                arr[i][j] = line[j];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15; i++){
            for(int j = 0;j < 5; j++){
                if(arr[j][i] == null || arr[j][i].equals(" ")){
                    continue;
                } else{
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}