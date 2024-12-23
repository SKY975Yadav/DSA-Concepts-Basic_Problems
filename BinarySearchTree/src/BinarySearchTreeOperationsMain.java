class BinarySearchTreeOperation{
    public boolean search(Node root,int key){//TC : O(h) , SC : O(h)
        if(root == null) return false;
        if (root.data==key) return true;
        else if(root.data>key){
            return search(root.left,key);
        }
        else return search(root.right,key);
    }
    public boolean searchIterative(Node root, int x){
        while(root!=null){
            if(root.data==x)
                return true;
            else if(root.data<x)
                root=root.right;
            else
                root=root.left;
        }
        return false;
    }
    public Node insertIterative(Node root,int x){
        Node temp = new Node(x);
        Node cur = root,parent = null;
        while (cur!=null){
            parent= cur;
            if (cur.data>x) cur = cur.left;
            else if (cur.data<x) cur = cur.right;
            else return root;
        }
        if (parent == null) return temp;
        if (parent.data<x) parent.right = temp;
        else parent.left = temp;
        return root;
    }
    public Node insert(Node root,int x){
        if (root==null) return new Node(x);
        if (root.data>x) root.left= insert(root.left,x);
        else if (root.data<x) root.right =  insert(root.right,x);
        return root;
    }

    public Node delete(Node root,int x){
        if (root==null) return null;
        if (root.data>x) root.left = delete(root.left,x);
        else if (root.data<x) root.right = delete(root.right,x);
        else {
            if (root.left==null) return root.right;
            if (root.right==null) return root.left;
            Node suc =findInorderSuccessor(root);
            root.data = suc.data;
            root.right = delete(root.right, suc.data);
        }
        return root;
    }
    public Node findInorderSuccessor(Node root){
        Node cur = root.right;
        while (cur!=null && cur.left!=null){
            cur =cur.left;
        }
        return cur;
    }
    public Node floor(Node root,int x){//floor means Node of  smaller or equal number
        if (root==null) return null;
        Node res= null;
        while (root!=null) {
            if (root.data == x) return root;
            if (root.data > x) root = root.left;
            else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }
    public Node ciel(Node root,int x){//floor means Node of  smaller or equal number
        if (root==null) return null;
        Node res= null;
        while (root!=null) {
            if (root.data == x) return root;
            if (root.data < x) root = root.right;
            else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
    public int maxInBST(Node root){
        if (root == null)return -1;
        Node cur = root;
        while (cur.right!=null){
            cur=cur.right;
        }
        return cur.data;
    }
    public int minInBST(Node root){
        if (root == null)return -1;
        Node cur = root;
        while (cur.left!=null){
            cur=cur.left;
        }
        return cur.data;
    }
}
public class BinarySearchTreeOperationsMain {
    public static void main(String[] args) {
        BinarySearchTreeOperation bst = new BinarySearchTreeOperation();
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(10);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
//        System.out.println(bst.searchIterative(root,80));
//        System.out.println(bst.search(root,80));
//        root = bst.insert(root,55);
//        root = bst.insert(root,37);
//        root = bst.delete(root,30);
//        Node floor = bst.floor(root,999999);
        Node ciel = bst.ciel(root,-323232);
        System.out.println();
        System.out.println(ciel.data);
//        System.out.println(floor.data);
//        bnl.inOrderTraversal(root);
//        System.out.println(maxInBST(root));
//        System.out.println(minInBST(root));

    }
}
