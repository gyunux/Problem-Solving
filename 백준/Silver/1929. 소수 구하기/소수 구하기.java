import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        boolean[] arr = new boolean[b+1];
        arr[0] = true;
        arr[1] = true;
        for(int i = a ; i <= b;i++){
            for(int j = 2;j <= (int)Math.sqrt(i);j++){
                if(i % j == 0){
                    arr[i] = true;
                    break;
                }
            }
        }

        for(int i = a;i <= b;i++){
            if(arr[i] == false){
                System.out.println(i);
            }
        }
        
    }

}
