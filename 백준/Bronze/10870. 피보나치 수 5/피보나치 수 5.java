import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fibonacciNum = Integer.parseInt(br.readLine());
        int result = fibonacci(fibonacciNum);
        System.out.println(result);
    }
    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}