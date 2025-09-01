import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split("\\*");
        int starLength = str[0].length() + str[1].length();

        for(int i = 0;i < repeat; i++){

            String[] line = br.readLine().split("");
            int gapLength = line.length - starLength;
            StringBuilder sb = new StringBuilder();

            for(int j = 0;j < gapLength; j++){
                sb.append("*");
            }
            String[] starStr = (str[0] + sb + str[1]).split("");

            boolean flag = true;
            for(int k = 0;k < line.length; k++){
                if(line[k].equals(starStr[k])){
                    continue;
                    
                }
                else{
                    if(!starStr[k].equals("*")){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}