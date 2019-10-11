/*
 * Ethan Newman
 * EEN170000
 * CS 3345.005
 * The task of this project is to implement in Java a binary search tree with lazy deletion.
 */



 public class LazyBinarySearchTree
 {
    
    TreeNode root;

    //TreeNode class for the linked list nodes
    public class TreeNode
    {
        int key;
        TreeNode leftChild;
        TreeNode rightChild;

        boolean deleted;
        
        
        //Constructor to create new TreeNodes
        TreeNode(TreeNode k)
        {
            key = k;
            leftChild = null;
            rightChild = null;
            deleted = false;
        }
    }

    //-------------Constructors-----------------------------------------------
    public LazyBinarySearchTree()
    {
        root = null;
    }






    //--------------functions-------------------------------------------------
    
    //insert item into BST
    //if duplicate, do nothing
    public boolean insert(int key) throws IllegalArgumentException
    {
        //if key is invalid, throw error with message
        if (key < 1 || key > 99)
        {
            throw new IllegalArgumentException("Key is not in range 1-99");
        }
        return true;
    }


    //mark deleted item
    public boolean delete(int key) throws IllegalArgumentException
    {
        // if key is invalid, throw error with message
        if (key < 1 || key > 99)
        {
            throw new IllegalArgumentException("Key is not in range 1-99");
        }




        return true;
    }


    //find minimum non-deleted element, return -1 if not found
    public int findMin()
    {
        
        return -1;
    }


    //find maximum non-deleted element, return -1 if not found
    public int findMax()
    {
        
        return -1;
    }


    // return true if BST contains (non-deleted) key
    public boolean contains(int key) throws IllegalArgumentException
    {
        // if key is invalid, throw error with message
        if (key < 1 || key > 99)
        {
            throw new IllegalArgumentException("Key is not in range 1-99");
        }
        return false;
    }


    //print preorder value of each element. Deleted elements preceded by *
    // 45 30 2 *5 47 50 *60
    public String toString()
    {

        return "";
    }


    // return the height of the tree, including “deleted” elements
    public int height()
    {

        return 0;
    }

    
    // return the count of elements in the tree, including “deleted” ones.
    public int size()
    {

        return 0;
    }

    //return the TreeNode that has the data
    private TreeNode findNode(int key)
    {
        TreeNode curr = root;

        //loop through 
        while (curr != null)
        {
            if (curr.key == key)
            {
                return curr;
            }

        }

    }

 }
