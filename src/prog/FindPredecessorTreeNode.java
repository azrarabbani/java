package prog;


/**
 *
 * Predecessor of a node x is the greatest key smaller than x
 * Case 1: The node x have a left child, then the right most node of the left tree of x is its predecessor. if it has no child then its has no predecessor.
 * case 2: The node x doesn't have a left sub tree and x is the left child of its parent in the tree
 * case 3: The node x doesn't have a left sub tree and it is the right child of its parent node
 */
public class FindPredecessorTreeNode {

    private static TreeNode findPredecessor(TreeNode tree, TreeNode node ) {

        if (tree == null || node == null) {
            return null;
        }

        //Case 1 : if left sub tree is not null then no need to traverse the tree, find right most node of the right tree
        if (node.left != null) {
            TreeNode temp = node.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            return temp;
        } else {
            //traverse the tree
            TreeNode ancestor = tree; //root
            TreeNode predecessor = null;
            while (ancestor.data != node.data) {
                if (node.data < ancestor.data) {//predecessor lies in the left subtree of ancestor
                    ancestor = ancestor.left; //go into left side of ancestor
                } else if (node.data > ancestor.data) {
                    predecessor = ancestor;//since node.data is less than ancestor it means the successor will be its ancestor
                    ancestor = ancestor.right; //since ancestor is smaller than node go into right
                }
            }
            return predecessor;
        }
    }

    public static void main(String[] args) {

   /* Let us create following BST
                50
            /        \
           17           72
         /    \       /    \
       12     23    54     76
      / \     /       \
     9   14  19       67
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


        TreeNode x = node3;

        TreeNode node = FindPredecessorTreeNode.findPredecessor(mainTree,x);

        System.out.println("Predecessor of " + x.data + " is " + node.data);
    }



}