
import java.util.*;


public class Scentence {
    
    private String newScentence;

    
    public Scentence(String newString) {
        this.newScentence = newString.replaceAll("\\s+", "");
    }

   
    public boolean isFact() {
        return !newScentence.contains("=>");
    }

   
    public String getPremise() {
        return isFact() ? newScentence : newScentence.split("=>|<=>")[0];
    }

   
    public Scentence getPScentence() {
        return new Scentence(getPremise());
    }

   
    public Scentence getCScentence() {
        return new Scentence(getConclusion());
    }

   
    public String getConclusion() {
        return isFact() ? newScentence : newScentence.split("=>|<=>")[1];
    }

   
    public List<String> getSigns() {
        ArrayList<String> output = new ArrayList<>();

        String[] newArray = newScentence.split("=>|&|\\/|<=>");

        for (String s : newArray) {
            if (!output.contains(s)) output.add(s);
        }

        return output;
    }

    
    public List<String> getConjunctions() {
        String input = getPremise();
        List<String> output = Arrays.asList(input.split("&"));
        return output;
    }

    
    public boolean conjunctionContains(String search) {
        for (String newstring : getConjunctions()) {
            if (newstring.equals(search)) return true;
        }
        return false;
    }

   
    public boolean propositionalLogic(Map<String, Boolean> signs) throws IllegalStateException {
        
        Tree treeScentence = new Tree(new TreeNode(newScentence));

       
        LinkedList<TreeNode> newList = new LinkedList<>();
        newList.add(treeScentence.getRootNode());

      
        LinkedList<TreeNode> al = new LinkedList<>();
        al.add(treeScentence.getRootNode());

        
        TreeNode newNode;
        while ((newNode = newList.pollFirst()) != null) {

            Operator operator = Operator.containOperator(newNode.getScentence());
            if (operator != null) {
              
                String[] splits = newNode.getScentence().split(operator.getOSymbol(), 2);

                newNode.settingOperator(operator.getOSymbol());
                for (String s : splits) {
                    TreeNode dl = new TreeNode(s);
                    newNode.addingChild(dl);
                   
                    newList.add(dl);

                    al.addFirst(dl);
                }
            }

            
            else {
                Boolean output = signs.get(newNode.getScentence());
                if (output == null) output = false;

                if (newNode.getScentence().contains("~")) output = !output;
                newNode.setValue(output);
            }
        }

        
        for (TreeNode treenode : al) {
            if (treenode.getChildrenList().size() == 0) continue;
            else {
                if (treenode.getChildrenList().size() != 2) throw new IllegalStateException();

                Boolean l = treenode.getChildrenList().get(0).getValue();
                if (l == null) l = false;
                Boolean r = treenode.getChildrenList().get(1).getValue();
                if (r == null) r = false;

                treenode.setValue(Operator.getOperator(treenode.gettingOperator()).booleanResult(l, r));
            }
        }

     
        return treeScentence.getRootNode().getValue();
    }

   
    public String getScentence() { return newScentence; }

    
    @Override
    public boolean equals(Object object) {
        if (object instanceof Scentence) return getScentence().equals(((Scentence) object).getScentence());
        else return false;
    }
}
