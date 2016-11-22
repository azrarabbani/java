package prog;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by arabbani on 11/17/16.
 *
 * Replace every element with the least greater element on its right
 In-place Convert BST into a Min-Heap
 Count inversions in an array | Set 2 (Using Self-Balancing BST)
 Print Common Nodes in Two Binary Search Trees
 Construct all possible BSTs for keys 1 to N
 K’th smallest element in BST using O(1) Extra Space
 Count BST subtrees that lie in given range
 Count BST nodes that lie in a given range

 */
public class BSTFindElement {

    //O(n) space
    public static TreeNode findKthMaximumElementBST(TreeNode root, int k) {
        if (k < 0) {
            return null;
        }
        if (k == 0) {
            return root;
        }
        List<TreeNode> list = convertTreeToListPost(root.right);
        if (k < list.size()) {
            return list.get(k - 1);
        } else {
            list.add(root);
            list.addAll(convertTreeToListPost(root.left));
        }
        return list.get(k - 1);

    }

    /**
     * O(1) space,
     * @param root
     * @param k
     * @return
     */
    public static TreeNode kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int i = 1;
        TreeNode retval = root;
        while(!stack.empty() || node != null) {//current node is null but we still have more nodes to traverse
            if(node != null) {
                stack.push(node);//if node is not null add it to the stack
                node = node.right; //now get the right node
            } else {
                node = stack.pop(); //if next node in line is null, then get the previous node which was the parent of the next node
                retval = node;//save it
                if(i++ == k) break;//increment a count for this node and match, if it is the required element return
                node = node.left;//now get the left of the node.
            }
        }
        return retval;
    }

    public static TreeNode findKthMinimumElementBST(TreeNode root, int k){
        if(k < 0) {
            return null;
        }
        if(k == 0) {
            return root;
        }
        List<TreeNode> list = convertTreeToList(root.left);
        if(k < list.size()) {
            return list.get(k-1);
        } else {
            list.add(root);
            list.addAll(convertTreeToList(root.right));
        }
        return list.get(k-1);
    }


    private static List<TreeNode> convertTreeToListPost(TreeNode root ){
        List<TreeNode> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.addAll(convertTreeToList(root.right) );

        if(root != null) {
            list.add(root);
        }
        list.addAll(convertTreeToList(root.left));
        return list;
    }


    private static List<TreeNode> convertTreeToList(TreeNode root ){
        List<TreeNode> list = new ArrayList<>();
        if(root == null) {
            return list;
        }//inorder is ascending
        list.addAll(convertTreeToList(root.left));
        if(root != null) {
            list.add(root);
        }
        list.addAll(convertTreeToList(root.right));
        return list;
    }

    private static int getTreeSize(TreeNode root, int count){
        if(root == null) {
            return count;
        }

        return count+ 1 + getTreeSize(root.left, count) + getTreeSize(root.right, count);
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

        TreeNode node =kthLargest(mainTree, 4);
                //findKthMinimumElementBST(mainTree, 10);
        System.out.println("10th Min Node "+node.data);

//        node = findKthMinimumElementBST(mainTree, 4);
//        System.out.println("4th Min Node "+node.data);
//
//        node = findKthMinimumElementBST(mainTree, 2);
//        System.out.println("2nd Min Node "+node.data);
//
//
//        node = findKthMaximumElementBST(mainTree, 4);
//        System.out.println("4th Max Node "+node.data);
//
//        node = findKthMaximumElementBST(mainTree, 3);
//        System.out.println("3rd Max Node "+node.data);
//
//        node = findKthMaximumElementBST(mainTree, 1);
//        System.out.println("1st Max Node "+node.data);data
    }


}
