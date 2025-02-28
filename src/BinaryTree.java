public class BinaryTree
{
    TreeNode root;

    public void insert(int value)
    {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value)
    {
        if (root == null)
        {
            return new TreeNode(value);
        }
        if (value < root.value)
        {
            root.left = insertRec(root.left, value);
        }
        else if (value > root.value)
        {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void inorder(TreeNode node)
    {
        if (node != null)
        {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    public void preorder(TreeNode node)
    {
        if (node != null)
        {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(TreeNode node)
    {
        if (node != null)
        {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }
}
