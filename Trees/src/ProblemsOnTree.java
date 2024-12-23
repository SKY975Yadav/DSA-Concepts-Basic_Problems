import java.util.LinkedList;
import java.util.Queue;

class Problems{
    public void printNodesAtKDistance(Node root,int k){ //TC : O(N) SC : (height)
        if (root==null)return;
        if (k==0){
            System.out.print(root.data+" ");
            return;
        }
        printNodesAtKDistance(root.left,k-1);
        printNodesAtKDistance(root.right,k-1);
    }
    public int maximumInBinaryTreeUsingDFS(Node root){// TC : O(N) SC : O(height)
        if (root==null)return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(maximumInBinaryTreeUsingDFS(root.left),maximumInBinaryTreeUsingDFS(root.right)));
    }
    public int maximumInBinaryTreeUsingBFS(Node root){// TC : O(N) SC : O(Max width)
        if (root==null) return-1;
        int max = root.data;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.left!=null){
                if (cur.left.data>max){
                    max = cur.left.data;
                }
                q.add(cur.left);
            }
            if (cur.right!=null){
                if (cur.right.data>max){
                    max = cur.right.data;
                }
                q.add(cur.right);
            }
        }
        return max;
    }
}
public class ProblemsOnTree {
    public static void main(String[] args) {
        Problems p = new Problems();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(60);
        root.left.left = new Node(30);
        root.left.right = new Node(82);
        root.right.left = new Node(16);
        root.right.right = new Node(46);
//        root.right.right.right =new Node(90);
        //Problem 1 :
//        p.printNodesAtKDistance(root,2);

        //Problem 2 :
        System.out.println(p.maximumInBinaryTreeUsingBFS(root));
        System.out.println(p.maximumInBinaryTreeUsingDFS(root));

    }
}
