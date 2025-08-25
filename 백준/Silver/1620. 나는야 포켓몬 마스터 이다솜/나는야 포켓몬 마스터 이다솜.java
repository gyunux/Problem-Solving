import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        Map<String,Integer> strInt = new HashMap<>();
        Map<Integer,String> intStr = new HashMap<>();

        int repeat = Integer.parseInt(line[0]);
        int answer = Integer.parseInt(line[1]);

        for(int i = 0;i < repeat; i++){
            String str = br.readLine();
            strInt.put(str,i+1);
            intStr.put(i+1,str);
        }

        for(int i = 0;i < answer ; i++){
            String str = br.readLine();
            char c = str.charAt(0);
            if(Character.isDigit(c)){
                int num = Integer.parseInt(str);
                System.out.println(intStr.get(num));
            }
            else{
                System.out.println(strInt.get(str));
            }
        }
    }
}