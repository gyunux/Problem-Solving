
import java.util.*;

public class Main{
    public static void main(String[] args) {
        
        Stack<Character> stack = new Stack<>();
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        boolean flag = false;
        //플래그 세팅
        String result = "";
        if(str.charAt(0) == '<'){
            flag = true;
        }
        
        

        for(int i = 0;i < str.length();i++){
            if(flag == false){
                if(str.charAt(i) == '<'){
                    if(stack.size() > 0){
                        int len = stack.size();
                        for(int j = 0;j < len; j++){
                            result += stack.pop();
                        }
                    }
                    result += "<";
                    flag = true;
                    
                }
                if(str.charAt(i) != ' ' && str.charAt(i) != '<'){
                    stack.push(str.charAt(i));
                }
                else if(str.charAt(i) == ' '){
                    int len = stack.size();
                    for(int j = 0;j < len; j++){
                        result += stack.pop();
                    }
                    result += " ";
                }
            }
            else{
                if(str.charAt(i) == '>'){
                    result += ">";
                    flag = false;
                }
                else{
                    result += str.charAt(i);
                }
            }
        }

        int n = stack.size();
        for(int j = 0; j < n;j++){
            result += stack.pop();
        }
        System.out.println(result);
    }
}
