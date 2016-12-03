package prog;

//import com.apple.concurrent.Dispatch;

import java.util.*;
/**
 * Created by arabbani on 11/14/16.
 * The basic requirement of a heap is that all of its children are <= to the value of node or >= to the value of the node.
 * Min heap: Value of a node must be less than or equal to all its children
 * Max heap: Value of a node must be greater than or equal to all its children
 *
 */
public class MinMaxHeapUtil {


    public static int[]mergeKSortedArrays(int[][] sorted){
        PriorityQueue<QueueNode> pg = new PriorityQueue();
        int resultSize =0;
        for(int i =0; i < sorted.length; i++) {
            int l = sorted[i].length;
            resultSize += l;
            if(l > 0) {
                pg.add(new QueueNode(i, 0 , sorted[i][0]));//initial index will be 0
            }
        }
        int[] results = new int[resultSize];
        for(int i =0; !pg.isEmpty(); i++){
           QueueNode node = pg.poll(); //returns the smallest element
           results[i] = node.value;
            int currentInd = node.currIndex + 1;
           if(currentInd < sorted[node.arrNum].length) {
               pg.add( new QueueNode(node.arrNum, currentInd, sorted[node.arrNum][currentInd]));
           }
        }
        return results;
    }

    static class  QueueNode implements Comparable<QueueNode> {
        int arrNum;
        int currIndex;
        int value;
        QueueNode(int arrNum, int currIndex, int value) {
            this.arrNum = arrNum;
            this.currIndex = currIndex;
            this.value = value;
        }
        public int compareTo(QueueNode n){
            if(value > n.value) return 1;
            if(value < n.value) return -1;
            return 0;
        }
    }

}
