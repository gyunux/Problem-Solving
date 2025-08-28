
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        Map<String,TreeNode> map = new HashMap<>();
        for(int i = 0;i < repeat; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String mid = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            if(!map.containsKey(mid)){
                map.put(mid,new TreeNode(mid));
            }
            if(!left.equals(".")){
                TreeNode leftChild = new TreeNode(left);
                map.get(mid).leftNode = leftChild;
                map.put(left,leftChild);
            }
            if(!right.equals(".")){
                TreeNode rightChild = new TreeNode(right);
                map.get(mid).rightNode = rightChild;
                map.put(right,rightChild);
            }
        }
        preOrder(map.get("A"));
        System.out.println();
        inOrder(map.get("A"));
        System.out.println();
        postOrder(map.get("A"));
    }
    
    public static void preOrder(TreeNode root){
        if(root == null){return;}
        System.out.print(root.data);
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    public static void inOrder(TreeNode root){
        if(root == null){return;}
        inOrder(root.leftNode);
        System.out.print(root.data);
        inOrder(root.rightNode);
    }

    public static void postOrder(TreeNode root){
        if(root == null){return;}
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(root.data);
    }



    static class TreeNode{
        private String data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(String alphabet){
            this.data = alphabet;
        }
    }
}
