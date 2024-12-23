class BinarySearchTree {
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Method to delete a node with a given data
    void deleteData(int data) {
        root = deleteIterative(root, data);
    }

    // Iterative function to delete a node with the given data
    Node deleteIterative(Node root, int data) {
        if (root == null) return null;

        Node parent = null;
        Node current = root;

        // Find the node to be deleted and its parent
        while (current != null && current.data != data) {
            parent = current;
            if (data < current.data)
                current = current.left;
            else
                current = current.right;
        }

        // If the data is not found in the tree
        if (current == null) return root;

        // Node with only one child or no child
        if (current.left == null || current.right == null) {
            Node newCurrent;

            if (current.left == null)
                newCurrent = current.right;
            else
                newCurrent = current.left;

            // If the node to be deleted is the root node
            if (parent == null)
                return newCurrent;

            // If the node to be deleted is not the root node
            if (current == parent.left)
                parent.left = newCurrent;
            else
                parent.right = newCurrent;
        } else {
            // Node with two children: Find the inorder successor (smallest in the right subtree)
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Link successor's right subtree to its parent
            if (successorParent != current)
                successorParent.left = successor.right;
            else
                successorParent.right = successor.right;

            // Replace current with successor
            successor.left = current.left;
            successor.right = current.right;

            if (parent == null)
                return successor;

            if (current == parent.left)
                parent.left = successor;
            else
                parent.right = successor;
        }
        return root;
    }

    // This method mainly calls the insert method
    void insert(int data) {
        root = insertIterative(root, data);
    }

    // Iterative function to insert a new data in the BST
    Node insertIterative(Node root, int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return root;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            if (data < current.data)
                current = current.left;
            else
                current = current.right;
        }

        if (data < parent.data)
            parent.left = newNode;
        else
            parent.right = newNode;

        return root;
    }

    // Method to print the inorder traversal of the BST
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of the BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    boolean search(int data){
        return searchElem(root,data);
    }
    private boolean searchElem(Node root,int data){
        if (root ==null) return false;
        Node cur =  root;
        while (cur!=null){
            if (data == cur.data){
                return true;
            }
            else if(data < cur.data){
                cur = cur.left;
            }
            else cur = cur.right;
        }
        return false;
    }

    // Driver code to test the above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\n\nSearch 20 in BST");
        System.out.println(tree.search(20));

        System.out.println("\n\nDelete 20");
        tree.deleteData(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\n\nSearch 20 in BST");
        System.out.println(tree.search(20));

        System.out.println("\n\nDelete 30");
        tree.deleteData(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\n\nDelete 50");
        tree.deleteData(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}

