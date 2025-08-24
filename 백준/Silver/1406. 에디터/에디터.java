import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char c : s.toCharArray()) {
            leftStack.push(c);
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("L") && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            } else if (command.equals("D") && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            } else if (command.equals("B") && !leftStack.isEmpty()) {
                leftStack.pop();
            } else if (command.equals("P")) {
                leftStack.push(st.nextToken().charAt(0));
            }
        }

        for (char c : leftStack) {
            bw.write(c);
        }
        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }

        bw.flush();
        bw.close();
    }
}
