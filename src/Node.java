class Node {
    int value, height;
    Node left, right;

    public Node(int item){
        this.value = item;
        right = left = null;
        height = 1;
    }
}
