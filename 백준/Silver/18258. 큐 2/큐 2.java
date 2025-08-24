
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Deque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        int last = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                last = num;
            } else if (command.equals("pop")) {
                sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? "1" : "0").append("\n");
            } else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? "-1" : queue.peek()).append("\n");
            } else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? "-1" : last).append("\n");
            }
        }
        
        System.out.print(sb);
        br.close();
    }
}
