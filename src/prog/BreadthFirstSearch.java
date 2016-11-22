package prog;

import java.util.*;
/**
 * Created by arabbani on 11/12/16.
 * Breadth First search is visiting each node at the same level before going to the next level.
 * Applications
 * Web crawling
 * Social networking
 * network broadcast
 * garbage collection
 * model checking
 */
public class BreadthFirstSearch {


    public static void BSD(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> nodeToTraverse =  new Stack<>();
        nodeToTraverse.push(root);
        BSD(nodeToTraverse);//50,17, 1
    }

    /**
     *            21
     *          /   \
     *        9     30
     *       /\    /  \
     *      6 10  24
     *
     *         30
     *     9   6
     * 21  30  10
     *
     * Breadth first can be done using stack as a helper ds in a loop
     * first add root node to a stack and strat while until stack is empty
     * pop a node from stack and process (it should process all children of a given node)
     * now add the right child of the root to the stack if it is not null
     * add the left child of the root to the stack if not null, because the left child should be processed before right
     * we need to keep moving up the existing nodes in the stack on top before adding any new ones so use temp stack which should
     * temporarily contain any existing nodes to traverse before adding the children of the processed nodes, to avoid any duplicate processing we can mark each mode\
     * visited in the process method
     *
     * @param nodeToTraverse
     */
    public static void BSD(Stack<TreeNode> nodeToTraverse){
        Stack<TreeNode> temp = new Stack<>();
        while(!nodeToTraverse.isEmpty()){
            TreeNode nodeToProcess = nodeToTraverse.pop();
            process(nodeToProcess);//process level
            while(!nodeToTraverse.isEmpty()) {
                temp.push( nodeToTraverse.pop());
            }
            if(nodeToProcess.right != null) {
                nodeToTraverse.push(nodeToProcess.right);
            }
            if(nodeToProcess.left != null) {
                nodeToTraverse.push(nodeToProcess.left);
            }
            while(!temp.isEmpty()) {
                nodeToTraverse.push(temp.pop());
            }
        }
    }

    private static void process(TreeNode node){
        if(node != null ) {
            if(!node.visited) {
                System.out.println(node.data);
                node.visited  =true;
            }
            if(node.left != null && !node.left.visited) {
                System.out.println(node.left.data);
                node.left.visited  =true;
            }
            if(node.right != null&& !node.right.visited) {
                System.out.println(node.right.data);
                node.right.visited  =true;
            }
        }
    }

    public static void main(String[] args) {

   /* Let us create following BST
                50
            /        \
           17           72
         /    \       /    \
       12     23    54     76
      / \     / \      \
     9   14  19 24      67
      */


        TreeNode mainTree = new TreeNode(50);
        TreeNode node2 = new TreeNode(17);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(23);
        TreeNode node5 = new TreeNode(14);
        TreeNode node6 = new TreeNode(54);
        TreeNode node7 = new TreeNode(72);
        TreeNode node8 = new TreeNode(67);
        TreeNode node9 = new TreeNode(19);
        TreeNode node10= new TreeNode(24);
        TreeNode node11 = new TreeNode(76);
        TreeNode node13 = new TreeNode(9);
        mainTree.left = node2;
        mainTree.right = node7;
        node2.left = node3;
        node2.right = node4;
        node4.left = node9;
        node4.right = node10;
        node3.left = node13;
        node3.right = node5;
        node7.left = node6;
        node7.right = node11;
        node6.right = node8;

        BreadthFirstSearch.BSD(mainTree);
    }
}
