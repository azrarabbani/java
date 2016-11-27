package prog;

/**
 * Created by arabbani on 12/29/15.
 */
public class LinkedListUtils {




    boolean isInInfiniteLoop(Node node) {
        if (node == null) {
            return false;
        }
        Node turtle = node; // slower moving node
        Node rabbit = node.next; // faster moving node
        while (rabbit != null) {
            System.out.println("T="+turtle.data+" , R="+rabbit.data);
            if (rabbit.equals(turtle)) {
                // the faster moving node has caught up with the slower moving node
                return true;
            } else if (rabbit.next == null) {
                // reached the end of list
                return false;
            } else {
                turtle = turtle.next;
                rabbit = rabbit.next.next;

            }
        }
        // rabbit reached the end
        return false;
    }



    public static Node Insert(Node head,int data) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node headCopy = head;
        if(headCopy == null) {
            head = new Node();
            head.data = data;
            return head;
        }

        while (headCopy.next != null) {
            headCopy = headCopy.next;
        }

        headCopy.next = new Node();
        headCopy.next.data = data;
        return head;

    }

    public static Node getKthElementFromEnd(Node list, int kthElement) {
        int size = 1;
        Node temp = list;
        while((temp = temp.next) != null){
            size++;
        }

        if(kthElement >= size ) {
            return null;
        }
        Node nextNode = list;
        for(int i = 0 ; i < size-kthElement ; i++) {
            nextNode = nextNode.next;
        }
        return nextNode;
    }



    public static Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if(headA == null && headB == null)  return null;
        if(headB ==  null ) return headA;
        if(headA ==  null ) return headB;
        Node listANext = headA;
        Node listBNext = headB;
        Node mergedNode = null;
        Node nodeToMerge = null;
        while(listANext != null && listBNext != null){
            if(listANext.data <= listBNext.data) {
                nodeToMerge = new Node(listANext.data);
                listANext = listANext.next;
            } else {
                nodeToMerge = new Node(listBNext.data);
                listBNext = listBNext.next;

            }
            mergedNode = mergeToNode(mergedNode,nodeToMerge );
        }
        nodeToMerge = listANext;
        while(nodeToMerge != null  ) {
            mergedNode = mergeToNode(mergedNode,nodeToMerge );
            nodeToMerge = nodeToMerge.next;
        }
        nodeToMerge = listBNext;
        while(nodeToMerge != null  ) {
            mergedNode = mergeToNode(mergedNode,nodeToMerge );
            nodeToMerge = nodeToMerge.next;
        }
        return mergedNode;
    }

    Node InsertNth2(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        if(head == null) {
            if(position == 0) {
                head = new Node();
                head.data = data;
                return head;
            }
        }
        int size = 1;
        Node temp = head;
        while(temp.next != null) {
            size++;
            temp = temp.next;
        }
        //size = 10; position = 8 ;
        if(position + 1 == size) {//at the end
            Node node = new Node();
            node.data = data;
            temp.next = node;
            return head;
        }
        if(position > size) {
            return head;
        }
        temp = head;
        for(int i=1;  i < position; i ++) {
            temp = temp.next;
        }
        Node temp2 = temp;
        Node node = new Node();
        node.data = data;
        temp.next = node;
        node.next = temp2.next;

        return head;
    }
//310542
    //5
//    3 0
//            5 1
//            4 2
//            2 3
//            10 1
    public static Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        if(head == null) {
            if(position == 0) {
                head = new Node();
                head.data = data;
                return head;
            } else {
                return head;
            }
        }
        if(position == 0) {
            Node node  = new Node();
            node.data = data;
            node.next = head;
            return node;
        }
        Node temp = head;
        for(int i=1;  i < position-1; i ++) {
            if(temp == null) {
                return head;//position is greater than size
            }
            temp = temp.next;
        }
        if(temp != null) {
            Node temp2 = temp.next;
            Node node = new Node();
            node.data = data;
            temp.next = node;
            node.next = temp2;
        }
        return head;
    }

    private static Node mergeToNode(Node mergedNode, Node nodeToMerge ) {
        if(mergedNode == null) {
            mergedNode =  new Node(nodeToMerge.data);
            //System.out.print(mergedNode.data +" -> ");
        } else {
            Node temp = mergedNode;
            while( temp.next != null) {
                temp = temp.next;
            }
            temp.next  = new Node(nodeToMerge.data);
           // System.out.print(temp.next.data +" -> ");
        }
        return mergedNode;
    }


    public static Node createLinkedList(int startingValue, int sizeOfList) {
        System.out.println("new list");
        Node head = new Node(startingValue);
        Node node = head;

        for(int i=startingValue +1; i <= sizeOfList; i++) {
            System.out.print(node.data +" -> ");
            node.next = new Node(i);
            node = node.next;
        }
        System.out.println(node.data);
        return head;
    }

    public static Node createLinkedListWithDataValues(int...dataValue) {

        if(dataValue.length == 0) return null;
        Node head = new Node(dataValue[0]);
        Node node = head;

        for(int i=1;i < dataValue.length; i++) {
            //System.out.print(node.data +" -> ");
            node.next = new Node(dataValue[i]);
            node = node.next;
        }
        //System.out.println(node.data);
        return head;
    }

    public static void main(String[] args) {
        LinkedListUtils ls = new LinkedListUtils();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        node9.next = null;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
       boolean hasLoop = ls.isInInfiniteLoop(node1);
        System.out.println("Loop found "+hasLoop);
        //System.out.println("Kth Element from End "+getKthElementFromEnd(node1, 3).data);

//        1 2 3 4 5 6 7
//        12 15
//        1 2




//        3
//        4
//        1 3 5 6
//        3
//        2 4 7
//        1
//        15
//        1
//        12
//        0
//        2
//        1 2
//        System.out.println("Test case 1");
//        System.out.println("--------------------------");
//        Node headA = createLinkedListWithDataValues(1,3,5,6);
//        Node headB = createLinkedListWithDataValues(3);
//        Node mergedList = MergeLists(headA, headB);
//        Node temp = mergedList;
//        System.out.println("output 1");
//        while (temp != null ) {
//            System.out.print(temp.data + "->");
//            temp = temp.next;
//        }
//
//        System.out.print("\n\n\n");
//        System.out.println("Test case 2");
//        System.out.println("--------------------------");
//        headA = createLinkedListWithDataValues(2, 4, 7);
//        headB = createLinkedListWithDataValues(1);
//        mergedList = MergeLists(headA, headB);
//        temp = mergedList;
//        System.out.println("output 2");
//        while (temp != null ) {
//            System.out.print(temp.data + "->");
//            temp = temp.next;
//        }
//
//        System.out.print("\n\n\n");
//        System.out.println("Test case 3");
//        System.out.println("--------------------------");
//        headA = createLinkedListWithDataValues(15);
//        headB = createLinkedListWithDataValues(1);
//        mergedList = MergeLists(headA, headB);
//        temp = mergedList;
//
//
//
//        System.out.println("output 3");
//        while (temp != null ) {
//            System.out.print(temp.data + "->");
//            temp = temp.next;
//        }
//        System.out.print("\n\n\n");
//        System.out.println("Test case 4");
//        System.out.println("--------------------------");
//
//
//
//        headA = null;// createLinkedListWithDataValues(2);
//        headB = createLinkedListWithDataValues(1, 2);
//        mergedList = MergeLists(headA, headB);
//        temp = mergedList;
//        System.out.println("output 4");
//        while (temp != null ) {
//            System.out.print(temp.data + "->");
//            temp = temp.next;
//        }
//        System.out.println("------------ insert node ------------ ");
//
//        Node node =  Insert(createLinkedListWithDataValues(1, 2,4,6,7,9,10, 34,23, 78), 54);
//
//        while (node != null ) {
//            System.out.print(node.data + "->");
//            node = node.next;
//        }
//        node =  InsertNth(createLinkedListWithDataValues(1, 2,4,6,7,9,10, 34,23, 78), 54, 0);
//        System.out.print("Test case Insert at 0th position");
//        while (node != null ) {
//            System.out.print(node.data + "->");
//            node = node.next;
//        }
//
//        node =  InsertNth(createLinkedListWithDataValues(1, 2,4,6,7,9,10, 34,23, 78), 54, 6);
//        System.out.print("Test case Insert at 6th position");
//        while (node != null ) {
//            System.out.print(node.data + "->");
//            node = node.next;
//        }
//
//
//        node =  InsertNth(createLinkedListWithDataValues(1, 2,4,6,7,9,10, 34,23, 78), 54, 10);
//        System.out.print("Test case Insert at 10th position");
//        while (node != null ) {
//            System.out.print(node.data + "->");
//            node = node.next;
//        }
//
//        node =  InsertNth(createLinkedListWithDataValues(1, 2,4,6,7,9,10, 34,23, 78), 54, 11);
//        System.out.print("Test case Insert at 11th position");
//        while (node != null ) {
//            System.out.print(node.data + "->");
//            node = node.next;
//        }
//
//        node =  InsertNth(createLinkedListWithDataValues(1, 2,4,6,7,9,10, 34,23, 78), 54, 12);
//        System.out.print("Test case Insert at 12th position");
//        while (node != null ) {
//            System.out.print(node.data + "->");
//            node = node.next;
//        }
    }

    public static class Node{
        Node next;
        int data;


        public Node() {

        }
        public Node(int id) {
           this.data =id;
        }

        public boolean equals (Object obj) {
           if(obj == null) return false;

           if(! (obj instanceof  Node)) return false;

           Node node0 = (Node)obj;
           return (node0.data == this.data) ;
        }

    }
}
