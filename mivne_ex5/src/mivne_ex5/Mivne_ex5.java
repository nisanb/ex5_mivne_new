/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mivne_ex5;

import static java.lang.Math.max;

/**
 *
 * @author nisan
 */
public class Mivne_ex5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node completeTree = completeTree();
        Node almostCompleteTree = almostCompleteTree();
        Node notCompleteTree = notCompleteTree();
        Node notCompleteTree2 = notCompleteTree2();
//        printTree(notCompleteTree);
        log("IsComplete: \r\nChecking Complete Tree");
        log(""+isComplete(completeTree).toString());
// 
        log("Checking Almost Complete Tree");
      log(isComplete(almostCompleteTree).toString());

    
        log("Checking Not Complete Tree");
        log(isComplete(notCompleteTree).toString());
        log("Checking Not Complete Tree 2");
        log(isComplete(notCompleteTree2).toString());
      //  log("Mickey Function");
      
      
      log("\r\nIsParentSmallerThankids:");
        log("Parent Tree OK: "+IsParentSmallerThanKids(ParentTreeOK()));
      log("Parent Tree OK: "+IsParentSmallerThanKids(ParentTreeNotOK()));
      
      log("\r\nIs Minimum Stack:");
        log("Parent Tree OK: "+IsMinimumStack(ParentTreeOK()));
      log("Parent Tree OK: "+IsMinimumStack(ParentTreeNotOK()));
      
        log("");
    }
    
    /**
     * 
     * @param node
     * @return 
     */
    public static Boolean isComplete(Node node){
        //Is empty - is full tree
        if(node==null)
            return true;
        
        if(node.right != null){
            if(node.left==null)
                return false; //tree is not ok!

            if((node.right.right != null || node.right.left != null)) //if right node has any sons
                if(node.left.left == null || node.left.right==null) //left node must have both sons
                    return false; //tree 
                
            
        }
        
        
        

        return isComplete(node.right) && isComplete(node.left);
        
    }
    
    /**
     * This function checks if a given binary trees' parent node is smaller than both of his sons
     * @param node
     * @return 
     */
    public static Boolean IsParentSmallerThanKids(Node node){
        if(node==null || (node.right==null && node.left==null))
            return true;
        
        if(node.right == null)
            if(node.left.val<node.val)
                return false;
        else
        if(node.left == null)
            if(node.right.val<node.val)
                return false;
        else
        if(max(node.right.val, node.left.val)<node.val)
            return false;
        
        return IsParentSmallerThanKids(node.right) && IsParentSmallerThanKids(node.left);
    }
    
    public static Boolean IsMinimumStack(Node node){
        return isComplete(node)&&IsParentSmallerThanKids(node);
    }
    
    /**
     * Set up new binary full complete tree
     *              3
     *            /   \
     *          4       6
     *        /   \    /  \
     *       1     2  7    8
     * @return 
     */
    public static Node completeTree(){
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
                
        return root;
    }
    
     /**
     * Set up new binary full complete tree
     *              1
     *            /   \
     *          2       5
     *        /   \    /  \
     *       3     4  6    
     * @return 
     */
    public static Node ParentTreeOK(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.left = new Node(6);
        
        return root;
    }
    
        /**
     * Set up new binary full complete tree
     *              1
     *            /   \
     *          2       5
     *        /   \    /  \
     *       3     4  4    
     * @return 
     */
    public static Node ParentTreeNotOK(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.left = new Node(2);
        
        return root;
    }
    
    /**
     * Set up new binary almost complete tree
     *                 1
     *            /         \
     *          2            3
     *        /   \        /    \
     *       4    5       6      7
     *      / \  / \     / \    / \
     *     8  9 10 11   14 15  12
     * @return 
     */
    public static Node almostCompleteTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.right.left = new Node(12);
        root.right.left.left = new Node(14);
        root.right.left.right = new Node(15);
        
        return root;
    }
    
    /**
     * Set up new binary not complete tree
     *              3
     *            /   \
     *          4       6
     *        /   \    /  \
     *       2        9    
     * @return 
     */
    public static Node notCompleteTree(){
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(6);
        root.right.left = new Node(9);
        root.left.left = new Node(2);
        
        
        return root;
    }
      /**
     * Set up new binary not complete tree
     *              3
     *            /   \
     *          4       6
     *        /   \    /  \
     *       2     5       9
     * @return 
     */
    public static Node notCompleteTree2(){
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.right = new Node(9);
        
        return root;
    }
    public static void printTree(Node node){
        if(node==null)
            return;
        System.err.print(node.val+"->");
        printTree(node.left);
        
        printTree(node.right);
        
    }
    public static int isComplete(Node node, int depth){
     //stop condition
        if (node == null) 
            return depth;
        int l = isComplete(node.left, depth++);
        int r = isComplete(node.right, depth++);

        //if one of the leafs is too deep (more than 1 level) return -1;
        if (l == -1 || r == -1) return -1;
        if (Math.abs(l-r) > 1) return -1;
     return Math.abs(l-r);
    }
    public static void log(String str){
        System.err.println(str);
    }
}
