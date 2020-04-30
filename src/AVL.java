public class AVL {
    Node root;

    int getHeight(Node N){
        if (N == null){
            return 0;
        }
        return N.height;
    }

    Node xoayPhai(Node node){
        Node a = node.left;
        Node b = a.right;
        a.right = node;
        node.left = b;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) +1;
        a.height = Math.max(getHeight(a.left), getHeight(a.right)) +1;
        return a;
    }
    Node xoayTrai(Node node){
        Node a = node.right;
        Node b = a.left;
        a.left = node;
        node.right = b;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        a.height = Math.max(getHeight(a.right), getHeight(a.left)) + 1;
        return a;
    }

    int chiSoCanBang(Node a){
        if (a == null){
            return 0;
        }
        return getHeight(a.left) - getHeight(a.right);
    }

    Node insert(Node node, int value){
        if (node == null){
            return new Node(value);
        }

        if (value < node.value){
            node.left = insert(node.left, value);
        } else if (value > node.value){
            node.right = insert(node.right, value);
        } else
            return node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int canBang = chiSoCanBang(node);

        if (canBang > 1 && value < node.left.value)
            return xoayPhai(node);

        if (canBang < -1 && value > node.right.value)
            return xoayTrai(node);

        if (canBang > 1 && value > node.left.value) {
            node.left = xoayTrai(node.left);
            return xoayPhai(node);
        }

        if (canBang < -1 && value < node.right.value) {
            node.right = xoayPhai(node.right);
            return xoayTrai(node);
        }

        return node;
    }
    static void string2Array(AVL avl, String str){
        str = str.replaceAll("\\s+"," ").trim();
        String[] strArr;
        strArr = str.split(" ");
        for (String s : strArr) {
            avl.root = avl.insert(avl.root, Integer.parseInt(s));
        }
    }

    void printLNR(Node root){
        if (root != null) {
            printLNR(root.left);
            System.out.print(root.value + " ");
            printLNR(root.right);
        }
    }

    public Integer findMax(){
        Node result = root;
        result = findMax(root, result);
        return result.value;
    }

    private Node findMax(Node node,Node result){
        if (node == null){
            return result;
        }
        if (node.value > result.value) {
            result = node;
        }
        result = findMax(node.left, result);
        result = findMax(node.right, result);
        return result;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        String integerString = "10 15 50 23 72 12 20";
        System.out.println("Chuoi so nguyen: "+integerString);
        System.out.println("\nCau 2.2: ");
        string2Array(tree, integerString);
        System.out.print("Duyet cay theo left-node-right: ");
        tree.printLNR(tree.root);
        System.out.print("\n\nCau 2.3: ");
        System.out.print("\nKhoa lon nhat cua cay la: "+ tree.findMax());
    }
}
