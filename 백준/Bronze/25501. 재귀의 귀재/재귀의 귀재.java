import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < num; i++){
            String[] line = br.readLine().split("");
            int l = 0;
            int r = line.length - 1;
            int returnValue = 1;
            int returnCount = 0;
            while(true){
                returnCount++;
                
                if(l >= r){
                    break;
                }
                if(!line[l].equals(line[r])){
                    returnValue = 0;
                    break;
                }
                l++;
                r--;
            }
            sb.append(String.format("%d %d%n",returnValue,returnCount));
        }
        System.out.println(sb);
    }
}