import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0;i < repeat; i++){
            Stack<String> stack = new Stack<>();
            String[] line = br.readLine().split("");
            for(int j = 0;j < line.length; j++){
                if(!stack.isEmpty()){
                    if(stack.peek().equals(line[j])){
                        stack.pop();
                    } else{
                        stack.push(line[j]);
                    }
                }else{
                    stack.push(line[j]);
                }
            }
            if(stack.isEmpty()){
                result++;
            }
        }
        System.out.println(result);
    }
}