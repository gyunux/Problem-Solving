import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int originNum = num;
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            num -= 1;
            String strNum = String.valueOf(num);
            String[] strNumSplit = strNum.split("");
            int numStr = Integer.parseInt(strNum);
            int originNumStr = numStr;
            StringBuilder str = new StringBuilder();
            for(int i = 0;i < strNumSplit.length; i++){
                numStr += Integer.parseInt(strNumSplit[i]);
                str.append(strNumSplit[i]);
            }
            if(str.toString().equals(strNum) && originNum == numStr){
                list.add(originNumStr);
            }
        }
        Collections.sort(list);
        if(list.isEmpty()){
            System.out.println(0);
        } else {
            System.out.println(list.get(0));
        }
    }
}