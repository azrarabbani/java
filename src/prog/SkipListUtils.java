package prog;

import java.util.*;
import java.lang.*;
/**
 * Created by arabbani on 11/12/16.
 * Randomized structure
 * bottom list must be ordered
 * to make sure same timecomplexity for every search make the gap between indices equal
 * it is a list representation of red black tree
 *
 *
 */
public class SkipListUtils<N extends Comparable<? super N>> {

    Node<N> skip = null;// new Node(9);
    int MAX_LEVELS = 2;
    private final static int DEFAULT_GAP_BETWEEN_SKIPPED_ELEMENTS = 3;
    int currentGapBetweenSkips= 0;
    int nextLevel=0;
    //public static final double POSITIVE_INFINITY = 1.0 / 0.0;

    /**
     * A constant holding the negative infinity of type
     * {@code double}. It is equal to the value returned by
     * {@code Double.longBitsToDouble(0xfff0000000000000L)}.
     */
    //public static final double NEGATIVE_INFINITY = -1.0 / 0.0;

    Random r = new Random();

//    public void insert(N data) {
//        if(skip == null) {
//            skip = new Node<>(data, MAX_LEVELS);
//            return;
//        }
//        Node temp = skip;
//        //all elements must go into the bottom level and list must be ordered
//        int idx = 0;
//        while(temp != null) {
//          if(data.compareTo(temp.next.get(0).data)  ) { //to make it ordered insertion
//              temp = temp.next.get(0);
//              idx++;
//          } else {
//              Node n = new Node(data, MAX_LEVELS);
//              n.next.set(0, temp.next.get(0));
//              temp.next.set(0, n);
//              currentGapBetweenSkips++;
//              if(currentGapBetweenSkips == DEFAULT_GAP_BETWEEN_SKIPPED_ELEMENTS) {
//                  Node nn = new Node(data, MAX_LEVELS);
//                  nn.next.set(idx, n); //connect to each other
//                  currentGapBetweenSkips = 0;
//              }
//              return;
//          }
//        }
//    }
//


    public void insert(N data) {
        Node<N> SkipNode = new Node<>(data,MAX_LEVELS);
        currentGapBetweenSkips++;
        insert(SkipNode, 0);
//        if(currentGapBetweenSkips == DEFAULT_GAP_BETWEEN_SKIPPED_ELEMENTS) {//now is the time
//              Node nn = new Node(data, MAX_LEVELS);
//              nn.next.set(0, SkipNode); //connect to each other,
//              currentGapBetweenSkips = 0;
//        }

    }

    public void print() {
        for (int i = 0; i < MAX_LEVELS; i++) {
            skip.print(i);
        }

        System.out.println();
    }

    private void insert(Node SkipNode, int level) {
        skip.insert(SkipNode, level);
    }

    public static void main(String[] args) {

        SkipListUtils u = new SkipListUtils();
        u.insert(9);
        u.insert(18);
        u.insert(5);
        u.insert(8);
    }

    private  static class Node<N extends Comparable<? super N>>{
        List<Node<N>> next;
        N data;
        int lastLevelFilled=0;
        Node(N data, int maxLevel){
            this.data = data;
            this.next = new ArrayList<>();
        }

        Node getNext(int level) {
           return this.next.get(level);
        }

        void setNext(Node node, int level) {
            this.next.set(level, node);
        }


        void insert(Node<N> SkipNode, int level) {
            Node<N> current = this.getNext(level);
            if (current == null) {
                this.setNext(SkipNode, level);
                return;
            }

            if (SkipNode.data.compareTo(current.data) < 1) {
                this.setNext(SkipNode, level);
                SkipNode.setNext(current, level);
                return;
            }

            while (current.getNext(level) != null &&
                    current.data.compareTo(SkipNode.data) < 1 &&
                     current.getNext(level).data.compareTo(SkipNode.data) < 1) {

                current = current.getNext(level);
            }

            Node<N> successor = current.getNext(level);
            current.setNext(SkipNode, level);
            SkipNode.setNext(successor, level);
        }

        void print(int level) {
            System.out.print("level " + level + ": [");
            int length = 0;
            Node<N> current = this.getNext(level);
            while (current != null) {
                length++;
                System.out.print(current.data.toString() + " ");
                current = current.getNext(level);
            }

            System.out.println("], length: " + length);
        }

    }
}
