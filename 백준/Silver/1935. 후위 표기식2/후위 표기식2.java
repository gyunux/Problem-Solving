import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());

        String line = br.readLine();
        double[] arr = new double[26];

        for(int i = 0;i < repeat; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0;i < line.length(); i++){
            char c = line.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                stack.push(arr[(int) c - 'A']);
            }
            else{
                double b = stack.pop();
                double a = stack.pop();
                if(line.charAt(i) == '*'){
                    stack.push(a * b);
                } else if(line.charAt(i) == '+'){
                    stack.push(a + b);
                } else if(line.charAt(i) == '/'){
                    stack.push(a / b);
                } else{
                    stack.push(a - b);
                }
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}