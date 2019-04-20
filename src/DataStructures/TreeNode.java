package DataStructures;

public class TreeNode {

    private String element;
    private TreeNode left;
    private TreeNode right;
    private int height;
    private TreeNode root;
    public TreeNode(String e) {
        element = e;
        left = null;
        right = null;
        height = 0;
    }
    public String getElement()
    {
        return element;
    }
    public void setElement(String e)
    {
        element = e;
    }
    public TreeNode getLeft()
    {
        return left;
    }
    public void setLeft(TreeNode newLeft)
    {
        left = newLeft;
    }
    public TreeNode getRight()
    {
        return right;
    }
    public void setRight(TreeNode newRight)
    {
        left = newRight;
    }
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int h)
    {
        height = h;
    }

    private int height(TreeNode left) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public class TreeNodeTree {
        private TreeNode root;
        private static final int ALLOWED_IMBALANCE = 1;
        // Construct the tree.
        public TreeNodeTree()
        {
            root = null;
        }
        // Return the height of node a or -1 if null
        private int height(TreeNode a)
        {
            if(a == null)
                return -1;
            else
                return a.getHeight();
        }
    }
    // Insert into the tree; duplicates are ignored.
    public void insert(String x)
    {
        root = insert(x, root);
    }
    // Internal method to insert into a subtree that returns the new
//root of the subtree.
    private TreeNode insert(String x, TreeNode t)
    {
        if(t == null)
            return new TreeNode(x);
        if(x.compareTo(t.getElement())<0)
            t.setLeft(insert(x, t.getLeft()));
        else if(x.compareTo(t.getElement())>0)
            t.setRight(insert(x, t.getRight()));
        else
            ; //Duplicate, do nothing
        return balance(t);
    }
    /**
     * Rotate binary tree node with left child.For AVL trees, this is a
     * single rotation for case 1. Update heights, then return new root.
     */
    private TreeNode rotateWithLeftChild(TreeNode k2)
    {
        TreeNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight()))
                + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }
    /**
     * Rotate binary tree node with right child. For AVL trees, this is a
     * single rotation for case 4. Update heights, then return new root.
     */
    private TreeNode rotateWithRightChild(TreeNode k1)
    {
        TreeNode k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight()))
                + 1);
        k2.setHeight(Math.max(height(k2.getRight()), k1.getHeight()) + 1) ;
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     * Update heights, then return new root.
     * Double LR = Single RR(α  left) + Single LL(α)
     */
    private TreeNode doubleWithLeftChild(TreeNode k3)
    {
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }
    private TreeNode doubleWithRightChild(TreeNode k1)
    {
        k1.setRight(rotateWithLeftChild(k1.getRight()));
        return rotateWithRightChild(k1);
    }
    private TreeNode balance(TreeNode t)
    {
        if( t == null )
            return t;
        int ALLOWED_IMBALANCE = 0;

        if(height(t.getLeft()) - height(t.getRight()) > ALLOWED_IMBALANCE)
            if(height(t.getLeft().getLeft()) >= height(t.getLeft().getRight()))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        else
        if(height(t.getRight()) - height(t.getLeft()) > ALLOWED_IMBALANCE)
            if(height(t.getRight().getRight()) >= height(t.getRight().getLeft()))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);
        t.setHeight(Math.max(height(t.getLeft()), height(t.getRight())) + 1);
        return t;
    }
    public void printTree()
    {
        if(root == null)
            System.out.println("Empty tree");
        else
            printTree(root);
    }
    private void printTree(TreeNode t)
    {
        if(t != null)
        {
            printTree(t.getLeft());
            System.out.println(t.getElement());
            printTree(t.getRight());
        }
    }

    private String Search(String s)
    {
        TreeNode Current = root;

        while(Current !=null)
        {
            if(Current.getElement().contains(s))
                return Current.getElement();
            else if(s.compareTo(Current.getElement())<0)
                Current.getLeft();
            else if(s.compareTo(Current.getElement())>0)
                Current.getRight();
            else
                return Current.getElement();
        }

        return "XXX";

    }

}

