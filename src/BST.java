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
    void printBSTLRN(Node root){
        printLRN(root);
    }

    void printLRN(Node root){
        if (root != null) {
            printLRN(root.left);
            printLRN(root.right);
            System.out.print(root.value + " ");
        }
    }
    void printBSTLNR(Node root){
        printLNR(root);
    }

    void printLNR(Node root){
        if (root != null) {
            printLNR(root.left);
            System.out.print(root.value + " ");
            printLNR(root.right);
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
    Node findKey(int value){
        return findKeyNode(root, value);
    }
    Node findKeyNode(Node root, int value){
        if(root != null){
            if (root.value == value){
                return root;
            }else if (root.value < value){
                return findKeyNode(root.right, value);
            }else{
                return findKeyNode(root.left, value);
            }
        }else {
            return null;
        }
    }

    void deleteValue(int value)
    {
        root = deleteNode(root, value);
    }

    Node deleteNode(Node root, int key)
    {
        if (root == null)  return root;
        if (key < root.value)
            root.left = deleteNode(root.left, key);
        else if (key > root.value)
            root.right = deleteNode(root.right, key);
        else
        {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.value = minValue(root.right);
            root.right = deleteNode(root.right, root.value);
        }
        return root;
    }
    int minValue(Node root)
    {
        int min = root.value;
        while (root.left != null)
        {
            min = root.left.value;
            root = root.left;
        }
        return min;
    }
    public static void main(String[] args) {
        BST tree = new BST();
        String integerString = "50 30 20 40 70 60 80";
        System.out.println("Chuoi so nguyen: "+integerString);
        System.out.println("Cau 1.2: ");
        string2Array(tree, integerString);
        System.out.print("Duyet cay theo left right node: ");
        tree.printBSTLRN(tree.root);
        System.out.println("\n \nCau 1.3: ");
        int keyValue = 70;
        if (tree.findKey(keyValue) != null){
            System.out.print("Ton tai khoa "+keyValue);
            System.out.print("Cac khoa ben phai khoa "+keyValue+": ");
            tree.printBSTLRN(tree.findKey(keyValue).right);
        }else {
            System.out.print("Khong ton tai khoa "+keyValue);
        }
        System.out.println("\n \nCau 1.4: ");
        System.out.print("Duyet cay theo left node right: ");
        tree.printBSTLNR(tree.root);
        System.out.println("\n \nCau 1.5: ");
        int keyValue2 = 50;
        if (tree.findKey(keyValue2) != null){
            System.out.print("Ton tai khoa "+keyValue2);
            tree.deleteValue(keyValue2);
            System.out.print("\nDuyet cay theo left right node sau khi xoa: ");
            tree.printBSTLRN(tree.root);
        }else {
            System.out.print("Khong ton tai khoa "+keyValue2);
        }
    }
}
