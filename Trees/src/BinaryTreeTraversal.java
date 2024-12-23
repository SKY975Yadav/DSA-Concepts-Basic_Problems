import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TraversalInBinaryTree{
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(70);
        root.right = new Node(10);
        root.left.left = new Node(80);
        root.left.right = new Node(34);
        root.right.left = new Node(84);
        root.right.right = new Node(53);
//        inOrderTraversal(root);
//        System.out.println();
//        inOrderTraversalInIterative(root);
//        System.out.println();
        preOrderTraversal(root);
        System.out.println();
        preOrderTraversalInIterative(root);
//        postOrderTraversal(root);
//        System.out.println();
//        postOrderTraversalInIterative(root);
//        System.out.println(height(root));
//        levelOrderTraversal(root);
//        System.out.println();
//        System.out.println(size(root));
    }

    //Using Recursion TC : O(N), SC : O(H)
    public static void inOrderTraversal(Node root){
        if (root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
    public static void preOrderTraversal(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public static void postOrderTraversal(Node root){
        if (root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static void inOrderTraversalInIterative(Node root){
        if (root==null) return;
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while (cur!=null || !st.isEmpty()){
            while ((cur!=null)){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.data+" ");
            cur = cur.right;
        }
    }
    public static void preOrderTraversalInIterative(Node root){
        if (root==null) return;
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while (cur!=null || !st.isEmpty()){
            while ((cur!=null)){
                System.out.print(cur.data+" ");
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            cur = cur.right;
        }
    }
    public static void postOrderTraversalInIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null)
                stack1.push(current.left);
            if (current.right != null)
                stack1.push(current.right);
        }
        while (!stack2.isEmpty()) {
            Node current = stack2.pop();
            System.out.print(current.data + " ");
        }
    }
    public static int height(Node root){
        if (root == null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static void levelOrderTraversal(Node root){
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.poll();
            System.out.print(cur.data+" ");
            if (cur.left!=null){
                q.add(cur.left);
            }
            if (cur.right!=null){
                q.add(cur.right);
            }
        }
    }
    private static int size(Node root){
        if (root == null) return 0;
        return 1 + size(root.left)+size(root.right);
    }
}
