import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        while(line.contains("XXXX")){
            line = line.replace("XXXX","AAAA");
        }

        while(line.contains("XX")){
            line = line.replace("XX","BB");
        }

        if(line.contains("X")){
            System.out.println(-1);
        }
        else{
            System.out.println(line);
        }
    }
}