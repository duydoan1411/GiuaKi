public class BST {
    Node root;

    void insert(int value){
       root = insertNode(root, value);
    }
    Node insertNode(Node root, int value){
        if (root == null){
            return new Node(value);
        }
        if (value < root.value){
            root.left = insertNode(root.left, value);
        }else if (value > root.value){
            root.right = insertNode(root.right, value);
        }
        return root;
    }
    void printBST(){
        printNode(root);
    }

    void printNode(Node root){
        if (root != null) {
            printNode(root.left);
            printNode(root.right);
            System.out.print(root.value + " ");
        }
    }

    static void string2Array(BST bst, String str){
        str = str.replaceAll("\\s+"," ").trim();
        String[] strArr;
        strArr = str.split(" ");
        for (String s : strArr) {
            bst.insert(Integer.parseInt(s));
        }
    }
    public static void main(String[] args) {
        BST tree = new BST();
        String integerString = "50 30 20 40 70 60 80";
        string2Array(tree, integerString);
        tree.printBST();
    }
}
