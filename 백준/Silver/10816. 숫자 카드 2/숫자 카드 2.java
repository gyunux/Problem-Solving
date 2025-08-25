
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer,Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        for(int i = 0;i < repeat; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int repeat2 = Integer.parseInt(br.readLine());
        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2);

        for(int i = 0;i < repeat2; i++){
            int temp = Integer.parseInt(st2.nextToken());
            if(map.containsKey(temp)){
                sb.append(map.get(temp)).append(" ");
            }
            else{
                sb.append("0").append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
