import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.isEmpty()) {
            System.out.println("Error!");
            return;
        }

        boolean isCpp = false;
        boolean isJava = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '_') {
                isCpp = true;
            } else if (Character.isUpperCase(c)) {
                isJava = true;
            }
        }

        if ((isCpp && isJava) || line.contains("__") ||
                Character.isUpperCase(line.charAt(0)) || line.charAt(0) == '_' ||
                line.charAt(line.length() - 1) == '_') {
            System.out.println("Error!");

        } else if (isCpp) {
            String[] strArr = line.split("_");
            StringBuilder sb = new StringBuilder(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                if (strArr[i].isEmpty() || Character.isUpperCase(strArr[i].charAt(0))) {
                    System.out.println("Error!");
                    return;
                }
                sb.append(Character.toUpperCase(strArr[i].charAt(0)));
                sb.append(strArr[i].substring(1));
            }
            System.out.println(sb);

        } else if (isJava) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isLowerCase(c)) {
                    sb.append(c);
                } else {
                    sb.append("_");
                    sb.append(Character.toLowerCase(c));
                }
            }
            System.out.println(sb);

        } else {
            System.out.println(line);
        }
    }
}