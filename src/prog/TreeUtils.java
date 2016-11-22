package prog;

/**
 * Created by arabbani on 11/16/15.
 */
public class TreeUtils {

//    public static boolean hasSubTree(Node main, Node sub, Node subOriginal, boolean found) {
//        if(main == null || sub == null) {
//            return found;
//        }
//        if(main.data == sub.data) {
//            Node temp = sub;
//            found |= true;
//            found &= hasSubTree(main.left, sub.left, subOriginal, found);
//            if (found) {
//                found &= hasSubTree(main.right, sub.right,subOriginal, found);
//            }
//            if(!found) {
//                sub = subOriginal;
//            }
//        } else if(main.data > sub.data) {
//            found = false;
//            return hasSubTree(main.left, subOriginal, subOriginal, found);
//        } else {
//            found = false;
//            return hasSubTree(main.right, subOriginal, subOriginal, found);
//        }
//        return found;
//    }


    public int findDuplicate(TreeNode curr,TreeNode prev) {
        if(curr == null)
            return 0;
        else {
            int count = 0;
            if(curr.data == prev.data)
                count++;
            return count + findDuplicate(curr.left, curr)
                    + findDuplicate(curr.right, curr);
        }
    }

    public static boolean hasSubTree(Node main, Node sub, Node subOriginal) {
        boolean found =   false;
        if(main.left == null || sub.left == null || main.right == null || sub.right == null) {
            return found;
        }
        if(main.data == sub.data) {
            Node mainCopy = main;
            Node subCopy = sub;

            found = hasSubTree(main.left, sub.left, subOriginal);
            if (found) {
                found &= hasSubTree(main.right, sub.right,subOriginal);
            }
            if(!found) {
                sub = subOriginal;
            } else {
                return true;
            }
        } else if(main.data > sub.data) {
            return hasSubTree(main.left, subOriginal, subOriginal);
        } else {

            return hasSubTree(main.right, subOriginal, subOriginal);
        }
        return found;
    }

public static void inOrder (Node root)
{
     //all left then root then all right
    if(root == null) return;

    inOrder( root.left);

    System.out.print(root.data + " -> ");


    inOrder( root.right );

}
    public static Boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        return isSymmetricInternal(root.left, root.right);
    }

    private static Boolean isSymmetricInternal(Node leftNode,
                                        Node rightNode) {

        boolean result = false;

        // If both null then true
        if (leftNode == null && rightNode == null) {
            result = true;
        }

        if (leftNode != null && rightNode != null) {
            result = (leftNode.data == rightNode.data)
                    && isSymmetricInternal(leftNode.left, rightNode.right)
                    && isSymmetricInternal(leftNode.right, rightNode.left);
        }

        return result;
    }


    //In Binary Search Tree, Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of input node.
    //1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
//    Go to right subtree and return the node with minimum key value in right subtree.
//    2) If right sbtree of node is NULL, then start from root and us search like technique. Do following.
//    Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.

    private static Node convertToMirror(Node root) {
        Node temp;
        if (root != null) {
            convertToMirror(root.left);
            convertToMirror(root.right);

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }


    //root , left , right
    public static void preOrder (Node root)
    {

        if(root == null) return;

        System.out.println(root.data);
        preOrder(root.left);

        preOrder(root.right);

    }

    //left, right ,root
    public static void postOrder (Node root)
    {

        if(root == null) return;


        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);

    }

    public static int findHeight(Node node, int height) {

        if (node == null) return height;

        int left = findHeight(node.left, height++);
        height = 0;
        int right = findHeight(node.right, height++);
        return  Math.max(left, right);
    }

    public static void printNodeValue(Node node) {
        System.out.print(node.data + " -> ");
    }

    public static boolean isBST(Node binaryTree){
        if(binaryTree == null) {
            return true;
        }
        else if(binaryTree.left != null && binaryTree.right == null ||
                binaryTree.right != null && binaryTree.left == null) {
            return false;
        }
        if(binaryTree.left.data > binaryTree.data || binaryTree.right.data < binaryTree.data) {
            return false;
        }
        return isBST(binaryTree.left) && isBST(binaryTree.right);

    }

    //a successor of an internal node is the min node on the right subtree. The min node can't have any left child.
    public static class Node {
        Node left;
        Node right;
        int data;
        int depth;
        boolean visited;

        public Node(int data) {
            this.data = data;
            this.visited = false;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.visited = false;
        }

        public boolean equals (Object obj) {
            if(obj == null) return false;

            if(! (obj instanceof  Node)) return false;

            Node node0 = (Node)obj;
            return (node0.data == this.data ) ;
        }
    }


    public static void main(String[] args) {
        TreeUtils ls = new TreeUtils();
        Node mainTree = new Node(20);
        Node node2 = new Node(15);
        Node node3 = new Node(8);
        Node node4 = new Node(19);
        Node node5 = new Node(2);
        Node node6 = new Node(23);
        Node node7 = new Node(45);
        Node node8 = new Node(39);
        Node node9 = new Node(25);
        Node node10 = new Node(45);
        Node node12 = new Node(21);
        Node node11 = new Node(52);
        Node node13 = new Node(10);

        mainTree.left = node2;
        mainTree.right = node7;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node13;
        node7.left = node6;
        node7.right = node11;
        node6.left = node12;
        node6.right = node8;
        node8.left = node9;
        node8.right = node10;

        Node node17 = new Node(39);
        Node node18 = new Node(25);
        Node node19 = new Node(45);
        node10.left = node17;
        node17.left = node18;
        node17.right = node19;

//        Node subTree = node8;
//        boolean hasSubTree = ls.hasSubTree(mainTree, subTree, subTree, false );
//        System.out.println("Subtree found "+hasSubTree);

        Node node14 = new Node(39);
        Node node15 = new Node(25);
        Node node16 = new Node(45);

        node14.left = node15;
        node14.right = node16;
        Node  subTree = node14;
        subTree.depth = 1;

        //boolean hasSubTree = ls.hasSubTree(mainTree, subTree, subTree, false );
//        Node node = findSuccessor(mainTree , subTree, mainTree);

        System.out.println("Node " + areNodeEquals(mainTree, node14));
        //System.out.println("Subtree found " + hasSubTree);
//        System.out.println("In order");
// //    inOrder(mainTree);
//        System.out.println("Pre order");
//        preOrder(mainTree);
//        System.out.println("Post order");
//        postOrder(mainTree);
//
//
//
//
//        Node root3 = new Node(1, new Node(2, new Node(4),
//                new Node(3)), new Node(2, new Node(3),
//                new Node(4)));
//        System.out.println("isSymmetric  " + isSymmetric(root3));
    }


    public static Node findSuccessor(Node rootNode, Node childNode) {
        if(rootNode == null || childNode == null) {
            return null;
        }
        if(rootNode.left == null || childNode.left == null || rootNode.right == null ||  childNode.right == null) {
            return rootNode;
        }
        if(rootNode.data < childNode.data) {
            findSuccessor(rootNode.right, childNode);
        } else if(rootNode.data > childNode.data) {
            findSuccessor(rootNode.left, childNode);
        }
        if(rootNode.data == childNode.data) {
            if(rootNode.right != null){
                Node temp = rootNode;
                while(temp.left != null){
                    temp = temp.left;
                }
                return  temp;
            }
        }
        return null;
    }


    //Successor is next in line
    //If the x has a right child then its inorder succes­sor will the left most ele­ment in the right sub tree of x.
    // if x is the right most node in the tree then its inorder suc­ces­sor will be NULL.
    //
    private static Node findSuccessor(Node rootNode, Node childNode, Node  rootParent) {
        if(rootNode == null || childNode == null) {
            return null;
        }
        if(childNode.left == null ||  childNode.right == null) {
            return rootParent;
        }
        if(rootNode.left == null ||  rootNode.right == null) {
            return null;
        }
        if(rootNode.data < childNode.data) {
            findSuccessor(rootNode.right, childNode, rootNode);
        } else if(rootNode.data > childNode.data) {
            findSuccessor(rootNode.left, childNode, rootNode);
        }
        if(rootNode.data == childNode.data) {
            Node successor = findSuccessor(rootNode.left, childNode.left, rootNode);
            if(successor != null) {
                successor = findSuccessor(successor.right, childNode.right, successor);
            }
            return successor;
        }
        return null;
    }



    public static boolean areNodeEquals(Node rootNode, Node childNode) {
        if(rootNode == null && childNode == null) {
            return   true;
        }
        if(rootNode != null && childNode == null) {
            return  true;
        }

        if(rootNode.data != childNode.data) {
            return  false;
        }
        return areNodeEquals (rootNode.left, childNode.left) &&
                areNodeEquals (rootNode.right, childNode.right);


    }



}
