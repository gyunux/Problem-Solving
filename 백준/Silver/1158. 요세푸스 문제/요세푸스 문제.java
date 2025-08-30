import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int size = Integer.parseInt(line[0]);
        int targetIdx = Integer.parseInt(line[1]);
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= size; i++){
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int curIdx = 1;
        while(queue.size() > 1){
            if(curIdx == targetIdx){
                sb.append(queue.poll()).append(", ");
                curIdx = 1;
            } else{
                queue.add(queue.poll());
                curIdx++;
            }
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}