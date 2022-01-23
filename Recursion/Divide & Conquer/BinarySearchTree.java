public class BinarySearchTree {

    class Node {
        int key;  // The Value of the Node
        Node left, right; // Left and Right Nodes
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;  // Root of BST

    public BinarySearchTree() { // Constructor
        root = null;
    }

    public void insert(int key) { // This method mainly calls insert()
        root = insert(root, key);
    }

    private Node insert(Node root, int key) {
        if (root == null) {  // Put the value of the Root Node
            root = new Node(key); 
            return root;
        }

        if (key < root.key)  // Put the value of the Left Node
            root.left = insert(root.left, key);
        else if (key > root.key)  // Put the value of the Right Node
            root.right = insert(root.right, key);
        return root;
    }

    public void inorder() {  // This method mainly calls Inorder()
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root) { // To do inorder traversal of BST
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.key);
            inorderTraversal(root.right);
        } 
    }

    public void leafNodes() {
        printLeafNodes(root);
    }

    private void printLeafNodes(Node root) { // Print all leaves using inorder Traversal
        if (root != null) {
            if(root.left == null && root.right == null) System.out.println("Leaf: " + root.key);
            printLeafNodes(root.left);
            printLeafNodes(root.right);
        } 
    }

    // Driver Code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /*
         * Let us create following BST
         *          50
         *          / \
         *       30  70
         *        / \   / \
         *     20 40 60 80
         */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        System.out.println("Inorder Traversal:");
        tree.inorder();
        System.out.println("Printing All the leaves:");
        tree.leafNodes();
    }
}
