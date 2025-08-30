import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        Map<String,Integer> strMap = new HashMap<>();
        Set<String> strSet = new HashSet<>();
        for(int i = 0;i < repeat; i++){
            String[] line = br.readLine().split("\\.");
            if(strMap.get(line[1]) == null){
                strMap.put(line[1],1);
                strSet.add(line[1]);
            } else {
                strMap.put(line[1],strMap.get(line[1]) + 1);
            }
        }
        List<String> strList = new ArrayList<>(strSet);
        Collections.sort(strList);
        for(int i = 0;i < strList.size(); i++){
            String expand = strList.get(i);
            System.out.println(String.format("%s %d",expand,strMap.get(expand)));
        }
    }
}