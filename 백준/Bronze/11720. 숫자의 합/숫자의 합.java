import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numLength = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int result = 0;

        for(int i = 0;i < numLength ; i++){
            result += Integer.parseInt(String.valueOf(line.charAt(i)));
        }
        
        System.out.println(result);
       
    }
}