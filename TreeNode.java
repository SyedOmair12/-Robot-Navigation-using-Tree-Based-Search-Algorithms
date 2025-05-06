
import java.util.ArrayList;
import java.util.List;


public class TreeNode {
   
    private String Scentence;

   public String operate;
   
    private TreeNode pNode;
    private List<TreeNode> cList;

  
    private Boolean bool;

   
    public TreeNode(String Scentence, TreeNode pNode) {
        this.Scentence = Scentence;
        this.operate = null;
        this.pNode = pNode;
        cList = new ArrayList<>();
        bool = null;
    }


    public TreeNode(String Scentence) {
        this(Scentence, null);
    }

 
    public TreeNode() {
        this("NULL", null);
    }

    public String getScentence() {
        return Scentence;
    }

  
    public void setScentence(String Scentence) {
        this.Scentence = Scentence;
    }

   
    public List<TreeNode> getChildrenList() {
        return cList;
    }

   
    public void addingChild(TreeNode treenode) {
    	cList.add(treenode);
    	treenode.setPNode(this);
    }

   
    public String gettingOperator() {
        return operate;
    }

   
    public void settingOperator(String operate) {
        this.operate = operate;
    }

   
    public TreeNode getPNode() {
        return pNode;
    }

   
    public void setPNode(TreeNode pNode) {
        this.pNode = pNode;
    }

    
    public Boolean getValue() {
        return bool;
    }

  
    public void setValue(Boolean bool) {
        this.bool = bool;
    }
}
