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
    
    //NOT DONE
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


    //NOT DONE
    //mark deleted item
    public boolean delete(int key) throws IllegalArgumentException
    {
        // if key is invalid, throw error with message
        if (key < 1 || key > 99)
        {
            throw new IllegalArgumentException("Key is not in range 1-99");
        }

        TreeNode curr = findNode(key);

        //if null or already deleted, do nothing
        if (curr == null || curr.deleted)
        {
            return false;
        }

        //else, mark deleted
        curr.deleted = true;
        return true;
    }


    //find minimum non-deleted element, return -1 if not found
    public int findMin()
    {
        TreeNode nonDelete = null;
        TreeNode curr = root;

        //loop through left Nodes
        while (curr.leftChild != null)
        {
            //if not deleted 
            if (!curr.deleted)
            {
                nonDelete = curr;
            }
            curr = curr.leftChild;
        }

        //if nonDelete isnt empty, return it 
        if (nonDelete != null)
        {
            return nonDelete;
        }

        return -1;
    }


    //find maximum non-deleted element, return -1 if not found
    public int findMax()
    {
        
        TreeNode nonDelete = null;
        TreeNode curr = root;

        // loop through left Nodes
        while (curr.rightChild != null) {
            // if not deleted
            if (!curr.deleted) {
                nonDelete = curr;
            }
            curr = curr.rightChild;
        }

        // if nonDelete isnt empty, return it
        if (nonDelete != null) {
            return nonDelete;
        }

    }


    // return true if BST contains (non-deleted) key
    public boolean contains(int key) throws IllegalArgumentException
    {
        // if key is invalid, throw error with message
        if (key < 1 || key > 99)
        {
            throw new IllegalArgumentException("Key is not in range 1-99");
        }

        //
        TreeNode found = findNode(key);
        if (found == null || found.deleted)
        {
            return false;
        }

        return true;
    }


    //preoder traversal helper
    private static preorderPrint(TreeNode curr)
    {
        if (curr == null)
        {
            return;
        }

        //if deleted is true, print with asterisk
        if (curr.deleted)
        {
            System.out.print("*" + node.key + " ");
        }
        else
        {
            System.out.print(curr.key + " ");
        }

        //traverse left
        preorderPrint(curr.leftChild);
        //traverse right
        preorderPrint(curr.rightChild);
    }

    //print preorder value of each element. Deleted elements preceded by *
    // 45 30 2 *5 47 50 *60
    public String toString()
    {
        preorder(root);
        return "";
    }

    //height helper (recursive)
    //gets the largest subtrees and returns height
    private int findDepth(TreeNode curr)
    {
        if (curr == null)
        {
            return 0;
        }

        else
        {
            //get depth of left and right subtree
            int left = findDepth(curr.leftChild);
            int right = findDepth(curr.rightChild);

            //return larger of the two
            if (left > right)
            {
                return (left + 1);
            }
            else
            {
                return (right + 1);
            }
        }

    }

    // return the height of the tree, including “deleted” elements
    public int height()
    {
        return findDepth(root);
    }

    
    //size helper (recursive)
    private int traversal(TreeNode curr)
    {
        if (curr == null)
        {
            return 0;
        }

        //return 
        return (traversal(curr.leftChild) + 1 + traversal(curr.rightChild));

    }


    // return the count of elements in the tree, including “deleted” ones.
    public int size()
    {
        return traversal(root);
    }

    
    //return the TreeNode that has the data
    private TreeNode findNode(int key)
    {
        TreeNode curr = root;

        //loop through nodes
        while (curr != null)
        {
            //if you've found the key, return this node
            if (curr.key == key)
            {
                return curr;
            }

            //if left child exists
            else if (curr.leftChild != null && key < curr.key)
            {
                curr = curr.leftChild;
            }

            //if right child exists and search key > current key
            else if (curr.rightChild != null && key > curr.key)
            {
                curr = curr.rightChild;
            }

            //doesn't exist
            else
            {
                return null;
            }

        }

        return null;

    }

 }
