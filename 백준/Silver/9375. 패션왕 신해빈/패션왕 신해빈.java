import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0;i < repeat; i++){
            Map<String,Integer> map = new HashMap<>();
            int innerRepeat = Integer.parseInt(br.readLine());
            for(int j = 0; j < innerRepeat; j++){
                String[] line = br.readLine().split(" ");
                if(map.get(line[1]) == null){
                    map.put(line[1],1);
                } else {
                    map.put(line[1],map.get(line[1]) + 1);
                }
            }
            int result = 1;
            for(int n : map.values()){
                result *= (n+1);
            }
            System.out.println(result - 1);
        }
    }
}