package prog;

/**
 * Created by arabbani on 11/12/16.
 */
public class FindMinMaxInBST {


    public static int[] findMinMax(TreeNode tree){
        int min = tree.data;
        int max = tree.data;
        TreeNode rightSubTree = tree.right;
        while(rightSubTree != null) {
            max = rightSubTree.data;
            rightSubTree = rightSubTree.right;
        }
        TreeNode leftSubTree = tree.left;
        while(leftSubTree != null) {
            min = leftSubTree.data;
            leftSubTree = leftSubTree.left;
        }
        return new int[]{min,max};
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

        int[] minMax = FindMinMaxInBST.findMinMax(mainTree);

        System.out.println("Min  " +minMax[0] + " ,Max " + minMax[1]);
    }
}
