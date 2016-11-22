package prog;

//a successor of an internal node is the min node on the right subtree. The min node can't have any left child.

public  class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;
    int depth;
    public boolean visited;

    public TreeNode(int data) {
        this.data = data;
        this.visited = false;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.visited = false;
    }

    public boolean equals (Object obj) {
        if(obj == null) return false;

        if(! (obj instanceof TreeNode )) return false;

        TreeNode node0 = (TreeNode)obj;
        return (node0.data == this.data ) ;
    }
}