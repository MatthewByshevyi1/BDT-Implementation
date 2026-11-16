import java.util.*;

/**
 * This BinarySearchTree object defines a reference based binary search tree
 * 
 * @author  
 * @version 
 */

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
    protected BinaryNode<T> root;      // reference to the root of this BST

    // Creates an empty Binary Search Tree object
    public BinarySearchTree()
    {
        root = null;
    }

    // Returns true if this BST is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return root == null;
    }

    // Returns the number of elements in this BST.
    public int size()
    {
        if (root == null) {
            return 0;
        }
        else {
            ArrayStack<BinaryNode<T>> nodes = new ArrayStack<BinaryNode<T>>();
            nodes.push(root);

            int size = 0;

            while (!nodes.empty()) {
                BinaryNode<T> curr = null;
                try {
                    curr = nodes.pop();
                    size++;
                } catch (StackUnderflowException e) {}

                if (curr.getRight() != null) {
                    nodes.push(curr.getRight());
                }
                if (curr.getLeft() != null) {
                    nodes.push(curr.getLeft());
                }
            }
            return size;
        }
    }

    // Adds element to this BST. The tree retains its BST property.
    public void add (T element)
    {
        if (root == null) {
            root = new BinaryNode<T>(element);
            return;
        }

        BinaryNode<T> neW = new BinaryNode<T>(element);

        BinaryNode<T> current = root;
        while(true) {
            if (element.compareTo(current.getInfo()) < 0) {

                if (current.getLeft() == null) {
                    current.setLeft(neW);
                    break;
                }
                else {
                    current = current.getLeft();
                }
            }
            else if (element.compareTo(current.getInfo()) >= 0) {
                if (current.getRight() == null) {
                    current.setRight(neW);
                    break;
                }
                else {
                    current = current.getRight();
                }

            }
        }
    }

    // Returns true if this BST contains an element e such that 
    // e.compareTo(element) == 0; otherwise, returns false.
    public boolean contains (T element)
    {
        if (root == null) {
            return false;
        }
        else {
            BinaryNode<T> curr = root;

            while (curr != null) {

                if (curr.getInfo().compareTo(element) == 0) {
                    return true;
                }
                else if (curr.getInfo().compareTo(element) < 0) {
                    curr = curr.getRight();
                }
                else {
                    curr = curr.getLeft();
                }
            }
            return false;
        }
    }

    // Returns a graphical representation of the tree
    public String toString()
    {
        return toString(root, 0);
    }

    private String toString(BinaryNode<T> tree, int level)
    {
        String str = "";
        if (tree != null)
        {
            str += toString(tree.getRight(), level + 1);
            for (int i = 1; i <= level; ++i)
                str = str + "| ";
            str += tree.getInfo().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }
        return str;
    }

    // Returns a list of elements from a preorder traversal
    public List<T> preorderTraverse()
    {
        return null;
    }

    // Returns a list of elements from an inorder traversal
    public List<T> inorderTraverse()
    {
        return null;
    }

    // Returns a list of elements from a postorder traversal
    public List<T> postorderTraverse()
    {
        return null;
    }

    // Removes an element e from this BST such that e.compareTo(element) == 0
    public void remove (T element)
    {
    }

    // Restructures this BST to be optimally balanced
    public void balance()
    {
    }
}