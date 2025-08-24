import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0;i < repeat; i++){
            String line = br.readLine();
            Stack<String> stack = new Stack<>();

            boolean flag = true;

            for(int j = 0;j < line.length(); j++){
                if(line.charAt(j) == '('){
                    stack.push(String.valueOf('('));
                }
                else{
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    else{
                        if(stack.peek().equals("(")){
                            stack.pop();
                        }
                        else{
                            System.out.println("NO");
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag && stack.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}