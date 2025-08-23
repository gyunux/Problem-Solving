import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] charCount = new int[26];
        String line = br.readLine().toUpperCase();

        for (int i = 0; i < line.length(); i++) {
            charCount[line.charAt(i) - 'A']++;
        }

        int maxCount = -1;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > maxCount) {
                maxCount = charCount[i];
            }
        }

        char result = '?';
        int countOfMax = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == maxCount) {
                countOfMax++;
                result = (char) (i + 'A');
            }
        }

        if (countOfMax > 1) {
            System.out.println("?");
        } else {
            System.out.println(result);
        }
    }
}