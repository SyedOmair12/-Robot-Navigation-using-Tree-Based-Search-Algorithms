
public class Tree {
   
    private TreeNode rNode;

  
    public Tree(TreeNode newnode) {
        this.rNode = newnode;
    }


    public TreeNode getRootNode() {
        return rNode;
    }

   
    public void setRootNode(TreeNode node) {
        this.rNode = node;
    }
}
