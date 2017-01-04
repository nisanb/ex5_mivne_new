/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mivne_ex5;

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
        
        printTree(almostCompleteTree);
        log("Checking Complete Tree");
        log(checkTree(completeTree).toString());
        log(isComplete(completeTree, 0)+"");
        log("Checking Almost Complete Tree");
        log(checkTree(almostCompleteTree).toString());
        log(isComplete(almostCompleteTree, 0)+"");
        log("Checking Not Complete Tree");
        log(checkTree(notCompleteTree).toString());
        log("Mickey Function");
        log(isComplete(notCompleteTree, 0)+"");
        log("");
    }
    
    public static Boolean checkTree(Node node){
        
        //Is empty - is full tree
        if(node==null)
            return true;
       // log("Checking node "+node.val);
        
        //If right tree is complete or almost complete
        //then the left one must be FULL
        if(checkTree(node.right)){
            log("Right tree is complete for node "+node.val);
            if(node.left==null)
                return false;
            if(node.left.left==null || node.left.right==null)
                return false;
        }
        
        if(node.right != null && node.left == null)
            return false;
        
        checkTree(node.left);
        
        
        
        return true;
        
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
     * Set up new binary almost complete tree
     *              3
     *            /   \
     *          4       6
     *        /   \    /  \
     *       1           
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
