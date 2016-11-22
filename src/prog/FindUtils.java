package prog;

import java.util.PriorityQueue;

/**
 * Created by arabbani on 11/10/15.
 */
public class FindUtils {


    public static int findKthLargestUsingPriorityQueue(Integer[] nums, int k) {
        int p = 0;
        int numElements = nums.length;
        // create priority queue where all the elements of nums will be stored
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // place all the elements of the array to this priority queue
        for (int n : nums) {
            pq.add(n);
        }

        // extract the kth largest element
//        while (numElements - k + 1 > 0) {
//            p = pq.poll();
//            k++;
//        }

        for (int i = 0; i < numElements - k+1; i ++) {
            p = pq.poll();

        }

        return p;
    }


    /**
     * Minimum heap is a binary tree where any given node is smaller than its children
     * Maximum heap is a binary tree where any given node is greater than its children
     * */
    public static void findKthLargestUsingMinHeap(int[] numbers) {



    }
//
//    public static class MinimumHeap{
//        private BinaryTreeNode minimumHeap ;
//
//        public void insertNum(int data) {
//            if(minimumHeap == null) {
//                minimumHeap = new BinaryTreeNode(data);
//            } else {
//               insertInMinimumHeap(minimumHeap, data);
//            }
//
//        }
//
//        private void insertInMinimumHeap(BinaryTreeNode minHeap , int data) {
//            int temp;
//            BinaryTreeNode available = getNextAvailableNode(minHeap);
//            available.data = data;
//            if(available.parent) {
//                temp = minHeap.data;
//                minHeap.data = data;
//
//                available.data = temp;
//            }
//        }
//
//
//
//        private BinaryTreeNode getNextAvailableNode(BinaryTreeNode minHeap ) {
//            if(minHeap.getLeft() == null ) {
//                minHeap.getLeft() = new BinaryTreeNode();
//            }
//            if(minHeap.getRight() == null ) {
//                minHeap.getRight() = new BinaryTreeNode();
//            }
//
//        }

 //   }
//
//    void findNthFromLast(Node headNode, int n)
//    {
//   /*this has to be static so that it holds it's value from
//     call to call because of the fact that a non-static variable
//     will not hold it's value since the variable will just be local
//     to the function if it's not static and will not be preserved
//     across call stack:  */
//
//        static int i = 0;
//        //base case when we reach the end of linked list:
//        if(headNode == NULL)
//            return;
//        //this is where head pointer is advanced (head->next)...
//        findNthFromLast(headNode->next, n);
//        //increment i and check to see if equals n
//        //if it does equal n then print out the element's data
//        if(++i == n)
//            printf("%d", headNode->elementData);
//    }

    private static BinaryTreeNode convertToMirror(BinaryTreeNode root) {
        BinaryTreeNode temp;
        if (root != null) {
            convertToMirror(root.getLeft());
            convertToMirror(root.getRight());

            temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
        return root;
    }

    public static void printTree (BinaryTreeNode bnode) {
        if(bnode == null) return;

        System.out.print(bnode.data + " ");
        printTree(bnode.getLeft());
        printTree(bnode.getRight());


    }
    //
    //Given an ordered large array of integers, find all pairs of numbers that add up to a particular given sum.
    //Given an NxN matrix, find out the number of ways to get to the NxNth cell from the 1x1 cell...
    //Max repeated character which occurs at a time first index..
    //How to keep track of max and min numbers from a continuous stream of numbers
    //Implement a stack using a Queue
    //Given a constant input stream of integers design a way to, at any point, return the current median of that stream.
    public static char getChar(int num) {
        return (char) num;
    }

//    "char" => "int" is called Widening Primitive Conversion and "int => char" is called Narrowing Primitive Conversion
//
//    In Java, a char is just a 16-bit integer. When casting ints (which are 32-bit integers) to chars, you are keeping the 16 least significant
//    bits of the int, and discarding the upper 16 bits.
//    This is called anarrowing conversion. Java characters are represented as members of the Unicode character set. The Unicode value of 'B' is 66.
//
//    int ascii = 66;
//
//    The integer value 66 is assigned to ascii.
//
//    char character = (char) ascii;
//
//    character stores the first 16 bits of the integer ascii. Storing 66 doesnt exceed 16 bits so the char variable gets it right
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{2, 3, 5, 4, 1, 12, 11, 13, 16, 7, 8, 6, 10, 9, 17, 15, 19, 20, 21, 23, 26, 22, 25, 24, 14};
//        //character data will start from 33 - ...
//        System.out.println(getChar(100));
//        System.out.println(findKthLargestUsingPriorityQueue(numbers, 2));
        BinaryTreeNode root = new BinaryTreeNode(null , null ,20);
        BinaryTreeNode left = new BinaryTreeNode( null, null , 18);
        BinaryTreeNode right = new BinaryTreeNode( null, null , 24);
        root.setLeft(left);
        root.setRight(right);

        BinaryTreeNode left2 = new BinaryTreeNode(null , null ,14) ;
        BinaryTreeNode right2 = new BinaryTreeNode( null, null , 22);
        root.getLeft().setLeft(left2);
        root.getRight().setLeft(right2);

        BinaryTreeNode right22 = new BinaryTreeNode( null, null , 19);
        BinaryTreeNode right223 = new BinaryTreeNode( null, null , 26);

        root.getLeft().setRight(right22);
        root.getRight().setRight(right223);
        printTree(root);
        System.out.println( " \n\n");
        printTree(convertToMirror(root));
    }


    public static class BinaryTreeNode {
        BinaryTreeNode leftNode;

        public void setRight(BinaryTreeNode rightNode) {
            this.rightNode = rightNode;
        }

        public void setLeft(BinaryTreeNode leftNode) {
            this.leftNode = leftNode;
        }

        BinaryTreeNode rightNode;
        int data;


        public BinaryTreeNode (int data) {
            this.leftNode = null;
            this.rightNode = null;
            this.data = data;

        }

        public BinaryTreeNode (BinaryTreeNode leftNode,
                BinaryTreeNode rightNode,
                int data) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.data = data;

        }

        public BinaryTreeNode getLeft() {
            return leftNode;
        }

        public BinaryTreeNode getRight () {
            return rightNode;
        }
    }

}


