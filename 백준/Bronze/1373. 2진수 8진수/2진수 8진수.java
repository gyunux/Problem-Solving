import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        while(line.length() % 3 != 0){
            line = "0" + line;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i += 3) {
            String sub = line.substring(i, i + 3);
            int num = Integer.parseInt(sub, 2);
            sb.append(num);
        }
        System.out.println(sb.toString());
    }
}