
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public abstract class Operator {
    protected String sOperator;
    protected int newlevel;

  
    private static List<Operator> lOperator;

    static {
    	lOperator = new ArrayList<>();

    	lOperator.add(new AndOperator());
    	lOperator.add(new OrOperator());
    	lOperator.add(new IfThenOperator());
    	lOperator.add(new IfAndOnlyIfOperator());

    	lOperator.sort(new OComparator());
    }

   
    private static class OComparator implements Comparator<Operator> {

        @Override
        public int compare(Operator operatror1, Operator operator2) {
            return operatror1.getLevel() - operator2.getLevel();
        }

        @Override
        public boolean equals(Object newobject) {
            return false;
        }
    }

   
    public static List<Operator> getOList() { return lOperator; }

    
    public static Operator containOperator(String Scentence) {
        for (Operator operator : lOperator) {
            if (Scentence.contains(operator.getOSymbol())) {
                return operator;
            }
        }
        return null;
    }

  
    public static Operator getOperator(String oSymbol) {
        for (Operator operator : lOperator) {
            if (oSymbol.equalsIgnoreCase(operator.getOSymbol()))
                return operator;
        }
        return null;
    }

    public String getOSymbol() { return sOperator; }

    
    public int getLevel() { return newlevel; }

    
    public abstract boolean booleanResult(boolean l, boolean r);
}
