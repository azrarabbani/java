package prog;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by arabbani on 11/22/16.
 */
public class BSTUtil {
//              50
//           /     \
//         23       78
//       /    \     / \
//      17    43   54  89
//    /  \    / \
//   12  29  33 45



    private Node findPredecessor(Node tree, Node x){

        if(tree == null || x == null) {
            return null;
        }
        if(x.left != null){
            Node temp = x.left;
            while(temp.right != null) {
                temp = temp.right;
            }
            return temp;
        } else {
            Node pred = null;
            Node ancestor = tree;
            while(ancestor.data != x.data) {
                if(x.data < ancestor.data) {
                    ancestor = ancestor.left;//go to left
                } else {
                    pred = ancestor;
                    ancestor = ancestor.right;
                }
            }
            return pred;
        }
    }

    //smallest number gt than x
    private Node findSuccessor(Node tree, Node x){
        if(tree == null || x == null) {
            return null;
        }

        if(x.right != null) {
            Node temp = x.right;
            while(temp.left != null) {
                temp = temp.left; //bcz we need to find the smallest gt
            }
            return temp;
        } else {
            Node successor = null;
            Node ancestor = tree;
            while(ancestor != null && ancestor.data != x.data) {
                if(x.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }

    }

    private Node breadthFirstSearch(Node tree, int s){
        if(tree == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(tree);

        while(!stack.isEmpty()) {
            Node temp = stack.pop();
            Node n = processNode(temp, s);
            if(n != null) {return n;}
            Stack<Node> tStack = new Stack<>();
            while(!stack.isEmpty()){
                tStack.push(stack.pop());//78
            }
            if(temp.right !=null) {stack.push(temp.right);}
            if(temp.left !=null) {stack.push(temp.left);}
            //[23,78], [78,17,43]
            while(!tStack.isEmpty()){
                stack.push(tStack.pop());
            }
        }
        return null;
    }


    private boolean isMirror(Node leftNode, Node rightNode) {
        if((leftNode == null && rightNode != null ) || (leftNode != null && rightNode == null) ) {
            return true;
        }

        if(leftNode == null && rightNode == null ) {
            return true;
        }
        return leftNode.data == rightNode.data
                && isMirror(leftNode.left, rightNode.right)
                && isMirror(leftNode.right, rightNode.left);
    }

    private void makeMirror(Node root){
        if(root == null) {
            return;
        }
        makeMirror(root.left);
        makeMirror(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    private boolean isBST(Node root){
        if (root == null) {
            return false;
        }
        if ((root.left == null && root.right == null) ||
                (root.left != null && root.right == null)    ){
            return false;
        }
        if(root.left.data > root.data ||
                root.right.data < root.data) {
          return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    static Node lcaBST(Node root, int v, int w){

        if(root == null){
            return null;
        }
        int i = 0;
        List<Node> pathToV = pathFromRootINBST(root, v);
        List<Node> pathToW = pathFromRootINBST(root, w);
        Node prev = null;
        while(i <  pathToV.size() && i < pathToW.size()){
            if(pathToV.get(i).data == pathToW.get(i).data) {
                prev = pathToV.get(i);
            }
            i++;
        }
        if(prev != null) {
            System.out.println("LCM = " + prev.data);
        }
        return prev;
    }


    private static Stack<Node> pathFromRoot(Node root, int x){
        if(root == null) {
            return null;
        }
        Stack<Node> path = new Stack<>();
        if(root.data == x) {
            path.push(root);
            return path;
        }
        path = pathFromRoot(root.left, x);
        path = pathFromRoot(root.right, x);
//        if(left != null) {
//            left.push(root);
//            return left;
//        }
//        if(right != null) {
//            right.push(root);
//            return right;
//        }
        return path;
    }



    static Node lca(Node root, int v, int w){
        if(root == null){
            return null;
        }
        int i = 0;
        Stack<Node> pathToV = pathFromRoot(root, v);
        List<Node> pathToW = pathFromRoot(root, w);
        Node prev = null;
        while(i <  pathToV.size() && i < pathToW.size()){
            if(pathToV.get(i).data == pathToW.get(i).data) {
                prev = pathToV.get(i);
            }
            i++;
        }
        if(prev != null) {
            System.out.println("LCM = " + prev.data);
        }
        return prev;
    }

    private static List<Node> pathFromRootINBST(Node root, int x){
        if(root == null) {
            return null;
        }
        List<Node> path = new ArrayList<>();
        if(root.data == x) {
            path.add(root);
            return path;
        }
        Node temp = root;
        while( temp != null && temp.data != x){
            path.add(temp);
            if(x < temp.data ) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return path;
    }

    //root,44,63

    //         50
//           /    \
//         23       63
//       /    \     / \
//      17    43   51  77
//     / \
//    3   19
//


    public Node processNode(Node tree, int s){
        if(tree != null) {
            if(tree.data == s) return tree;
        }
        if(tree.left != null) {
            if(tree.left.data == s) return tree.left;
        }
        if(tree.right != null) {
            if(tree.right.data == s) return tree.right;
        }
        return null;
    }


    public static void main(String[] args) {
//n=12, a=50,17
   /* Let us create following BST
                50
            /        \
           17           72
         /    \       /    \
       12     23    54     76
      / \     /       \
     9   14  19       67
      */


        Node mainTree = new Node(50);
        Node node2 = new Node(17);
        Node node3 = new Node(12);
        Node node4 = new Node(23);
        Node node5 = new Node(14);
        Node node6 = new Node(54);
        Node node7 = new Node(72);
        Node node8 = new Node(67);
        Node node9 = new Node(19);
        Node node10 = new Node(24);
        Node node11 = new Node(76);
        Node node13 = new Node(9);

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


        Node x = node10;
        BSTUtil u= new BSTUtil();
        BSTUtil.lca(mainTree, 9, 19);
//
//        u.findLeastCommonAncestor(mainTree, node3, node6);
    }

    static class  Node{
        Node left;
        Node right;
        int data;
        boolean visited;

        Node(int d){
            this.data = d;
        }
    }
}
