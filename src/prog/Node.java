package prog;

/**
 * Created by arabbani on 11/12/16.
 */
public class Node{
    Node next;
    int data;

    public Node(int data) {
        this.data =data;
    }

    public boolean equals (Object obj) {
        if(obj == null) return false;

        if(! (obj instanceof  Node)) return false;

        Node node0 = (Node)obj;
        return (node0.data == this.data) ;
    }

}