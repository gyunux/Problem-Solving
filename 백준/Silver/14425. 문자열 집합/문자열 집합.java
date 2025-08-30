import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        Set<String> set = new HashSet<>();

        for(int i = 0;i < N; i++){
            set.add(br.readLine());
        }
        int result = 0;
        for(int i = 0;i < M; i++){
            String str = br.readLine();
            if(set.contains(str)){
                result++;
            }
        }
        System.out.println(result);

    }
}