
public class IfAndOnlyIfOperator extends Operator {
    public IfAndOnlyIfOperator() {
    	sOperator = "<=>";
        newlevel = 1;
    }

    @Override
    public boolean booleanResult(boolean l, boolean r) {
        return (l && r) || (!l && !r);
    }
}
