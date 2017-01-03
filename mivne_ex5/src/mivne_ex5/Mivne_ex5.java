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
        log("Complete Tree");
        printTree(completeTree);
        log("Almost Complete Tree");
        printTree(almostCompleteTree);
        log("Not Complete Tree");
        printTree(notCompleteTree);
        
        
        log("");
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
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(1);
        
        return root;
    }
    
    /**
     * Set up new binary not complete tree
     *              3
     *            /   \
     *          4       6
     *        /   \    /  \
     *                3    5
     * @return 
     */
    public static Node notCompleteTree(){
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(5);
        
        return root;
    }
    
    public static void printTree(Node node){
        if(node==null)
            return;
        printTree(node.left);
        System.err.print(node.val+"->");
        printTree(node.right);
        
    }
 
    
    public static void log(String str){
        System.err.println(str);
    }
}
