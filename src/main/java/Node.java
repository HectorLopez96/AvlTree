public class Node {
    public Node root;
    int element;
    int height;
    Node left;
    Node right;

    public Node(int element) {
        left = null;
        right = null;
        this.element = element;
        this.height = 0;

    }

}
