public class AvlTree {
    public Node root;

    public AvlTree()
    {
        root = null;
    }

    public void removeAll()
    {
        root = null;
    }
    public int getHeight(Node node )
    {
        return node == null ? -1 : node.height;
    }

    public int getMaxHeight(int leftNodeHeight, int rightNodeHeight)
    {
        return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
    }

    public void insertElement(int element)
    {
        root = insertElement(element, root);
    }

    private Node insertElement(int element, Node node)
    {
        if (node == null)
            node = new Node(element);

        else if (element < node.element)
        {
            node.left = insertElement( element, node.left );
            if( getHeight( node.left ) - getHeight( node.right ) == 2 )
                if( element < node.left.element )
                    node = rotateWithLeft( node );
                else
                    node = doubleWithLeft( node );
        }
        else if( element > node.element )
        {
            node.right = insertElement( element, node.right );
            if( getHeight( node.right) - getHeight( node.left ) == 2 )
                if( element > node.right.element)
                    node = rotateWithRight( node );
                else
                    node = doubleWithRight( node );
        }
        else
            node.height = getMaxHeight( getHeight( node.left ), getHeight( node.right ) ) + 1;

        return node;
    }

    public Node rotateWithLeft(Node node2)
    {
        Node node1 = node2.left;
        node2.left = node1.right;
        node1.right = node2;
        node2.height = getMaxHeight( getHeight( node2.left ), getHeight( node2.right ) ) + 1;
        node1.height = getMaxHeight( getHeight( node1.left ), node2.height ) + 1;
        return node1;
    }

    public Node rotateWithRight(Node node1)
    {
        Node node2 = node1.right;
        node1.right = node2.left;
        node2.left = node1;
        node1.height = getMaxHeight( getHeight( node1.left ), getHeight( node1.right ) ) + 1;
        node2.height = getMaxHeight( getHeight( node2.right ), node1.height ) + 1;
        return node2;
    }

    public Node doubleWithLeft(Node node3)
    {
        node3.left = rotateWithRight( node3.left );
        return rotateWithLeft( node3 );
    }

    public Node doubleWithRight(Node node1)
    {
        node1.right = rotateWithLeft( node1.right );
        return rotateWithRight( node1 );
    }

    private void inorderTraversal(Node head)
    {
        if (head != null)
        {
            inorderTraversal(head.left);
            System.out.print(head.element+" ");
            inorderTraversal(head.right);
        }
    }

    public void inorderTraversal()
    {

        inorderTraversal(root);
    }

    public void preorderTraversal()
    {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node head)
    {
        if (head != null)
        {
            System.out.print(head.element+" ");
            preorderTraversal(head.left);
            preorderTraversal(head.right);
        }
    }

    private void postorderTraversal(Node head)
    {
        if (head != null)
        {
            postorderTraversal(head.left);
            postorderTraversal(head.right);
            System.out.print(head.element+" ");
        }
    }

    public void postorderTraversal()
    {
        postorderTraversal(root);
    }

}
